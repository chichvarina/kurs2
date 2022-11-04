import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Task {

    private static int counter = 1;

    private final int id;
    private final String name;
    private final boolean isWorkTask;
    private final String description;
    private final LocalDateTime beginDateTime;
    private final Repeatable repeatable;

    public Task(String name, boolean isWorkTask, String description, LocalDateTime beginDateTime, Repeatable repeatable) throws Exception {
        this.id = counter;
        counter++;

        if(name==null || name.isBlank() || name.isEmpty()){
            throw new Exception("Не введено название задачи");
        }else{
            this.name=name;
        }

        this.isWorkTask=isWorkTask;

        if(description==null || description.isBlank() || description.isEmpty()){
            throw new Exception("Не введено описание задачи");
        }else{
            this.description=description;
        }

        if(beginDateTime==null){
            throw new Exception("Не введена дата начала выполнения задачи");
        }else{
            this.beginDateTime=beginDateTime;
        }

        if(repeatable==null){
            throw new Exception("Не введена повторяемость выполнения задачи");
        }else {
            this.repeatable=repeatable;
        }
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isWorkTask() {
        return isWorkTask;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getBeginDateTime() {
        return beginDateTime;
    }

    public Repeatable getRepeatable() {
        return repeatable;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter= DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        String dateTime = beginDateTime.format(formatter);

        StringBuilder s = new StringBuilder();
        s.append("Задача id=");
        s.append(id);
        s.append(", ");
        s.append(name);
        s.append(", дата и время начала = ");
        s.append(dateTime);
        s.append(", ");
        s.append(repeatable);

        return s.toString();
    }


}
