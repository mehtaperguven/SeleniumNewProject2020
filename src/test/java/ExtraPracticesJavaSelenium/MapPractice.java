package ExtraPracticesJavaSelenium;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapPractice {
    public static void main(String[] args) {
        Map<String, String> nameStatePair=new TreeMap<>();//or HashMap  //or LinkedHashMap
        nameStatePair.put("Erva","TX");
        nameStatePair.put("Dilara","TX");
        nameStatePair.put("Cabir","TU");
        nameStatePair.put("Salim","NJ");
        nameStatePair.put("Heyhat","NY");
        System.out.println(nameStatePair);



    }
}
