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
    public void replace(String id, Item item) {
        int i = 0;
        for (Item arr : this.items) {
            if (arr != null && arr.getId().equals(id)) {
                break;
            }
            i++;
        }
        if (this.items[i] != null) {
            this.items[i] = item;
        }
    }

    // удаление заявок
    public void delete(String id) {
        int i = 0;
        Item[] array = new Item[this.position];
        this.position--;
        Item temp;
        for (Item item : this.items) {
            if (item != null && item.getId().equals(id)) {
                break;
            }
            i++;
        }
        for (; i <= this.position; i++) {
            temp = this.items[i];
            this.items[i] = this.items[i + 1];
            this.items[i + 1] = temp;
        }
        this.items[position] = null;
        System.arraycopy(this.items, 0, array, 0, this.position);
    }

    // получение списка всех заявок
    public Item[] findAll() {
        return Arrays.copyOf(this.items, this.position);
    }

    // получение списка по имени
    public Item[] findByName(String key) {
        Item[] result = new Item[this.position];
        int i = 0;
        for (Item item : this.items) {
            if ((item.getName()).equals(key)) {
                result[i++] = item;
            }
            if (item == null) {
                break;
            }
        }
        return Arrays.copyOf(result, i);
    }
}
