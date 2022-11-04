import java.time.LocalDate;

public class YearlyRepeat implements Repeatable{

    @Override
    public LocalDate nextDate(LocalDate previousDate){
        return previousDate.plusYears(1);
    }

    @Override
    public String toString() {
        return "Повторяется ежегодно";
    }
}
