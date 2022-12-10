package mariogatchi.use_cases.find_mariogatchi;

import mariogatchi.entities.Mariogatchi;
import mariogatchi.entities.User;
import mariogatchi.entities.environments.Forest;
import mariogatchi.entities.environments.GeneratedMariogatchis;
import mariogatchi.entities.environments.MariogatchiFactory;
import mariogatchi.use_cases.change_environment.EnvironmentFactory;
import static mariogatchi.entities.environments.Env.FOREST;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import org.junit.Test;


public class FindMariogatchiRunnerTest {
    @Test
    public void FindMariogatchiNoMariogatchisRequest(){
        FindMariogatchiOutputBoundary findMariogatchiOutputBoundary = new FindMariogatchiOutputBoundary() {
            @Override
            public FindMariogatchiResponseModel findMariogatchiPrepareSuccessView(FindMariogatchiResponseModel findMariogatchiResponseModel) {
                return findMariogatchiResponseModel;
            }

            @Override
            public FindMariogatchiResponseModel findMariogatchiPrepareFailureView(String errorMessage, FindMariogatchiResponseModel findMariogatchiResponseModel) {
                return findMariogatchiResponseModel;
            }
        };
            User testUser = new User("test user");
            testUser.setMariogatchis(new ArrayList<>());
            EnvironmentFactory environmentFactory = new EnvironmentFactory();
            testUser.setCurrentEnvironment(environmentFactory.getName(FOREST));

        FindMariogatchiRunner findMariogatchiRunner = new FindMariogatchiRunner(findMariogatchiOutputBoundary);
        FindMariogatchiRequestModel findMariogatchiRequestModel = new FindMariogatchiRequestModel(testUser, "find mariogatchi", null);
        FindMariogatchiResponseModel findMariogatchiResponseModel = findMariogatchiRunner.findMariogatchi(findMariogatchiRequestModel);
        assertTrue(findMariogatchiResponseModel.getCatchTrigger());
    }

    @Test
    public void FindMariogatchiNoNextRequest(){
        FindMariogatchiOutputBoundary findMariogatchiOutputBoundary = new FindMariogatchiOutputBoundary() {
            @Override
            public FindMariogatchiResponseModel findMariogatchiPrepareSuccessView(FindMariogatchiResponseModel findMariogatchiResponseModel) {
                return findMariogatchiResponseModel;
            }

            @Override
            public FindMariogatchiResponseModel findMariogatchiPrepareFailureView(String errorMessage, FindMariogatchiResponseModel findMariogatchiResponseModel) {
                return findMariogatchiResponseModel;
            }
        };
            User testUser = new User("test user");
            testUser.setMariogatchis(new ArrayList<>());
            MariogatchiFactory mariogatchiFactory = new MariogatchiFactory();
            Mariogatchi mariogatchi = mariogatchiFactory.getRarity("common");
            mariogatchi.setName("Jiahao Mariogatchi");
            testUser.getMariogatchis().add(mariogatchi);
            EnvironmentFactory environmentFactory = new EnvironmentFactory();
            testUser.setCurrentEnvironment(environmentFactory.getName(FOREST));
            GeneratedMariogatchis generatedMariogatchis = new GeneratedMariogatchis();
            ((Forest) testUser.getCurrentEnvironment()).setGeneratedMariogatchis(generatedMariogatchis);
            Mariogatchi mariogatchiForest = mariogatchiFactory.getRarity("common");
            mariogatchiForest.setName("Mario Mariogatchi");
            ((Forest) testUser.getCurrentEnvironment()).getGeneratedMariogatchis().addMariogatchi(mariogatchiForest);

        FindMariogatchiRunner findMariogatchiRunner = new FindMariogatchiRunner(findMariogatchiOutputBoundary);
        FindMariogatchiRequestModel findMariogatchiRequestModel = new FindMariogatchiRequestModel(testUser, "deny", mariogatchiForest);
        FindMariogatchiResponseModel findMariogatchiResponseModel = findMariogatchiRunner.findMariogatchi(findMariogatchiRequestModel);
        assertFalse(findMariogatchiResponseModel.getCatchTrigger());
        assertNull(findMariogatchiResponseModel.getMariogatchi());
    }

