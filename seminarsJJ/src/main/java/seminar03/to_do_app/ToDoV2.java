package seminar03.to_do_app;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class ToDoV2 implements Externalizable {
    /**
     * Наименование задачи
     */
    private String title;
    /**
     * Статус задачи
     */
    private boolean isDone;

    public ToDoV2(){

    }
    public ToDoV2(String title) {
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


    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(title);
        out.writeBoolean(isDone);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        title = (String)in.readObject();
        isDone = in.readBoolean();
    }
}
