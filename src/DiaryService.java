import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DiaryService {
    private HashMap<Integer,Task> map;

    public DiaryService( ){
        this.map = new HashMap<>();
    }

    public void addTask(Task task){
        map.put(task.getId(), task);
    }

    public void removeTask(int id){
        map.remove(id);
    }

    public ArrayList<Task> getTaskList(LocalDate testDate){
        ArrayList<Task> arrayList = new ArrayList<>();

        for (Map.Entry<Integer, Task> entry : map.entrySet()) {
            Task task = entry.getValue();

            LocalDateTime beginDateTime = task.getBeginDateTime();
            LocalDate beginDate = beginDateTime.toLocalDate();

            if(testDate.equals(beginDate)){
                arrayList.add(task);
            }else{
                if(!(task.getRepeatable() instanceof SingleRepeat)){//задача повторяется

                    while(beginDate.isBefore(testDate)){
                        beginDateTime=task.getRepeatable().nextDateTime(beginDateTime);
                        beginDate=beginDateTime.toLocalDate();

                        if(testDate.equals(beginDate)){
                            arrayList.add(task);
                        }

                    }
                }
            }
        }
        return arrayList;
    }

    @Override
    public String toString() {
        StringBuilder s= new StringBuilder("Полный список задач в ежедневнике:\n");
        for (Map.Entry<Integer, Task> entry : map.entrySet()) {
            Task task = entry.getValue();
            s.append(task);
            s.append("\n");
        }
        return s.toString();
    }


    public void printTaskList(LocalDate date){
        DateTimeFormatter formatter= DateTimeFormatter.ofPattern("dd.MM.yyyy");
        ArrayList<Task> arrayList = getTaskList(date);
        System.out.println("Список задач на дату "+date.format(formatter)+":");
        for (Task task: arrayList) {
            System.out.println(task);
        }
    }
}
