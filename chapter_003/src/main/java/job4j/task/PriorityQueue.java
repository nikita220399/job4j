package job4j.task;

import java.util.LinkedList;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     * Для вставок использовать add(int index, E value)
     * @param task задача
     */
    public void put(Task task) {
        if (this.tasks.size() == 0) {
            this.tasks.add(task);
        } else {
            int ind = 0;
            for (Task check : this.tasks) {
                if (task.getPriority() < check.getPriority()) {
                    int i = this.tasks.indexOf(check);
                    this.tasks.add(i, task);
                    break;
                }
                ind++;
            }
            if (ind == this.tasks.size()) {
                this.tasks.add(task);
            }
        }
    }

    public Task take() {
        return this.tasks.poll();
    }
}
