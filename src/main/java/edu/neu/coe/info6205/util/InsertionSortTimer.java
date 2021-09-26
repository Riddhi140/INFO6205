package edu.neu.coe.info6205.util;

import com.google.common.collect.Lists;
import edu.neu.coe.info6205.sort.elementary.InsertionSort;
import edu.neu.coe.info6205.util.Benchmark_Timer;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class InsertionSortTimer {
    private static final int REPETITIONS = 100;
    private static final int MIN = -1000;
    private static final int MAX = 1000;
    private static final Random RANDOM = new Random();

    private static Integer[] generateRandomNumberArray(int n) {
        Integer[] randomNumbers = new Integer[n];
        for (int i = 0; i < n; i++) {
            randomNumbers[i] = RANDOM.nextInt(MAX + 1 - MIN) + MIN;
        }
        return randomNumbers;
    }

    public static void calculateTime(final String text, final Integer[] input){
        final Consumer<Integer[]> insertionSorter = InsertionSort::sort;
        final Supplier<Integer[]> supplier = () -> Arrays.copyOf(input, input.length);

        final Benchmark_Timer<Integer[]> benchmark_timer = new Benchmark_Timer<>(text,null, insertionSorter,null);
        final double meanOfArrayInMillis = benchmark_timer.runFromSupplier(supplier, REPETITIONS);

        System.out.println(text + " | mean sort time (in ms): " + meanOfArrayInMillis);
    }

    public static void main(String[] args) {
        final List<Integer[]> randomNumbersList = Lists.newArrayList(
                generateRandomNumberArray(500),
                generateRandomNumberArray(1_000),
                generateRandomNumberArray(2_000),
                generateRandomNumberArray(5_000),
                generateRandomNumberArray(10_000)
        );

        for(Integer[] randomNumbers : randomNumbersList) {
            System.out.println("----------------------------------");
            System.out.println("Number of elements: " + randomNumbers.length);

            calculateTime("Randomly Ordered", randomNumbers);

            Arrays.sort(randomNumbers, 0, (randomNumbers.length)/2);
            calculateTime("PartialOrdered", randomNumbers);

            Arrays.sort(randomNumbers);
            calculateTime("Ordered",randomNumbers);

            Arrays.sort(randomNumbers, Collections.reverseOrder());
            calculateTime("Reverse Ordered", randomNumbers);

            System.out.println("----------------------------------");
        }
    }
}
