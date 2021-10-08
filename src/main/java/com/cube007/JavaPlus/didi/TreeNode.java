package com.cube007.JavaPlus.didi;

public class TreeNode {
    private int val;
    private TreeNode rightNode;
    private TreeNode leftNode;

    TreeNode () {

    }

    TreeNode (int val, TreeNode rightNode, TreeNode leftNode) {
        this.val = val;
        this.rightNode = rightNode;
        this.leftNode = leftNode;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public TreeNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(TreeNode rightNode) {
        this.rightNode = rightNode;
    }

    public TreeNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(TreeNode leftNode) {
        this.leftNode = leftNode;
    }
}
