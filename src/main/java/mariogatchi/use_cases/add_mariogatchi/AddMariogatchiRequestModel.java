package mariogatchi.use_cases.add_mariogatchi;

import mariogatchi.entities.Mariogatchi;
import mariogatchi.entities.User;

public class AddMariogatchiRequestModel {
    private User user;
    private Mariogatchi mariogatchi;

    public AddMariogatchiRequestModel(User user, Mariogatchi mariogatchi){
        this.mariogatchi = mariogatchi;
        this.user = user;
    }

    public Mariogatchi getMariogatchi(){return this.mariogatchi;}

    public User getUser(){ return this.user;}


}
