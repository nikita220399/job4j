package ru.job4j.tracker;

public class StartUI {
    private Input input;

    public StartUI(Input input) {
        this.input = input;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        Tracker tracker = new Tracker();
        MenuTracker menu = new MenuTracker(this.input, tracker);
        int[] ranges = new int[]{0, 1, 2, 3, 4, 5};
        menu.fillActions();
        do {
            menu.show();
            menu.select(this.input.ask("Select: ", ranges));
        } while (!"y".equals(this.input.ask("Exit?(y): ")));
    }

    /**
     * Запускт программы.
     * @param args
     */
    public static void main (String[] args) {
        Input input = new ValidateInput(new ConsoleInput());
        new StartUI(input).init();
    }
}
