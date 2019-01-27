package ru.job4j.tracker;
import java.util.*;

class EditItem extends BaseAction {

    public EditItem(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Редактирование заявки --------------");
        String id = input.ask("Введите id заявки :");
        String name = input.ask("Введите имя новой заявки :");
        String desc = input.ask("Введите описание новой заявки :");
        Item item = new Item(name, desc);
        boolean flag = tracker.replace(id, item);
        if (flag == true) {
            System.out.println("Новая заявка после редактирования: ");
            System.out.println(item.toString());
        } else {
            System.out.println("------------ Заявка с таким id не найдена --------------");
        }
    }
}

public class MenuTracker  {
    private Input input;
    private Tracker tracker;
    private UserAction[] actions = new UserAction[6];

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void fillActions() {
        this.actions[0] = new AddItem(0, "Add the new item.");
        this.actions[1] = new MenuTracker.ShowItem(1, "Show items.");
        this.actions[2] = new EditItem(2, "Edit the new item.");
        this.actions[3] = new DeleteItem(3, "Delete items.");
        this.actions[4] = new FindIdItem(4, "Find ID items.");
        this.actions[5] = new FindNameItem(5, "Find Name items.");
    }

    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    public void select(int key) {
        this.actions[key].execute(this.input, this.tracker);
    }

    private class AddItem extends BaseAction {

        public AddItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Adding new item --------------");
            String name = input.ask("Please, provide item name:");
            String desc = input.ask("Please, provide item description:");
            Item item = new Item(name, desc);
            tracker.add(item);
            System.out.println("------------ New Item with Id : " + item.getId());
            System.out.println("------------ New Item with Name : " + item.getName());
            System.out.println("------------ New Item with Description : " + item.getDesc());
        }
    }

    private static class ShowItem extends BaseAction {
        public ShowItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            List<Item> result = tracker.findAll();
            if (result.size() != 0) {
                System.out.println("------------ Все добавленные заявки --------------");
                int i = 1;
                for (Item item : result) {
                    System.out.println("------------ Заявка №" + i + " --------------");
                    System.out.println(item.toString());
                    i++;
                }
            } else {
                System.out.println("------------ Вы не добавляли заявки!!! --------------");
            }
        }
    }

    private class DeleteItem extends BaseAction {
        public DeleteItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Удаление заявки --------------");
            String id = input.ask("Введите id заявки :");
            boolean flag = tracker.delete(id);
            if (flag == true) {
                System.out.println("------------ Заявка удалена!!! --------------");
            } else {
                System.out.println("------------ Заявка в таким id не найдена. УДАЛЕНИЕ НЕ ПРОИЗОШЛО!!! --------------");
            }
        }
    }

    private class FindIdItem extends BaseAction {
        public FindIdItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Поиск заявки по id --------------");
            String id = input.ask("Введите id заявки :");
            Item item;
            item = tracker.findById(id);
            if (item != null) {
                System.out.println("------------ Найденная заявка --------------");
                System.out.println(item.toString());
            } else {
                System.out.println("------------ Заявка с таким id не найдена --------------");
            }
        }
    }

    private class FindNameItem extends BaseAction {
        public FindNameItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Получение списка заявок по имени --------------");
            String name = input.ask("Введите имя заявки :");
            Item[] result = tracker.findByName(name);
            int i = 1;
            if (result.length != 0) {
                for (Item item : result) {
                    System.out.println("------------ Заявка №" + i + " --------------");
                    System.out.println(item.toString());
                    i++;
                }
            } else {
                System.out.println("------------ Заявки с таким именем не найдены --------------");
            }
        }
    }
}
