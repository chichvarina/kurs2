import java.time.LocalDate;

public class MonthlyRepeat implements Repeatable{

    @Override
    public LocalDate nextDate(LocalDate previousDate){
        return previousDate.plusMonths(1);
    }

    @Override
    public String toString() {
        return "Повторяется ежемесячно";
    }
}
