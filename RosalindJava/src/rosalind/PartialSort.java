package rosalind;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by johnflanigan on 11/27/16.
 */
public class PartialSort {

    public static void partialSort() {

        Scanner s = null;
        try {
            s = new Scanner(new File("/Users/johnflanigan/IdeaProjects/Rosalind/src/rosalind/rosalind_ps.txt"));
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
            minHeapify(array, i, end);
        }

        int k = s.nextInt();

        int root = 0;
        for (int i = 0; i < k; i++) {
            root = array[1];
            array[1] = array[end];
            end--;
            minHeapify(array, start, end);
            System.out.print(root + " ");
        }
    }

    private static void minHeapify(int[] array, int i, int end) {
        int left = 2 * i;
        int right = 2 * i + 1;
        int smallest = i;

        if (left <= end && array[left] <= array[smallest]) {
            smallest = left;
        }
        if (right <= end && array[right] <= array[smallest]) {
            smallest = right;
        }

        if (smallest != i) {
            int temp = array[i];
            array[i] = array[smallest];
            array[smallest] = temp;
            minHeapify(array, smallest, end);
        }
    }
}
