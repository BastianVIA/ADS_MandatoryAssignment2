import java.util.ArrayList;

public class BinarySearchTree<E extends Comparable> extends BinaryTree<E>{

    BinarySearchNode root;
    BinaryTreePrint print = new BinaryTreePrint();

    public boolean insert(E element) {
        if (getRoot() == null) {
            setRoot(new BinarySearchNode(element));
            return true;
        }
        if (contains(element)) {
            return false;
        }

        return insertHelper(element, (BinarySearchNode) getRoot());
    }

    private boolean insertHelper(E element, BinarySearchNode node) {
        if (element.compareTo(node.getElement()) < 0) {
            if (node.getLeftChild() == null) {
                node.addLeftChild(new BinarySearchNode(element));
                return true;
            }
            return insertHelper(element, (BinarySearchNode) node.getLeftChild());
        }else if (element.compareTo(node.getElement()) > 0) {
            if (node.getRightChild() == null) {
                node.addRightChild(new BinarySearchNode(element));
                return true;
            }
            return insertHelper(element, (BinarySearchNode) node.getRightChild());
        }
        return false;
    }

    public boolean removeElement(E element) {
        if (getRoot() == null) {
            return false;
        }
        if (contains(element)) {
            if (getRoot().getElement() == element) {
                setRoot(null);
                return true;
            }
            return removeHelper(element, getRoot());
        }
        return false;
    }

    private boolean removeHelper(E element, BinaryTreeNode node) {
        //If element is equal to the node
        if (node.getElement() == element) {
            node.setElement(null);
            return true;
        }
        //If element is smaller than the node
        if (element.compareTo(node.getElement()) < 0) {
            //If left child is null
            if (node.getLeftChild() == null) {
                return false;
            }
            //If element is equal to the left child
            else if (element.compareTo(node.getLeftChild().getElement()) == 0) {
                node.getLeftChild().setElement(null);
                return true;
            }
            return removeHelper(element, node.getLeftChild());
        }
        //If element is larger than the node
        else if (element.compareTo(node.getElement()) > 0) {
            //If right child is null
            if (node.getRightChild() == null) {
                return false;
            }
            //If element is equal to the right child
            else if(element.compareTo(node.getRightChild()) == 0) {
                node.getRightChild().setElement(null);
                return true;
            }
            return removeHelper(element, node.getRightChild());
        }
        return false;
    }

    public E findMin() {
        if (getRoot() == null){
            return (E) new BinarySearchNode<E>("Empty Tree").getElement();
        }
        else if (getRoot().getLeftChild() == null) {
            return (E) getRoot().getElement();
        }
        return findMinHelper(getRoot());
    }

    private E findMinHelper(BinaryTreeNode node) {
        if (node.getLeftChild() == null) {
            return (E) node.getElement();
        }
        return findMinHelper(node.getLeftChild());
    }

    public E findMax() {
        if (getRoot() == null) {
            return (E) new BinarySearchNode<E>("Empty Tree").getElement();
        }
        else if (getRoot().getRightChild() == null) {
            return (E) getRoot().getElement();
        }
        return findMaxHelper(getRoot());
    }

    private E findMaxHelper(BinaryTreeNode node) {
        if (node.getRightChild() == null) {
            return (E) node.getElement();
        }
        return findMaxHelper(node.getRightChild());
    }

    public void reBalance() {
        ArrayList inOrderList = inOrder();
        ArrayList preOrderList = preOrder();
        if (inOrderList.isEmpty()){
            return;
        }
        for (Object o : preOrderList) {
            removeElement((E) o);
        }

        reBuild(inOrderList, 0, inOrderList.size() - 1);

    }

    private void reBuild(ArrayList inOrderList, int start, int end) {

        if (start <= end) {
            int mid = (start + end) / 2;
            insert((E) inOrderList.get(mid));
            reBuild(inOrderList, start, mid - 1);
            reBuild(inOrderList, mid + 1, end);
        }
    }


}
