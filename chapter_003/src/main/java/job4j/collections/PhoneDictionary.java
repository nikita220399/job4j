package job4j.collections;

import java.util.ArrayList;
import java.util.List;

public class PhoneDictionary {
    private List<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add( person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */
    public List<Person> find(String key) {
        List<Person> result = new ArrayList<>();
        for (Person check : this.persons) {
            if (check.getName().contains(key) || check.getSurname().contains(key) || check.getPhone().contains(key)
                    || check.getAddress().contains(key)) {
                result.add(check);
            }
        }
        return result;
    }
}
