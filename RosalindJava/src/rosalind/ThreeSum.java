package rosalind;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static java.util.Arrays.copyOf;
import static java.util.Arrays.sort;

/**
 * Created by johnflanigan on 9/6/16.
 */
public class ThreeSum {

    public static void threeSum() {

        Scanner s = null;
        try {
            s = new Scanner(new File("/Users/johnflanigan/IdeaProjects/Rosalind/src/rosalind/rosalind_3sum.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int numberOfArrays;
        int size;
        numberOfArrays = s.nextInt();
        size = s.nextInt();

        for (int j = 0; j < numberOfArrays; j++) {

            int[] array = new int[size];
            for (int i = 0; i < size; i++) {
                array[i] = s.nextInt();
            }

            Boolean foundFlag = false;
            int[] sortedArray;
            sortedArray = copyOf(array, size);
            sort(sortedArray);
            int a = 0, b = 0, c = 0, start, end;
            for (int i = 0; i < size - 3 && !foundFlag; i++) {
                a = sortedArray[i];
                start = i + 1;
                end = size - 1;

                while (start < end && !foundFlag) {
                    b = sortedArray[start];
                    c = sortedArray[end];

                    if (a + b + c == 0) {
                        foundFlag = true;
                    } else if (a + b + c > 0) {
                        end--;
                    } else {
                        start++;
                    }
                }
            }

            int[] toPrint = new int[3];
            int k = 0;
            Boolean aFlag = false, bFlag = false, cFlag = false;
            for (int i = 0; i < size && k < 3; i++) {
                if (array[i] == a && !aFlag) {
                    toPrint[k] = i + 1;
                    k++;
                    aFlag = true;
                } else if (array[i] == b && !bFlag) {
                    toPrint[k] = i + 1;
                    k++;
                    bFlag = true;
                } else if (array[i] == c && !cFlag) {
                    toPrint[k] = i + 1;
                    k++;
                    cFlag = true;
                }
            }

            sort(toPrint);

            if (foundFlag) {
                System.out.print(toPrint[0] + " " + toPrint[1] + " " + toPrint[2] + "\n");
            } else {
                System.out.print("-1\n");
            }
        }
    }
}
