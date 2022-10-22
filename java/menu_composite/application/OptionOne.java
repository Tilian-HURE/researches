package menu.application;


import menu.composite.Option;


public class OptionOne extends Option {

    public OptionOne() {
        super("First option", "1");
    }

    @Override
    public void execute() {
        System.out.println("\nThis is the first option.");
    }

}
