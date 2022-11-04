import java.time.LocalDate;

public class WeeklyRepeat implements Repeatable{

    @Override
    public LocalDate nextDate(LocalDate previousDate){
        return previousDate.plusWeeks(1);
    }

    @Override
    public String toString() {
        return "Повторяется еженедельно";
    }
}
