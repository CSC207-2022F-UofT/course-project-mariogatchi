package mariogatchi.use_cases.change_environment;

import mariogatchi.entities.User;
import mariogatchi.entities.environments.EnvironmentFactory;
import static mariogatchi.entities.environments.Env.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class ChangeEnvironmentRunnerTest {
    @Test
    @Order(1)
    void changeEnvironmentFailRequest(){
        ChangeEnvironmentOutputBoundary changeEnvironmentOutputBoundary = new ChangeEnvironmentOutputBoundary() {
            @Override
            public ChangeEnvironmentResponseModel changeEnvPrepareSuccessView(ChangeEnvironmentResponseModel changeEnvironmentResponseModel) {
                return changeEnvironmentResponseModel;
            }

            @Override
            public ChangeEnvironmentResponseModel changeEnvPrepareFailureView(String errorMessage, ChangeEnvironmentResponseModel changeEnvironmentResponseModel) {
                return changeEnvironmentResponseModel;
            }
        };
            User testUser = new User("test user");
            EnvironmentFactory environmentFactory = new EnvironmentFactory();
            testUser.setCurrentEnvironment(environmentFactory.getName(PARK));

        ChangeEnvironmentRunner changeEnvironmentRunner = new ChangeEnvironmentRunner(changeEnvironmentOutputBoundary);
        ChangeEnvironmentRequestModel changeEnvironmentRequestModel = new ChangeEnvironmentRequestModel(testUser, "park");
        ChangeEnvironmentResponseModel changeEnvironmentResponseModel = changeEnvironmentRunner.changeEnvironment(changeEnvironmentRequestModel);
        assertEquals(changeEnvironmentResponseModel.getNewEnvironment(), testUser.getCurrentEnvironment().getName());
    }

    @Test
    @Order(2)
    void changeEnvironmentSuccessRequest(){
        ChangeEnvironmentOutputBoundary changeEnvironmentOutputBoundary = new ChangeEnvironmentOutputBoundary() {
            @Override
            public ChangeEnvironmentResponseModel changeEnvPrepareSuccessView(ChangeEnvironmentResponseModel changeEnvironmentResponseModel) {
                return changeEnvironmentResponseModel;
            }

            @Override
            public ChangeEnvironmentResponseModel changeEnvPrepareFailureView(String errorMessage, ChangeEnvironmentResponseModel changeEnvironmentResponseModel) {
                return changeEnvironmentResponseModel;
            }
        };
            User testUser = new User("test user");
            EnvironmentFactory environmentFactory = new EnvironmentFactory();
            testUser.setCurrentEnvironment(environmentFactory.getName(PARK));

        ChangeEnvironmentRunner changeEnvironmentRunner = new ChangeEnvironmentRunner(changeEnvironmentOutputBoundary);
        ChangeEnvironmentRequestModel changeEnvironmentRequestModel = new ChangeEnvironmentRequestModel(testUser, "home");
        ChangeEnvironmentResponseModel changeEnvironmentResponseModel = changeEnvironmentRunner.changeEnvironment(changeEnvironmentRequestModel);
        assertEquals(changeEnvironmentResponseModel.getNewEnvironment(), changeEnvironmentRequestModel.getNewEnvironment());
    }
}
