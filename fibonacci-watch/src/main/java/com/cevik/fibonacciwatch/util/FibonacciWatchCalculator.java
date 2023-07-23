package com.cevik.fibonacciwatch.util;

import com.cevik.fibonacciwatch.enums.Color;
import com.cevik.fibonacciwatch.exception.FibonacciWatchCanNotBeCalculated;
import com.cevik.fibonacciwatch.model.FibonacciWatch;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
@Component
public class FibonacciWatchCalculator {

    static final int[] fibonacciNumbers = {1, 1, 2, 3, 5};
    static List<List<Color>> allCombinations;


    public FibonacciWatch getFibonacciWatch (int h, int m) {

        FibonacciWatch fibonacciWatch = new FibonacciWatch();
        allCombinations = generateCombinations(5, List.of(Color.RED, Color.GREEN, Color.BLUE, Color.WHITE));

        // r, b, g, b, r
        //List<Color> combination = List.of( Color.RED, Color.BLUE, Color.GREEN, Color.BLUE, Color.RED );
        /*int hours = computeHoursFromCombination(combination);
        int minutes = computeMinutesFromCombination(combination);
        System.out.printf("Uhrzeit: %02d : %02d", hours, minutes);
        System.out.println();

        for (List<Color> aCombination : allCombinations) {
            System.out.println(aCombination);
        }*/
        System.out.println(allCombinations.size());


            List<Color> foundCombination = findCombinationForTime(h, m);
            if (foundCombination != null) {
                fibonacciWatch.setColors(foundCombination);
                fibonacciWatch.setHours(h);
                fibonacciWatch.setMinutes(m);

                System.out.println("Uhrzeit: %02d:%02d Kombination: %s".formatted(h, m, foundCombination));
            } else {

                System.out.println("Keine Kombination gefunden");
                throw new FibonacciWatchCanNotBeCalculated("Keine Kombination gefunden");
            }

            return fibonacciWatch;
        // Teste, ob es für jede Uhrzeit eine passende Farbkombination gibt.
      /*  for (int h = 0; h <= 12; h++) {
            for (int m = 0; m < 60; m += 5) {
                List<Color> foundCombination = findCombinationForTime(h, m);
                if (foundCombination != null) {
                    System.out.println("Uhrzeit: %02d:%02d Kombination: %s".formatted(h, m, foundCombination));
                } else {
                    System.out.println("Keine Kombination gefunden");
                }
            }
        }*/
    }

    private List<Color> findCombinationForTime(int hours, int minutes) {
        // prüfe vorher, ob 0 <= hours <= 12 und 0 <= minutes <= 55, wobei minutes % 5 == 0
        for (List<Color> aCombination : allCombinations) {
            int computedHours = computeHoursFromCombination(aCombination);
            int computedMinutes = computeMinutesFromCombination(aCombination);
            if (hours == computedHours && minutes == computedMinutes) {
                return new ArrayList<>(aCombination);
            }
        }
        return null;
    }

    // Berechnet alle Kombinationen, die mit den vorgegebenen Farben möglich sind. Die Kombinationen
    // enthalten Wiederholungen.
    private List<List<Color>> generateCombinations(int combinationLength, List<Color> colors) {
        if (combinationLength == 0) {
            return List.of(List.of());
        }

        var partialSolution = generateCombinations(combinationLength - 1, colors);
        var solution = new ArrayList<List<Color>>();

        for (List<Color> smallerCombination : partialSolution) {
            for (Color aColor : colors) {
                List<Color> newCombination = new ArrayList<>(smallerCombination);
                newCombination.add(aColor);
                solution.add(newCombination);
            }
        }

        return solution;
    }

    private int computeHoursFromCombination(List<Color> combination) {
        int hours = 0;
        for (int i = 0; i < combination.size() && i < fibonacciNumbers.length; ++i) {
            Color color = combination.get(i);
            if (color == Color.RED || color == Color.BLUE) {
                hours += fibonacciNumbers[i];
            }
        }
        return hours;
    }

    private int computeMinutesFromCombination(List<Color> combination) {
        int minutes = 0;
        for (int i = 0; i < combination.size() && i < fibonacciNumbers.length; ++i) {
            Color color = combination.get(i);
            if (color == Color.GREEN || color == Color.BLUE) {
                minutes += fibonacciNumbers[i];
            }
        }

        return minutes * 5;
    }
}
