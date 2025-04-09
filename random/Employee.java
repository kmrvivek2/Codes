package random;

/* id, name, salary, department
10
3 maths
3 phys
4 chem

Department name where max no of employees are working
*/


import java.util.*;

public class Employee {
    private int id;
    private String name;
    private int salary;
    private String department;

    Employee(int id, String name, int salary, String department){
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    public String getDepartment(){
        return department;
    }
}

class Impl{
    public static void main(String[] args) {
        Employee e1 = new Employee(1, "A", 1000, "maths");
        Employee e2 = new Employee(2, "B", 2000, "maths");
        Employee e3 = new Employee(3, "C", 3000, "phys");

        List<Employee> employeeList = new ArrayList<Employee>();
        employeeList.add(e1);
        employeeList.add(e2);
        employeeList.add(e3);

        Impl imp = new Impl();
        String deptName =imp.getDepartmentWithHighestCount(employeeList);
        System.out.println(deptName);
    }

    public String getDepartmentWithHighestCount(List<Employee> emp){
        Map<String,Integer> employeeMap = new HashMap<String,Integer>();
//        for(Employee e : emp){
//            if(employeeMap.containsKey(e.getDepartment())){
//                employeeMap.put(e.getDepartment(), employeeMap.get(e.getDepartment())+1);
//            }else{
//                employeeMap.put(e.getDepartment(), 1);
//            }
//        }

//        emp.stream().forEach(e -> {
//            if(employeeMap.containsKey(e.getDepartment())){
//                employeeMap.put(e.getDepartment(), employeeMap.get(e.getDepartment())+1);
//            }else{
//                employeeMap.put(e.getDepartment(), 1);
//            }
//        });

        for (Employee em : emp) {
            employeeMap.put(em.getDepartment(), employeeMap.getOrDefault(em.getDepartment(), 0) + 1);
        }

        String maxDept = Collections.max(employeeMap.entrySet(), Map.Entry.comparingByValue()).getKey();
        return maxDept;

//        Map<String,Long> employeeMap = emp.stream()
//                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
//
//        return employeeMap.entrySet().stream()
//                .max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1)
//                .get().getKey();
    }
}



