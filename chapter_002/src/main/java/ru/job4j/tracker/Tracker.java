package ru.job4j.tracker;

import java.util.*;

public class Tracker {
    // Массив для хранение заявок
    private final Item[] items = new Item[100];
    // Указатель ячейки для новой заявки
    private int position = 0;
    private static final Random RN = new Random();

    //добавление заявок
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
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
    public boolean replace(String id, Item item) {
        boolean flag = false;
        int index = 0;
        for (; index < this.position; index++) {
            if (this.items[index].getId().equals(id)) {
                flag = true;
                break;
            }
        }
        if (index < this.position) {
            item.setId(id);
            this.items[index] = item;
        }
        return flag;
    }

    // удаление заявок
    public boolean delete(String id) {
        boolean flag = false;
        int index = 0;
        int i = 0;
        Item temp;
        for (; index < this.position; index++) {
            if (this.items[index].getId().equals(id)) {
                flag = true;
                break;
            }
            i++;
        }
        for (; index < this.position - 1; index++) {
            temp = this.items[index];
            this.items[index] = this.items[index + 1];
            this.items[index + 1] = temp;
        }
        if (i != this.position) {
            this.items[position - 1] = null;
            this.position--;
        }
        return flag;
    }

    // получение списка всех заявок
    public Item[] findAll() {
        return Arrays.copyOf(this.items, this.position);
    }

    // получение списка по имени
    public Item[] findByName(String key) {
        Item[] result = new Item[this.position];
        int i = 0;
        for (int index = 0; index < this.position; index++) {
            if ((this.items[index].getName()).equals(key)) {
                result[i++] = this.items[index];
            }
        }
        return Arrays.copyOf(result, i);
    }
}
