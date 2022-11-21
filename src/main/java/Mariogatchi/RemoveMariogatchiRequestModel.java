package Mariogatchi;

public class RemoveMariogatchiRequestModel {
    private Mariogatchi mariogatchi;
    private Environment currEnv;
    private User user;

    public RemoveMariogatchiRequestModel(Mariogatchi mariogatchi, Environment environment, User user){
        this.mariogatchi = mariogatchi;
        this.currEnv = environment;
        this.user = user;
    }

    public Mariogatchi getMariogatchi(){
        return this.mariogatchi;
    }

    public Environment getCurrEnv(){
        return this.currEnv;
    }

    public User getUser() {
        return this.user;
    }
}
