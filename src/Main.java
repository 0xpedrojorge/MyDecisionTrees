import tree.*;
import util.DataManager;
import util.ID3;

public class Main {
//3
    public static void main(String[] args) {
        DataManager dataManager = new DataManager();
        ID3 id3 = new ID3();
        if(args.length == 0){
            System.out.println("ERROR: No file selected.");
            return;
        }
        Tree tree = dataManager.readCSVFile(args[0]);

        id3.createTree(tree.getRoot());



    }

}
