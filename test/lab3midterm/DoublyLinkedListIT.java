package lab3midterm;


import lab3midterm.DoublyLinkedList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class DoublyLinkedListIT {

    private DoublyLinkedList<Integer> list;

    @BeforeClass
    public static void setUpClass() {
        System.out.println("=== Starting all tests at " + new java.util.Date() + " ===");
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("=== All tests completed ===");
    }

    @Before
    public void setUp() {
        list = new DoublyLinkedList<>();
        System.out.println("Setting up new list for next test.");
    }

    @After
    public void tearDown() {
        System.out.println("Tearing down list.");
    }

    @Test
    public void testAddFirst() {
        System.out.println("Test: addFirst - Adding 1 to empty list");
        list.addFirst(1);
        int result = list.get(0);
        System.out.println("Result: got " + result + ", size is " + list.size());
        assertEquals(1, result);
        assertEquals(1, list.size());
    }

    @Test
    public void testAddLast() {
        System.out.println("Test: addLast - Adding 1 to empty list");
        list.addLast(1);
        int result = list.get(0);
        System.out.println("Result: got " + result + ", size is " + list.size());
        assertEquals(1, result);
        assertEquals(1, list.size());
    }

    @Test
    public void testRemoveFirstEmpty() {
        System.out.println("Test: removeFirstEmpty - Removing from empty list");
        Integer result = list.removeFirst();
        System.out.println("Result: got " + result + ", size is " + list.size());
        assertNull(result);
        assertEquals(0, list.size());
    }

    @Test
    public void testRemoveLastEmpty() {
        System.out.println("Test: removeLastEmpty - Removing from empty list");
        Integer result = list.removeLast();
        System.out.println("Result: got " + result + ", size is " + list.size());
        assertNull(result);
        assertEquals(0, list.size());
    }

    @Test
    public void testInsertAtIndex() {
        System.out.println("Test: insertAtIndex - Inserting 2 at index 1 after 1");
        list.addLast(1);
        list.insertAtIndex(1, 2);
        int result = list.get(1);
        System.out.println("Result: got " + result + ", size is " + list.size());
        assertEquals(2, result);
        assertEquals(2, list.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testInsertAtIndexException() {
        System.out.println("Test: insertAtIndexException - Trying invalid index -1");
        list.insertAtIndex(-1, 1);
    }

    @Test
    public void testDeleteAtIndex() {
        System.out.println("Test: deleteAtIndex - Deleting index 1 from [1, 2]");
        list.addLast(1);
        list.addLast(2);
        Integer result = list.deleteAtIndex(1);
        System.out.println("Result: got " + result + ", size is " + list.size());
        assertEquals(2, result.intValue());
        assertEquals(1, list.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testDeleteAtIndexException() {
        System.out.println("Test: deleteAtIndexException - Trying invalid index 0");
        list.deleteAtIndex(0);
    }

    @Test
    public void testGet() {
        System.out.println("Test: get - Getting index 0 after adding 1");
        list.addLast(1);
        Integer result = list.get(0);
        System.out.println("Result: got " + result);
        assertEquals(1, result.intValue());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetException() {
        System.out.println("Test: getException - Trying invalid index 0");
        list.get(0);
    }

    @Test
    public void testContains() {
        System.out.println("Test: contains - Checking 1 and 2 after adding 1");
        list.addLast(1);
        boolean result1 = list.contains(1);
        boolean result2 = list.contains(2);
        System.out.println("Result: contains 1 = " + result1 + ", contains 2 = " + result2);
        assertTrue(result1);
        assertFalse(result2);
    }

    @Test
    public void testSize() {
        System.out.println("Test: size - Checking size after adding 1 and 2");
        list.addFirst(1);
        list.addLast(2);
        int result = list.size();
        System.out.println("Result: size is " + result);
        assertEquals(2, result);
    }

    @Test
    public void testReverse() {
        System.out.println("Test: reverse - Reversing [1, 2]");
        list.addLast(1);
        list.addLast(2);
        list.reverse();
        int result1 = list.get(0);
        int result2 = list.get(1);
        System.out.println("Result: first = " + result1 + ", second = " + result2);
        assertEquals(2, result1);
        assertEquals(1, result2);
    }

    @Test
    public void testSwapNodes() {
        System.out.println("Test: swapNodes - Swapping 0 and 2 in [1, 2, 3]");
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.swapNodes(0, 2);
        int result1 = list.get(0);
        int result2 = list.get(2);
        System.out.println("Result: first = " + result1 + ", last = " + result2);
        assertEquals(3, result1);
        assertEquals(1, result2);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSwapNodesException() {
        System.out.println("Test: swapNodesException - Trying invalid indices on empty list");
        list.swapNodes(0, 1);
    }
}
