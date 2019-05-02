package tree;

public class LeafNode extends Node {
    //3
    private String classification;
    private String originationAttribute;

    public LeafNode (Node parent, String[][] data, int lines, int cols) {
        super(parent, data, lines, cols);
        this.isLeaf = true;
        this.classification = this.data[1][this.cols-1];
    }

    String getClassification() {
        return classification;
    }

    public String getOriginationAttribute() { return originationAttribute; }

    public void setOriginationAttribute(String attribute) {
        this.originationAttribute = attribute;
    }


}
