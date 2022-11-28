package mariogatchi.use_cases.manager.remove_mariogatchi;

/**
 * Presenter
 * Prints the remove Mariogatchi action text to the console
 */
public class RemoveMariogatchiDisplayer implements RemoveMariogatchiDisplayerInterface{

    /**
     * Prints the text to the console
     * @param text the specified text for removing a Mariogatchi
     */
    public void removeMariogatchiText(String text){
        System.out.println(text);
    }
}