    @Test
    public void FindMariogatchiHasNextRequest(){
        FindMariogatchiOutputBoundary findMariogatchiOutputBoundary = new FindMariogatchiOutputBoundary() {
            @Override
            public FindMariogatchiResponseModel findMariogatchiPrepareSuccessView(FindMariogatchiResponseModel findMariogatchiResponseModel) {
                return findMariogatchiResponseModel;
            }

            @Override
            public FindMariogatchiResponseModel findMariogatchiPrepareFailureView(String errorMessage, FindMariogatchiResponseModel findMariogatchiResponseModel) {
                return findMariogatchiResponseModel;
            }
        };
            User testUser = new User("test user");
            testUser.setMariogatchis(new ArrayList<>());
            MariogatchiFactory mariogatchiFactory = new MariogatchiFactory();
            Mariogatchi mariogatchi = mariogatchiFactory.getRarity("common");
            mariogatchi.setName("Jiahao Mariogatchi");
            testUser.getMariogatchis().add(mariogatchi);
            EnvironmentFactory environmentFactory = new EnvironmentFactory();
            testUser.setCurrentEnvironment(environmentFactory.getName(FOREST));
            GeneratedMariogatchis generatedMariogatchis = new GeneratedMariogatchis();
            ((Forest) testUser.getCurrentEnvironment()).setGeneratedMariogatchis(generatedMariogatchis);
            Mariogatchi mariogatchiForest = mariogatchiFactory.getRarity("common");
            mariogatchiForest.setName("Mario Mariogatchi");
            ((Forest) testUser.getCurrentEnvironment()).getGeneratedMariogatchis().addMariogatchi(mariogatchiForest);

        FindMariogatchiRunner findMariogatchiRunner = new FindMariogatchiRunner(findMariogatchiOutputBoundary);
        FindMariogatchiRequestModel findMariogatchiRequestModel = new FindMariogatchiRequestModel(testUser, "find mariogatchi", null);
        FindMariogatchiResponseModel findMariogatchiResponseModel = findMariogatchiRunner.findMariogatchi(findMariogatchiRequestModel);
        assertNotEquals(findMariogatchiResponseModel.getMariogatchi(), null);
        assertFalse(findMariogatchiResponseModel.getCatchTrigger());
    }

    @Test
    public void FindMariogatchiCatch(){
        FindMariogatchiOutputBoundary findMariogatchiOutputBoundary = new FindMariogatchiOutputBoundary() {
            @Override
            public FindMariogatchiResponseModel findMariogatchiPrepareSuccessView(FindMariogatchiResponseModel findMariogatchiResponseModel) {
                return findMariogatchiResponseModel;
            }

            @Override
            public FindMariogatchiResponseModel findMariogatchiPrepareFailureView(String errorMessage, FindMariogatchiResponseModel findMariogatchiResponseModel) {
                return findMariogatchiResponseModel;
            }
        };
            User testUser = new User("test user");
            testUser.setMariogatchis(new ArrayList<>());
            MariogatchiFactory mariogatchiFactory = new MariogatchiFactory();
            Mariogatchi mariogatchi = mariogatchiFactory.getRarity("common");
            mariogatchi.setName("Jiahao Mariogatchi");
            testUser.getMariogatchis().add(mariogatchi);
            EnvironmentFactory environmentFactory = new EnvironmentFactory();
            testUser.setCurrentEnvironment(environmentFactory.getName(FOREST));
            GeneratedMariogatchis generatedMariogatchis = new GeneratedMariogatchis();
            ((Forest) testUser.getCurrentEnvironment()).setGeneratedMariogatchis(generatedMariogatchis);
            Mariogatchi mariogatchiForest = mariogatchiFactory.getRarity("common");
            mariogatchiForest.setName("Mario Mariogatchi");
            ((Forest) testUser.getCurrentEnvironment()).getGeneratedMariogatchis().addMariogatchi(mariogatchiForest);

        FindMariogatchiRunner findMariogatchiRunner = new FindMariogatchiRunner(findMariogatchiOutputBoundary);
        FindMariogatchiRequestModel findMariogatchiRequestModel = new FindMariogatchiRequestModel(testUser, "accept", mariogatchiForest);
        FindMariogatchiResponseModel findMariogatchiResponseModel = findMariogatchiRunner.findMariogatchi(findMariogatchiRequestModel);
        assertEquals(findMariogatchiResponseModel.getMariogatchi(), findMariogatchiRequestModel.getCurrMariogatchi());
        assertTrue(findMariogatchiResponseModel.getCatchTrigger());
    }
}
