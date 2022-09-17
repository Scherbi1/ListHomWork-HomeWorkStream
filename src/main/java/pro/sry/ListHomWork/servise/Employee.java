package pro.sry.ListHomWork.servise;

import java.util.Objects;

public class Employee {
    private final String name;
    private final String surName;
    private double salaryStaff;
    private int departmentNumber;

    public Employee(String name, String surName, double salaryStaff, int departmentNumber) {
        this.name = name;
        this.surName = surName;
        this.departmentNumber = departmentNumber;
        this.salaryStaff = salaryStaff;
    }

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }

    public double getSalaryStaff() {
        return salaryStaff;
    }

    public int getDepartmentNumber() {
        return departmentNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return name.equals(employee.name) && surName.equals(employee.surName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surName);


    }

    @Override
    public String toString() {
        return
                "Имя - " + name + '\'' +
                ", фамилия - " + surName + '\'' +
                ", зарплата - " + salaryStaff +
                ", отдел - " + departmentNumber;
    }
}




