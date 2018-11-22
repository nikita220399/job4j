package ru.job4j.tracker;

public class StartUI {
    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String ADD = "0";

    /**
     * Константа для выхода из цикла.
     */
    private static final String EXIT = "6";
    /**
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Конструтор инициализирующий поля.
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            if (ADD.equals(answer)) {
                //добавление заявки вынесено в отдельный метод.
                this.createItem();
            } else if (answer.equals("1")) {
                this.findAllItem();
            } else if (EXIT.equals(answer)) {
                exit = true;
            } else if (answer.equals("2")) {
                this.replaceItem();
            } else if (answer.equals("3")) {
                this.deleteItem();
            } else if (answer.equals("4")) {
                this.findByIdItem();
            } else if (answer.equals("5")) {
                this.findByNameItem();
            }
        }
    }

    /**
     * Метод реализует добавленяи новый заявки в хранилище.
     */
    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
    }

    private void replaceItem() {
        System.out.println("------------ Редактирование заявки --------------");
        String id = this.input.ask("Введите id заявки :");
        String name = this.input.ask("Введите имя новой заявки :");
        String desc = this.input.ask("Введите описание новой заявки :");
        Item item = new Item(name, desc);
        boolean flag = this.tracker.replace(id, item);
        if (flag == true) {
            System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
            System.out.println("------------ Новая заявка с именем : " + item.getName() + "-----------");
            System.out.println("------------ Новая заявка с описанием : " + item.getDesc() + "-----------");
        } else {
            System.out.println("------------ Заявка с таким id не найдена --------------");
        }
    }

    private void findAllItem() {
        Item[] result = tracker.findAll();
        if (result.length != 0) {
            System.out.println("------------ Все добавленные заявки --------------");
            int i = 1;
            for (Item item : result) {
                System.out.println("------------ Заявка №" + i + " --------------");
                System.out.println("GetId заявки: " + item.getId());
                System.out.println("Имя заявки: " + item.getName());
                System.out.println("Описание заявки : " + item.getDesc());
                i++;
            }
        } else {
            System.out.println("------------ Вы не добавляли заявки!!! --------------");
        }
    }

    private void deleteItem() {
        System.out.println("------------ Удаление заявки --------------");
        String id = this.input.ask("Введите id заявки :");
        boolean flag = tracker.delete(id);
        if (flag == true) {
            System.out.println("------------ Заявка удалена!!! --------------");
        } else {
            System.out.println("------------ Заявка в таким id не найдена. УДАЛЕНИЕ НЕ ПРОИЗОШЛО!!! --------------");
        }
    }

    private void findByIdItem() {
        System.out.println("------------ Поиск заявки по id --------------");
        String id = this.input.ask("Введите id заявки :");
        Item item;
        item = tracker.findById(id);
        if (item != null) {
            System.out.println("------------ Найденная заявка --------------");
            System.out.println("GetId заявки: " + item.getId());
            System.out.println("Имя заявки : " + item.getName());
            System.out.println("Описание заявки : " + item.getDesc());
        } else {
            System.out.println("------------ Заявка с таким id не найдена --------------");
        }
    }

    private void findByNameItem() {
        System.out.println("------------ Получение списка заявок по имени --------------");
        String name = this.input.ask("Введите имя заявки :");
        Item[] result = tracker.findByName(name);
        int i = 1;
        if (result.length != 0) {
            for (Item item : result) {
                System.out.println("------------ Заявка №" + i + " --------------");
                System.out.println("GetId заявки : " + item.getId());
                System.out.println("Имя заявки : " + item.getName());
                System.out.println("Описание заявки : " + item.getDesc());
                i++;
            }
        } else {
            System.out.println("------------ Заявки с таким именем не найдены --------------");
        }
    }

    private void showMenu() {
        System.out.println("Меню.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
        System.out.println("Select:");
    }

    /**
     * Запускт программы.
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
