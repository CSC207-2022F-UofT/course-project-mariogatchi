package mariogatchi;

import mariogatchi.entities.Mariogatchi;
import mariogatchi.entities.User;

public class AddMariogatchiRequestModel {
    private User user;
    private Mariogatchi mariogatchi;

        /*
    The input data needed for the CatchMariogatchi use case
    @param Mariogatchi - The Mariogatchi the User wants to catch
    @param User - the User that wants to add the Mariogatchi
     */

    public void AddMariogatchiRequestModel(User user, Mariogatchi mariogatchi){
        this.mariogatchi = mariogatchi;
        this.user = user;
    }


    public Mariogatchi getMariogatchi(){return this.mariogatchi;}

    public User getUser(){ return this.user;}


}
