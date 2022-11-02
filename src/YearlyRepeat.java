import java.time.LocalDateTime;

public class YearlyRepeat implements Repeatable{

    @Override
    public LocalDateTime nextDateTime(LocalDateTime previousDatetime) {
        return previousDatetime.plusYears(1);
    }

    @Override
    public String toString() {
        return "Повторяется ежегодно";
    }
}
