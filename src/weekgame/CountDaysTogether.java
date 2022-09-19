package weekgame;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author chengj
 * @Description
 * @Date 2022/9/17
 */
public class CountDaysTogether {

    public static void main(String[] args) {
        CountDaysTogether countDaysTogether = new CountDaysTogether();
        System.out.println(countDaysTogether.countDaysTogether("09-01","10-19","06-19","10-20"));
    }
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate beginA = LocalDate.parse("2022-" + arriveAlice, dateTimeFormatter);
        LocalDate beginB = LocalDate.parse("2022-" + arriveBob,dateTimeFormatter);
        LocalDate endA = LocalDate.parse("2022-" + leaveAlice, dateTimeFormatter);
        LocalDate endB = LocalDate.parse("2022-" + leaveBob,dateTimeFormatter);

        LocalDate begin = beginA.isAfter(beginB) ? beginA: beginB;
        LocalDate end = endA.isBefore(endB) ? endA : endB;
        if (end.isBefore(begin)){
            return 0;
        }
        long days = end.toEpochDay() - begin.toEpochDay();

        return (int) days + 1;
    }
}
