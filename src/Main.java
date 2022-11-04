import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        Task task1 = new Task("Планерка по понедельникам", true, "Описание 1",
                LocalDateTime.of(2022, 10, 17, 13, 0), new WeeklyRepeat());

        Task task2 = new Task("Обеденный перерыв", false, "Описание 2",
                LocalDateTime.of(2022, 10, 17, 12, 0), new DayliRepeat());

        Task task3 = new Task("Сдача экзамена", false, "Описание 3",
                LocalDateTime.of(2022, 10, 23, 9, 0), new SingleRepeat());

        Task task4 = new Task("День рождения", false, "Описание 4",
                LocalDateTime.of(1967, 10, 23, 17, 0), new YearlyRepeat());

        Task task5 = new Task("Передать показания счетчика", false, "Описание 5",
                LocalDateTime.of(2012, 10, 25, 19, 0), new MonthlyRepeat());


        DiaryService diaryService = new DiaryService();
        diaryService.addTask(task1);
        diaryService.addTask(task2);
        diaryService.addTask(task3);
        diaryService.addTask(task4);
        diaryService.addTask(task5);

        System.out.println(diaryService);

        LocalDate testDate = LocalDate.of(2022, 10, 23);
        diaryService.printTaskList(testDate);

        System.out.println();
        System.out.println("************ конец тестирования *****************");

        System.out.println();
        System.out.println("************ ввод с консоли *****************");

        try (Scanner scanner = new Scanner(System.in)) {
            label:
            while (true) {
                printMenu();

                if (scanner.hasNextInt()) {
                    int menu = scanner.nextInt();
                    switch (menu) {
                        case 1:
                            inputTask(scanner, diaryService);
                            break;
                        case 2:
                            deleteTask(scanner, diaryService);
                            break;
                        case 3:
                            listTask(scanner, diaryService);
                            break;
                        case 0:
                            break label;
                    }
                } else {
                    scanner.next();
                    System.out.println("Выберите пункт меню из списка!");
                }
            }
        }

    }


    private static void inputTask(Scanner scanner, DiaryService diaryService) throws Exception {
        System.out.print("Введите название задачи >");
        String name = scanner.next();

        System.out.print("Введите тип задачи: 1-рабочая, любая другая клавиша - личная >");
        boolean isWorkTask = scanner.next().equals("1");

        System.out.print("Введите описание задачи >");
        String description = scanner.next();

        label1:

        System.out.print("Введите дату начала задачи в формате ДД.ММ.ГГГГ >");
        String date = scanner.next();

        System.out.print("Введите время выполнения задачи в формате Часы:Минуты >");
        String dateTime = date+" "+scanner.next();
        System.out.println(dateTime);

        LocalDateTime beginDateTime;
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
            beginDateTime = LocalDateTime.parse(dateTime, formatter);
        }catch (DateTimeParseException e){
            System.out.println("Ошибка в дате/времени. Создание задачи прервано. Ввведите данные повторно");
            return;
        }

        printRepetableMenu();
        int repeat = scanner.nextInt();
        Repeatable repeatable=null;
        switch (repeat){
            case 1:
                repeatable = new DayliRepeat();
                break;
            case 2:
                repeatable = new WeeklyRepeat();
                break;
            case 3:
                repeatable = new MonthlyRepeat();
                break;
            case 4:
                repeatable = new YearlyRepeat();
                break;
            case 0:
                repeatable = new SingleRepeat();

        }

        Task task = new Task(name, isWorkTask, description, beginDateTime, repeatable);
        diaryService.addTask(task);

        System.out.println("Печатаем содержимое ежедневника после добавления задачи");
        System.out.println(diaryService);
    }

    private static void deleteTask(Scanner scanner, DiaryService diaryService){
        System.out.print("Введите ID задачи >");
        int id = scanner.nextInt();
        diaryService.removeTask(id);

        System.out.println("Печатаем содержимое ежедневника после удаления задачи");
        System.out.println(diaryService);
    }

    private static void listTask(Scanner scanner, DiaryService diaryService){
        System.out.print("Введите дату в формате ДД.ММ.ГГГГ >");
        String date = scanner.next();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate testDate = LocalDate.parse(date, formatter);

        diaryService.printTaskList(testDate);
        System.out.println();
    }

    private static void printMenu() {
        System.out.println("Выберите пункт меню:");
        System.out.println("1. Добавить задачу");
        System.out.println("2. Удалить задачу");
        System.out.println("3. Получить задачу на указанный день");
        System.out.println("0. Выход");
        System.out.print(">");
    }

    private static void printRepetableMenu(){
        System.out.println("Выберите повторяемость задачи:");
        System.out.println("1. Ежедневная");
        System.out.println("2. Еженедельная");
        System.out.println("3. Ежемесячная");
        System.out.println("4. Ежегодная");
        System.out.println("0. Онократная");
        System.out.print(">");
    }

}