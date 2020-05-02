package org.obapanel.yaitshallowvsdeep;

import java.util.Objects;

public class Employee implements Cloneable {

    private String name;

    private int salary;

    private boolean active;

    private TaskOfEmployee taskOfEmployee;

    public Employee() {

    }

    public Employee(String name, int salary, boolean active, TaskOfEmployee taskOfEmployee) {
        this.name = name;
        this.salary = salary;
        this.active = active;
        this.taskOfEmployee = taskOfEmployee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean changeActive() {
        this.active = !active;
        return active;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return salary == employee.salary &&
                active == employee.active &&
                Objects.equals(name, employee.name) &&
                Objects.equals(taskOfEmployee, employee.taskOfEmployee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, salary, active, taskOfEmployee);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", active=" + active +
                ", taskOfEmployee=" + taskOfEmployee +
                '}';
    }
}
