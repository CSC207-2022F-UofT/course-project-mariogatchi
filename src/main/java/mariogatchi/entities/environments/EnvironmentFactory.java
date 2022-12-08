package mariogatchi.entities.environments;
import mariogatchi.entities.environments.*;
/*
 * Use Case:
 * Concrete factory for the creation of new environment instances
 */
public class EnvironmentFactory {
    /**
     * uses getAction method to get the specified use case to transfer a Mariogatchi
     *
     * @param environment inputs an environment name as an enum/string
     * @return environment class equivalent of the input
     */
    public Environment getName(Env environment){
        return switch (environment) {
            case PARK -> new Park();
            case HOME -> new Home();
            case FOREST -> new Forest();
        };
    }
    public Environment getName(String environment){
        return switch (environment) {
            case "park" -> new Park();
            case "home" -> new Home();
            case "forest" -> new Forest();
            default -> throw new IllegalArgumentException("This environment is not defined in this program");
        };
    }
}
