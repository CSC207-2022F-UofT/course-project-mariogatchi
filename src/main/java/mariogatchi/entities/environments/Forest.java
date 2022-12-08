package mariogatchi.entities.environments;

import mariogatchi.entities.Mariogatchi;
import mariogatchi.entities.MariogatchiFactory;
import static mariogatchi.entities.environments.Env.FOREST;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/*
 * Entity:
 * Forest subclass of environment; unlike the other environments, the forest subclass creates 1-5 Mariogatchis
 * upon initialization and stored them in generatedMariogatchis
 */
public class Forest extends Environment implements MariogatchiGeneratable {
    /*
     * Constructor:
     * create an instance of the forest subclass using the parent constructor
     * <p>
     * generateMariogatchis: this class inherits MariogatchiGeneratable, so it is capable of creating new Mariogatchis,
     * which it does and stores in the instance attribute
     */
    public Forest() {
        super(FOREST);
        List<Mariogatchi> generatedMariogatchis = createMariogacthis();
    }
    @Override
    public List<Mariogatchi> createMariogacthis() {
        /*
         * Method - Overridden (inherited from interface):
         * 1. create a Mariogatchi simple factory
         * 2. pull a random number from numberOfMariogatchis and store this value in randomNumber
         * 3. create an empty list to hold the new Mariogatchis
         * 4. create randomNumber of Mariogatchis, storing each one in generatedMariogatchis
         *
         * Notes:
         * - the probability of generating 1, 2, 3, 4, or 5 Mariogatchis is 2/15, 4/15, 6/15, 2/15, and 1/15 respectively
         * - the first three Mariogatchis will be common, the fourth and fifth Mariogatchi will be rare
         * - the fifth Mariogatchi will be rare and leveled up
         */
        MariogatchiFactory mariogatchiFactory = new MariogatchiFactory();
        List<Integer> numberOfMariogatchis = Arrays.asList(1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 4, 4, 5);
        List<String> rarityTypes = Arrays.asList("common", "common", "common", "rare", "rare");

        Random rand = new Random();
        int randomNumber = numberOfMariogatchis.get(rand.nextInt(numberOfMariogatchis.size()));

        List<Mariogatchi> generatedMariogatchis = new ArrayList<>();
        for (int i = 0; i < randomNumber; i++) {
            Mariogatchi newMariogatchi = mariogatchiFactory.getRarity(rarityTypes.get(i));
            if (i == 4) {
                newMariogatchi.increaselvl();
            }
            generatedMariogatchis.add(newMariogatchi);
        }
        return generatedMariogatchis;
    }
}

