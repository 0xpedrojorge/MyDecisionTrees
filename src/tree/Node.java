package tree;

import java.util.HashMap;

public abstract class Node {
    protected String[][] data;
    protected int lines, cols;
    protected Node parent;

    public Node (String[][] data, int lines, int cols) {
        this.data = data;
        this.lines = lines;
        this.cols = cols;
        this.parent = null;
    }

    public Node (Node parent, String[][] data, int lines, int cols) {
        this.data = data;
        this.lines = lines;
        this.cols = cols;
        this.parent = parent;
    }
//3
    public String[][] getData() {
        return data;
    }

    public int getLines() {
        return lines;
    }

    public int getCols() {
        return cols;
    }

    public HashMap<String, Integer> getDiffOutcomes() {
        HashMap<String, Integer> list= new HashMap<>();
        for(int i=1; i<this.getLines(); i++) {
            if (!list.containsKey(this.data[i][this.getCols()-1])) {
                list.put(this.data[i][this.getCols()-1], 1);
            } else {
                String key = this.data[i][this.getCols()-1];
                list.replace(key, list.get(key)+1 );
            }
        }
        return list;
    }

    public HashMap<String, Integer> getDiffAttributes(int col) {
        HashMap<String, Integer> list= new HashMap<>();
        for(int i=1; i<this.getLines(); i++) {
            if (!list.containsKey(this.data[i][col])) {
                list.put(this.data[i][col], 1);
            } else {
                String key = this.data[i][col];
                list.replace(key, list.get(key)+1 );
            }
        }
        return list;
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
