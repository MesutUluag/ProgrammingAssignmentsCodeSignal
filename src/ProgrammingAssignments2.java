import java.util.*;

public class ProgrammingAssignments2 {
    public static void main(String args[]) {
//        System.out.println(digitsProduct(450));  //product=12 digitsProduct(product) = 26
//        String[] s= {"a(1)","a(6)","a","a","a","a","a","a","a","a","a","a"};
//        System.out.println(fileNaming(s));

//        System.out.println(messageFromBinaryCode("010010000110010101101100011011000110111100100001"));


//        System.out.println(spiralNumbers(5));

//        int[][] grid = {{1,3,2,5,4,6,9,8,7},
//                        {4,6,5,8,7,9,3,2,1},
//                        {7,9,8,2,1,3,6,5,4},
//                        {9,2,1,4,3,5,8,7,6},
//                        {3,5,4,7,6,8,2,1,9},
//                        {6,8,7,1,9,2,5,4,3},
//                        {5,7,6,9,8,1,4,3,2},
//                        {2,4,3,6,5,7,1,9,8},
//                        {8,1,9,3,2,4,7,6,5}};
//
//
//        System.out.println(sudoku(grid));

//        double[] prices= {10, 95, 70};
//        String [] notes = {"10.0% higher than in-store",
//                           "5.0% lower than in-store",
//                           "Same as in-store"};
//        int x= 5;
        double[] prices = {2};
        String[] notes = {"100.0% higher than in-store"};
        int x = 9;

        System.out.println(isAdmissibleOverpayment(prices, notes, x));


    }


    public static boolean isAdmissibleOverpayment(double[] prices, String[] notes, double x) {
        double firstPrice= Arrays.stream(prices).sum();
        double secondPrice=0;
        for(String note : notes){
            int i=0;
            String delims = "[%]+";
            String[] tokens = note.split(delims);
            if(tokens[0].equalsIgnoreCase("Same as in-store")){
                secondPrice+=prices[i];
                i++;
            }
            else if(tokens[1].equals(" higher than in-store")){
                Double value= Double.parseDouble(tokens[0]);
                prices[i]= prices[i] + prices[i]*value/100;
                secondPrice+=prices[i];
                i++;
            }
            else if(tokens[1].equalsIgnoreCase(" lower than in-store")){
                Double value= Double.parseDouble(tokens[0]);
                prices[i]= prices[i] - prices[i]*value/100;
                secondPrice+=prices[i];
                i++;
            }
        }
        double difference= secondPrice - firstPrice;
        if(difference>=x)
            return true;
        else
            return false;
    }













    public static boolean sudoku(int[][] grid) {
        HashSet<Integer> numbers= new HashSet<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
        if(!sumLeftToRight(grid)){
            return false;
        }
        if(!sumTopToBottom(grid)){
            return false;
        }
        if(!controlBoxes(grid))
        {
            return false;
        }
        return true;
    }
    public static boolean sumLeftToRight(int[][] grid){
        for(int i=0;i<9;i++){
            int sum=0;
            HashSet<Integer> numbers= new HashSet<>();
            for(int j=0;j<9;j++){
                if(!numbers.contains(grid[i][j])) {
                    numbers.add(grid[i][j]);
                    sum += grid[i][j];
                } else{
                    return false;
                }
            }
            if(sum!=45){
                return false;
            }
        }
        return true;
    }
    public static boolean sumTopToBottom(int[][] grid){
        for(int j=0;j<9;j++){
            int sum=0;
            HashSet<Integer> numbers= new HashSet<>();
            for(int i=0;i<9;i++){
                if(!numbers.contains(grid[i][j])) {
                    numbers.add(grid[i][j]);
                    sum += grid[i][j];
                } else{
                    return false;
                }
            }
            if(sum!=45){
                return false;
            }
        }
        return true;
    }

