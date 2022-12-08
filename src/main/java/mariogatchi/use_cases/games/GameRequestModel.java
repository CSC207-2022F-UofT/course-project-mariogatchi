package mariogatchi.use_cases.games;

public class GameRequestModel {

    private final String NAME;
    private final GameRequestModel.GameActions TYPE;

    public enum GameActions {
        CREATE,
        DELETE,
        LOAD
    }

    /**
     The input data needed for the Playdate use case
     @param name- the name of the User to act on
     @param type - what to do with that username
     */
    public GameRequestModel(String name, GameRequestModel.GameActions type) {
        this.NAME = name;
        this.TYPE = type;
    }

    public GameActions getTYPE(){
        return this.TYPE;
    }

    public String getNAME(){
        return this.NAME;
    }
}
