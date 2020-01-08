package org.cloudfun.algorithm.binarytree;

/**
 * @author cloudgc
 * @apiNote
 * @date 2020/1/8
 */
public class BlackRedTree {

    private TreeNode rootNode;


    public void insertNode(int element) {


    }


    public TreeNode removeNode(int element) {

        return null;
    }

    public TreeNode getRootNode() {
        return rootNode;
    }

    public static void main(String[] args) {
        BlackRedTree blackRedTree = new BlackRedTree();


        int maxElement = 28;
        for (int i = 1; i < maxElement; i++) {
            blackRedTree.insertNode(i);
        }

        BinaryTree.printInOrderTree(blackRedTree.getRootNode());

        blackRedTree.removeNode(28);
        blackRedTree.removeNode(1);
        blackRedTree.removeNode(10);

        BinaryTree.printInOrderTree(blackRedTree.getRootNode());


    }

}
