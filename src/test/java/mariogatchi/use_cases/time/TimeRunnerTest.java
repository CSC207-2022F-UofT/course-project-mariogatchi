package mariogatchi.use_cases.time;

import mariogatchi.entities.Mariogatchi;
import mariogatchi.entities.Statistics;
import mariogatchi.entities.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TimeRunnerTest {

    @Test
    void checkPassedTime() {
        TimeRunner timeRunner = new TimeRunner(new TimePresenter() {
            @Override
            public TimeResponseModel prepareSuccessView(TimeResponseModel responseModel) {
                return null;
            }

            @Override
            public TimeResponseModel prepareFailView(String error) {
                return null;
            }
        });
        User u = new User("");
        List<Mariogatchi> lst = new ArrayList<Mariogatchi>();
        Mariogatchi m = new Mariogatchi("common");
        m.setName("J");
        lst.add(m);
        u.setMariogatchis(lst);
        timeRunner.checkPassedTime(new TimeRequestModel((System.currentTimeMillis() + (60000 * 61)), u));
        System.out.println(m.getStats().getEnergy());
        assertEquals(48, m.getStats().getEnergy());
    }
}