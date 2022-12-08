package mariogatchi.entities;

import java.util.*;


public class Calculations {
    public enum sortOrder{
        FORWARDS,
        REVERSE
    }
    public float healthIndex(Mariogatchi mariogatchi1) {
        /**
         * Calculates the health index of mariogatchi which shows how healthy he/she is overall
         */

        float index = (mariogatchi1.getStats().getCleanliness() +
                2 * mariogatchi1.getStats().getHappiness() +
                mariogatchi1.getStats().getHunger() * mariogatchi1.getStats().getEnergy()) / 100;

        return index;

    }

    public float combatIndex(Mariogatchi mariogatchi1) {
        /**
         * Overall fighting power of mariogatchi based on its current stats and level
         */
        float index = (mariogatchi1.getLvl() * (mariogatchi1.getStats().getStrategy() + 3 * mariogatchi1.getStats().getAgility() +
                mariogatchi1.getStats().getHunger() * mariogatchi1.getStats().getEnergy())) / 100;

        return index;

    }

    public float performanceIndex(Mariogatchi mariogatchi1) {
        /**
         * The performance index of a single mariogatchi
         */

        float index = (mariogatchi1.getStats().sum()) / 100;

        return index;
    }

    public float performanceIndexAll(List<Mariogatchi> mariogatchiList) {
        /**
         * The performance index of all the mariogatchis
         */
        int sum = 0;

        int len = mariogatchiList.size();
        for (Mariogatchi mariogatchi1 : mariogatchiList) {
            sum += mariogatchi1.getStats().sum();
        }
        float index = sum / len;
        return index;


    }

    public float averageStat(Statistics.Stats stat, List<Mariogatchi> mariogatchiList) {

        /**
         * Takes the average of a specific stat for all the mariogatchis
         */
        int sum = 0;
        int len = mariogatchiList.size();

        for (Mariogatchi mariogatchii : mariogatchiList) {
            sum += mariogatchii.getStats().getStat(stat);
        }

        float averagee = sum / len;
        return averagee;
    }

    public List<Mariogatchi> sortMariogatchis(List<Mariogatchi> mariogatchiList, String compareBy, sortOrder order) {

        /**
         * Sorting Method for mariogatchis
         * Takes the mariogatchi list input and compareby string as the input
         */
        List<Mariogatchi> returnList = new ArrayList<Mariogatchi>();
        returnList.addAll(mariogatchiList);
        switch (order) {
            case FORWARDS:
                Collections.sort(returnList, new Comparator<Mariogatchi>() {
                    public int compare(Mariogatchi m1, Mariogatchi m2) {
                        switch (compareBy) {
                            case "Agility":
                                return m1.getStats().getAgility() - m2.getStats().getAgility();
                            case "Strategy":
                                return m1.getStats().getStrategy() - m2.getStats().getStrategy();
                            case "Cleanliness":
                                return m1.getStats().getCleanliness() - m2.getStats().getCleanliness();
                            case "Energy":
                                return m1.getStats().getEnergy() - m2.getStats().getEnergy();
                            case "Hunger":
                                return m1.getStats().getHunger() - m2.getStats().getHunger();
                            case "Happiness":
                                return m1.getStats().getHappiness() - m2.getStats().getHappiness();
                            case "Combat":
                                return (int) (combatIndex(m1) - combatIndex(m2));
                            case "Health":
                                return (int) (healthIndex(m1) - healthIndex(m2));
                            case "Level":
                            default:
                                return m1.getLvl() - m2.getLvl();
                        }
                    }
                });
            case REVERSE:
                Collections.sort(returnList, new Comparator<Mariogatchi>() {
                    public int compare(Mariogatchi m1, Mariogatchi m2) {
                        switch (compareBy) {
                            case "Agility":
                                return m2.getStats().getAgility() - m1.getStats().getAgility();
                            case "Strategy":
                                return m2.getStats().getStrategy() - m1.getStats().getStrategy();
                            case "Cleanliness":
                                return m2.getStats().getCleanliness() - m1.getStats().getCleanliness();
                            case "Energy":
                                return m2.getStats().getEnergy() - m1.getStats().getEnergy();
                            case "Hunger":
                                return m2.getStats().getHunger() - m1.getStats().getHunger();
                            case "Happiness":
                                return m2.getStats().getHappiness() - m1.getStats().getHappiness();
                            case "Combat":
                                return (int) (combatIndex(m2) - combatIndex(m1));
                            case "Health":
                                return (int) (healthIndex(m2) - healthIndex(m1));
                            case "Level":
                            default:
                                return m2.getLvl() - m1.getLvl();
                        }
                    }
                });
        }

        return returnList;
    }

    }

