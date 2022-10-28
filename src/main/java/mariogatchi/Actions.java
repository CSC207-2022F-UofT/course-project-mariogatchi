package mariogatchi;

public class Actions {

    public String releaseMariogatchi(){
        /**
         * Releases the selected Mariogatchi from the Users collection of Mariogatchi.
         * Deletes the selected Mariogatchi's statistics.
         *
         * @param userName the username
         * @param password the passwor
         * TODO: Remove the Mariogatchi statistics, remove Mariogatchi from collection of Mariogatchis
         * TODO: Return the User to view main list of eligibleActions of Forest
         */
        return "Mariogatchi has been released.";
    }

    public String neverMind(){
        /*
          TODO: Return the User to view main list of eligibleActions of Forest
         */
        return "Mariogatchi remains in your inventory.";
    }
}
