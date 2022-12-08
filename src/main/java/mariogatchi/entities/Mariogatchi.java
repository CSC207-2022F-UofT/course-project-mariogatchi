package mariogatchi.entities;

import java.awt.Image;

public class Mariogatchi {
    /* name is a string representing the name of the mariogatchi.Mariogatchi */
    private String name;

    /* Avatar is and Image representing the  mariogatchi.Mariogatchi  each mariogatchi.Mariogatchi has its own avatar */
    private Image avatar;

    /* lvl is an int representing the current level if the mariogatchi.Mariogatchi it can increase through actions and time*/
    private int lvl;


    /* Rarety represents the rarety of the  mariogatchi.Mariogatchi,
       rarety can be either uncommon, common, rare and legendary*/
    private String rarity;


    /* Each mariogatchi has his own xp amount. This int is used to check if the level should increase */
    private int xp;

    /* Each Mariogatchi posses their own statistics which are defined in the Statistics class*/
    private Statistics stats;

    /**
     * Big constructor for mariogatchi
     * @param level The mariogatchi's level
     * @param name The mariogatchi's name
     * @param avatar The mariogatchi's avatar
     * @param rarity The mariogatchi's rarity
     */
    public Mariogatchi(int level, String name, Image avatar, String rarity) {
        this.avatar = avatar;
        this.lvl = level;
        this.name = name;
        this.rarity = rarity;
        stats = new Statistics(rarity);
    }

    public Mariogatchi(String rarity) {
        this.avatar = null;
        this.lvl = 1;
        this.name = null;
        this.rarity = rarity;
        stats = new Statistics(rarity);
        this.rarity = rarity;
    }

    /* Gets the level of the mariogatchi */
    public int getLvl() { return this.lvl; }

    /* Gets the name of the mariogatchi */
    public String getName() { return this.name; }

    /* Gets the rarity of the mariogatchi*/
    public String getRarity() { return this.rarity; }

    /* Gets the avatar of the mariogatchi */
    public Image getAvatar() { return this.avatar; }

    /* Gets the Statistics of the mariogatchi */
    public Statistics getStats() {
        return stats;
    }

    public void setName(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "Your mariogatchi.Mariogatchi " + this.name + " is level " + this.lvl + "... No wonder why he's" + this.rarity;
    }
}
