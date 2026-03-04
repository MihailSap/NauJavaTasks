package ru.sapegin.task2;

import java.util.*;

public class ListTask {

    private static final Scanner scanner = new Scanner(System.in);

    private static final double NUMS_RANGE = 100.0;

    public void run(){
        System.out.print("Введите размер массива: ");
        int n = scanner.nextInt();
        if(n >= 1){
            List<Double> rawNums = getRandomNums(n);
            List<Double> sortedNums = mergeSort(rawNums);
            printReport(rawNums, sortedNums);
        } else if (n == 0){
            System.out.println("Невозможно отсортировать пустой массив");
        } else {
            System.out.println("Размер массива не может быть меньше нуля. Введите неотрицательное число");
        }
    }

    private List<Double> getRandomNums(int size) {
        List<Double> nums = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            nums.add(rand.nextDouble(-NUMS_RANGE, NUMS_RANGE + 1));
        }
        return nums;
    }

    private List<Double> mergeSort(List<Double> rawNums) {
        int n = rawNums.size();
        if (n <= 1) {
            return new ArrayList<>(rawNums);
        }

        int middle = n / 2;
        List<Double> left = getSublist(rawNums, 0, middle);
        List<Double> right = getSublist(rawNums, middle, n);

        left = mergeSort(left);
        right = mergeSort(right);

        return merge(left, right);
    }

    public List<Double> getSublist(List<Double> nums, int start, int end) {
        List<Double> result = new ArrayList<>();
        for (int i = start; i < end; i++) {
            result.add(nums.get(i));
        }
        return result;
    }

    private List<Double> merge(List<Double> left, List<Double> right) {
        List<Double> result = new ArrayList<>();
        int i = 0, j = 0;
        while (i < left.size() && j < right.size()) {
            if (Double.compare(left.get(i), right.get(j)) < 0) {
                result.add(left.get(i++));
            } else {
                result.add(right.get(j++));
            }
        }

        while (i < left.size()) {
            result.add(left.get(i++));
        }

        while (j < right.size()) {
            result.add(right.get(j++));
        }

        return result;
    }

    private void printReport(List<Double> rawNums, List<Double> sortedNums) {
        System.out.printf("Список до сортировки: %s%n", rawNums);
        System.out.printf("Список после сортировки: %s%n", sortedNums);
    }
}
