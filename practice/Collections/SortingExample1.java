package practice.Collections;

import java.util.*;

public class SortingExample1 {
    public static void main(String[] args) {
//        sortArrayExample1();
//        sortArrayExample2();
//        sortArrayExample3();
//        sortArrayExample4();
        sortArrayExample5();
        sortArrayExample6();
    }

    public static void sortArrayExample1() {
        int[] arr = {11, 5, 6, 120, 8, 9};
        System.out.println("sortArrayExample1:");
        Arrays.sort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void sortArrayExample2() {
        int[] arr = {11, 5, 6, 120, 8, 9};

        // Is immutable list so can't change object list. So,we need to make it mutable.
        List<Integer> list = Arrays.stream(arr).boxed().toList();

        // Creating a mutable list from immutable list
        List<Integer> list1 = new ArrayList<>(list);

        System.out.println("sortArrayExample2:");
        Collections.sort(list1);
        System.out.println(list1);
    }

    public static void sortArrayExample3() {
        List<Integer> list = new ArrayList<>();
        list.add(11); // AutoBoxing - Converting primitive to object
        list.add(5);
        list.add(6);
        list.add(120);
        list.add(8);
        list.add(9);

        Collections.sort(list);
        System.out.println("sortArrayExample3:");
        System.out.println(list);
    }

    public static void sortArrayExample4() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "A", 23));
        students.add(new Student(2, "B", 21));
        students.add(new Student(3, "C", 25));

        System.out.println("sortArrayExample4:");
        System.out.println(students); // without sorting

        // Below line give error -> No suitable method found for sort
        // Required: List<T> Provided:List<Student>
        // (i.e. As it is comparable object so we need to implement comparable interface)
            //Collections.sort(students);

        Collections.sort(students); // After implementing Comparable interface in Student class
        System.out.println(students);
    }

    public static void sortArrayExample5() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(3, "C", 25));
        employees.add(new Employee(1, "A", 23));
        employees.add(new Employee(2, "B", 21));

        System.out.println("sortArrayExample5:");
        System.out.println(employees); // without sorting

        // After implementing comparator interface in Employee class
            Collections.sort(employees,new EmpIdComparator());
            //Collections.sort(employees,new NameComparator());
            //Collections.sort(employees,new AgeComparator());
            System.out.println(employees);
    }

    public static void sortArrayExample6() {
        TreeSet<Student> treeSet = new TreeSet<>();
    }
}

// Implementing Comparable interface to sort the object which support -> Single sorting logic
class Student implements Comparable<Student> {
    int rollNo;
    String name;
    int age;

    public Student(int rollNo, String name, int age) {
        this.rollNo = rollNo;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString(){
        return "Students{"+"rollNo="+rollNo+" name="+name+" age="+age+"}\n";
    }

    @Override
    public int compareTo(Student o) {
        /* Logic:
            > 0 => this > o
            = 0 => this = o
            < 0 => this < o
         */
        return this.age - o.age;
    }
}

class Employee {
    int empId;
    String name;
    int age;

    public Employee(int empId, String name, int age) {
        this.empId = empId;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString(){
        return "Employee{"+"empId="+empId+" name="+name+" age="+age+"}\n";
    }
}

// Implementing Comparator interface to sort the object which support -> Multiple sorting logic
class EmpIdComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.empId - o2.empId;
    }
}

// Implementing Comparator interface to sort the object which support -> Multiple sorting logic
class NameComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.name.compareTo(o2.name);
    }
}

// Implementing Comparator interface to sort the object which support -> Multiple sorting logic
class AgeComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.age - o2.age;
    }
}
