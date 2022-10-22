package menu.composite;


/**
 * Simple option of a menu.
 * Parent class that must be overridden by every sub-Option classes that implements an option.
 */
public abstract class Option extends OptionMenu {

    public Option(String title, String code) {
        super(title, code);
    }

    /**
     * Executes the chosen option of a menu (to override for every sub-Option classes).
     */
    @Override
    public abstract void execute();

}
