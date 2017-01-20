package rosalind;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by johnflanigan on 11/21/16.
 */
public class ThreeWayPartition  {

    public static void threeWayPartition() {

        Scanner s = null;
        try {
            s = new Scanner(new File("/Users/johnflanigan/IdeaProjects/Rosalind/src/rosalind/rosalind_par3.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ArrayList<Integer> lessThan = new ArrayList<Integer>();
        ArrayList<Integer> equalTo = new ArrayList<Integer>();
        ArrayList<Integer> greaterThan = new ArrayList<Integer>();

        int size;
        size = s.nextInt();

        int r = s.nextInt();
        equalTo.add(r);

        for (int i = 0; i < size-1; i++) {
            int temp = s.nextInt();
            if (temp < r) {
                lessThan.add(temp);
            } else if (temp == r) {
                equalTo.add(temp);
            } else if (temp > r) {
                greaterThan.add(temp);
            }
        }

        int stop;
        stop = lessThan.size();
        for (int i = 0; i < stop; i++) {
            System.out.print(lessThan.remove(0) + " ");
        }
        stop = equalTo.size();
        for (int i = 0; i < stop; i++) {
            System.out.print(equalTo.remove(0) + " ");
        }
        stop = greaterThan.size();
        for (int i = 0; i < stop; i++) {
            System.out.print(greaterThan.remove(0) + " ");
        }
    }
}
