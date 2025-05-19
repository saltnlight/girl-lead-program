import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ExampleWithMap {

     public static void testingMap() {
         Map<Integer, Student> map = new HashMap<>();

         map.put(1, new Student("Faith", 10));
         map.put(2, new Student("Flora", 4));
         map.put(3, new Student("Edna", 9));
//         System.out.println(map);

         Set<Map.Entry<Integer, Student>> entrySet = map.entrySet();
         System.out.println(entrySet);

         Set<Integer> keySet = map.keySet();
         System.out.println(keySet);

         map.put(1, new Student("Vivian", 7)); // replace Student faith with Student vivian
         System.out.println(map);

         Student expelledStudent = map.remove(1);
         System.out.println("Who was expelled: "+expelledStudent);
         System.out.println("Who are left: "+map);
     }
}
