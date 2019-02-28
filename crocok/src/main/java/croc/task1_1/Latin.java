package croc.task1_1;

public class Latin {
    private char[] alfavit = new char[] {'a', 'e', 'i', 'o', 'u', 'y'};

    public String swap(String str) {
        char[] array = str.toCharArray();
        boolean flag1;
        boolean flag2;
        int index = array.length - 1;
        for (int i = 0; i < index; i++) {
            flag1 = false;
            flag2 = false;
            for (int j = 0; j < this.alfavit.length; j++) {
                if (array[i] == this.alfavit[j]) {
                    flag1 = true;
                    break;
                }
            }
            if (flag1 == true) {
                for (; index > i; index--) {
                    for (int j = 0; j < this.alfavit.length; j++) {
                        if (array[index] == this.alfavit[j]) {
                            char c = array[i];
                            array[i] = array[index];
                            array[index] = c;
                            flag2 = true;
                            index--;
                            break;
                        }
                    }
                    if (flag2 == true) {
                        break;
                    }
                }
            }
        }
        String str2 = new String(array);
        return str2;
    }
}
