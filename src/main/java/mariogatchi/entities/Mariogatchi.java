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

    public void Mariogatchi(int level, String name, Image avatar, String rarity) {
        this.avatar = avatar;
        this.lvl = level;
        this.name = name;
        this.rarity = rarity;
        stats = new Statistics(rarity);
    }

    /* Gets the level of the mariogatchi */
    public int getLvl() { return this.lvl; }

    /* Gets the name of the mariogatchi */
    public String getName() { return this.name; }

    /* Gets the rarity of the mariogatchi*/
    public String getRarity() { return this.rarity; }

    /* Gets the avatar of the mariogatchi */
    public Image getAvatar() { return this.avatar; }

    @Override
    public String toString() {
        return "Your mariogatchi.Mariogatchi " + this.name + " is level " + this.lvl + "... No wonder why he's" + this.rarity;
    }

    public boolean increaselvl() {
        if (this.stats.getAgility() >= this.stats.getMaxLevel() && this.stats.getMaxLevel() >= this.stats.getStrategy()) {     /* This function upgrades the mariogatchi.Mariogatchi Level only if the XP level passes the level cap*/
            this.stats.LevelUp();
            this.stats.ResetAgility();
            return true;
        } else {
            return false;
        }


    }
}
