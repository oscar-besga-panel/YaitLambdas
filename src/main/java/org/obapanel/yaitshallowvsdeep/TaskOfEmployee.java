package org.obapanel.yaitshallowvsdeep;

import java.util.Objects;

public class TaskOfEmployee {

    long num;

    boolean completed;

    public TaskOfEmployee() {}

    public TaskOfEmployee(long num, boolean completed) {
        this.num = num;
        this.completed = completed;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskOfEmployee that = (TaskOfEmployee) o;
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
}
