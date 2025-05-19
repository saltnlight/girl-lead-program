import java.util.*;

public class ExampleWithCollection {

    /*
     * Collection is a framework to store and manipulate dynamic group of data
     * This framework is found in java.util
     *
     * Collection Intf is a parent of
     *      Set Intf, - doesn't allow duplicates, not ordered
     *          - HasHSet
     *
     *      List Intf - ordered, allows duplicates
     *          - ArrayList

     *      Queue Intf - hold element prior to processing (FIFO)
     *          - Deque Intf
     *                  - LinkedList
     *
     * Collections util
     * */

    public static void testingLists() {
        // faster for insert&delete operations
        // slower get operations
        LinkedList<Integer> integers = new LinkedList<>();
        integers.add(2);
        integers.add(5);
        integers.add(1);
        integers.add(7);
        integers.add(4);
        integers.add(3);
        integers.add(6);
        //_ _ ll1 _____ ll2 _____ll5_______
        //_ _ ll3 _____ ll4 _____________
        System.out.println(integers);
        Collections.sort(integers);
        System.out.println("Sorted: " + integers);

        //[________]{_____}________
        //[________]__________
        // slower for insert&delete operations
        // faster get operations
        ArrayList<String> list = new ArrayList<>();
        list.add("John");
        list.add("Chess");
        list.add("John");
        list.add("Qatar");
        list.add("Dance");
        list.add("Peep");
        list.add("Chess");

        System.out.println(list.get(3));
//        for (String s : list) {
//            System.out.println(s);
//        }

        System.out.println("Original" + list);
        Collections.shuffle(list);
        System.out.println("Shuffled: " + list);
        Collections.sort(list);
        System.out.println("Sorted: " + list);
        Collections.reverse(list);
        System.out.println("Reversed: " + list);
        System.out.println(list.get(0));

//        list.clear();
    }

    public static void testingSets() {
        Set<Long> longSet = new HashSet<>();
        longSet.add(20L);
        longSet.add(1000L);
        longSet.add(490L);
        longSet.add(1000L);
        longSet.add(1000L);
        longSet.add(1000L);
        longSet.add(1000L);
        longSet.add(283L);
//        longSet.add(null);
//        longSet.add("20L"); cannot use a String
        longSet.forEach(System.out::println);
        System.out.println("The highest number is: "+Collections.max(longSet)+"\n");


        // TreeSet doesn't allow null values and provides default ordering of your data
        Set<String> stringSet = new TreeSet<>();
        stringSet.add("John");
        stringSet.add("Ava");
        stringSet.add("Faith");
        stringSet.add("Edna");
        stringSet.forEach(System.out::println);

//        Set<Integer> integerSet = new ArrayList<>(); will throw an error
    }
}
