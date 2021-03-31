import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class HackerRankAssignments {
    public static void main(String args[]) {
//        int[]i={1,1,3,1,2,1,3,3,3,3};
//        sockMerchant(10, i);

//        countingValleys(8, "DDUUDDUDUUUD");

        int[] i = {0, 0, 0, 1, 0, 0};
        jumpingOnClouds(i);
    }

    static int sockMerchant(int n, int[] ar) {
        HashMap<Integer, Integer> socks = new HashMap<>();
        int result = 0;
        for (int i : ar) {
            int initialValue = socks.get(i) == null ? 0 : socks.get(i);
            initialValue++;
            socks.put(i, initialValue);
        }

        for (int i : socks.keySet()) {
            result += socks.get(i) / 2;
        }

        return result;
    }

    public static int countingValleys(int steps, String path) {
        char[] charPath = path.toCharArray();
        int result = 0;
        int valleyCount = 0;

        for (char i : charPath) {
            if (i == 'D') {
                result = result - 1;
                if ((result < 0) && (result + 1 >= 0))
                    valleyCount++;
            } else {
                result = result + 1;
            }
        }
        System.out.println(valleyCount);
        return valleyCount;
    }

    static int jumpingOnClouds(int[] c) {
        int jump = 0;
        int i=0;
        while (i < c.length - 3)
        {
            i += (c[i + 2] == 0) ? 2 : 1;
            jump++;
        }
        jump++;
        return jump;
    }

}
