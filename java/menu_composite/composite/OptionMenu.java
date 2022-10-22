package menu.composite;


/**
 * Parent class of Menu and Option classes.
 */
public abstract class OptionMenu {

    private String title; // Option or menu title
    private String code; // Option or menu execution code

    public OptionMenu(String title, String code) {
        this.title = title;
        this.code = code;
    }


    // Getters
    public String getTitle() {
        return this.title;
    }
    public String getCode() {
        return this.code;
    }


    /* Methods for Option and Menu classes */

    /**
     * Prints the execution code and the title of an option or a menu.
     */
    public void print() {
        System.out.println(this.code + ") " + this.title);
    }

    /**
     * Executes the chosen option of a menu (to override for every sub-Option classes)
     *  or launches the choosing procedure of a menu.
     */
    public abstract void execute();

}
