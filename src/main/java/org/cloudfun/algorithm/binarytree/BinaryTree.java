package org.cloudfun.algorithm.binarytree;

import java.util.LinkedList;
import java.util.Queue;

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

        System.out.println();
        printPreOrderTree(treeNode);

        System.out.println();
        printInOrderTree(treeNode);

        System.out.println();
        printPostOrderTree(treeNode);

        System.out.println();
        printByLevel(treeNode);

    }

    /**
     * 后序遍历  右叶子节点 -> 本节点 -> 左叶子节点
     *
     * @param treeNode data
     */
    public static void printPostOrderTree(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }

        printPostOrderTree(treeNode.getRightLeaf());

        printPostOrderTree(treeNode.getLeftLeaf());

        System.out.print(treeNode.getElement() + ",");

    }

    /**
     * 中序遍历  左叶子节点 -> 本节点 -> 右叶子节点
     *
     * @param treeNode data
     */
    public static void printInOrderTree(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }

        printInOrderTree(treeNode.getLeftLeaf());

        System.out.print(treeNode.getElement() + ",");

        printInOrderTree(treeNode.getRightLeaf());
    }

    /**
     * 前序遍历  本节点 -> 左叶子节点 -> 右叶子节点
     *
     * @param treeNode data
     */
    public static void printPreOrderTree(TreeNode treeNode) {

        if (treeNode == null) {
            return;
        }

        System.out.print(treeNode.getElement() + ",");

        printPreOrderTree(treeNode.getLeftLeaf());

        printPreOrderTree(treeNode.getRightLeaf());

    }


    /**
     * 按层遍历
     *
     * @param treeNode data
     */
    public static void printByLevel(TreeNode treeNode) {

        Queue<TreeNode> rootQueue = new LinkedList<>();

        Queue<TreeNode> mirrorQueue = new LinkedList<>();

        rootQueue.offer(treeNode);

        printLevelNode(rootQueue, mirrorQueue);


    }

    private static void printLevelNode(Queue<TreeNode> rootQueue, Queue<TreeNode> mirrorQueue) {

        if (rootQueue.isEmpty()) {
            return;
        }
        printLevel(mirrorQueue, rootQueue);
        printLevel(rootQueue, mirrorQueue);
        printLevelNode(rootQueue, mirrorQueue);
    }

    private static void printLevel(Queue<TreeNode> rootQueue, Queue<TreeNode> mirrorQueue) {
        while (!mirrorQueue.isEmpty()) {
            TreeNode nextNode = mirrorQueue.poll();
            System.out.print(nextNode.getElement()+" ");
            if (nextNode.getLeftLeaf() != null) {
                rootQueue.offer(nextNode.getLeftLeaf());
            }

            if (nextNode.getRightLeaf() != null) {
                rootQueue.offer(nextNode.getRightLeaf());
            }
        }

        System.out.println();
    }


}