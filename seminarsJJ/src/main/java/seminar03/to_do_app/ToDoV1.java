package seminar03.to_do_app;

import java.io.Serializable;

public class ToDoV1 implements Serializable {
    /**
     * Наименование задачи
     */
    public String title;
    /**
     * Статус задачи
     */
    private boolean isDone;
    public ToDoV1(String title){
        this.title = title;
        isDone = false;
    }

    /**
     * Получить наименование задачи
     * @return наименование задачи
     */
    public String getTitle() {
        return title;
    }

    /**
     * Получить статус задачи
     * @return статус задачи
     */
    public boolean isDone() {
        return isDone;
    }

    /**
     * Изменить статус задачи
     * @param done новый статус задачи
     */
    public void setDone(boolean done) {
        isDone = done;
    }


}
