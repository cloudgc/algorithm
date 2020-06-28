package org.cloudfun.algorithm.binarytree;

/**
 * @author cloudgc
 * @apiNote binary tree node
 * @date 2019/12/30
 */
public class TreeNode {
    
    public TreeNode() {
    }
    
    public TreeNode(int element) {
        this.element = element;
    }
    
    private int element;
    
    private TreeNode leftLeaf;
    
    private TreeNode rightLeaf;
    
    public int getElement() {
        return element;
    }
    
    public void setElement(int element) {
        this.element = element;
    }
    
    public TreeNode getLeftLeaf() {
        return leftLeaf;
    }
    
    public void setLeftLeaf(TreeNode leftLeaf) {
        this.leftLeaf = leftLeaf;
    }
    
    public TreeNode getRightLeaf() {
        return rightLeaf;
    }
    
    public void setRightLeaf(TreeNode rightLeaf) {
        this.rightLeaf = rightLeaf;
    }
    
    @Override
    public String toString() {
        return "TreeNode{" + "element=" + element + ", leftLeaf=" + leftLeaf + ", rightLeaf=" + rightLeaf + '}';
    }
}
