import java.time.LocalDate;
import java.time.LocalDateTime;

public interface Repeatable {
    LocalDate nextDate(LocalDate previousDate);
}
