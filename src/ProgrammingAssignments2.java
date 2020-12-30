import java.util.*;

public class ProgrammingAssignments2 {
    public static void main(String args[]) {
        System.out.println(digitsProduct(450));  //product=12 digitsProduct(product) = 26
    }

    static int digitsProduct(int product) {
        if (product == 0) return 10;
        else if (product < 10) return product;

        int smallPos = 0;
        while (product > 9) {
            int orig = product;
            for (int i = 9; i > 1; i--) {
                if (product % i == 0) {
                    int nexDigit=product / i;
                    nexDigit=digitsProduct(nexDigit);
                    if(nexDigit==-1) return -1;
                    smallPos = smallPos * 10 + nexDigit ;
                    product=i;
                    break;
                }
            }
            if (product == orig) return -1;
        }
        return smallPos * 10 + product;
    }

}
