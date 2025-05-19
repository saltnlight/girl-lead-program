Lesson Note: Introduction to Data Structures in Java (Java Collections Framework)

1. Introduction <br>
Welcome to today's class on Data Structures in Java. In Java, most data structures are implemented through the Java Collections Framework (JCF). This framework provides a set of interfaces and classes that handle the storage, manipulation, and retrieval of data efficiently.
What is the Java Collections Framework (JCF)?
The Java Collections Framework is a group of interfaces, implementations (classes), and algorithms that allow you to store and manipulate groups of data as a single unit (collection).


2. Why Use Collections?

* To store multiple values in a single variable

* To perform complex operations like sorting, searching, or filtering efficiently

* To reduce the need for boilerplate code (loops, manual resizing of arrays)

* Collections are more flexible than arrays

3. Core Interfaces of the Java Collections Framework
* Interface
* Description
* Collection

4. The root interface for most collection classes <br>
| List : An ordered collection (allows duplicates) |<br>
| Set : A collection that does not allow duplicate elements |<br>
| Queue : Designed for holding elements prior to processing (FIFO)  |<br>
| Map : An object that maps keys to values (not part of Collection hierarchy)|<br>


5. Commonly Used Implementations

| Interface | Class Implementations |<br>
|-----------|--------------------------------------------|<br>
List      | ArrayList, LinkedList, Vector <br>
Set       | HashSet, LinkedHashSet, TreeSet <br>
Queue     | PriorityQueue, LinkedList <br>
Map       | HashMap, LinkedHashMap, TreeMap, Hashtable <br>

6. Characteristics of Key Classes

ArrayList: Dynamic array, fast access, slow insertion/removal

LinkedList: Doubly linked list, fast insertion/removal

HashSet: Unordered, no duplicates, backed by HashMap

TreeSet: Sorted, no duplicates

HashMap: Key-value pair storage, fast lookup

TreeMap: Sorted map based on keys

7. Basic Usage Examples

List<String> fruits = new ArrayList<>();
fruits.add("Apple");
fruits.add("Banana");
System.out.println(fruits); // [Apple, Banana]

Set<Integer> numbers = new HashSet<>();
numbers.add(1);
numbers.add(2);
numbers.add(1); // duplicate, ignored
System.out.println(numbers); // [1, 2]

Map<String, Integer> ageMap = new HashMap<>();
ageMap.put("Alice", 25);
ageMap.put("Bob", 30);
System.out.println(ageMap.get("Alice")); // 25

8. When to Use What

Use ArrayList for fast random access

Use LinkedList when you need frequent insertions/deletions

Use HashSet when duplicates are not allowed

Use TreeSet for sorted unique elements

Use HashMap when you need to associate keys with values

9. Algorithms in Collections
   The Collections class provides static methods for sorting, searching, shuffling, etc.

Collections.sort(fruits); // sort a List
Collections.reverse(fruits); // reverse a List

10. Summary

Java Collections Framework provides standard ways to handle groups of data. Choose the right data structure based on your use-case (performance, ordering, duplication)

Practice using them in small projects