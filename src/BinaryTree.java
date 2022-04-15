import org.w3c.dom.ranges.Range;

import java.awt.font.NumericShaper;
import java.time.temporal.ValueRange;
import java.util.ArrayList;

public class BinaryTree<E>  {

    private BinaryTreeNode root;
    private ArrayList<BinaryTreeNode> nodes;
    private int size;

    public BinaryTreeNode getRoot() {
        if (root != null) {
            return root;
        }
        else return null;
    }

    public void setRoot(BinaryTreeNode node) {
        root = node;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public int getSize() {
        return inOrder().size();
    }

    public boolean contains(E element) {
        if (isEmpty()){
            return false;
        }
        return contains(element, root);
    }

    private boolean contains(E element, BinaryTreeNode root) {
        if (element == root.getElement()) {
            return true;
        }
        if (root.getLeftChild() == null && root.getRightChild() == null){
            return false;
        } else if (root.getLeftChild() == null) {
            return contains(element, root.getRightChild());
        } else if (root.getRightChild() == null) {
            return contains(element, root.getLeftChild());
        }

        return contains(element, root.getLeftChild()) || contains(element,root.getRightChild());

    }

    public ArrayList<E> inOrder() {
        ArrayList<E> inOrderList = new ArrayList<>();
        addInOrder(inOrderList, root);
        return inOrderList;
    }

    private void addInOrder(ArrayList<E> inOrderList, BinaryTreeNode nodeToAdd) {
        if (nodeToAdd == null) {
            return;
        }
        addInOrder(inOrderList, nodeToAdd.getLeftChild());
        inOrderList.add((E) nodeToAdd.getElement());
        addInOrder(inOrderList, nodeToAdd.getRightChild());
    }

    public ArrayList<E> preOrder() {
        ArrayList<E> preOrderList = new ArrayList<>();
        addPreOrder(preOrderList, root);
        return preOrderList;
    }

    private void addPreOrder(ArrayList<E> preOrderList, BinaryTreeNode nodeToAdd) {
        if (nodeToAdd == null){
            return;
        }
        preOrderList.add((E) nodeToAdd.getElement());
        addPreOrder(preOrderList, nodeToAdd.getLeftChild());
        addPreOrder(preOrderList, nodeToAdd.getRightChild());
    }

    public ArrayList<E> postOrder() {
        ArrayList<E> postOrderList = new ArrayList<>();
        addPostOrder(postOrderList, root);
        return postOrderList;
    }

    private void addPostOrder(ArrayList<E> postOrderList, BinaryTreeNode nodeToAdd) {
        if (nodeToAdd == null){
            return;
        }
        addPostOrder(postOrderList, nodeToAdd.getLeftChild());
        addPostOrder(postOrderList, nodeToAdd.getRightChild());
        postOrderList.add((E) nodeToAdd.getElement());
    }

    public ArrayList<E> levelOrder() {
        return null;
    }

    public int height() {
        if (isEmpty()) {
            return -1;
        }
        return calculateHeight(root) - 1;
    }

    private int calculateHeight(BinaryTreeNode node) {
        if (node == null ) {
            return 0;
        }

        int heightLeft = calculateHeight(node.getLeftChild());
        int heightRight = calculateHeight(node.getRightChild());

        return Math.max(heightLeft + 1, heightRight + 1);

    }

    public int heightBalance() {
        return calculateHeight(getRoot().getLeftChild()) - calculateHeight(getRoot().getRightChild());
    }

    public boolean isHeightBalanced(){

        if (ValueRange.of(-1, 1).isValidValue(heightBalance())) {
            return true;
        }
        return false;
    }

}
