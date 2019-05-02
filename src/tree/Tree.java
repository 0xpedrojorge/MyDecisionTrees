package tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Tree {
    //3
    private NonLeafNode root;

    public Tree (NonLeafNode root) {
        this.root = root;
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

}
