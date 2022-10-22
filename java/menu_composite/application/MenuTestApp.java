package menu.application;


import menu.composite.Menu;


/**
 * Applicative test class to show a usage of the OptionMenu, Option and Menu classes.
 */
public class MenuTestApp {

    public static void main(String[] args) {
        // Create the main menu and its sub-menu
        Menu mainMenu = new MainMenu();
        Menu subMenu = new SubMenu();

        // Add options and the sub-menu in the main menu
        mainMenu.add(new OptionOne());
        mainMenu.add(new OptionTwo());
        mainMenu.add(subMenu);

        // Add an option in the sub-menu
        //subMenu.add(new OptionThree());

        // Execute the main menu
        mainMenu.execute();
    }

}
