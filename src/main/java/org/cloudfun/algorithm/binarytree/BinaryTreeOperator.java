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
        
        insertTreeNode(insertTreeNode, 20);
        insertTreeNode(insertTreeNode, 22);
        BinaryTree.printInOrderTree(insertTreeNode);
        System.out.println();
        
        TreeNode removeTreeNode = removeTreeNode(treeNode, 14);
        BinaryTree.printInOrderTree(removeTreeNode);
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
    
    public static TreeNode removeTreeNode(TreeNode treeNode, int data) {
        TreeNode node = treeNode;
        
        //get data parent node
        TreeNode nodeParent = null;
        
        while (node != null && node.getElement() != data) {
            nodeParent = node;
            if (node.getElement() > data) {
                node = node.getLeftLeaf();
            } else {
                node = node.getRightLeaf();
            }
        }
        
        // if not found note return
        if (node == null) {
            return treeNode;
        }
        
        // node has full leaf node
        if (node.getRightLeaf() != null && node.getLeftLeaf() != null) {
            TreeNode minNodeParent = node;
            TreeNode minNode = node.getRightLeaf();
            while (minNode.getLeftLeaf() != null) {
                minNodeParent = minNode;
                minNode = minNode.getLeftLeaf();
            }
            node.setElement(minNode.getElement());
            // minNode.setElement(0);
            // minNodeParent.setLeftLeaf(null);
            node = minNode;
            nodeParent = minNodeParent;
            
            
        }
        
        TreeNode child;
        if (node.getLeftLeaf() != null) {
            child = node.getLeftLeaf();
        } else if (node.getRightLeaf() != null) {
            child = node.getRightLeaf();
        } else {
            child = null;
        }
        
        if (nodeParent == null) {
            treeNode = child;
        } else if (nodeParent.getLeftLeaf() == node) {
            nodeParent.setLeftLeaf(child);
        } else {
            nodeParent.setRightLeaf(child);
        }
        
        return treeNode;
    }
    
    
}
