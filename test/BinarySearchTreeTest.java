import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {

    private BinarySearchTree binarySearchTree;

    @BeforeEach
    void setup() {
        binarySearchTree = new BinarySearchTree();
    }

    void fillTree() {
        binarySearchTree.insert(5);
        binarySearchTree.insert(4);
        binarySearchTree.insert(6);
        binarySearchTree.insert(1);
    }

    @Test
    void testInsertNotEmpty() {
        binarySearchTree.insert(5);
        assertFalse(binarySearchTree.isEmpty());
    }

    @Test
    void testInsertCorrectElement() {
        binarySearchTree.insert(5);
        assertTrue(binarySearchTree.contains(5));
    }

    @Test
    void testInsertWithSeveralElements() {
        fillTree();
        ArrayList correctList = new ArrayList<>(Arrays.asList(1, 4, 5, 6));
        assertArrayEquals(correctList.toArray(), binarySearchTree.inOrder().toArray());
    }

    @Test
    void testInsertWithSameElement() {
        fillTree();
        assertFalse(binarySearchTree.insert(1));
    }

    @Test
    void testRemoveOnEmptyTree() {
        assertFalse(binarySearchTree.removeElement(1));
    }

    @Test
    void testRemoveNoMatchingElement() {
        fillTree();
        assertFalse(binarySearchTree.removeElement(10));
    }

    @Test
    void testRemoveMatchingElement(){
        fillTree();
        assertTrue(binarySearchTree.removeElement(1));
    }

    @Test
    void testRemoveNull(){
        fillTree();
        binarySearchTree.removeElement(5);
        assertNull(binarySearchTree.getRoot());
    }

    @Test
    void testFindMinEmptyTree() {
        assertEquals("Empty Tree", binarySearchTree.findMin());
    }

    @Test
    void testFindMinFilledTree() {
        fillTree();
        assertEquals(1, binarySearchTree.findMin());
    }

    @Test
    void testFindMaxEmptyTree() {
        assertEquals("Empty Tree", binarySearchTree.findMax());
    }

    @Test
    void testFindMaxFilledTree() {
        fillTree();
        assertEquals(6, binarySearchTree.findMax());
    }

    @Test
    void testReBalance(){
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

        assertFalse(binarySearchTree.isHeightBalanced());

        binarySearchTree.reBalance();

        assertTrue(binarySearchTree.isHeightBalanced());
    }



}