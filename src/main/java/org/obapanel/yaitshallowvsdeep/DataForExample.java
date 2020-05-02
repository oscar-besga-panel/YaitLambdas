package org.obapanel.yaitshallowvsdeep;

import java.util.Arrays;
import java.util.List;

public class DataForExample {

    private static final List<Employee> employeeList;
    private static final List<EmployeeClonable> employeeClonableList;
    static {
        //  Joe, William, Jack y Averell
        Employee employee1 = new Employee("Joe Dalton", 10, true, new TaskOfEmployee(0, false));
        Employee employee2 = new Employee("William Dalton", 11, true, new TaskOfEmployee(1, false));
        Employee employee3 = new Employee("Jack Dalton", 12, true, new TaskOfEmployee(2, false));
        Employee employee4 = new Employee("Averell Dalton", 13, false, new TaskOfEmployee(3, true));
        employeeList = Arrays.asList(employee1, employee2, employee3, employee4);

        EmployeeClonable employeeClonable1 = new EmployeeClonable("Joe Dalton", 10, true, new TaskOfEmployeeClonable(0, false));
        EmployeeClonable employeeClonable2 = new EmployeeClonable("William Dalton", 11, true, new TaskOfEmployeeClonable(1, false));
        EmployeeClonable employeeClonable3 = new EmployeeClonable("Jack Dalton", 12, true, new TaskOfEmployeeClonable(2, false));
        EmployeeClonable employeeClonable4 = new EmployeeClonable("Averell Dalton", 13, false, new TaskOfEmployeeClonable(3, true));
        employeeClonableList = Arrays.asList(employeeClonable1, employeeClonable2, employeeClonable3, employeeClonable4);

    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Employee e0o = employeeList.get(0);
        Employee e0c = (Employee) e0o.clone();
        System.out.println("e active " + e0o.isActive());
        System.out.println("e active " + e0c.isActive());
        e0c.changeActive();
        System.out.println("e active " + e0o.isActive());
        System.out.println("e active " + e0c.isActive());

        EmployeeClonable ec0o = employeeClonableList.get(0);
        EmployeeClonable ec0c = (EmployeeClonable) ec0o.clone();
        System.out.println("e active " + ec0o.getTaskOfEmployeeClonable().isCompleted());
        System.out.println("e active " + ec0o.getTaskOfEmployeeClonable().isCompleted());
        ec0o.getTaskOfEmployeeClonable().changeCompleted();
        System.out.println("e active " + ec0o.getTaskOfEmployeeClonable().isCompleted());
        System.out.println("e active " + ec0o.getTaskOfEmployeeClonable().isCompleted());



    }
}
