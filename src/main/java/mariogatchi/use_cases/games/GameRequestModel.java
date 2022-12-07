package mariogatchi.use_cases.games;

import mariogatchi.use_cases.authentication.AuthenticationRequestModel;

public class GameRequestModel {

    private String name = new String();
    private GameRequestModel.GameActions type;

    public enum GameActions {
        CREATE,
        DELETE,

        LOAD;
    }

    public GameRequestModel(String name, GameRequestModel.GameActions type) {
        this.name = new String();
        this.type = type;
    }

    public GameActions getType(){
        return this.type;
    }

    public String getName(){
        return this.name;
    }
}
