package tree;

public class LeafNode extends Node {
    //3
    private String classification;
    private String originationAttirbute;

    public LeafNode (Node parent, String[][] data, int lines, int cols) {
        super(parent, data, lines, cols);
        this.isLeaf = true;
        this.classification = this.data[1][this.cols-1];
    }

    public String getClassification() {
        return classification;
    }

    public String getOriginationAttirbute() { return originationAttirbute; }

    public void setOriginationAttirbute(String attribute) {
        this.originationAttirbute = attribute;
    }


}
