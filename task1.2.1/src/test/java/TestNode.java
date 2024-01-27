import org.example.Node;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestNode {
    private Node<String> root;
    @BeforeEach
    public void setup(){
        root = new Node<>("R1", null);
    }

    @Test
    public void addNodeTest(){
        Node<String> a = root.addNode("A");
        assertNotNull(a);
        assertEquals("A", a.getValue());
        assertEquals(1, root.neighbours.size());
    }
    @Test
    public void deleteNodeTest(){
        Node<String> a = root.addNode("A");
        Node<String> b = root.addNode("B");
        assertEquals(2, root.neighbours.size());

        a.deleteNode();
        assertEquals(1, root.neighbours.size());
        assertNull(a.getValue());
        assertNull(a.getPid());
    }
    @Test
    public void equalsTest() {
        Node<String> a = root.addNode("A");
        Node<String> b = root.addNode("B");

        Node<String> root2 = new Node<>("R1", null);
        Node<String> a2 = root2.addNode("A");
        Node<String> b2 = root2.addNode("B");

        assertEquals(root, root2);
    }
}
