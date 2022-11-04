import java.time.LocalDate;

public class SingleRepeat implements Repeatable{

    @Override
    public LocalDate nextDate(LocalDate previousDate){
        return null;//задача одноразовая, следущей даты не существует
    }

    @Override
    public String toString() {
        return "Не повторяется";
    }
}
