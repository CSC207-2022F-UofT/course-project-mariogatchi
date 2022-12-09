package mariogatchi.entities;

import mariogatchi.use_cases.add_mariogatchi.AddMariogatchiRequestModel;
import mariogatchi.use_cases.add_mariogatchi.AddMariogatchiPresenter;
import mariogatchi.use_cases.add_mariogatchi.AddMariogatchiResponseModel;
import mariogatchi.use_cases.add_mariogatchi.AddMariogatchiRunner;
import org.junit.Test;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AddMariogatchiRunnerTest {

    /*
    Tests the addMariogatchi Use case
     */

    @Test

    void addmariogatchitestsuccess(){
        /*Tests the case in which a User tries to add a Mariogatchi with all the requirements completed */
        AddMariogatchiRunner mariogatchirunner = new AddMariogatchiRunner(new AddMariogatchiPresenter() {
            @Override
            public AddMariogatchiResponseModel prepareSuccessView(AddMariogatchiResponseModel responseModel) {
                boolean added = false;
                for(Mariogatchi mar: responseModel.getuser().getMariogatchis()) {
                    if(mar == responseModel.getMariogatchi()) {
                        added = true;
                    }
                }
                assertTrue(added);

                return null;
            }

            @Override
            public AddMariogatchiResponseModel prepareFailView(String error) {
                return null;
            }
        });

        mariogatchirunner.addMariogatchiToList(new AddMariogatchiRequestModel(new User(""), new Mariogatchi(10,"Jiahaogatchi", null, "Rare")));
        }

    @Test

    void addMariogatchiduplicateMariogatchitestFail(){
        /*Tests the case in which a User tries to add a Mariogatchi he already owns */
        AddMariogatchiRunner mariogatchirunner = new AddMariogatchiRunner(new AddMariogatchiPresenter() {
            @Override
            public AddMariogatchiResponseModel prepareSuccessView(AddMariogatchiResponseModel responseModel) {
                boolean added = false;
                for(Mariogatchi mar: responseModel.getuser().getMariogatchis()) {
                    if(mar == responseModel.getMariogatchi()) {
                        added = true;
                    }
                }
                assertFalse(added);

                return null;
            }

            @Override
            public AddMariogatchiResponseModel prepareFailView(String error) {
                return null;
            }
        });
        List<Mariogatchi> lst = new ArrayList<Mariogatchi>();
        lst.add(new Mariogatchi(10,"Jiahaogatchi", null, "Rare"));
        User u = new User("");
        u.setMariogatchis(lst);
        mariogatchirunner.addMariogatchiToList(new AddMariogatchiRequestModel( u,
                new Mariogatchi(10,"Jiahaogatchi", null, "Rare"))
        );
    }


    void addmariogatchiinventorymaxedtestFail(){
        /*Tests the case in which a User tries to add a Mariogatchi but has no space in inventory */

        AddMariogatchiRunner mariogatchirunner = new AddMariogatchiRunner(new AddMariogatchiPresenter() {
            @Override
            public AddMariogatchiResponseModel prepareSuccessView(AddMariogatchiResponseModel responseModel) {
                boolean added = false;
                for(Mariogatchi mar: responseModel.getuser().getMariogatchis()) {
                    if (mar == responseModel.getMariogatchi()) {
                        added = true;
                    }
                }
                assertFalse(added);

                return null;
            }

            @Override
            public AddMariogatchiResponseModel prepareFailView(String error) {
                return null;
            }
        });
        List<Mariogatchi> lst = new ArrayList<Mariogatchi>();
        for(int i = 0; i < 10; i++){
            lst.add(new Mariogatchi(10,"Jiahaogatchi" + i, null, "Rare"));
        }
        User u = new User("");
        u.setMariogatchis(lst);
        mariogatchirunner.addMariogatchiToList(new AddMariogatchiRequestModel( u,
                new Mariogatchi(10,"Jiahaogatchi", null, "Rare"))
        );
    }
}