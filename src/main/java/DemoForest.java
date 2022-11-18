import factories.ForestFactory;

import java.util.Scanner;

//Branch 5 replacement class for Forest, testing the getAction() for different actions
//TODO: implement into Nishi's Forest class
public class DemoForest {
    public ForestFactory factory;

    public DemoForest() {
        this.factory = new ForestFactory();
    }

    //asks the User to confirm their Action in the Forest

    //confirmation of User for release method, returns to Forest or returns invalid input if otherwise
    public void release() {
        System.out.println("Are you sure that you want to release this Mariogatchi? Y/N");
        Scanner sc = new Scanner(System.in);
        String result = sc.nextLine();
        if (result.equals("Y")) {
            factory.getAction("release").executes();
            System.out.print("You released your Mariogatchi. Goodbye _insert_name_. ");
        }
        else if (result.equals("N")) {
            factory.getAction("returnForest").executes();
            System.out.println("You have returned to the Forest.");
        }
        else {
            System.out.println("That is an invalid input, please try again.");
        }
    }

    //confirmation of User for catch method, returns to Forest or returns invalid input if otherwise
    public void catchMariogatchi() {
        System.out.println("Are you sure that you want to catch this Mariogatchi? Y/N");
        Scanner sc = new Scanner(System.in);
        String result = sc.nextLine();
        if (result.equals("Y")) {
            factory.getAction("catch").executes();
            System.out.print("You have a new Mariogatchi! Congratulations :)");
        }
        else if (result.equals("N")) {
            factory.getAction("returnForest").executes();
            System.out.println("You have returned to the Forest.");
        }
        else {
            System.out.println("That is an invalid input, please try again.");
        }
    }

}
