import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SonarSourceAssignmentTest {

    @org.junit.jupiter.api.Test
    void main() {
    }

    @org.junit.jupiter.api.Test
    void countYearly() {
    }

    @org.junit.jupiter.api.Test
    void countMonthly() {
    }

    @org.junit.jupiter.api.Test
    void handleExpense() {

    }

    @org.junit.jupiter.api.Test
    void printData() throws ParseException {
        DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(sdf.parse("2020/01/01"));

        String command = "INCOME 2020/01/01 gift 500";
        String[] parsedCommand = command.split(" ");

        List<Data> data = SonarSourceAssignment.handleExpense(parsedCommand,SonarSourceAssignment.data);
        assertEquals("gift", data.get(0).description);
        assertEquals("INCOME", data.get(0).type);
        assertEquals(500, data.get(0).amount);
        assertEquals(2020,data.get(0).date.get(Calendar.YEAR));

        command = "PRINT YEAR 2021";
        parsedCommand = command.split(" ");
        assertEquals(0,SonarSourceAssignment.printData(parsedCommand,SonarSourceAssignment.data));

        command = "PRINT YEAR 2020";
        parsedCommand = command.split(" ");
        assertEquals(500,SonarSourceAssignment.printData(parsedCommand,SonarSourceAssignment.data));

        command = "EXPENSE 2020/10/12 coffee 5";
        parsedCommand = command.split(" ");
        data = SonarSourceAssignment.handleExpense(parsedCommand,SonarSourceAssignment.data);

        calendar.setTime(sdf.parse("2020/10/11"));
        data.add(new Data("EXPENSE", calendar, "lunch", 25));

        command = "PRINT YEAR 2020";
        parsedCommand = command.split(" ");
        assertEquals(470,SonarSourceAssignment.printData(parsedCommand,SonarSourceAssignment.data));

    }
}