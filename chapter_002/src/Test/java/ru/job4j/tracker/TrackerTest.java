package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {
    // добавление заявки
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1","testDescription",123L);
        tracker.add(item);
        assertThat(tracker.findAll()[0], is(item));
    }

    // редактирование заявки
    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1","testDescription",123L);
        // Добавляем заявку в трекер. Теперь в объект проинициализирован id.
        tracker.add(previous);
        // Создаем новую заявку.
        Item next = new Item("test2","testDescription2",1234L);
        // Проставляем старый id из previous, который был сгенерирован выше.
        next.setId(previous.getId());
        // Обновляем заявку в трекере.
        tracker.replace(previous.getId(), next);
        // Проверяем, что заявка с таким id имеет новые имя test2.
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }

    // получение заявки по id
    @Test
    public void whenItemThenTrackerHasSameItemToId() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1","testDescription",123L);
        tracker.add(item);
        assertThat(tracker.findById(item.getId()).getName(), is("test1"));
        assertThat(tracker.findById(item.getId()), is(item));
    }

    // удаление заявок
    @Test
    public void whenAddNewItemThenTrackerHasDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1","testDescription",123L);
        tracker.add(item);
        Item item2 = new Item("test2","testDescription2",222L);
        tracker.add(item2);
        assertThat(tracker.findAll()[0], is(item));
        assertThat(tracker.findAll()[1], is(item2));
        tracker.delete(item.getId());
        assertThat(tracker.findAll()[0], is(item2));
    }

    // получение списка по имени
    @Test
    public void whenAddNewItemThenTrackerHasGetNameListItem() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test","testDescription",123L);
        tracker.add(item1);
        Item item2 = new Item("test2","testDescription2",1232L);
        tracker.add(item2);
        Item item3 = new Item("test","testDescription3",1233L);
        tracker.add(item3);
        Item[] arr = new Item[2];
        arr[0] = item1;
        arr[1] = item3;
        Item[] exp = tracker.findByName("test");
        assertThat(exp, is(arr));
    }
}
