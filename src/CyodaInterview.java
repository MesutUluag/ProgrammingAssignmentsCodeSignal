import java.math.BigDecimal;
import java.util.List;

public class CyodaInterview {
    public static void main(String args[]) {

//        Write a program that prints the numbers from 1 to 100.
//        But for multiples of three print “Fizz” instead of the number and for the multiples of five print “Buzz”.
//        For numbers which are multiples of both three and five print “FizzBuzz”
        print1to100();
    }

    public static void print1to100() {
        for (int i = 1; i < 101; i++) {
            if (i % 15 == 0) {
                System.out.println("FizzBuzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else
                System.out.println(i);
        }
    }
}

class Node {
    private BigDecimal value;
    List<Node> childs;

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public List<Node> getChilds() {
        return childs;
    }

    public void setChilds(List<Node> childs) {
        this.childs = childs;
    }

    public static BigDecimal printSum(Node rootNode) {
        BigDecimal sum = null;
        for(Node node : rootNode.childs){
            sum.add(node.getValue());
            if(node.childs != null)
                sum.add(printSum(node));
        }
        return sum;
    }
}




