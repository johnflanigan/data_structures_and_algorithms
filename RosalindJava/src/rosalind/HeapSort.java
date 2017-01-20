package rosalind;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by johnflanigan on 11/27/16.
 */
public class HeapSort {

    public static void heapSort() {

        Scanner s = null;
        try {
            s = new Scanner(new File("/Users/johnflanigan/IdeaProjects/Rosalind/src/rosalind/rosalind_hs.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int end = s.nextInt();
        int start = 1;
        int size = end + 1;
        int array[] = new int[size];

        for (int i = start; i < size; i++) {
            array[i] = s.nextInt();
        }

        for (int i = end/2; i >= start; i--) {
            maxHeapify(array, i, end);
        }

        while (start != end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            end--;
            maxHeapify(array, start, end);
        }

        for (int i = start; i < size; i++) {
            System.out.print(array[i] + " ");
        }
    }

    private static void maxHeapify(int[] array, int i, int end) {
        int left = 2 * i;
        int right = 2 * i + 1;
        int largest = i;

        if (left <= end && array[left] >= array[largest]) {
            largest = left;
        }
        if (right <= end && array[right] >= array[largest]) {
            largest = right;
        }

        if (largest != i) {
            int temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;
            maxHeapify(array, largest, end);
        }
    }
}
