package ru.sapegin.task1;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ArrayTask {

    private static final Scanner scanner = new Scanner(System.in);

    private static final int NUMS_RANGE = 2;

    private int[] nums;

    public void run(){
        System.out.print("Введите размер массива: ");
        int n = scanner.nextInt();
        if(n >= 1){
            nums = new int[n];
            fillNumsRandomValues();
            int max = getMaxAbsValue();
            printReport(max);
        } else if (n == 0){
            System.out.println("Невозможно выполнить поиск в пустом массиве");
        } else {
            System.out.println("Размер массива не может быть меньше нуля. Введите неотрицательное число");
        }
    }

    private void fillNumsRandomValues(){
        Random rand = new Random();
        for (int i = 0; i < nums.length; i++){
            nums[i] = rand.nextInt(-NUMS_RANGE, NUMS_RANGE + 1);
        }
    }

    private int getMaxAbsValue(){
        int max = Math.abs(nums[0]);
        for (int i = 1; i < nums.length; i++){
            max = Math.max(max, Math.abs(nums[i]));
        }
        return max;
    }

    private void printReport(int maxAbsValue){
        System.out.printf("Массив: %s%n", Arrays.toString(nums));
        System.out.println("Максимальное значение по модулю в массиве: " + maxAbsValue);
    }
}
