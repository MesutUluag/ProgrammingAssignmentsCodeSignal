public class AmazonAssignments {
    public static void main(String args[]) {
//        int[]i={1,1,3,1,2,1,3,3,3,3};
//        sockMerchant(10, i);
    fizzBuzz(15);

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
}
