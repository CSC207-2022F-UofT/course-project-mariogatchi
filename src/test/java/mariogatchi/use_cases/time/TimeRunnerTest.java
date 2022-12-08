package mariogatchi.use_cases.time;

import mariogatchi.entities.Statistics;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TimeRunnerTest {

    @Test
    void checkPassedTime() {
        TimeRunner timeRunner = new TimeRunner(new TimePresenter() {
            @Override
            public TimeResponseModel prepareSuccessView(TimeResponseModel responseModel) {
                assertTrue(responseModel.getTimeDifference() > (60000 * 60));
                return null;
            }

            @Override
            public TimeResponseModel prepareFailView(String error) {
                return null;
            }
        });
        Statistics stats = new Statistics("common");
        timeRunner.checkPassedTime(new TimeRequestModel((int) (System.currentTimeMillis() + (60000 * 60)), stats));
        assertEquals(48, stats.getEnergy());
    }
}