package factories;

import forestactions.ForestAction;
import forestactions.Release;
import forestactions.ReturnForest;
import forestactions.CatchDemo;

public class ForestFactory {

    //use getAction() method to get the object of type Action
    public ForestAction getAction(String Action) {
        switch (Action) {
            case "release":
                return new Release();
            case "returnForest":
                return new ReturnForest();
            case "catch":
                return new CatchDemo();

            // if Action type is invalid then return the following statement
            default:
                System.out.println("Action " + Action + " cannot be specified and does not run.");
                return null;
        }
    }


}
