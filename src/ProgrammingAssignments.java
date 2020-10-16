import java.util.*;

public class ProgrammingAssignments {
    public static void main(String args[]) {
//    String s="aabaa";
//    String s="hlbeeykoqqqqokyeeblh";
//    String s="az";
//    System.out.println(checkPalindrome(s));

//    int a[]={1, 2, 1, 2};//false
//    int a[]={1, 3, 2 }; //true

//    int a[][]={{0, 1, 1, 2},
//            {0, 5, 0, 0},
//            {2, 0, 3, 3}};
//
//    System.out.println(matrixElementsSum(a));

//    String a[]={"aba", "aa", "ad", "vcd", "aba"};

//    String a[]={"aa"};
//
//    String result[]=allLongestStrings(a);
//    for(String input:result){
//        System.out.println(input);
//    }

//    String s1 = "aabcc";
//    String  s2 = "adcaa";
//    System.out.println(commonCharacterCount(s1,s2));

//    int []a={1000, 999};
//    System.out.println(avoidObstacles(a));
//
//    int a[][]={{36,0,18,9},
//            {27,54,9,0},
//            {81,63,72,45}};

//    int a[][]={{7,4,0,1},
//            {5,6,2,2},
//            {6,10,7,8},
//            {1,4,2,0}};
//    boxBlur(a);

//    int []a={1, 1, 2, 1, 2, 1, 1};
//    System.out.println(goodTuples(a));

//    int a[][]={{1,2,3},
//               {4,5,6},
//               {7,8,9}};
//    int []q={0,1,2};
//    mutateMatrix(a,q);

//        int[] prices = {2, 4, 1, 5, 2, 6, 7};
//        int[] algo = {0, 1, 0, 0, 1, 0, 0};
//        System.out.println(maxRevenueFromStocks(prices, algo, 4));


//        boolean a[][] = {{true, false, false},
//                {false, true, false},
//                {false, false, false}
//        };
//
//        minesweeper(a);

//            int a[]={1, 2, 3, 4, 5 };
//            arrayReplace(a, 3,0);

//        System.out.println(evenDigitsOnly(248622));

//        System.out.println(variableName("var_1__Int"));

        //        String a="crazy";
//        System.out.println(alphabeticShift(a));

//        System.out.println(chessBoardCellColor("A1","H3"));

//        System.out.println(circleOfNumbers(10, 2));

//        System.out.println(depositProfit(100,20,170));

//        int a[]={-4, -1};
//        System.out.println(absoluteValuesSumMinimization(a));

//        String a[] = {"aba", "bbb", "bab"};
//        System.out.println(stringsRearrangement(a));

//        int [] a={1, 1,1,1};
//        System.out.println(extractEachKth(a,1));
//        int []result= new int[hashMap.size()]; just an example

//        String a="var_1__Int";
//        firstDigit(a);

//         differentSymbolsNaive("cabca");

//        int []a= {2, 3, 5, 1, 6};
//        arrayMaxConsecutiveSum(a,2);

//        System.out.println(growingPlant(100,10,910));


//       System.out.println(knapsackLight(3,5,3,8,10));

//        String input="123aa1";
//        System.out.println(longestDigitsPrefix(input));

//        System.out.println(digitDegree(91));

//        System.out.println(bishopAndPawn("a5", "c3"));

//        System.out.println(isBeautifulString("aabbb"));

//        System.out.println(findEmailDomain("admin@mailserver2.ru"));

//        System.out.println(buildPalindrome("abcabc"));

//        int []x={2, 3, 5, 2};
//        int k=3;
//        System.out.println(electionsWinners(x,k));

        System.out.println(isMAC48Address("not a MAC-48 address"));

    }

