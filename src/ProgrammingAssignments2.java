import java.util.*;

public class ProgrammingAssignments2 {
    public static void main(String args[]) {
//        System.out.println(digitsProduct(450));  //product=12 digitsProduct(product) = 26
        String[] s= {"a(1)","a(6)","a","a","a","a","a","a","a","a","a","a"};
        System.out.println(fileNaming(s));
    }

    public static Map<String, Integer> namesMap = new LinkedHashMap<>();
    static String[] fileNaming(String[] names) {
        for(String name : names){
            namesMap.put(fileNamingRecursive(namesMap, name), 1);
        }
        int i=0;
        for(String s: namesMap.keySet()){
            names[i] =s;
            i++;
        }
        Arrays.stream(names).forEach(s -> System.out.println(s));
        namesMap.clear();
        return names;
    }

    static public String fileNamingRecursive(Map<String, Integer> namesMap, String name){
        if(namesMap.containsKey(name)){
            StringBuilder stringBuilder = new StringBuilder(name);
            int counter= namesMap.get(name);
            String s= "(" + counter + ""+ ")";
            stringBuilder.append(s);
            if(namesMap.containsKey(stringBuilder.toString())){
                return recursiveControl(namesMap, stringBuilder.toString());
            } else {
                return stringBuilder.toString();
            }
        } else {
            return name;
        }
    }
        public static int value = 1;
    static public String recursiveControl(Map<String, Integer> namesMap, String name){
        String actualString = name;
        String lastName= actualString.substring(0, actualString.length()-3);
        StringBuilder stringBuilder = new StringBuilder(lastName);
        value++;
        String s= "(" + value + ""+ ")";
        stringBuilder.append(s);
        if(namesMap.containsKey(stringBuilder.toString())){
            recursiveControl(namesMap, name);
        } else {
            value=1;
            namesMap.put(stringBuilder.toString(), 1);
            return stringBuilder.toString();
        }
        return stringBuilder.toString();
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
