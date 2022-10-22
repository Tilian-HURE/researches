package menu.application;


import menu.composite.Option;


public class OptionThree extends Option {

    public OptionThree() {
        super("First option of this sub-menu", "1");
    }

    @Override
    public void execute() {
        System.out.println("\nThis is the first option this sub-menu.");
    }

}
