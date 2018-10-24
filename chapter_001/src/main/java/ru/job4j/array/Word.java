package ru.job4j.array;

/**
 * Обертка над строкой.
 */
public class Word {
    private char[] data;

    public Word(String line) {
        this.data = line.toCharArray();
    }

    /**
     * Проверяет. что слово начинается с префикса.
     * @param prefix префикс.
     * @return если слово начинается с префикса
     */
    public boolean startWith(String prefix) {
        boolean result = false;
        int kolvo = 0;
        char[] value = prefix.toCharArray();

        for (int i = 0; i < value.length; i++) {
            if (value[i] == data[i]) {
                kolvo++;
            }
        }
        if (kolvo == value.length) {
            result = true;
        }
        return result;
    }
}