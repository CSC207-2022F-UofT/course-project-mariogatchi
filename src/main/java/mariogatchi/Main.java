package mariogatchi;

import mariogatchi.removemariogatchi.RemoveMariogatchi;
import mariogatchi.removemariogatchi.killmariogatchi.Starvation;

public class Main {
    public static void main(String[] args) {
        RemoveMariogatchi r = new Starvation();
        User user= new User("your mom");
        ReleasePresenter presenter = new ReleasePresenter();
        Mariogatchi mario = new Mariogatchi();
        r.execute(user, mario, presenter);
    }
}
