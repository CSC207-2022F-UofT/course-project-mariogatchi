package mariogatchi;

public class AddMariogatchiResponseModel {
        private User user;
        private Mariogatchi mariogatchi;

        /*
        The Response Model (output data) for the AddItem Use Case
        @param Mariogatchi - The mariogatchi that was to be added to the inventory
        @param User - The User who wants to catch the Mariogatchi
         */
        public  AddMariogatchiResponseModel(Mariogatchi mariogatchi, User user) {
            this.mariogatchi = mariogatchi;
            this.user = user;
        }

        // returns the Mariogatchi
        public Mariogatchi get() {
            return this.mariogatchi;
        }
        // returns the User
        public User getuser(){return this.user;}
    }
