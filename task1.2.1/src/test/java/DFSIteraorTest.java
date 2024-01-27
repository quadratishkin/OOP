import org.example.Node;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DFSIteraorTest {
    private Node<String> root;
    @BeforeEach
    public void setup(){
        root = new Node<>("R1", null);
    }
    @Test
    public void testDfsIterator(){
        Node<String> a = root.addNode("A");
        Node<String> b = root.addNode("B");
        Node<String> c = a.addNode("C");
        Node<String> d = a.addNode("D");

        StringBuilder result = new StringBuilder();
        for (Node<String> node : root) {
            result.append(node.getValue());
            result.append(" ");
        }
        assertEquals("R1 A C D B ", result.toString());
    }
}
