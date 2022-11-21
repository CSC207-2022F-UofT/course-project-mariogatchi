package mariogatchi;

import mariogatchi.removemariogatchi.factories.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        User user= new User("test user");

        Mariogatchi mariogatchi = new Mariogatchi();
        Mariogatchi mario = new Mariogatchi();

        MariogatchiManager manager = new MariogatchiManager();
        user.setMariogatchis(new ArrayList<>());

        manager.AddMariogatchi(user, mariogatchi);
        manager.AddMariogatchi(user, mario);

        RemoveMariogatchiPresenter presenter = new RemoveMariogatchiPresenter();
        RemoveMariogatchiDisplayer displayer = new RemoveMariogatchiDisplayer();

        RemoveMariogatchiFactory transferFactory = new TransferMariogatchiFactory();
        RemoveMariogatchiFactory killFactory = new KillMariogatchiFactory();

        killFactory.getAction("illness").execute(user, mariogatchi, presenter, displayer);
    }
}
