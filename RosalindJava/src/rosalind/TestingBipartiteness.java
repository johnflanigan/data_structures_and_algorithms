package rosalind;

import java.io.*;
import java.util.*;

import static java.lang.Integer.parseInt;

/**
 * Created by johnflanigan on 9/6/16.
 */
public class TestingBipartiteness {

    public static void testingBipartiteness() throws IOException {

        BufferedReader br = null;
        br = new BufferedReader(new FileReader("/Users/johnflanigan/IdeaProjects/Rosalind/src/rosalind/test.txt"));

        String s = br.readLine();
        int numberOfGraphs = parseInt(s);

        HashMap<Integer, Node> map = new HashMap<Integer, Node>();
        int to, from;

        while (br.readLine() != "") {
            s = br.readLine();
            String[] pairs = s.split(" ");
            to = parseInt(pairs[0]);
            from = parseInt(pairs[1]);

            map.get(to).adjacencyList.addLast(from);
            map.get(from).adjacencyList.addLast(to);
        }


        System.out.print("Test\n");


    }

    private class Node {
        int value;
        LinkedList adjacencyList = new LinkedList();
        Boolean visited = false;
    }

}
