package rosalind;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by johnflanigan on 9/6/16.
 */
public class TwoWayPartition {

    public static void twoWayPartition() {

        Scanner s = null;
        try {
            s = new Scanner(new File("/Users/johnflanigan/IdeaProjects/Rosalind/src/rosalind/rosalind_inv.txt"));
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

        int pivot = array[0];

        int[] lessThanArray = new int[size];
        int[] greaterThanArray = new int[size];
        int iLess = 0;
        int iGreater = 0;

        for (i = 1; i < size; i++) {
            if (array[i] <= pivot) {
                lessThanArray[iLess] = array[i];
                iLess++;
            } else {
                greaterThanArray[iGreater] = array[i];
                iGreater++;
            }
        }

        int[] permutedArray = new int[size];
        for (i = 0; i < iLess; i++) {
            permutedArray[i] = lessThanArray[i];
        }
        permutedArray[i] = pivot;
        int j = 0;
        for (i = iLess + 1; i < iGreater + iLess + 1; i++) {
            permutedArray[i] = greaterThanArray[j];
            j++;
        }

        for (i = 0; i < size; i++) {
            System.out.print(permutedArray[i] + " ");
        }
    }
}
