package mariogatchi.entities;

import mariogatchi.use_cases.add_mariogatchi.AddMariogatchiRequestModel;
import mariogatchi.use_cases.add_mariogatchi.AddMariogatchiPresenter;
import mariogatchi.use_cases.add_mariogatchi.AddMariogatchiResponseModel;
import mariogatchi.use_cases.add_mariogatchi.AddMariogatchiRunner;

import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AddMariogatchiRunnerTest {
    /*
    Tests the addMariogatchi Use case
     */

    @Test
    public void addmariogatchitestsuccess() {
        /*Tests the case in which a User tries to add a Mariogatchi with all the requirements completed */
        AddMariogatchiRunner mariogatchirunner = new AddMariogatchiRunner(new AddMariogatchiPresenter() {
            @Override
            public AddMariogatchiResponseModel prepareAddSuccessView(AddMariogatchiResponseModel responseModel) {
                return responseModel;
            }

            @Override
            public AddMariogatchiResponseModel prepareAddFailView(String error) {
                return null;
            }
        });
        List<Mariogatchi> lst = new ArrayList<Mariogatchi>();
        User u = new User("");
        u.setMariogatchis(lst);
        AddMariogatchiResponseModel responseModel = mariogatchirunner.addMariogatchiToList(new AddMariogatchiRequestModel(u, new Mariogatchi("Jiahaogatchi", null, "Rare")));
        boolean added = false;
        for (Mariogatchi mar : responseModel.getuser().getMariogatchis()) {
            if (mar.getName().equals(responseModel.getMariogatchi().getName())) {
                added = true;
                break;
            }
        }
        assertTrue(added);
    }



    @Test
    public void addMariogatchiduplicateMariogatchitestFail() {
        /*Tests the case in which a User tries to add a Mariogatchi he already owns */
        AddMariogatchiRunner mariogatchirunner = new AddMariogatchiRunner(new AddMariogatchiPresenter() {
            @Override
            public AddMariogatchiResponseModel prepareAddSuccessView(AddMariogatchiResponseModel responseModel) {
                boolean added = false;
                for (Mariogatchi mar : responseModel.getuser().getMariogatchis()) {
                    if (mar == responseModel.getMariogatchi()) {
                        added = true;
                    }
                }
                assertFalse(added);

                return null;
            }

            @Override
            public AddMariogatchiResponseModel prepareAddFailView(String error) {
                return null;
            }
        });
        List<Mariogatchi> lst = new ArrayList<Mariogatchi>();
        lst.add(new Mariogatchi("Jiahaogatchi", null, "Rare"));
        User u = new User("");
        u.setMariogatchis(lst);
        mariogatchirunner.addMariogatchiToList(new AddMariogatchiRequestModel(u,
                new Mariogatchi("Jiahaogatchi", null, "Rare"))
        );
    }

    @Test
    public void addmariogatchiinventorymaxedtestFail() {
            /*Tests the case in which a User tries to add a Mariogatchi but has no space in inventory */

            AddMariogatchiRunner mariogatchirunner = new AddMariogatchiRunner(new AddMariogatchiPresenter() {
                @Override
                public AddMariogatchiResponseModel prepareAddSuccessView(AddMariogatchiResponseModel responseModel) {
                    boolean added = false;
                    for (Mariogatchi mar : responseModel.getuser().getMariogatchis()) {
                        if (mar == responseModel.getMariogatchi()) {
                            added = true;
                        }
                    }
                    assertFalse(added);

                    return null;
                }

                @Override
                public AddMariogatchiResponseModel prepareAddFailView(String error) {
                    return null;
                }
            });
            List<Mariogatchi> lst = new ArrayList<Mariogatchi>();
            for (int i = 0; i < 10; i++) {
                lst.add(new Mariogatchi("Jiahaogatchi" + i, null, "Rare"));
            }
            User u = new User("");
            u.setMariogatchis(lst);
            mariogatchirunner.addMariogatchiToList(new AddMariogatchiRequestModel(u,
                    new Mariogatchi("Jiahaogatchi", null, "Rare"))
            );
        }
    }
