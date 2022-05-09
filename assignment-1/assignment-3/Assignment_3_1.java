// 15.	Create List and Map. List A contains 1,2,3,4,10(integer) .
// Map B contains ("a","1") ("b","2") ("c","10")   (key = string, value = string)
// Question: get a list which contains all the elements in list A, but not in map B.

import java.util.*;


public class Assignment_3_1 {


    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>(Arrays.asList(1,2,3,4,10));
        HashMap<String, String> b = new HashMap<>();
        b.put("a", "1");
        b.put("b", "2");
        b.put("c", "10");
        Set<Integer> bval = new HashSet<>();

        for (String val: b.values()) {
            bval.add(Integer.valueOf(val));
        }

        List<Integer> res = new ArrayList<>();
        for (Integer i: a) {
            if (!bval.contains(i)) {
                res.add(i);
            }
        }

        System.out.println(res);

    }

}
