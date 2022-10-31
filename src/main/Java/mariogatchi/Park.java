package mariogatchi;

import mariogatchi.Environment;

public class Park extends Environment {

    public Park(){
        this.name = "Park";
        this.elibleActions = [Trainable, Playable];
    }
}
