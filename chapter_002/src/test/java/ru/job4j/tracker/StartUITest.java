package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


public class StartUITest {
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();     // создаём Tracker
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});   //создаём StubInput с последовательностью действий
        new StartUI(input, tracker).init();     //   создаём StartUI и вызываем метод init()
        assertThat(tracker.findAll()[0].getName(), is("test name")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
        Item item = tracker.add(new Item("test name", "desc"));
        //создаём StubInput с последовательностью действий(производим замену заявки)
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "6"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }

    @Test
    public void whenUserAddItemThenTrackerHasItemId() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"4", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("test name"));
    }

    @Test
    public void whenUserAddItemThenTrackerHasDeleteItem() {
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("test name", "desc"));
        Item item2 = tracker.add(new Item("test 2", "desc2"));
        Input input = new StubInput(new String[]{"3", item1.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0], is(item2));
    }

    @Test
    public void whenUserAddItemThenTrackerHasFindByNameToItems() {
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("test", "desc"));
        Item item2 = tracker.add(new Item("test", "desc2"));
        Input input = new StubInput(new String[]{"5", "test", "6"});
        Item[] arr = new Item[2];
        arr[0] = item1;
        arr[1] = item2;
        new StartUI(input, tracker).init();
        assertThat(tracker.findByName("test"), is(arr));
    }

    @Test
    public void whenUserAddItemThenTrackerHasFindAllItems() {
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("test name", "desc"));
        Item item2 = tracker.add(new Item("test 2", "desc2"));
        Input input = new StubInput(new String[]{"1", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0], is(item1));
        assertThat(tracker.findAll()[1], is(item2));
    }
}
