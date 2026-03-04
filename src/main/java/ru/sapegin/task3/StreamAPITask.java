package ru.sapegin.task3;

import java.util.List;

public class StreamAPITask {

    private final List<Employee> employees = List.of(
            new Employee("Иванов Иван Иванович", 20, "Отдел 1", 100.0),
            new Employee("Петров Пётр Петрович", 25, "Отдел 2", 200.0),
            new Employee("Смирнов Иван Петрович", 30, "Отдел 3", 300.0),
            new Employee("Петров Иван Иванович", 35, "Отдел 4", 400.0),
            new Employee("Смирнов Пётр Иванович", 40, "Отдел 5", 500.0)
    );

    public void run(){
        List<Employee> filteredEmployees = getFilteredEmployees();
        printReport(filteredEmployees);
    }

    private List<Employee> getFilteredEmployees(){
        return employees.stream().filter(e -> e.getAge() != null && e.getAge() > 30).toList();
    }

    private void printReport(List<Employee> filteredEmployees){
        System.out.println("Список всех сотрудников:");
        for(var employee : employees){
            System.out.println(employee);
        }

        System.out.println("Сотрудники, которым более 30 лет:");
        for(var employee : filteredEmployees){
            System.out.println(employee);
        }
    }
}
