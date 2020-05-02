package org.obapanel.yaitshallowvsdeep;

import java.util.Objects;

public class TaskOfEmployeeClonable implements Cloneable {

    long num;

    boolean completed;

    public TaskOfEmployeeClonable() {}

    public TaskOfEmployeeClonable(long num, boolean completed) {
        this.num = num;
        this.completed = completed;
    }

    public TaskOfEmployeeClonable(TaskOfEmployeeClonable other) {
        this.num = other.num;
        this.completed = other.completed;
    }

    public long getNum() {
        return num;
    }

    public void setNum(long num) {
        this.num = num;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public boolean changeCompleted() {
        completed = !completed;
        return completed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskOfEmployeeClonable that = (TaskOfEmployeeClonable) o;
        return num == that.num &&
                completed == that.completed;
    }

    @Override
    public int hashCode() {
        return Objects.hash(num, completed);
    }

    @Override
    public String toString() {
        return "TaskOfEmployee{" +
                "num=" + num +
                ", completed=" + completed +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        //return super.clone();
        return new TaskOfEmployeeClonable(num, completed);
    }
}
