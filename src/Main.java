import tree.*;
import util.DataManager;
import util.ID3;

public class Main {

    public static void main(String[] args) {
        DataManager dataManager = new DataManager();
        ID3 id3 = new ID3();

        Tree tree = dataManager.readCSVFile(args[0]);

        id3.createTree(tree);

    }

}