    static boolean isMAC48Address(String a) {
        String Pattern="[0-9][0-9]|[0-9][A-F]|[A-F][0-9]|[A-F][A-F]";
        String [] ips= a.split("\\-");
        if(a.charAt(a.length()-1)=='-'){
            return false;
        }
        for(String ip:ips){
            if(!ip.matches(Pattern)){
                return false;
            }
        }
        return true;
    }


    static int electionsWinners(int[] votes, int k) {
        int []sorted=Arrays.stream(votes).sorted().toArray();
        int result=0;
        for(int i=0;i<sorted.length;i++){
            if((sorted[i]+k)>sorted[sorted.length-1]){
                result++;
            }
        }
        if(k==0) {
            if(sorted[sorted.length-1]==sorted[sorted.length-2]){
                return 0;
            }else
                return 1;
        }
        return result;
    }
    static String buildPalindrome(String st) {
        int counter = 0;
        String newString = "";
        for (int i = 0; i < st.length(); i++) {
            if (!isPalindrome(st)) {
                st = addCharToString(st, st.charAt(i), st.length() - i);
            } else {
                return st;
            }
        }
        return st;
    }
    static boolean isPalindrome(String a){
        for(int i=0;i<a.length()/2;i++){
            if(a.charAt(i)!=a.charAt(a.length()-i-1)){
                return false;
            }
        }
        return true;
    }
    public static String addCharToString(String str, char c, int pos) {
        StringBuilder stringBuilder = new StringBuilder(str);
        stringBuilder.insert(pos, c);
        return stringBuilder.toString();
    }

    static String findEmailDomain(String address) {
        String result = "";
        for (int i = 0; i < address.length(); i++) {
            if (address.charAt(i) == '@') {
                result = address.substring(i + 1, address.length());
            }
        }
        return result;
    }

