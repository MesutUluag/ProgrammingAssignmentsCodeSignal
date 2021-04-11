import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AmazonAssignments {
    public static void main(String args[]) {
//        int[]i={1,1,3,1,2,1,3,3,3,3};
//        sockMerchant(10, i);
//    fizzBuzz(15);

        List<Integer> i= List.of(3,7,5,6,2);
        minimalHeaviestSetA(i);

    }

    public static void fizzBuzz(int n) {
        for(int i=1; i<=n; i++){
            if(i%15==0)
                System.out.println("FizzBuzz");
            else if(i%3==0)
                System.out.println("Fizz");
            else if(i%5==0)
                System.out.println("Buzz");
            else
                System.out.println(i);
        }
    }

    public static List<Integer> minimalHeaviestSetA(List<Integer> arr) {
        List<Integer> result = new ArrayList<>();
        Integer sum = arr.stream().reduce(0, Integer::sum);
        List<Integer> sortedList= new ArrayList<Integer>(arr);
        Collections.sort(sortedList, Collections.reverseOrder());
        arr.size();
        long sum2=0;
        for(Integer i : sortedList){
            if(sum2<=sum/2){
                result.add(i);
                sum2+=i;
            }
        }
        System.out.println(result.get(0) + " " + result.get(1));
        return result;
    }

    public static long storage(int n, int m, List<Integer> h, List<Integer> v) {
        List<Integer> adjacentH = new ArrayList<>();
        List<Integer> adjacentV = new ArrayList<>();
        // first find ajjacent elements
        for(Integer i : h){
            if(i+1==h.get(i+1)){
                adjacentH.add(i);
            }
        }

        // multiply most adjacent elements with H and V

        int hSize=h.size()+1;
        int vSize=v.size()+1;
        int result=hSize*vSize;

        return result;
    }

}



