package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Node<Integer> tree1 = new Node<>(1, null);
        Node<String> tree2 = new Node<>("1", null);

        tree1.addNode(2);
        tree1.addNode(3);
        Node<Integer> peremennaya = tree1.addNode(1);
        peremennaya.deleteNode();

        tree2.addNode("2");
        tree2.addNode("2");
        tree2.addNode("2");
        for(Node<Integer> node : tree1 ){
            System.out.println(node.getValue());
        }
    }
}