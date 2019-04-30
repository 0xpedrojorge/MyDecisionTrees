package tree;

public abstract class Node {
    protected String[][] data;
    protected int lines, cols;

    public Node (String[][] data, int lines, int cols) {
        this.data = data;
        this.lines = lines;
        this.cols = cols;
    }

    public String[][] getData() {
        return data;
    }

    public int getLines() {
        return lines;
    }

    public int getCols() {
        return cols;
    }

    public void printNode() {
        for (int i=0; i<lines; i++) {
            for (int j=0; j<cols; j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }
    }

}