    static boolean isBeautifulString(String inputString) {
        TreeMap<Character, Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < inputString.length(); i++) {
            int counter = treeMap.get(inputString.charAt(i)) != null ? treeMap.get(inputString.charAt(i)) : 0;
            counter++;
            treeMap.put(inputString.charAt(i), counter);
        }
        char lastkey = treeMap.lastKey();
        char firstkey = 'a';
        for (int i = firstkey; i < lastkey + 1; i++) {
            if (!treeMap.containsKey((char) i)) {
                return false;
            }
        }
        char previousKey = treeMap.firstKey();
        for (char i : treeMap.keySet()) {
            if (!(treeMap.get(previousKey) >= treeMap.get(i))) {
                return false;
            } else {
                previousKey = i;
            }
        }
        return true;
    }

    static boolean bishopAndPawn(String bishop, String pawn) {

        HashSet<String> hashSet = new HashSet<>();
        {
            char[] chars = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
            char firstChar = bishop.charAt(0);
            int secondChar = Character.getNumericValue(bishop.charAt(1));
            for (int i = 0; i < chars.length; i++) {
                if (secondChar > 9 || firstChar > 'h')
                    break;
                hashSet.add(firstChar + "" + secondChar);
                firstChar++;
                secondChar++;
            }
            firstChar = bishop.charAt(0);
            secondChar = Character.getNumericValue(bishop.charAt(1));
            for (int i = 0; i < chars.length; i++) {
                if (firstChar < 'a' || secondChar < 1)
                    break;
                hashSet.add(firstChar + "" + secondChar);
                firstChar--;
                secondChar--;
            }

            firstChar = bishop.charAt(0);
            secondChar = Character.getNumericValue(bishop.charAt(1));
            for (int i = 0; i < chars.length; i++) {
                if (firstChar < 'a' || secondChar > 9)
                    break;
                hashSet.add(firstChar + "" + secondChar);
                firstChar--;
                secondChar++;
            }

            firstChar = bishop.charAt(0);
            secondChar = Character.getNumericValue(bishop.charAt(1));
            for (int i = 0; i < chars.length; i++) {
                if (firstChar > 'h' || secondChar < 1)
                    break;
                hashSet.add(firstChar + "" + secondChar);
                firstChar++;
                secondChar--;
            }
            System.out.println(hashSet);
            if (hashSet.contains(pawn)) {
                return true;
            } else {
                return false;
            }
        }
    }

    static int resultofDigitDegree = 0;

    static int digitDegree(int n) {
        String k = Integer.toString(n);
        int sum = 0;
        if (k.length() == 1) {
            return 0;
        }
        for (int i = 0; i < k.length(); i++) {
            sum += Character.getNumericValue(k.charAt(i));
        }
        resultofDigitDegree++;
        String sum2 = Integer.toString(sum);
        if (sum2.length() == 1) {
            int result2 = resultofDigitDegree;
            resultofDigitDegree = 0;
            return result2;
        } else {
            return (digitDegree(sum));
        }
    }

    static String longestDigitsPrefix(String inputString) {
        String result = "";
        for (int i = 0; i < inputString.length(); i++) {
            if (Character.isDigit(inputString.charAt(i))) {
                result += inputString.charAt(i);
            } else {
                return result;
            }
        }
        return result;
    }

    static int knapsackLight(int value1, int weight1, int value2, int weight2, int maxW) {
        if (weight1 + weight2 <= maxW) {
            return value1 + value2;
        } else if ((weight1 > maxW) && (weight1 <= maxW)) {
            return value2;
        } else if ((weight2 > maxW) && (weight2 <= maxW)) {
            return value1;
        } else if ((weight1 > weight2) && (weight1 <= maxW) && value1 > value2) {
            return value1;
        } else if ((weight1 < weight2) && (weight2 > maxW) && (weight1 <= maxW)) {
            return value1;
        } else if ((weight2 > weight1) && (weight2 <= maxW) && value2 > value1) {
            return value2;
        } else if ((weight2 < weight1) && (weight1 > maxW) && (weight2 <= maxW)) {
            return value2;
        } else if ((weight1 <= maxW) && (weight2 <= maxW) && value1 >= value2) {
            return value1;
        } else if ((weight1 <= maxW) && (weight2 <= maxW) && value2 >= value1) {
            return value2;
        }
        return 0;
    }

    static int growingPlant(int upSpeed, int downSpeed, int desiredHeight) {
        int day = 0;
        int height = 0;
        while (height < desiredHeight) {
            day++;
            height += upSpeed;
            if (height >= desiredHeight) {
                return day;
            }
            height -= downSpeed;
        }
        return day;
    }

    static int arrayMaxConsecutiveSum(int[] a, int k) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < a.length - k + 1; i++) {
            int sum = 0;
            for (int j = i; j < k + i; j++) {
                sum += a[j];
            }
            hashSet.add(sum);
        }
        return hashSet.stream().max(Integer::compareTo).get();
    }

    static int differentSymbolsNaive(String s) {
        HashSet<Character> hashSet = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            hashSet.add(s.charAt(i));
        }
        return hashSet.size();
    }

    static char firstDigit(String inputString) {
        for (int i = 0; i < inputString.length(); i++) {
            if (Character.isDigit(inputString.charAt(i))) {
                return inputString.charAt(i);
            }
        }
        return 0;
    }

    static int[] extractEachKth(int[] a, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap();
        for (int i = 0; i < a.length; i++) {
            hashMap.put(i, a[i]);
        }
        for (int i = 0; i < a.length; i++) {
            if ((i + 1) % (k) == 0) {
                hashMap.remove(i);
            }
        }
        int[] result = new int[hashMap.size()];
        int counter = 0;
        for (int i : hashMap.keySet()) {
            result[counter] = hashMap.get(i);
            counter++;
        }

        for (int i : result)
            System.out.println(i);
        return result;
    }

    static boolean stringsRearrangement(String[] a) {

        for (int i = 0; i < a.length; i++) {

            for (int j = 0; j < a.length - 1; j++) {
                for (int x = 0; x < a.length - 1; x++) {
                    if (!control(a[x], a[x + 1])) {
                        break;
                    }
                    if (x == a.length - 2) {
                        return true;
                    }
                }
                String temp;
                temp = a[j];
                a[j] = a[j + 1];
                a[j + 1] = temp;
//                System.out.println(a[j]);
            }
            for (String k : a)
                System.out.println(k);
        }
        return false;
    }

    static boolean control(String stra, String strb) {
        char[] a = stra.toCharArray();
        char[] b = strb.toCharArray();
        int sameCharCount = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                sameCharCount++;
            }
        }
        if (sameCharCount == 1) {
            return true;
        } else {
            return false;
        }
    }

    static int absoluteValuesSumMinimization(int[] a) {
        return a[(a.length - 1) / 2];
    }

    static int depositProfit(int deposit, int rate, int threshold) {
        double lastdeposit = deposit;
        int yearCount = 0;
        while (lastdeposit < threshold) {
            lastdeposit += lastdeposit * rate / 100;
            yearCount++;
        }
        return yearCount;
    }

    static int circleOfNumbers(int n, int firstNumber) {

        return (firstNumber + n / 2) % n;

    }

    static boolean chessBoardCellColor(String cell1, String cell2) {
        Hashtable<String, Boolean> chessBoard = new Hashtable<>();
        int charIndex = 'A';
        int index = 1;
        boolean color = true;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                chessBoard.put((char) charIndex + Integer.toString(index), color);
                index++;
                color = !color;
            }
            index = 1;
            charIndex++;
            color = !color;
        }
        System.out.println(chessBoard);
        if (chessBoard.get(cell1) == chessBoard.get(cell2)) {
            return true;
        } else {
            return false;
        }
    }

    static String alphabeticShift(String a) {
        char[] arrayString = a.toCharArray();

        for (int i = 0; i < a.length(); i++) {
            int x = a.charAt(i);
            if (a.charAt(i) == 'z') {
                arrayString[i] = 'a';
            } else {
                x++;
                arrayString[i] = (char) x;
            }
        }
        String result = new String(arrayString);
        return result;
    }

    static boolean variableName(String name) {
        String Pattern = "[a-zA-Z_]+[\\w_]*";
        if (!name.matches(Pattern)) {
            return false;
        } else {
            return true;
        }
    }

    static boolean evenDigitsOnly(int n) {
        char[] nChar = (Integer.toString(n)).toCharArray();


        for (int i = 0; i < nChar.length; i++) {
            if ((int) nChar[i] % 2 != 0) {
                return false;
            }
        }
        return true;

    }

    static int[] arrayReplace(int[] a, int elemToReplace, int substitutionElem) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == elemToReplace)
                a[i] = substitutionElem;
        }
        return a;


    }

    static int[][] minesweeper(boolean[][] a) {
        int[][] result = new int[a.length][a[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                int counter = 0;
                try {
                    if (a[i][j + 1] == true) {
                        counter++;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {

                }
                try {
                    if (a[i + 1][j + 1]) {
                        counter++;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {

                }
                try {
                    if (a[i + 1][j]) {
                        counter++;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {

                }
                try {
                    if (a[i + 1][j - 1]) {
                        counter++;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {

                }
                try {
                    if (a[i][j - 1]) {
                        counter++;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {

                }
                try {
                    if (a[i - 1][j - 1]) {
                        counter++;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {

                }
                try {
                    if (a[i - 1][j]) {
                        counter++;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {

                }
                try {
                    if (a[i - 1][j + 1]) {
                        counter++;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {

                }
                result[i][j] = counter;
                System.out.println(counter);
            }
        }
        return result;
    }

    static int maxRevenueFromStocks(int[] prices, int[] algo, int k) {
        HashSet<Integer> maxRevenue = new HashSet<>();
        for (int x = 0; x < prices.length - k; x++) {
            int revenue = 0;
            for (int i = 0; i < k; i++) {
                algo[i] = algo[i] == 0 ? -1 : 1;
                revenue += prices[i] * algo[i];
            }
            maxRevenue.add(revenue);
        }
        int result = 0;
        for (int i : maxRevenue) {
            result = i;
        }
        return result;
    }

    static int[][] mutateMatrix(int[][] a, int[] q) {
        for (int x = 0; x < q.length; x++) {
            if (q[x] == 0) {
                {
                    int n = a.length;
                    for (int i = 0; i < n / 2; i++) {
                        for (int j = i; j < n - i - 1; j++) {
                            int temp = a[i][j];
                            a[i][j] = a[n - 1 - j][i];
                            a[n - 1 - j][i] = a[n - 1 - i][n - 1 - j];
                            a[n - 1 - i][n - 1 - j] = a[j][n - 1 - i];
                            a[j][n - 1 - i] = temp;
                        }
                    }
                    for (int[] k : a) {
                        for (int l : k)
                            System.out.println(l);
                    }
                }
            }
            if (q[x] == 1) {
                int n = a.length;
                int row = 0;
                for (int j = 0; j < n; j++) {
                    Stack<Integer> s = new Stack<>();
                    int i = row, k = j;
                    while (i < n && k >= 0) {
                        s.push(a[i++][k--]);
                    }
                    i = row;
                    k = j;
                    while (i < n && k >= 0) {
                        a[i++][k--] = s.peek();
                        s.pop();
                    }
                }
                int column = n - 1;
                for (int j = 1; j < n; j++) {
                    Stack<Integer> s = new Stack<>();
                    int i = j, k = column;
                    while (i < n && k >= 0) {
                        s.push(a[i++][k--]);
                    }
                    i = j;
                    k = column;
                    while (i < n && k >= 0) {
                        a[i++][k--] = s.peek();
                        s.pop();
                    }
                }
                for (int[] k : a) {
                    for (int l : k)
                        System.out.println(l);
                }
            }
            if (q[x] == 2) {
                int n = a.length;
                for (int i = 0; i < (n - 1); i++)
                    for (int j = 0; j < (n - 1) - i; j++) {
                        int tmp = a[i][j];
                        a[i][j] = a[(n - 1) - j][(n - 1) - i];
                        a[(n - 1) - j][(n - 1) - i] = tmp;
                    }
                for (int[] k : a) {
                    for (int l : k)
                        System.out.println(l);
                }
            }
        }
        return a;
    }

    static int goodTuples(int[] a) {
        int result = 0;
        boolean goodTuple = false;

        for (int x = 0; x < a.length - 2; x++) {
            int sameNumbers = 0;
            for (int i = x; i < 1 + x; i++) {
                if (a[i] == a[i + 1]) {
                    sameNumbers++;
                }
                if (a[i] == a[i + 2]) {
                    sameNumbers++;
                }
                if (a[i + 1] == a[i + 2]) {
                    sameNumbers++;
                }
            }
            if (sameNumbers == 1)
                result++;
        }
        return result;
    }

    static int[][] boxBlur(int[][] a) {
        int arraySizeRow = a.length - 3 + 1;
        int arraySizeColumn = a[0].length - 3 + 1;
        int[][] result = new int[arraySizeRow][arraySizeColumn];
        for (int x = 0; x < a.length - 2; x++) {
            int firstindex = 0;
            for (int i = 0; i < a[0].length - 2; i++) {
                int toplam = 0;
                int ortalama = 0;
                for (int j = x; j < x + 3; j++) {
                    for (int k = i; k < i + 3; k++)
                        toplam += a[j][k];
                }
                System.out.println("toplam" + toplam);
                ortalama = (int) toplam / 9;
                System.out.println("ortalama" + ortalama);
                result[x][firstindex] = ortalama;
                firstindex++;
            }
        }

//        for(int i[]:result){
//            for(int j:i){
//                System.out.println(j);
//            }
//        }

        return result;
    }

    static boolean isIPv4Address(String a) {

//        250 to 255 25[0-5]
//        200 to 249 2[0-4][0-9]
//        100 to 199 1[0-9][0-9]
//        10 to 99 [1-9][0-9]
//        0 to 9 [0-9]

        String Pattern = "25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9][0-9]|[0-9]";
        String[] ips = a.split("\\.");
        if (ips.length != 4) return false;
        for (String ip : ips) {
            if (!ip.matches(Pattern))
                return false;
        }
        return true;
    }

    static int arrayMaximalAdjacentDifference(int[] a) {
        int maxAdjDifference = 0;
        for (int i = 1; i < a.length - 1; i++) {
            int firstDifference = Math.abs(a[i - 1] - a[i]);
            int secondDifference = Math.abs(a[i] - a[i + 1]);
            int maxDifference = firstDifference > secondDifference ? firstDifference : secondDifference;
            if (maxDifference > maxAdjDifference)
                maxAdjDifference = maxDifference;
        }

        System.out.println(maxAdjDifference);
        return maxAdjDifference;
    }

    static boolean areEquallyStrong(int yourLeft, int yourRight, int friendsLeft, int friendsRight) {
        int yourstrongest = yourLeft > yourRight ? yourLeft : yourRight;
        int yourweakest = yourLeft < yourRight ? yourLeft : yourRight;
        int friendStrongest = friendsLeft > friendsRight ? friendsLeft : friendsRight;
        int friendWeakest = friendsLeft < friendsRight ? friendsLeft : friendsRight;

        if ((yourstrongest == friendStrongest) && (yourweakest == friendWeakest)) {
            return true;
        } else return false;


    }

    static boolean palindromeRearranging(String inputString) {
        boolean result = false;
        HashMap<Character, Integer> charCount = new HashMap<>();
        for (char i : inputString.toCharArray()) {
            int count = charCount.containsKey(i) ? charCount.get(i) : 0;
            charCount.put(i, count + 1);
        }
        System.out.println(charCount);
        if (inputString.length() % 2 == 0) {
            for (char i : charCount.keySet()) {
                if (charCount.get(i) % 2 != 0) {
                    return false;
                }
            }
            return true;
        } else if (inputString.length() % 2 != 0) {
            int control = 0;
            for (char i : charCount.keySet()) {
                if ((charCount.get(i) % 2 != 0)) {
                    control++;
                    if (control > 1) {
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }

    static int arrayChange(int[] a) {
        int result = 0;
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] >= a[i + 1]) {
                result += Math.abs(a[i] - a[i + 1]) + 1;
                int difference = Math.abs(a[i] - a[i + 1]) + 1;
                a[i + 1] = a[i + 1] + difference;
            }
        }
        System.out.println(result);

        return result;
    }

    static boolean areSimilar(int[] a, int[] b) {
        HashMap<Integer, Integer> firstArray = new HashMap<>();
        HashMap<Integer, Integer> secondArray = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            int count = firstArray.containsKey(a[i]) ? firstArray.get(a[i]) : 0;
            firstArray.put(a[i], count + 1);
            int count2 = secondArray.containsKey(b[i]) ? secondArray.get(b[i]) : 0;
            secondArray.put(b[i], count2 + 1);
        }
        if (firstArray.equals(secondArray)) {
            if (a.equals(b)) {
                return true;
            } else {
                int unequalCount = 0;
                for (int i = 0; i < a.length; i++) {
                    if (a[i] != b[i])
                        unequalCount++;
                }
                if (unequalCount <= 2) {
                    return true;
                } else {
                    return false;
                }
            }
        } else {
            return false;
        }

    }

    static String[] addBorder(String[] picture) {
        ArrayList<String> newList = new ArrayList<>();

        int charCount = picture[0].length();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < charCount + 2; i++) {
            stringBuilder.insert(i, "*");
        }
        newList.add(stringBuilder.toString());
        for (int i = 0; i < picture.length; i++) {

            picture[i] = "*" + picture[i].toString() + "*";
            newList.add(picture[i]);
        }
        newList.add(stringBuilder.toString());

        System.out.println(newList);


        return newList.toArray(new String[0]);

    }

    static int[] alternatingSums(int[] a) {
        int result[] = new int[2];
        result[0] = 0;
        result[1] = 0;
        for (int i = 0; i < a.length; i++) {
            if (i % 2 == 0)
                result[0] += a[i];
            if (i % 2 != 0)
                result[1] += a[i];
        }
        return result;
    }

    static String reverseInParentheses(String inputString) {
        List<String> inParanthesis = new ArrayList();
        int paranthesisCount = 0;
        int otherParanthesisCount = 0;
        int firstindex = 0;
        int lastindex = 0;
        for (int i = 0; i < inputString.length(); i++) {
            if (inputString.charAt(i) == '(') {
                if (paranthesisCount == 0)
                    firstindex = i;
                paranthesisCount++;
            }
            if (inputString.charAt(i) == ')') {
                lastindex = i;
                otherParanthesisCount++;
            }
            if ((paranthesisCount == otherParanthesisCount) && (paranthesisCount != 0) && (otherParanthesisCount != 0)) {
                for (int j = firstindex + 1; j < lastindex; j++) {
                    inParanthesis.add(String.valueOf(inputString.charAt(j)));
                }
                break;
            }
        }
        System.out.println(inParanthesis.toString().replaceAll(",", ""));

        if (inParanthesis.contains("(")) {
            return reverseInParentheses(inParanthesis.toString().replaceAll(",", ""));
        } else {
            Collections.reverse(inParanthesis);
            return inParanthesis.toString().replaceAll(",", "");
        }

    }

    static int[] sortByHeight(int[] a) {
        int treecount = (int) Arrays.stream(a).filter(x -> (x == -1)).count();
        int treeIndexes[] = new int[treecount];
        int index = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == -1) {
                treeIndexes[index] = i;
                index++;
            }
        }

//        for(int i:treeIndexes)
//            System.out.println(i);
        int sortedA[] = Arrays.stream(a).sorted().filter(x -> (x != -1)).toArray();
        int newArray[] = new int[sortedA.length + treeIndexes.length];
        newArray = sortedA;

        for (int i = 0; i < treeIndexes.length; i++) {
            int exValue = newArray[treeIndexes[i]];
            newArray[treeIndexes[i]] = -1;

            for (int j = treeIndexes[i] + 1; j < newArray.length - 1; j++) {
                newArray[j] = exValue;
                exValue = newArray[j + 1];
            }
        }


        for (int i : newArray)
            System.out.println(i);
        return a;
    }

    static boolean isLucky(int n) {
        String s1 = Integer.toString(n);
        int firstSum = 0;
        int secondSum = 0;
        for (int i = 0; i < s1.length() / 2; i++) {
            firstSum += Character.getNumericValue(s1.charAt(i));
        }
        for (int i = (s1.length() / 2); i < s1.length(); i++) {
            secondSum += Character.getNumericValue(s1.charAt(i));
        }
        if (firstSum == secondSum)
            return true;
        return false;

    }

    static int makeArrayConsecutive2(int[] statues) {
        int result = 0;
        Arrays.sort(statues);
        for (int i = 0; i < statues.length - 1; i++) {
            int existingValue = statues[i];
            int nextValue = statues[i + 1];
            int difference = existingValue - nextValue;
            if (result != -1) {
                result = result - difference - 1;
            }
        }
        return result;
    }

    static int shapeArea(int n) {
        if (n == 1) {
            return 1;
        } else {
            return 4 * (n - 1) + shapeArea(n - 1);
        }
    }

    static int adjacentElementsProduct(int[] inputArray) {
        int result = -1000000000;
        for (int i = 0; i < inputArray.length; i++) {
            int firstValue = inputArray[i];
            if (i + 1 >= inputArray.length) {
                return result;
            }
            int secondValue = inputArray[i + 1];
            int product = firstValue * secondValue;
            if (result < product) {
                result = product;
            }
        }
        return result;
    }

    static int avoidObstacles(int[] a) {
        Arrays.sort(a);
        HashSet<Integer> array = new HashSet<>();
        Arrays.stream(a).forEach(x -> array.add(x));

        int result = 0;
        int jumplength = 1;
        int firstindex = 0;

        for (int j = 0; j < a[a.length - 1]; j++) {
            for (int i = 0; i < a[a.length - 1]; i++) {
                if (array.contains(firstindex + jumplength)) {
                    jumplength++;
                    firstindex = 0;
                    break;
                } else if (firstindex + jumplength > a[a.length - 1]) {
                    return jumplength;
                } else {
                    firstindex += jumplength;
                }
            }
        }
        return jumplength;
    }

    static int commonCharacterCount(String s1, String s2) {
        Map<Character, Integer> characterTables1 = new HashMap<>();
        Map<Character, Integer> characterTables2 = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            int count = 1;
            if (characterTables1.get(s1.charAt(i)) == null) {
                characterTables1.put(s1.charAt(i), count);
            } else {
                characterTables1.put(s1.charAt(i), characterTables1.get(s1.charAt(i)) + 1);
            }
        }
        for (int i = 0; i < s2.length(); i++) {
            int count = 1;
            if (characterTables2.get(s2.charAt(i)) == null) {
                characterTables2.put(s2.charAt(i), count);
            } else {
                characterTables2.put(s2.charAt(i), characterTables2.get(s2.charAt(i)) + 1);
            }
        }
        return characterTables1.keySet().stream()
                .filter(characterTables2.keySet()::contains)
                .mapToInt(c -> Math.min(characterTables1.get(c), characterTables2.get(c)))
                .sum();
    }

    static String[] allLongestStrings(String[] inputArray) {
        List result = new ArrayList<String>();
        int stringLength = 0;
        for (String input : inputArray) {
            if (input.length() > stringLength) {
                stringLength = input.length();
            }
        }
        for (String input : inputArray) {
            if (input.length() == stringLength) {
                result.add(input);
            }
        }
        String a[] = new String[result.size()];
        for (int i = 0; i < result.size(); i++) {
            a[i] = (String) result.get(i);
        }
        return a;
    }

    static int matrixElementsSum(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int value = matrix[i][j];
                sum += value;
                if (value == 0) {
                    for (int k = i; k < matrix.length; k++) {
                        matrix[k][j] = 0;
                    }
                }
            }
        }
        return sum;
    }

    static boolean almostIncreasingSequence(int[] sequence) {
        boolean result = false;
        int problemValues = 0;
        if (problemValues < 2) {
            for (int i = 0; i < sequence.length - 1; i++) {
                if ((sequence[i] + 1) != sequence[i + 1]) {
                    int y = sequence[i + 1];
                    double[] d = {8, 7, -6, 5, -4};
                    sequence = Arrays.stream(sequence).filter(x -> x != y).toArray();
                    problemValues++;
                    result = almostIncreasingSequence(sequence);
                } else {
                    return true;
                }
            }
        } else {
            return false;
        }
        return result;
    }

    static boolean checkPalindrome(String inputString) {
        boolean result = true;
        int stringLength = inputString.length();
        System.out.println(inputString.length());
        int j = 0;
        for (int i = 0; i < inputString.length() / 2; i++) {
            j++;
            if (inputString.charAt(i) == inputString.charAt(stringLength - j)) {
                result = true;
            } else {
                result = false;
            }
        }
        return result;
    }
}


