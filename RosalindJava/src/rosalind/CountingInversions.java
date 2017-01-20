package rosalind;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by johnflanigan on 11/21/16.
 */
public class CountingInversions {

    public static void countingInversions() {

        Scanner s = null;
        try {
            s = new Scanner(new File("/Users/johnflanigan/IdeaProjects/Rosalind/src/rosalind/rosalind_inv.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int size;
        size = s.nextInt();

        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = s.nextInt();
        }

        long count = 0;
        for (int i = 0; i < size-1; i++) {
            for (int j = i+1; j < size; j++) {
                if (array[i] > array[j]) {
                    count++;
                }
            }
        }

        System.out.print(count);
    }
}
