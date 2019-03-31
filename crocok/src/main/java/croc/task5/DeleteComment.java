package croc.task5;

import java.util.*;

public class DeleteComment implements BlackListFilter{

    @Override
    public List<String> filterComments(List<String> comments, Set<String> blackList) {
        int i = 0;
        List<Integer> kolvo = new ArrayList<>();
        for (String comment : comments) {
        A : for (String black : blackList) {
                String[] arrayComment = comment.split(" ");
                for (String str : arrayComment) {
                    if (black.equals(str)) {
                        kolvo.add(i);
                        break A;
                    }
                }
            }
            i++;
        }
        Collections.reverse(kolvo);
        for (int cur : kolvo) {
            comments.remove(cur);
        }
        return comments;
    }
}
