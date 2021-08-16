package com.pavan;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static List<String> areaList;

    public static void main(String[] args) {
	// write your code here
        boolean quit = false;
        int choice = 0;
        printInstructions();

        while (!quit) {
            System.out.println();
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    printInstructions();
                    break;
                case 1:
                    initializeDefaultList();
                    break;
                case 2:
                    sortLinkedList();
                    break;
                case 3:
                    sortCustomListObjects();
                    break;
                case 4:
                    compareLinkedList();
                    break;
                case 10:
                    quit = true;
                    break;
                default:
                    System.out.println("Illegal Input");
                    break;
            }
        }

    }

    private static void compareLinkedList() {
        List<String> list1 = new LinkedList<>(Arrays.asList("foo", "bar", "baz", "foo", "bar", "baz", "Hinjawadi", "Bhugaon",
                "Magarpatta", "Hinjawadi", "ShivajiNagar", "Wakad", "Hadapsar", "Hinjawadi", "BalewadiHighStreet", "Yerawada", "Bavdhan",
                "KalyaniNagar", "Baner", "KoregaonPark", "PimpleSaudagar"));

        List<String> list2 = new LinkedList<>(Arrays.asList("PimpleSaudagar", "foo", "bar", "baz", "foo", "bar", "baz", "Hinjawadi", "Bhugaon",
                "Magarpatta", "Hinjawadi", "ShivajiNagar", "Wakad", "Hadapsar", "Hinjawadi", "BalewadiHighStreet", "Yerawada", "Bavdhan",
                "KalyaniNagar", "Baner"));


        System.out.println();
        System.out.println("isEqual = " + list1.equals(list2));
        System.out.println();
        System.out.println(list1);
        System.out.println(list2);

        System.out.println();
        System.out.println("size of list 1 = " +list1.size());
        System.out.println("size of list 2 = " +list2.size());
        System.out.println("Remove additional element from list 1 ");

        List<String> list3 = new LinkedList<>(list1);
     //   list3.removeAll(list2);
        System.out.println("size of list 3 = " +list3.size());
        System.out.println("size of list 2 = " +list2.size());
        System.out.println(list3);

     list3.retainAll(list2);
        System.out.println(list3);

        System.out.println("size of list 3 = " +list3.size());
        System.out.println("size of list 2 = " +list2.size());
    }

    private static void sortCustomListObjects() {
        Employee e1 = new Employee(10, "Pavan",  26);
        Employee e2 = new Employee(15, "Vinayak",  27);
        Employee e3 = new Employee(70, "Sameer",  26);
        Employee e4 = new Employee(5, "Sauarabh",  28);
        Employee e5 = new Employee(13, "Satyam",  25);
        Employee e6 = new Employee(52, "SATISH",  85);
        Employee e7 = new Employee(2, "ABC",  2);

        List<Employee> employees = new LinkedList<>();
        employees.add(e1);
        employees.add(e2);
        employees.add(e3);
        employees.add(e4);
        employees.add(e5);
        employees.add(e6);
        employees.add(e7);

        System.out.println(employees);

        Collections.sort(employees);

        System.out.println();
        System.out.println("After Implementing Comparable: Using Collections.sort(Employee e) : Override compareTo");
        System.out.println(employees);


        System.out.println();
        System.out.println("After Implementing Comparator: Using Collections.sort(list, new Comparator<Employee>)");
        Collections.sort(employees, new NameComparator());
        System.out.println(employees);

        System.out.println();
        System.out.println("Using Java 8 Age Sort Comparator.comparing method : ");

        employees.sort(Comparator.comparing(employee -> employee.getAge()));
        System.out.println(employees);

        System.out.println();
        System.out.println(employees);
        System.out.println("Sorting By Name Java 8");
        employees.sort(Comparator.comparing(e->e.getName().toLowerCase()));
        System.out.println(employees);


    }

    private static void sortLinkedList() {

        List<String> areaList1 = new LinkedList<>(Arrays.asList("foo", "bar", "baz", "foo", "bar", "baz", "Hinjawadi", "Bhugaon",
                "Magarpatta", "Hinjawadi", "ShivajiNagar", "Wakad", "Hadapsar", "Hinjawadi", "BalewadiHighStreet", "Yerawada", "Bavdhan",
                "KalyaniNagar", "Baner", "KoregaonPark", "PimpleSaudagar"));

        List<String> arrayList = new ArrayList<>(Arrays.asList("Pavan", "prasanna", "Lala", "Aman", "Saurabh", "Satyam", "saurabh","lala"));
        List<String> linkedList = new LinkedList<>(arrayList);

        List<String> areaList2 = new LinkedList<>(areaList1);
        List<String> areaList3 = new LinkedList<>(areaList1);
        List<String> sortedAreaLinkedList = new LinkedList<>(areaList1);

        //Sort using List.sort() method
        System.out.println("Sort using List.sort() method");
        areaList1.sort(Comparator.comparing(String::toString));
        System.out.println(areaList1);


        System.out.println();
        // Sort Using Collections.sort() method
        System.out.println("Sort Using Collections.sort() method gives wrong results when list contains UpperCase and LowerCase strings");
        Collections.sort(areaList2);
        System.out.println(areaList2);

        System.out.println();
        System.out.println("Use Collections.sort(list, String.CASE_INSENSITIVE_ORDER) method to sort list containing UpperCase and LowerCase strings");
        Collections.sort(areaList2, String.CASE_INSENSITIVE_ORDER);
        System.out.println(areaList2);


        System.out.println();
        System.out.println("Sort using Java 8");
        List<String> sortedLinkedList = areaList3
                                            .stream()
                                            .sorted(Comparator.comparing(String::toString))
                                            .collect(Collectors.toList());

        System.out.println(sortedLinkedList);

        System.out.println();
        System.out.println("Using Lambda Method ignore Case while comparing");
        sortedAreaLinkedList.sort((s1, s2)-> s1.compareToIgnoreCase(s2));
        System.out.println(sortedAreaLinkedList);
    }

    private static void printInstructions() {

        System.out.println("\nPress ");
        System.out.println("\t 0 - To print choice options");
        System.out.println("\t 1 - To Initialize LinkedList with Default Values");
        System.out.println("\t 2 - To sort LinkedList");
        System.out.println("\t 3 - To sort Custom Employee LinkedList");
        System.out.println("\t 4 - To compare LinkedList");
        System.out.println("\t 10 - To quite an application");
    }

    private static void initializeDefaultList() {
        String[] stringArray = {"foo", "bar", "baz", "foo", "bar", "baz", "Hinjawadi", "Bhugaon", "Magarpatta",
                "Hinjawadi", "Shivaji Nagar", "Wakad", "Hadapsar", "Hinjawadi", "Balewadi High Street", "Yerawada", "Bavdhan",
                "Kalyani Nagar", "Baner", "Koregaon Park", "Pimple Saudagar"};


        areaList = new LinkedList<>(Arrays.asList(stringArray));
        System.out.println("Size of Default LinkedList :" + areaList.size());
        System.out.println(areaList);
    }
}
