package tree;

import java.util.Map;
import java.util.Stack;

public class Tree {

    private NonLeafNode root;
    private String[] initialAttributes;

    public Tree (NonLeafNode root) {
        this.root = root;
        initialAttributes = new String[root.getCols()-1];
        for(int i=0; i<root.getCols()-1; i++) {
            initialAttributes[i] = root.getData()[0][i];
        }
    }

    public NonLeafNode getRoot() {
        return this.root;
    }

    public void printTree(){
        System.out.println();
        System.out.println("Decision Tree: ");

        printTree(this.root, "", 0);
    }
    private void printTree(Node node, String indentation, int rootFlag) {
        if (node == null) return;
        if (node.isLeaf) {
            LeafNode n = (LeafNode) node;
            System.out.println(n.getClassification() + " (" + (n.getLines()-1) + ")");
        } else {
            NonLeafNode n = (NonLeafNode) node;
            System.out.println();
            if (rootFlag != 0) {
                indentation += "    ";
            }
            System.out.println(indentation + "<" + n.getSplittigAttribute() + ">");
            indentation += "    ";
            for (Map.Entry<String, Node> child : n.getDescendents().entrySet()) {
                System.out.print(indentation + child.getKey() + ": ");
                printTree(child.getValue(), indentation, 1);
            }
        }

    }

    public String testCase(String line) {
        System.out.println("Testing for case:");
        System.out.println(line);
        Node cur = this.root;

        String[] l = line.split(",");

        while (!cur.isLeaf) {
            String checkingAttribute = ((NonLeafNode) cur).getSplittigAttribute();

            for(int i=1; i<root.getCols()-1; i++) {
                if (this.initialAttributes[i].equals(checkingAttribute)) {
                    String attributeValue = l[i];
                    cur = ((NonLeafNode) cur).getDescendents().get(attributeValue);
                    break;
                }
            }

        }
        System.out.println("Result: "+((LeafNode) cur).getClassification());
        return "";
    }

}
