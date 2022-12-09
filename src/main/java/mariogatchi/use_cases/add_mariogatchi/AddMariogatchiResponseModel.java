package mariogatchi.use_cases.add_mariogatchi;

import mariogatchi.entities.Mariogatchi;
import mariogatchi.entities.User;

import mariogatchi.entities.Mariogatchi;
import mariogatchi.entities.User;

public class AddMariogatchiResponseModel {
        private User user;
        private Mariogatchi mariogatchi;

        /**
        The Response Model (output data) for the AddMariogatchi Use Case
        @param mariogatchi - The mariogatchi that was to be added to the inventory
        @param user - The User who wants to catch the Mariogatchi
         */
        public  AddMariogatchiResponseModel(Mariogatchi mariogatchi, User user) {
            this.mariogatchi = mariogatchi;
            this.user = user;
        }

        // returns the Mariogatchi
        public Mariogatchi getMariogatchi() {
            return this.mariogatchi;
        }
        // returns the User
        public User getuser(){return this.user;}
    }
