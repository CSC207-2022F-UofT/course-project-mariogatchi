package mariogatchi;

public class Actions implements Nevermind, Release{
    /**
     * Class that implements the interfaces.
     **/

    @Override
    public String nevermindRelease(){
        return "Mariogatchi remains in your inventory.";
    }

    @Override
    public String releaseMariogatchi() {
        return "Mariogatchi has been released.";
    }
}
