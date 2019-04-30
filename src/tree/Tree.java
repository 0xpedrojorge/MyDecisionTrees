package tree;

public class Tree {
    private NonLeafNode root;

    public Tree (NonLeafNode root) {
        this.root = root;
    }

    public NonLeafNode getRoot() {
        return this.root;
    }

}
