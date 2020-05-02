package org.obapanel.yaitshallowvsdeep;

import java.io.Serializable;
import java.util.Objects;

public class EmployeeClonable implements Cloneable, Serializable {

    private String name;

    private int salary;

    private boolean active;

    private TaskOfEmployeeClonable taskOfEmployeeClonable;


    public EmployeeClonable() {

    }

    public EmployeeClonable(String name, int salary, boolean active, TaskOfEmployeeClonable taskOfEmployeeClonable) {
        this.name = name;
        this.salary = salary;
        this.active = active;
        this.taskOfEmployeeClonable = taskOfEmployeeClonable;
    }

    public EmployeeClonable(EmployeeClonable other) {
        this.name = other.name;
        this.salary = other.salary;
        this.active = other.active;
        this.taskOfEmployeeClonable = other.taskOfEmployeeClonable;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        //return super.clone();
        EmployeeClonable other = new EmployeeClonable();
        other.name = name;
        other.salary = salary;
        other.active = active;
        other.taskOfEmployeeClonable = new TaskOfEmployeeClonable(taskOfEmployeeClonable);
        return other;
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

    public TaskOfEmployeeClonable getTaskOfEmployeeClonable() {
        return taskOfEmployeeClonable;
    }

    public void setTaskOfEmployeeClonable(TaskOfEmployeeClonable taskOfEmployeeClonable) {
        this.taskOfEmployeeClonable = taskOfEmployeeClonable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeClonable employee = (EmployeeClonable) o;
        return salary == employee.salary &&
                active == employee.active &&
                Objects.equals(name, employee.name) &&
                Objects.equals(taskOfEmployeeClonable, employee.taskOfEmployeeClonable);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, salary, active, taskOfEmployeeClonable);
    }

    @Override
    public String toString() {
        return "EmployeeClonable{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", active=" + active +
                ", taskOfEmployeeClonable=" + taskOfEmployeeClonable +
                '}';
    }
}
