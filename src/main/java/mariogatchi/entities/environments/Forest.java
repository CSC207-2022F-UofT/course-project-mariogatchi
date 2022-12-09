package mariogatchi.entities.environments;

import mariogatchi.entities.Mariogatchi;
import mariogatchi.use_cases.change_environment.MariogatchiGeneratable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static mariogatchi.entities.environments.Env.FOREST;

/**
 * Entity Subclass
 * Forest subclass of environment; unlike the other environments, the forest subclass creates 1-5 Mariogatchis
 * upon initialization and stored them in generatedMariogatchis
 */
public class Forest extends Environment implements MariogatchiGeneratable {
    private List<Mariogatchi> generatedMariogatchis;
    /**
     * Constructor:
     * create an instance of the forest subclass using the parent constructor
     * <p>
     * generateMariogatchis: this class inherits MariogatchiGeneratable, so it is capable of creating new Mariogatchis,
     * which it does and stores in the instance attribute
     */
    public Forest() {
        super(FOREST);
        this.generatedMariogatchis = createMariogacthis();
    }

    /**
     * creates up to 5 random mariogatchis
     * @return the iterable list of Mariogatchis stored in the forest
     */
    public List<Mariogatchi> getGeneratedMariogatchis(){
        return this.generatedMariogatchis;
    }

    public void setGeneratedMariogatchis(List<Mariogatchi> generatedMariogatchis){
        this.generatedMariogatchis = generatedMariogatchis;
    }

    /**
     * @author Humayura Nishi
     * <p>
     * Method - Overridden (inherited from interface):
     * 1. create a Mariogatchi simple factory
     * 2. pull a random number from numberOfMariogatchis and store this value in randomNumber
     * 3. create an empty list to hold the new Mariogatchis
     * 4. create randomNumber of Mariogatchis, storing each one in generatedMariogatchis
     * <p>
     * Notes:
     * - the probability of generating 1, 2, 3, 4, or 5 Mariogatchis is 2/15, 4/15, 6/15, 2/15, and 1/15 respectively
     * - the first three Mariogatchis will be common, the fourth and fifth Mariogatchi will be rare
     * - the fifth Mariogatchi will be rare and leveled up
     */
    @Override
    public List<Mariogatchi> createMariogacthis() {
        MariogatchiFactory mariogatchiFactory = new MariogatchiFactory();
        List<Integer> numberOfMariogatchis = Arrays.asList(1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 4, 4, 5);
        List<String> rarityTypes = Arrays.asList("common", "common", "common", "rare", "rare");
        List<String> names = Arrays.asList("Nishi Mariogatchi", "Nicole Mariogatchi", "Grace Mariogatchi",
                "Najim Mariogatchi", "Anthony Mariogatchi", "Spencer Mariogatchi", "Samuel Mariogatchi",
                "Vivek Mariogatchi", "Jiahao Mariogatchi", "Mario Mariogatchi");

        Random rand = new Random();
        int randomNumber = numberOfMariogatchis.get(rand.nextInt(numberOfMariogatchis.size()));

        List<Mariogatchi> generatedMariogatchis = new ArrayList<>();
        for (int i = 0; i < randomNumber; i++) {
            Mariogatchi newMariogatchi = mariogatchiFactory.getRarity(rarityTypes.get(i));
                Random rand1 = new Random();
                String randomName = names.get(rand1.nextInt(names.size()));
            newMariogatchi.setName(randomName);
            if (i == 4) {
                newMariogatchi.getStats().levelUp();
            }
            generatedMariogatchis.add(newMariogatchi);
        }
        return generatedMariogatchis;
    }
}

