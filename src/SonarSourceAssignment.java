import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class SonarSourceAssignment {
    static List<Data> data = new ArrayList<>();

    public static void main(String args[]) throws ParseException {
        while (true) {

            // get user input
            Scanner com = new Scanner(System.in);
            System.out.println("Enter Command");
            String command = com.nextLine();

            // parse user input
            String[] parsedInput = command.split(" ");

            // call related operation
            if (parsedInput[0].equalsIgnoreCase("EXPENSE") || parsedInput[0].equalsIgnoreCase("INCOME")) {
                // handle expense
                data = handleExpense(parsedInput, data);
            } else if (parsedInput[0].equalsIgnoreCase("PRINT")) {
                printData(parsedInput, data);
            }
        }
    }

    public static int countYearly(List<Data> data, String year) {
        int sum = 0;
        for (Data dt : data) {
            if (dt.type.equalsIgnoreCase("INCOME") && dt.date.get(Calendar.YEAR) == Integer.parseInt(year)) {
                sum += dt.amount;
            } else if (dt.type.equalsIgnoreCase("EXPENSE") && dt.date.get(Calendar.YEAR) == Integer.parseInt(year)) {
                sum -= dt.amount;
            }
        }
        return sum;
    }

    public static int countMonthly(List<Data> data, String yearMonth) {
        int sum = 0;
        String[] parsedDate = yearMonth.split("/");
        for (Data dt : data) {
            if (dt.type.equalsIgnoreCase("INCOME") &&
                    dt.date.get(Calendar.YEAR) == Integer.parseInt(parsedDate[0]) &&
                    dt.date.get(Calendar.MONTH) + 1 == Integer.parseInt(parsedDate[1])
            ) {
                sum += dt.amount;
            } else if (dt.type.equalsIgnoreCase("EXPENSE") &&
                    dt.date.get(Calendar.YEAR) == Integer.parseInt(parsedDate[0]) &&
                    dt.date.get(Calendar.MONTH) + 1 == Integer.parseInt(parsedDate[1])) {
                sum -= dt.amount;
            }
        }
        return sum;
    }

    public static int countDaily(List<Data> data, String yearMonthDay) {
        int sum = 0;
        String[] parsedDate = yearMonthDay.split("/");
        for (Data dt : data) {
            if (dt.type.equalsIgnoreCase("INCOME") &&
                    dt.date.get(Calendar.YEAR) == Integer.parseInt(parsedDate[0]) &&
                    dt.date.get(Calendar.MONTH) + 1 == Integer.parseInt(parsedDate[1]) &&
                    dt.date.get(Calendar.DAY_OF_MONTH) == Integer.parseInt(parsedDate[2])
            ) {
                sum += dt.amount;
            } else if (dt.type.equalsIgnoreCase("EXPENSE") &&
                    dt.date.get(Calendar.YEAR) == Integer.parseInt(parsedDate[0]) &&
                    dt.date.get(Calendar.MONTH) + 1 == Integer.parseInt(parsedDate[1]) &&
                    dt.date.get(Calendar.DAY_OF_MONTH) == Integer.parseInt(parsedDate[2])
            ) {
                sum -= dt.amount;
            }
        }
        return sum;
    }

    public static int printData(String[] parsedInput, List<Data> data) {
        if (parsedInput[1].equalsIgnoreCase("YEAR")) {
            System.out.println(countYearly(data, parsedInput[2]));
            return countYearly(data, parsedInput[2]);
        } else if (parsedInput[1].equalsIgnoreCase("MONTH")) {
            System.out.println(countMonthly(data, parsedInput[2]));
            return countMonthly(data, parsedInput[2]);
        } else if (parsedInput[1].equalsIgnoreCase("DAY")) {
            System.out.println(countDaily(data, parsedInput[2]));
            return countDaily(data, parsedInput[2]);
        }
        return 0;
    }

    public static List<Data> handleExpense(String[] parsedInput, List<Data> data) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        calendar.setTime(sdf.parse(parsedInput[1]));
        data.add(new Data(parsedInput[0], calendar, parsedInput[2], Integer.parseInt(parsedInput[3])));
        return data;
    }

}
