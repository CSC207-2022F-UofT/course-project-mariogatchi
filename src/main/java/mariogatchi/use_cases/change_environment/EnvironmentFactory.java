package mariogatchi.use_cases.change_environment;
import mariogatchi.entities.environments.*;
/**
 * Use case
 * Concrete factory for the creation of new environment instances
 */
public class EnvironmentFactory {
    /**
     * uses getAction method to get the specified use case to transfer a Mariogatchi
     *
     * @param environment inputs an environment name as a string
     * @return environment class equivalent of string environment input
     */
    public Environment getName(String environment){
        return switch (environment) {
            case "park" -> new Park();
            case "home" -> new Home();
            case "forest" -> new Forest();
            default -> throw new IllegalArgumentException("This is not a valid environment");
        };
    }
}
