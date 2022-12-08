package mariogatchi.use_cases.info_access;

import mariogatchi.entities.Statistics;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InformationAccessRunnerTest {

    @Test
    void checkStatistic() {
        InformationAccessRunner infoAccessRunner = new InformationAccessRunner(new InfoAccessPresenter() {
            @Override
            public InfoAccessResponseModel prepareSuccessView(InfoAccessResponseModel responseModel) {
                assertEquals(50, responseModel.getCurrentValue());
                return null;
            }

            @Override
            public InfoAccessResponseModel prepareFailView(String error) {
                return null;
            }
        });

        infoAccessRunner.checkStatistic(new InfoAccessRequestModel(new Statistics("common"),
                Statistics.Stats.AGILITY));
    }
}