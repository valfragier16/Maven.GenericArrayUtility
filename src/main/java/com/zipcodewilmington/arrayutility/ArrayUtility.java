package com.zipcodewilmington.arrayutility;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<E>{
    private E[] array;

    // Constructor
    public ArrayUtility(E[] array){
        this.array = array;
    }

    public Integer countDuplicatesInMerge(E[] arrayToMerge, E valueToCheck){
        array = Stream.concat(Arrays.stream(array), Arrays.stream(arrayToMerge))
                .toArray(size -> Arrays.copyOf(array, size));

        return getNumberOfOccurrences(valueToCheck);
    }

    public E getMostCommonFromMerge(E[] arrayToMerge) {
        array = Stream.concat(Arrays.stream(array), Arrays.stream(arrayToMerge))
                .toArray(size -> Arrays.copyOf(array, size));

        return Arrays.stream(array)
                .max((Comparator.comparingInt(this::getNumberOfOccurrences)))
                .orElse(null);
    }

    public Integer getNumberOfOccurrences(E valueToCheck){
        return((int) Arrays.stream(array)
                .filter(val -> val == valueToCheck)
                .count());
    }

    public E[] removeValue(E valueToRemove){
        return Arrays.stream(array)
                .filter(element -> !element.equals(valueToRemove))
                .toArray(size -> Arrays.copyOf(array, size));
    }
}
