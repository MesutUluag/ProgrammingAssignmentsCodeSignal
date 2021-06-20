import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class LinkareAssignment {
    public static void main(String args[]) throws ParseException {
        System.out.println("Hello World");

        DateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String dateString = "20140211";
        String dateString2 = "20150211";
        Date date = sdf.parse(dateString);
        Date date2 = sdf.parse(dateString2);
        Orders orders = new Orders();
        orders.pushOrder(new Order(), date);
        orders.pushOrder(new Order(), date2);

        System.out.println(orders.toString());

        System.out.println(orders.getOrders().length);

        System.out.println(orders.toString());

    }
}
