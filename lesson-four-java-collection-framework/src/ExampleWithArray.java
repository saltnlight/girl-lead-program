public class ExampleWithArray {
    /*
    * Array is not a part of the Collection Framework
    * Although you can convert an Array to a List
    * Array is a fixed-size container that stores data of the same type
    * On initialization, you must know the exact size of the array
    * You can easily run into 'Array index is out of bounds' exception
     * */

    //[23_______5]________________
    //____[Student@24d46ca6,Student@4517d9a3,Student@372f7a8d]___________________
    //[Student1]________["John","Jane","Doe",null,null]_________[Student3]__
    //__[Student2]_______________________
    public static void arrays() {

        int[] numbers = new int[10];
        numbers[0] = 2; // 010
        numbers[1] = 3; // 011
        numbers[2] = 54;
        numbers[3] = 928;
        numbers[4] = 19;
        numbers[5] = 395;
        numbers[6] = 10;
        numbers[7] = 92;
        numbers[8] = 26;
        numbers[9] = -13;
//        numbers[10] = 2; will throw 'Array index is out of bounds' exception
        System.out.println("value of numbers: "+numbers);
        int highscore = 0;
        for (int number : numbers) {
            if (number > highscore)
                highscore = number;
            System.out.println(number);
        }
        System.out.println("The highscore is "+highscore+"\n");


        String[] names = new String[5];
        names[0] = "John";
        names[1] = "Jane";
        names[2] = "Doe";
        System.out.println("value of names: "+names);
        for (String name : names) {
            System.out.println(name);
        }


        Student[] students = new Student[3];
        students[0] = new Student("Faith", 10);
        students[1] = new Student("Edna", 9);
        students[2] = new Student("Flora", 4);

        System.out.println("value of students: "+students);
        for (Student student : students) {
            System.out.println(student.getName()+" scored "+student.getScore());
        }

        names[2] = "Biggie";
        System.out.println(names[2]);
    }
}
