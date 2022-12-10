package mariogatchi.use_cases.find_mariogatchi;

import mariogatchi.entities.Mariogatchi;
import mariogatchi.entities.User;
import mariogatchi.entities.environments.Forest;
import mariogatchi.entities.environments.GeneratedMariogatchis;
import mariogatchi.entities.environments.MariogatchiGeneratable;

/**
 * FindMariogatchiRequestModel: the information the use case requests from the controller
 */
public class FindMariogatchiRequestModel {
    private final User USER;
    private final GeneratedMariogatchis GENERATED_MARIOGATCHIS;
    private final boolean CATCH_DECISION;
    private final Mariogatchi CURR_MARIOGATCHI;

    /**
     * Constructs a request model
     * @param user the user who is looking for a Mariogatchi
     * @param choice what the user is choosing to do (find mariogatchi/accept/deny)
     * @param mariogatchi the current Mariogatchi the user sees
     */
    public FindMariogatchiRequestModel(User user, String choice, Mariogatchi mariogatchi) {
        USER = user;
        this.GENERATED_MARIOGATCHIS = ((Forest) user.getCurrentEnvironment()).getGeneratedMariogatchis();
        if (choice.equalsIgnoreCase("find mariogatchi")){
            this.CATCH_DECISION = false;
            this.CURR_MARIOGATCHI = new Mariogatchi("common");
        } else if (choice.equalsIgnoreCase("deny")) {
            this.CATCH_DECISION = false;
            this.CURR_MARIOGATCHI = mariogatchi;
        } else {
            this.CATCH_DECISION = true;
            this.CURR_MARIOGATCHI = mariogatchi;
        }
    }

    /**
     * Returns the user who is looking for a Mariogatchi
     * @return the user who is looking for a Mariogatchi
     */
    public User getUser(){
        return this.USER;
    }

    /**
     * Returns the Mariogatchis in the forest environment the user is in as an iterable class
     * @return the Mariogatchis in the forest environment the user is in as an iterable class
     */
    public GeneratedMariogatchis getGeneratedMariogatchis(){
        return this.GENERATED_MARIOGATCHIS;
    }

    /**
     * Returns the decision the user made
     * @return the decision the user made
     */
    public Boolean getDecision(){
        return this.CATCH_DECISION;
    }

    /**
     * Returns the current Mariogatchi the user sees (null if the user chose find mariogatchi)
     * @return the current Mariogatchi the user sees (null if the user chose find mariogatchi)
     */
    public Mariogatchi getCurrMariogatchi(){
        return CURR_MARIOGATCHI;
    }
}