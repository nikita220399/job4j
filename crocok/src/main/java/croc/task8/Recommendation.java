package croc.task8;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Recommendation {

   public List<Film> films = new ArrayList<>();

    private void readFilms(String path) {
        try (Scanner scanner = new Scanner(new FileReader(path))) {
            while (scanner.hasNextLine()) {
                String[] listFilms = scanner.nextLine().split(",");
                Integer name = Integer.parseInt(listFilms[0]);
                String index = listFilms[1];
                Map<Integer, String> temp = new HashMap<>();
                temp.put(name, index);
                films.add(new Film(temp, 0));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void readListFilms(String path) {
        try (Scanner scanner = new Scanner(new FileReader(path))) {
            while (scanner.hasNextLine()) {
                String[] tokens = scanner.nextLine().split(",");
                for (String str : tokens) {
                    Integer count = Integer.parseInt(str);
                    for (Film film : films) {
                        if (film.getName().keySet().contains(count)) {
                            film.setRating(film.getRating() + 1);
                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private List<String> calculating(List<Integer> list) {
        Collections.sort(films);
        List<String> result = new ArrayList<>();
        int count = 0;
        for (Film film : films) {
            if (!list.contains(film.getName().keySet().iterator().next())) {
                result.add(film.getName().values().iterator().next());
                count++;
                if (count == 3) {
                    break;
                }
            }
            for (Integer i : list) {
                if (film.getName().keySet().iterator().next().equals(i)) {
                    film.setRating(film.getRating() + 1);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Recommendation recommendation = new Recommendation();
        recommendation.readFilms("C:\\f1.txt");
        recommendation.readListFilms("C:\\f2.txt");
        List<Integer> list = new ArrayList<>();
        list.add(2);
        for (String film : recommendation.calculating(list)) {
            System.out.println(film);
        }
    }
}


