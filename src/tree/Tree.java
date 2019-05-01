package tree;

public class Tree {
    //3
    private NonLeafNode root;

    public Tree (NonLeafNode root) {
        this.root = root;
    }

    public NonLeafNode getRoot() {
        return this.root;
    }

}
