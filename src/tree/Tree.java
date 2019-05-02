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

        Stack<Node> stack = new Stack<>();
        stack.push(this.getRoot());
        while (!stack.isEmpty()){
            System.out.println();
            Node node = stack.pop();
            String toPrint;

            if (node.isLeaf){

                LeafNode node1 = (LeafNode) node;
                System.out.print(node1.getDepth() + node1.getOriginationAttirbute() + " " + ": " + node1.getClassification());

            }else {
                System.out.print(node.getDepth() + ((NonLeafNode) node).getSplittigAttribute());

                for (Map.Entry<String, Node> entry : ((NonLeafNode) node).getDescendents().entrySet()) {
                    entry.getValue().setDepth(entry.getValue().getDepth() + " ");
                    stack.push(entry.getValue());

                }
            }

        }

    }

    public String testCase(String line) {
        System.out.println();
        System.out.println("Testing for case:");
        System.out.println(line);
        Node cur = this.root;

        String[] l = line.split(",");

        while (!cur.isLeaf) {
            String checkingAttribute = ((NonLeafNode) cur).getSplittigAttribute();

            for(int i=0; i<root.getCols()-1; i++) {
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
