public class BinaryTreeNode<E> {

    private E element;
    private BinaryTreeNode leftChild;
    private BinaryTreeNode rightChild;

    public BinaryTreeNode(E element) {
        setElement(element);
    }

    public void setElement(E element) {
        this.element = element;
    }

    public E getElement() {
        return element;
    }

    public void addLeftChild(BinaryTreeNode node) {
        leftChild = node;
    }

    public void addRightChild(BinaryTreeNode node) {
        rightChild = node;
    }

    public BinaryTreeNode getLeftChild() {
        if (leftChild != null) {
            return leftChild;
        } else return null;
    }

    public BinaryTreeNode getRightChild() {
        if (rightChild != null) {
            return rightChild;
        } else return null;
    }
}
