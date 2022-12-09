package mariogatchi.use_cases.games;

import mariogatchi.entities.User;

public class GameResponseModel {
    public User user;

    public String message;

    public GameResponseModel(User user, String message) {
        this.user = user;
        this.message = message;
    }

    public User getUser() {
        return this.user;
    }

    public String getMessage(){
        return this.message;
    }
}
