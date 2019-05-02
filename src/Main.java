import tree.*;
import util.DataManager;
import util.ID3;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        DataManager dataManager = new DataManager();
        ID3 id3 = new ID3();

        if(args.length == 0){
            System.out.println("ERROR: No file selected.");
            return;
        }

        Tree tree = dataManager.readCSVFile(args[0]);

        id3.createTree(tree.getRoot());
        tree.printTree();

        if (args.length == 1) {
            System.out.println("No tests file, exiting.");
            System.exit(0);
        }
        String[] tests = dataManager.readTestFile(args[1]);
        for (String test : tests) {
            System.out.println(tree.testCase(test));
        }

    }

}