    public static boolean controlBoxes(int[][] grid){
        int k=0;
        int l=0;
        while (l<9) {
            k=0;
            while (k < 9) {
                int sum = 0;
                for (int i = l; i < 3+ l; i++) {
                    for (int j = k; j < 3 + k; j++) {
                        sum += grid[i][j];
                    }
                }
                if (sum != 45) {
                    return false;
                }
                k += 3;
            }
            l+=3;
        }
        return true;
    }

//    public static int number=1;
//    public static int[][] spiralNumbers(int n) {
//        int[][] result= new int[n][n];
//        goRight(result,0,0, n);
//        return result;
//    }
//
//    public static int[][] goRight(int[][] currentMatrix, int iPosition, int jPosition,int dimension){
//        if(currentMatrix[iPosition][jPosition+1]!=0){
//            return currentMatrix;
//        }
//        for(int j=jPosition; j<dimension; j++){
//
//            if(currentMatrix[iPosition][j]==0) {
//                currentMatrix[iPosition][j] = number;
//                number++;
//                jPosition = j;
//            } else{
//                goDown(currentMatrix, iPosition, jPosition, dimension);
//            }
//        }
//        goDown(currentMatrix, iPosition, jPosition, dimension);
//        return currentMatrix;
//    }
//
//    public static int[][] goDown(int[][] currentMatrix, int iPosition, int jPosition,int dimension){
//
//        if(currentMatrix[iPosition+1][jPosition]!=0){
//            return currentMatrix;
//        }
//        iPosition++;
//        for(int i=iPosition; i<dimension; i++){
//            if(currentMatrix[i][jPosition]==0) {
//                currentMatrix[i][jPosition] = number;
//                number++;
//                iPosition = i;
//            } else{
//                goLeft(currentMatrix, iPosition, jPosition, dimension);
//            }
//        }
//        goLeft(currentMatrix, iPosition, jPosition, dimension);
//        return currentMatrix;
//    }
//
//    public static int[][] goLeft(int[][] currentMatrix, int iPosition, int jPosition,int dimension){
//        if(currentMatrix[iPosition][jPosition-1]!=0){
//            return currentMatrix;
//        }
//        jPosition--;
//
//        for(int j=jPosition; j>=0; j--){
//            if(currentMatrix[iPosition][j]==0) {
//                currentMatrix[iPosition][j] = number;
//                number++;
//                jPosition = j;
//            } else{
//                goUp(currentMatrix, iPosition, jPosition, dimension);
//            }
//        }
//        goUp(currentMatrix, iPosition, jPosition, dimension);
//        return currentMatrix;
//    }
//
//    public static int[][] goUp(int[][] currentMatrix, int iPosition, int jPosition,int dimension){
//            if (currentMatrix[iPosition - 1][jPosition] != 0) {
//                return currentMatrix;
//            }
//
//        iPosition--;
//        for(int i=iPosition; i>=0; i--){
//            if(currentMatrix[i][jPosition]==0) {
//                currentMatrix[i][jPosition] = number;
//                number++;
//                iPosition = i;
//            } else{
//                goRight(currentMatrix, iPosition, jPosition, dimension);
//            }
//        }
//        goRight(currentMatrix, iPosition, jPosition, dimension);
//        return currentMatrix;
//    }


//    public static int[][] spiralNumbers(int n) {
//        int[][] result= new int[n][n];
//        int number=1;
//        for(int i=0;i<n;i++){
//            for(int j=0;j<n;j++){
//                result[i][j]=number;
//                number++;
//                System.out.print(result[i][j]);
//            }
//            System.out.println();
//        }
//
//        return result;
//    }


//    public static String messageFromBinaryCode(String code) {
//        String result;
//        StringBuilder stringBuilder = new StringBuilder();
//        int counter=0;
//        while(counter<code.length()) {
//            int AsciiCode = Integer.valueOf(code.substring(counter, counter + 8), 2);
//            stringBuilder.append(new Character((char)AsciiCode).toString());
//            counter+=8;
//        }
//        return stringBuilder.toString();
//    }

//    public static Map<String, Integer> namesMap = new LinkedHashMap<>();
//    static String[] fileNaming(String[] names) {
//        for(String name : names){
//            namesMap.put(fileNamingRecursive(namesMap, name), 1);
//        }
//        int i=0;
//        for(String s: namesMap.keySet()){
//            names[i] =s;
//            i++;
//        }
//        Arrays.stream(names).forEach(s -> System.out.println(s));
//        namesMap.clear();
//        return names;
//    }

//    static public String fileNamingRecursive(Map<String, Integer> namesMap, String name){
//        if(namesMap.containsKey(name)){
//            StringBuilder stringBuilder = new StringBuilder(name);
//            int counter= namesMap.get(name);
//            String s= "(" + counter + ""+ ")";
//            stringBuilder.append(s);
//            if(namesMap.containsKey(stringBuilder.toString())){
//                return recursiveControl(namesMap, stringBuilder.toString());
//            } else {
//                return stringBuilder.toString();
//            }
//        } else {
//            return name;
//        }
//    }
//        public static int value = 1;
//    static public String recursiveControl(Map<String, Integer> namesMap, String name){
//        String actualString = name;
//        String lastName= actualString.substring(0, actualString.length()-3);
//        StringBuilder stringBuilder = new StringBuilder(lastName);
//        value++;
//        String s= "(" + value + ""+ ")";
//        stringBuilder.append(s);
//        if(namesMap.containsKey(stringBuilder.toString())){
//            recursiveControl(namesMap, name);
//        } else {
//            value=1;
//            namesMap.put(stringBuilder.toString(), 1);
//            return stringBuilder.toString();
//        }
//        return stringBuilder.toString();
//    }

    static int digitsProduct(int product) {
        if (product == 0) return 10;
        else if (product < 10) return product;

        int smallPos = 0;
        while (product > 9) {
            int orig = product;
            for (int i = 9; i > 1; i--) {
                if (product % i == 0) {
                    int nexDigit = product / i;
                    nexDigit = digitsProduct(nexDigit);
                    if (nexDigit == -1) return -1;
                    smallPos = smallPos * 10 + nexDigit;
                    product = i;
                    break;
                }
            }
            if (product == orig) return -1;
        }
        return smallPos * 10 + product;
    }


}
