package menu.application;


import menu.composite.Option;


public class OptionTwo extends Option {

    public OptionTwo() {
        super("Second option", "2");
    }

    @Override
    public void execute() {
        System.out.println("\nThis is the second option.");
    }

}
