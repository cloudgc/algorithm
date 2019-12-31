package org.cloudfun.algorithm.binarytree;

/**
 * @author cloudgc
 * @apiNote
 * @date 2019/12/30
 */
public class BinaryTree {

    private static final int NUM_2 = 2;


    public static TreeNode buildFullTree(int[] data) {
        TreeNode root = new TreeNode();
        setTreeNode(root, data, 1);
        return root;
    }

    private static void setTreeNode(TreeNode treeNode, int[] data, int index) {
        if (index >= data.length) {
            return;
        }
        treeNode.setElement(data[index]);

        if (NUM_2 * index >= data.length) {
            return;
        }
        int left = data[2 * index];
        TreeNode leftNode = new TreeNode(left);
        treeNode.setLeftLeaf(leftNode);
        setTreeNode(leftNode, data, 2 * index);

        if ((NUM_2 * index + 1) >= data.length) {
            return;
        }
        int right = data[2 * index + 1];

        TreeNode rightNode = new TreeNode(right);
        treeNode.setRightLeaf(rightNode);
        setTreeNode(rightNode, data, 2 * index + 1);
    }


    public static void main(String[] args) {

        int[] data = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};

        TreeNode treeNode = buildFullTree(data);


        printPreOrderTree(treeNode);

        printInOrderTree(treeNode);

        printPostOrderTree(treeNode);


    }

    private static void printPostOrderTree(TreeNode treeNode) {
    }

    private static void printInOrderTree(TreeNode treeNode) {

    }

    private static void printPreOrderTree(TreeNode treeNode) {

    }


}