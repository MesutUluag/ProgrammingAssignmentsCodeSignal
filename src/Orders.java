import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public final class Orders {

    private HashMap<Date, Order> orderList;

    public HashMap<Date, Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(HashMap<Date, Order> orderList) {
        this.orderList = orderList;
    }

    public void pushOrder(Order order, Date date){
        // reformat the date
        DateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        try{
            date = (Date)formatter.parse(date.toString());
        } catch (ParseException parseException){
            System.out.println("Parse Exception occured at date Exception: " + parseException.getMessage());
        } catch (Exception e){
            System.out.println("Exception occured while paring date: " + e.getMessage());
        }
        if(this.orderList == null)
            this.orderList = new HashMap<>();
        this.orderList.put(date, order);
    }
    public Order[] getOrders(){
        Order[] orders = this.orderList.values().toArray(Order[]::new);
        return orders;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "orderList=" + orderList +
                '}';
    }
}
