package util;

import tree.*;

import java.util.HashMap;
import java.util.Map;

public class ID3 {

    public void createTree(Node node) {
        if (node == null) return;
        if (!isPure(node.getData(), node.getLines(), node.getCols())) {
            NonLeafNode node1 = (NonLeafNode) node;

            split(node1);

            HashMap<String, Node> child = node1.getDescendents();

            for (Map.Entry<String, Node> entry : child.entrySet()) {
                createTree(entry.getValue());
            }
        }
    }

    private void split(NonLeafNode node) {
        int bestCol = getBestColToSplit(node);

        HashMap<String, Integer> diffAtt = node.getDiffAttributes(bestCol);

        for (Map.Entry<String, Integer> entry : diffAtt.entrySet()) {

            int lines = entry.getValue() + 1;
            String[][] childData = new String[lines][node.getCols() - 1];
            int t = 0;
            for (int i = 0; i < node.getCols(); i++) {
                if (i == bestCol) {

                    continue;
                }
                childData[0][t] = node.getData()[0][i];
                t++;
            }

            int lineInChild = 1;
            for (int i = 1; i < node.getLines(); i++) {
                int k = 0;
                if (node.getData()[i][bestCol].equals(entry.getKey())) {
                    for (int j = 0; j < node.getCols(); j++) {
                        if (j == bestCol) {
                            continue;
                        }
                        childData[lineInChild][k] = node.getData()[i][j];
                        k++;
                    }
                    lineInChild++;
                }
            }

            if (isPure(childData, lines, node.getCols() - 1)) {
                LeafNode child = new LeafNode(node, childData, lines, node.getCols() - 1);
                node.getDescendents().put(entry.getKey(), child);
                node.setSplittigAttribute(bestCol);
                child.setOriginationAttribute(entry.getKey());
            } else {
                NonLeafNode child = new NonLeafNode(node, childData, lines, node.getCols() - 1);
                node.setSplittigAttribute(bestCol);
                node.getDescendents().put(entry.getKey(), child);
            }

        }


    }

    private int getBestColToSplit(NonLeafNode node) {
        double maxGain = Double.MIN_VALUE;
        int bestCol = 1;
        for (int i=1; i<node.getCols()-2; i++) {
            double tempGain = gain(node, i);
            if (tempGain > maxGain) {
                maxGain = tempGain;
                bestCol = i;
            }
        }
        return bestCol;
    }

    private double gain(Node node, int attibuteCol) {
        double fatherEntropy = getNodeEntropy(node);
        double fatherSize = node.getLines()-1;

        HashMap<String, Integer> diffAtt = node.getDiffAttributes(attibuteCol);

        double[] possibleDescendentsEntropy = new double[diffAtt.size()];
        double[] possibleDescendentsSize = new double[diffAtt.size()];

        int index = 0;
        for (Map.Entry<String, Integer> entry : diffAtt.entrySet()) {

            int timeAttributeAppears = entry.getValue();
            String[][] fakeChildData = new String[timeAttributeAppears+1][node.getCols()];
            for(int i=0; i<node.getCols(); i++) {
                fakeChildData[0][i] = node.getData()[0][i];
            }
            int lineInChild = 1;
            for(int i=1; i<node.getLines(); i++) {
                if (node.getData()[i][attibuteCol].equals(entry.getKey())) {
                    for(int j=0; j<node.getCols(); j++) {
                        fakeChildData[lineInChild][j] = node.getData()[i][j];
                    }
                    lineInChild++;
                }
            }
            NonLeafNode fakeChild = new NonLeafNode(fakeChildData, timeAttributeAppears+1, node.getCols());
            possibleDescendentsEntropy[index] = getNodeEntropy(fakeChild);
            possibleDescendentsSize[index] = timeAttributeAppears;
            index++;
        }

        double gain = fatherEntropy;
        for (int i=0; i<diffAtt.size(); i++) {
            gain -= (possibleDescendentsSize[i]/fatherSize) * possibleDescendentsEntropy[i];
        }

        return (float )gain;
    }

    private double getNodeEntropy(Node node) {

        HashMap<String, Integer> diffOut = node.getDiffOutcomes();

        double entropy = 0.0;
        for (Map.Entry<String, Integer> entry : diffOut.entrySet()) {
            double p = (double) entry.getValue() / (double) (node.getLines()-1);
            entropy -= p * (Math.log(p) / Math.log(2));
        }

        return entropy;
    }

    private boolean isPure(String[][] data, int lines, int cols) {

        String flag = data[1][cols-1];

        for (int i=1; i<lines; i++) {
            if (!data[i][cols-1].equals(flag)) {
                return false;
            }
        }
        return true;
    }
}
