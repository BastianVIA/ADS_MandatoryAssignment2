public class Main {
    public static void main(String[] args) {

        BinarySearchTree binarySearchTree = new BinarySearchTree<>();
        BinaryTreePrint print = new BinaryTreePrint();

        binarySearchTree.insert(10);
        binarySearchTree.insert(4);
        binarySearchTree.insert(6);
        binarySearchTree.insert(1);
        binarySearchTree.insert(2);
        binarySearchTree.insert(3);
        binarySearchTree.insert(17);
        binarySearchTree.insert(5);
        binarySearchTree.insert(8);
        binarySearchTree.insert(11);

        print.printTree(binarySearchTree.getRoot());

        binarySearchTree.reBalance();

        print.printTree(binarySearchTree.getRoot());


    }
}
