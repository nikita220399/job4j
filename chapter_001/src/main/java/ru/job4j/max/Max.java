package ru.job4j.max;

/**
 * @author Nikita Karuk
 * @version $Id$
 * @since 0.1
 */
public class Max {
    /**
     * @param first
     * @param second
     * @return max number
     */
    public int max(int first, int second) {
        return first > second ? first : second;
    }

    public  int max3(int first, int second, int third) {
        return this.max(this.max(first, second), third);
    }
}