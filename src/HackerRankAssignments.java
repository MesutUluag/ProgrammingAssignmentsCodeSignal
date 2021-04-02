import com.sun.xml.internal.fastinfoset.stax.events.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class HackerRankAssignments {
    public static void main(String args[]) {
//        int[]i={1,1,3,1,2,1,3,3,3,3};
//        sockMerchant(10, i);

//        countingValleys(8, "DDUUDDUDUUUD");

//        int[] i = {0, 0, 0, 1, 0, 0};
//        jumpingOnClouds(i);

//        System.out.println(repeatedString("a", 1000000000000L));

//        int[][] arr = {{1, 1, 1, 0, 0, 0}, {0, 1, 0, 0, 0, 0}, {1, 1, 1, 0, 0, 0}, {0, 0, 2, 4, 4, 0}, {0, 0, 0, 2, 0, 0}, {0, 0, 1, 2, 4, 0}};
//        System.out.println(hourglassSum(arr));


//        int[] i = {1,2,3,4,5};
//        rotLeft(i,3);

//        int[] i = {2,1,5,3,4};
        int[] i = {1, 2, 5, 3, 7, 8, 6, 4};
        minimumBribes(i);
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
        int i = 0;
        while (i < c.length - 3) {
            i += (c[i + 2] == 0) ? 2 : 1;
            jump++;
        }
        jump++;
        return jump;
    }

    static long repeatedString(String s, long n) {
        long whole = n / s.length();
        int remainder = (int) (n % s.length());
        long found = 0;

        for (char ch : s.toCharArray()) {
            if (ch == 'a')
                found++;
        }
        long total = found * whole;
        if (remainder == 0)
            return total;
        else {
            String part = s.substring(0, remainder);
            for (char ch : part.toCharArray()) {
                if (ch == 'a')
                    total++;
            }
        }
        return total;
    }

    static int hourglassSum(int[][] arr) {
        int sum = -1000;
        for (int i = 0; i < 4; i++) {
            for (int x = 0; x < 4; x++) {

                int top = arr[i][x] + arr[i][x + 1] + arr[i][x + 2];
                int middle = arr[i + 1][x + 1];
                int bottom = arr[i + 2][x] + arr[i + 2][x + 1] + arr[i + 2][x + 2];
                if (top + middle + bottom > sum) {
                    sum = top + middle + bottom;
                }
            }
        }
        return sum;

    }

    static int[] rotLeft(int[] a, int d) {
        for(int i=0; i<d; i++){
            int index=0;
            int temp= a[a.length-1];
            a[a.length-1]=a[index];
            for(int j=0; j<a.length-2;j++){
                a[j]=a[j+1];
            }
            a[a.length-2]=temp;
        }
        return a;
    }

//    int[] i = {2,1,5,3,4};
private static void minimumBribes(int[] arr) {
    int swapCount = 0;

    for (int i = arr.length - 1; i >= 0; i--) {

        if (arr[i] != i + 1) {
            if (((i - 1) >= 0) && arr[i - 1] == (i + 1)) {
                swapCount++;
                swap(arr, i, i - 1);
            } else if (((i - 2) >= 0) && arr[i - 2] == (i + 1)) {
                swapCount += 2;
                swap(arr, i - 2, i - 1);
                swap(arr, i - 1, i);
            } else {
                System.out.println("Too chaotic");
                return;
            }
        }
    }
    System.out.println(swapCount);
}
    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}


