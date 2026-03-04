package ru.sapegin;

import ru.sapegin.task1.ArrayTask;
import ru.sapegin.task2.ListTask;
import ru.sapegin.task3.StreamAPITask;
import ru.sapegin.task4.HttpJsonTask;
import ru.sapegin.task5.Task;
import ru.sapegin.task5.TimerTask;

public class Main {

    public static void main(String[] args) {
        System.out.println("Задание 1.");
        ArrayTask arrayTask = new ArrayTask();
        arrayTask.run();

        System.out.println("Задание 2.");
        ListTask listTask = new ListTask();
        listTask.run();

        System.out.println("Задание 3.");
        StreamAPITask streamAPITask = new StreamAPITask();
        streamAPITask.run();

        System.out.println("Задание 4.");
        HttpJsonTask httpJsonTask = new HttpJsonTask();
        httpJsonTask.run();

        System.out.println("Задание 5.");
        runTimerTask();
    }

    private static void runTimerTask(){
        int totalSeconds = 4;
        Task timerTask = new TimerTask(totalSeconds);
        timerTask.start();
        try {
            Thread.sleep(1900);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        timerTask.stop();
    }
}