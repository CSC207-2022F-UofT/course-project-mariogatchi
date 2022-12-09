package mariogatchi.entities;

import java.awt.Image;

public class Mariogatchi {
    /* name is a string representing the name of the mariogatchi.Mariogatchi */
    private String name;

    /* Avatar is and Image representing the  mariogatchi.Mariogatchi  each mariogatchi.Mariogatchi has its own avatar */
    private final Image AVATAR;

    /* Rarity represents the rarity of the  mariogatchi.Mariogatchi,
       rarity can be either uncommon, common, rare and legendary*/
    private String rarity;

    /* Each Mariogatchi posses their own statistics which are defined in the Statistics class*/
    private final Statistics stats;

    /**
     * Big constructor for mariogatchi
     * @param name The mariogatchi's name
     * @param avatar The mariogatchi's avatar
     * @param rarity The mariogatchi's rarity
     */
    public Mariogatchi(String name, Image avatar, String rarity) {
        this.AVATAR = avatar;
        this.name = name;
        this.rarity = rarity;
        stats = new Statistics(rarity);
    }

    public Mariogatchi(String rarity) {
        this.AVATAR = null;
        this.name = null;
        this.rarity = rarity;
        stats = new Statistics(rarity);
        this.rarity = rarity;
    }

    /* Gets the level of the mariogatchi */
    public int getLvl() { return this.lvl; }

    /* Gets the name of the mariogatchi */
    public String getName(){
        return this.name;
    }

    /* Gets the rarity of the mariogatchi*/
    public String getRarity(){
        return this.rarity;
    }

    /* Gets the avatar of the mariogatchi */
    public Image getAvatar(){
        return this.AVATAR;
    }

    /* Gets the Statistics of the mariogatchi */
    public Statistics getStats(){
        return stats;
    }

    public int getLvl(){
        return ((this.stats.getMaxLevel() / 10) - 9);
    }

    public void setName(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "Your mariogatchi:  " + this.name;
    }
}
