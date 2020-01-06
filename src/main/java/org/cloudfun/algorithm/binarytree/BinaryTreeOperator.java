package org.cloudfun.algorithm.binarytree;

/**
 * @author cloudgc
 * @apiNote
 * @date 2020/1/6
 */
public class BinaryTreeOperator {

    public static void main(String[] args) {
        int[] data = {0, 8, 4, 12, 2, 6, 10, 14, 1, 3, 5, 7, 9, 11, 13, 15};
        TreeNode treeNode = BinaryTree.buildFullTree(data);

        // 中序遍历
        BinaryTree.printInOrderTree(treeNode);
        System.out.println();

        //查找节点
        TreeNode findNode = findTreeNode(treeNode, 10);
        System.out.println(findNode);


    }


    public static TreeNode findTreeNode(TreeNode treeNode, int data) {
        if (treeNode == null) {
            treeNode = new TreeNode(data);
        }
        TreeNode tmp = treeNode;
        TreeNode find = null;
        while (tmp != null) {
            if (tmp.getElement() > data) {
                tmp = tmp.getLeftLeaf();
            } else if (tmp.getElement() < data) {
                tmp = tmp.getRightLeaf();
            } else {
                find = tmp;
                break;
            }

        }
        return find;
    }

    public static TreeNode insertTreeNode(int data) {
        return null;
    }

    public static TreeNode removeTreeNode(int data) {
        return null;
    }


}
