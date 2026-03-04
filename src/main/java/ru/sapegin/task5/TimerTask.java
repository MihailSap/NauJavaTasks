package ru.sapegin.task5;

import java.util.concurrent.atomic.AtomicBoolean;

public class TimerTask implements Task {

    private final int totalSeconds;

    private final AtomicBoolean isRunning;

    private Thread thread;

    public TimerTask(int totalSeconds) {
        if(totalSeconds <= 0){
            throw new IllegalArgumentException("Количество секунд должно быть больше нуля");
        }
        this.totalSeconds = totalSeconds;
        this.isRunning = new AtomicBoolean(false);
    }

    @Override
    public void start() {
        if (isRunning.get()) {
            System.out.println("Таймер уже запущен");
            return;
        }

        isRunning.set(true);
        thread = new Thread(() -> run());
        thread.start();
    }

    @Override
    public void stop() {
        if (!isRunning.get()) {
            System.out.println("Таймер ещё не запущен");
            return;
        }

        if (thread != null && thread.isAlive()) {
            thread.interrupt();
            try {
                thread.join(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("Таймер остановлен");
    }

    private void run() {
        int secondsLeft = totalSeconds;
        try {
            while (secondsLeft > 0 && isRunning.get()) {
                System.out.printf("Секунд осталось: %s%n", secondsLeft);
                Thread.sleep(1000);
                secondsLeft--;
            }
            System.out.println("Таймер завершил работу");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            isRunning.set(false);
        }
    }
}
