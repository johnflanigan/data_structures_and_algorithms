package rosalind;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static java.util.Arrays.copyOfRange;


/**
 * Created by johnflanigan on 9/6/16.
 */
public class MergeSort {

    public static void mergeSort() {

        Scanner s = null;
        try {
            s = new Scanner(new File("/Users/johnflanigan/IdeaProjects/Rosalind/src/rosalind/rosalind_ms.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int size;
        size = s.nextInt();

        int[] array = new int[size];
        int i = 0;
        while (s.hasNextInt()) {
            array[i] = s.nextInt();
            i++;
        }

        int[] sortedArray = split(array);

        for (i = 0; i < size; i++) {
            System.out.print(sortedArray[i] + " ");
        }

    }

    private static int[] split(int[] array) {
        int size = array.length;
        if (size <= 1) {
            return array;
        }

        int middle = size / 2;
        int[] array1 = copyOfRange(array, 0, middle);
        int[] array2 = copyOfRange(array, middle, size);

        array1 = split(array1);
        array2 = split(array2);

        int[] sortedArray = merge(array1, array2);

        return sortedArray;
    }

    private static int[] merge(int[] array1, int[] array2) {
        int size1 = array1.length;
        int size2 = array2.length;
        int mergedSize = size1 + size2;
        int[] mergedArray = new int[mergedSize];
        int i = 0, j = 0, k = 0;

        while (i < size1 && j < size2) {
            if (array1[i] < array2[j]) {
                mergedArray[k] = array1[i];
                i++;
            } else {
                mergedArray[k] = array2[j];
                j++;
            }
            k++;
        }

        for (; i < size1; i++) {
            mergedArray[k] = array1[i];
            k++;
        }

        for (; j < size2; j++) {
            mergedArray[k] = array2[j];
            k++;
        }

        return mergedArray;
    }
}

