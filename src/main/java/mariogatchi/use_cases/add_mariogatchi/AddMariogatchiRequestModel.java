package mariogatchi.use_cases.add_mariogatchi;

import mariogatchi.entities.Mariogatchi;
import mariogatchi.entities.User;

public class AddMariogatchiRequestModel {
    private User user;
    private Mariogatchi mariogatchi;

        /**
    The input data needed for the CatchMariogatchi use case
    @param mariogatchi - The Mariogatchi the User wants to catch
    @param user - the User that wants to add the Mariogatchi
     */

    public AddMariogatchiRequestModel(User user, Mariogatchi mariogatchi){
        this.mariogatchi = mariogatchi;
        this.user = user;
    }


    public Mariogatchi getMariogatchi(){return this.mariogatchi;}

    public User getUser(){ return this.user;}


}
