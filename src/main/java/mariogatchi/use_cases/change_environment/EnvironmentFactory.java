package mariogatchi.use_cases.change_environment;

import mariogatchi.entities.environments.*;

/**
 * Entity (factory)
 * Concrete factory for the creation of new environment instances
 */
public class EnvironmentFactory {
    /**
     * Simple Factory
     * @param environment inputs an environment name as an enum/string
     */
    public Environment getName(Env environment){
        switch (environment) {
            case PARK:
                return new Park();
            case HOME:
                return new Home();
            case FOREST:
                return new Forest();
            default:
                throw new IllegalArgumentException();
        }
    }
    public Environment getName(String environment){
        switch (environment) {
            case "park":
                return new Park();
            case "home":
                return new Home();
            case "forest":
                return new Forest();
            default:
                throw new IllegalArgumentException("This environment is not defined in this program");
        }
    }
}
