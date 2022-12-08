package mariogatchi.use_cases.add_mariogatchi;

import mariogatchi.entities.Mariogatchi;
import mariogatchi.entities.User;

public class AddMariogatchiRequestModel {
    private final User USER;
    private final Mariogatchi MARIOGATCHI;
    
    public AddMariogatchiRequestModel(User user, Mariogatchi mariogatchi){
        this.MARIOGATCHI = mariogatchi;
        this.USER = user;
    }

    public Mariogatchi getMariogatchi(){
        return MARIOGATCHI;}

    public User getUser(){
        return USER;}


}
