package org.cloudfun.algorithm.binarytree;

/**
 * @author cloudgc
 * @apiNote
 * @date 2020/1/6
 */
public class BinaryTreeOperator {

    public static void main(String[] args) {
        int[] data = {0, 8, 4, 12, 2, 6, 10, 14, 1, 3, 5, 7, 9, 11, 13, 16};
        TreeNode treeNode = BinaryTree.buildFullTree(data);

        // 中序遍历
        BinaryTree.printInOrderTree(treeNode);
        System.out.println();

        //查找节点
        TreeNode findNode = findTreeNode(treeNode, 10);
        System.out.println(findNode);

        //插入节点
        TreeNode insertTreeNode = insertTreeNode(treeNode, 15);
        BinaryTree.printInOrderTree(insertTreeNode);
        System.out.println();


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

    public static TreeNode insertTreeNode(TreeNode treeNode, int data) {
        if (treeNode == null) {
            return new TreeNode(data);
        }

        TreeNode tmp = treeNode;
        while (tmp != null) {
            if (tmp.getElement() > data) {
                if (tmp.getLeftLeaf() == null) {
                    tmp.setLeftLeaf(new TreeNode(data));
                }
                tmp = tmp.getLeftLeaf();
            } else if (tmp.getElement() < data) {
                if (tmp.getRightLeaf() == null) {
                    tmp.setRightLeaf(new TreeNode(data));
                }
                tmp = tmp.getRightLeaf();
            } else {
                return treeNode;
            }
        }


        return treeNode;
    }

    public static TreeNode removeTreeNode(int data) {
        return null;
    }


}
