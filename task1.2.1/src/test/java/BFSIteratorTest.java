import org.example.Node;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BFSIteratorTest {
    private Node<String> root;
    @BeforeEach
    public void setup(){
        root = new Node<>("R1", null);
    }
    @Test
    public void BfsIteratorTest(){
        Node<String> a = root.addNode("A");
        Node<String> b = root.addNode("B");
        Node<String> c = a.addNode("C");
        Node<String> d = a.addNode("D");

        StringBuilder result = new StringBuilder();
        Iterator<Node<String>> iterator = root.bfsIterator();
        while (iterator.hasNext()) {
            result.append(iterator.next().getValue());
            result.append(" ");
        }
        assertEquals("R1 A B C D ", result.toString());
    }

}
