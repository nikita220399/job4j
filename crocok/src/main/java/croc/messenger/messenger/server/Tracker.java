package croc.messenger.messenger.server;

import java.util.*;

public class Tracker {
    // Коллекция для хранение заявок
    private static List<Item> items = new ArrayList<>();
    // Указатель ячейки для новой заявки
    private static int position = 0;
    private static final Random RN = new Random();

    //добавление заявок
    public void add(Item item) {
        item.setId(this.generateId());
        this.items.add(item);
        this.position++;
    }

    // Метод генерирует уникальный ключ для заявки
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }

    // получение заявки по id
    public Item findById(String id) {
        Item result = null;
        for (Item item : this.items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }


    // редактирование заявок
    public boolean replace(String id, String desc) {
        boolean flag = false;
        int index = 0;
        for (; index < this.position; index++) {
            if (this.items.get(index).getId().equals(id)) {
                flag = true;
                break;
            }
        }
        if (index < this.position) {
            this.items.get(index).setDesc(desc);
        }
        return flag;
    }

    // удаление заявок
    public boolean delete(String id) {
        boolean flag = false;
        int index = 0;
        for (; index < this.position; index++) {
            if (this.items.get(index).getId().equals(id)) {
                flag = true;
                this.items.remove(index);
                this.position--;
                break;
            }
        }
        return flag;
    }

    // получение списка всех заявок
    public List<Item> findAll() {
        return this.items;
    }

    // получение списка по имени
    public Item[] findByName(String key) {
        Item[] result = new Item[this.position];
        int i = 0;
        for (int index = 0; index < this.position; index++) {
            if ((this.items.get(index).getName()).equals(key)) {
                result[i++] = this.items.get(index);
            }
        }
        return Arrays.copyOf(result, i);
    }
}
