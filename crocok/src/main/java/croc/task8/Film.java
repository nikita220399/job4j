package croc.task8;

import java.util.Map;

public class Film implements Comparable<Film> {
    private Map<Integer, String> name;
    private Integer rating;

    public Film(Map<Integer, String> name, Integer rating) {
        this.name = name;
        this.rating = rating;
    }

    public Map<Integer, String> getName() {
        return name;
    }

    public void setName(Map<Integer, String> name) {
        this.name = name;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    @Override
    public int compareTo(Film o) {
        return o.getRating() - this.getRating();
    }
}
