package mariogatchi.use_cases.info_access;

import mariogatchi.entities.Mariogatchi;
import mariogatchi.entities.User;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InformationAccessRunnerTest {

    @Test
    void checkStatistic() {
        InformationAccessRunner infoAccessRunner = new InformationAccessRunner(new InfoAccessPresenter() {
            @Override
            public InfoAccessResponseModel prepareSuccessView(InfoAccessResponseModel responseModel) {
                assertEquals(50, responseModel.getStats().getHunger());
                return null;
            }

            @Override
            public InfoAccessResponseModel prepareFailView(String error) {
                return null;
            }
        });

        User u = new User("");
        List<Mariogatchi> lst = new ArrayList<Mariogatchi>();
        Mariogatchi m = new Mariogatchi("common");
        m.setName("J");
        lst.add(m);
        u.setMariogatchis(lst);
        infoAccessRunner.checkStatistic(new InfoAccessRequestModel("J", u));
    }
}