package rosalind;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by johnflanigan on 11/27/16.
 */
public class QuickSort {

    public static void quickSort() {

        Scanner s = null;
        try {
            s = new Scanner(new File("/Users/johnflanigan/IdeaProjects/Rosalind/src/rosalind/rosalind_qs.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int size;
        size = s.nextInt();

        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = s.nextInt();
        }

        recursiveHelper(array, 0, size - 1);

        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
    }

    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low;
        int current;
        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                // Swap array[i] with array[j]
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
            }
        }
        // Swap array[i] with array[high]
        int temp = array[i];
        array[i] = array[high];
        array[high] = temp;
        return i;
    }

    private static void recursiveHelper(int[] array, int low, int high) {
        if (low < high) {
            int p = partition(array, low, high);
            recursiveHelper(array, low, p - 1);
            recursiveHelper(array, p + 1, high);
        }
    }
}
