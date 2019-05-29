import java.util.function.*;
import java.util.*;
class PredicateDemoOnCustomObject {
    
    public static void main(String[] args) {
        
        ArrayList<Employee> employeeList = new ArrayList<Employee>();
        employeeList.add(new Employee("a", 1000));
        employeeList.add(new Employee("b", 2000));
        employeeList.add(new Employee("c", 3000));
        employeeList.add(new Employee("d", 4000));
        employeeList.add(new Employee("e", 5000));
        
        
        Predicate<Employee> pe = e->e.salary > 3000;
        
        for(Employee employee : employeeList) {
            if(pe.test(employee)) {
            System.out.println(employee.name + " " + employee.salary);
        }
        }
        
        
    }


}

class Employee {
    double salary;
    String name;
    
    Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
    
    
}