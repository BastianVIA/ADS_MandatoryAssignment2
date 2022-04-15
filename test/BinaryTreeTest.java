import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {

    private BinaryTree binaryTree;
    private BinaryTreeNode root;
    BinaryTreeNode leftChild = new BinaryTreeNode<>(1);
    BinaryTreeNode leftChild2 = new BinaryTreeNode<>("Hej");
    BinaryTreeNode rightChild3 = new BinaryTreeNode<>(3);

    @BeforeEach
    void setup() {
        binaryTree = new BinaryTree();
        root = new BinaryTreeNode(5);
    }

    void fillUpTree() {
        binaryTree.setRoot(root);
        root.addLeftChild(leftChild);
        root.getLeftChild().addLeftChild(leftChild2);
        root.getLeftChild().getLeftChild().addRightChild(rightChild3);
    }

    @Test
    void testSetRoot() {
        binaryTree.setRoot(root);
        assertNotNull(binaryTree.getRoot());
    }

    @Test
    void testForCorrectRoot() {
        binaryTree.setRoot(root);
        assertEquals(root, binaryTree.getRoot());
    }

    @Test
    void testIsEmptyWithEmptyRoot() {
        assertTrue(binaryTree.isEmpty());
    }

    @Test
    void testIsEmptyWithRoot(){
        binaryTree.setRoot(root);
        assertFalse(binaryTree.isEmpty());
    }

    @Test
    void testSizeWhenEmpty() {
        assertEquals(0, binaryTree.getSize());
    }

    @Test
    void testSizeWith1Element(){
        binaryTree.setRoot(root);
        assertEquals(1, binaryTree.getSize());
    }

    @Test
    void testSizeWith2Elements(){
        BinaryTreeNode leftChild = new BinaryTreeNode<>(1);

        binaryTree.setRoot(root);
        root.addRightChild(leftChild);

        assertEquals(2, binaryTree.getSize());
    }

    @Test
    void testSizeWithMultipleGenerations(){
        fillUpTree();

        assertEquals(4, binaryTree.getSize());
    }

    @Test
    void testContainsWithEmptyTree() {
        assertFalse(binaryTree.contains(1));
    }

    @Test
    void testContainsWithNoMatchingElement() {
        fillUpTree();
        assertFalse(binaryTree.contains(7));
    }

    @Test
    void testContainsWithMatchingInt(){
        fillUpTree();
        assertTrue(binaryTree.contains(1));
    }

    @Test
    void testContainsWithMatchingString(){
        fillUpTree();
        assertTrue(binaryTree.contains("Hej"));
    }

    @Test
    void testInOrderReturnsList(){
        assertNotNull(binaryTree.inOrder());
    }

    @Test
    void testInOrderReturnsCorrectList() {
        fillUpTree();

        ArrayList correctList = new ArrayList<>(Arrays.asList(leftChild2.getElement(), rightChild3.getElement(),  leftChild.getElement(), root.getElement()));
        assertArrayEquals(correctList.toArray(), binaryTree.inOrder().toArray());
    }

    @Test
    void testPreOrderReturnsList(){
        assertNotNull(binaryTree.preOrder());
    }

    @Test
    void testPreOrderReturnsCorrectList() {
        fillUpTree();

        ArrayList correctList = new ArrayList<>(Arrays.asList(root.getElement(), leftChild.getElement(), leftChild2.getElement(), rightChild3.getElement()));
        assertArrayEquals(correctList.toArray(), binaryTree.preOrder().toArray());
    }

    @Test
    void testPostOrderReturnsList(){
        assertNotNull(binaryTree.postOrder());
    }

    @Test
    void testPostOrderReturnsCorrectList() {
        fillUpTree();

        ArrayList correctList = new ArrayList<>(Arrays.asList(rightChild3.getElement(), leftChild2.getElement(), leftChild.getElement(), root.getElement()));
        assertArrayEquals(correctList.toArray(), binaryTree.postOrder().toArray());
    }

    @Test
    void testHeightWithEmptyTree(){
        assertEquals(-1, binaryTree.height());
    }

    @Test
    void testHeightOnlyRoot(){
        binaryTree.setRoot(root);
        assertEquals(0, binaryTree.height());
    }

    @Test
    void testHeightWithSeveralGenerations(){
        fillUpTree();
        assertEquals(3, binaryTree.height());
    }




}