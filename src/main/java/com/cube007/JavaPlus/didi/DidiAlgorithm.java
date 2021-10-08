package com.cube007.JavaPlus.didi;

import java.util.Stack;

public class DidiAlgorithm {
    public static void main(String[] args) {

    }

    /**
     * 二叉树的非递归后序遍历
     * @param treeNode:
     * @author Cube007
     * @date 2021/10/8 21:57
     */
    public static void back(TreeNode treeNode) {

        if (treeNode == null) {
            return;
        }
        if (treeNode.getRightNode() == null && treeNode.getLeftNode() == null) {
            System.out.println(treeNode.getVal());
        }

        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> res = new Stack<>();

        stack.push(treeNode);
        while (!stack.isEmpty()) {
            TreeNode p = stack.pop();
            res.push(p);
            if (p.getLeftNode() != null) {
                stack.push(p.getLeftNode());
            }
            if (p.getRightNode() != null) {
                stack.push(p.getRightNode());
            }
        }
        while (!res.isEmpty()) {
            System.out.println(res.pop().getVal() + " ");
        }

    }
}
