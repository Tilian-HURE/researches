package menu.composite;


import java.util.ArrayList;
import java.util.Scanner;


/**
 * Menu composed of options and/or sub-menus.
 * Parent class that must be overridden by every sub-Menu classes that implements a menu.
 */
public abstract class Menu extends OptionMenu {

    private ArrayList<OptionMenu> omList; // List of options and/or sub-menus contained in the current menu
    private String exitCode; // Exit code of the current menu

    public Menu(String title, String code, String exitCode) {
        super(title, code);
        this.omList = new ArrayList<OptionMenu>();
        this.exitCode = exitCode;
    }


    /* Setters methods to add, set, or remove an option or a sub-menu from the current menu */

    /**
     * Adds the given option or sub-menu following the others in the current menu.
     * @param optionMenu: option or sub-menu to add
     */
    public void add(OptionMenu optionMenu) {
        this.omList.add(optionMenu);
    }

    /**
     * Replaces the option or the menu from the given index by the given option or sub-menu in the current menu.
     * @param index: index of the option or the sub-menu to replace
     * @param optionMenu: option or sub-menu of replacement
     */
    public void set(int index, OptionMenu optionMenu) {
        this.omList.set(index, optionMenu);
    }

    /**
     * Removes the option or the menu from the given index from the current menu.
     * @param index: index of the option or the sub-menu to replace
     * @throws Exception if the list of options and/or sub-menus is empty
     */
    public void remove(int index) throws Exception {
        if (this.omList.size() == 0) {
            throw new Exception("This menu is empty!");
        }
        this.omList.remove(index);
    }
    /**
     * Removes the given option from the current menu.
     * @param optionMenu: option or sub-menu to remove
     * @throws Exception if the list of options and/or sub-menus is empty
     */
    public void remove(OptionMenu optionMenu) throws Exception {
        if (this.omList.size() == 0) {
            throw new Exception("This menu is empty");
        }
        this.omList.remove(optionMenu);
    }


    /* Methods of this class */

    /**
     * Prints the current menu with its title and its contained options listed.
     */
    private void printMenu() {
        System.out.println("\n" + this.getTitle() + ":");
        if (this.omList.size() > 0) {
            for (OptionMenu optionMenu : this.omList) {
                optionMenu.print();
            }
        } else {
            System.out.println("<this menu is empty>");
        }
        System.out.print(this.exitCode + ") Exit\nChosen option -> ");
    }

    /**
     * Launches a choosing procedure which will execute the chosen option or open the chosen sub-menu.
     */
    @Override
    public void execute()  {
        boolean error = true;
        Scanner input = new Scanner(System.in);
        String choice;
        while (true) {
            this.printMenu();
            choice = input.next();
            for (OptionMenu optionMenu: this.omList) {
                if (choice.equals(optionMenu.getCode())) {
                    optionMenu.execute();
                    error = false;
                    break;
                }
            }
            if (choice.equals(this.exitCode)) {
                break;
            } else if (error) {
                System.out.println("\nThis option isn't in this menu, try again.");
            }
            error = true;
        }
    }

}
