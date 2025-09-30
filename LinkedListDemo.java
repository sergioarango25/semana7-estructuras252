class Node {
    Integer value;
    Node next;

    Node(Integer value) {
        this.value = value;
        this.next = null;
    }
}

class LinkedList {
    private Node head;

    public void insertAtHead(Integer value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
    }

    public void LinkedListInsertAfter(Node previous, Node newNode) {
        newNode.next = previous.next;
        previous.next = newNode;
    }

    public Node LinkedListLookUp(int elementNumber) {
        Node current = head;
        int count = 0;

        while (count < elementNumber && current != null) {
            current = current.next;
            count++;
        }
        return current;
    }


    public void insertAtIndex(int index, Integer value) {
        // Caso especial: insertar en la cabeza
        if (index == 0) {
            Node newHead = new Node(value);
            newHead.next = head;
            head = newHead;
            return;
        }

        Node current = head;
        Node previous = null;
        int count = 0;

        // Avanzar hasta la posición
        while (count < index && current != null) {
            previous = current;
            current = current.next;
            count++;
        }

        // Verificar si el índice es inválido
        if (count < index) {
            throw new IndexOutOfBoundsException("Índice inválido: " + index);
        }

        // Insertar el nuevo nodo
        Node newNode = new Node(value);
        newNode.next = previous.next;
        previous.next = newNode;
    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.value + "->");
            current = current.next;
        }
        System.out.print("/");
    }
}

public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insertAtHead(50);
        list.insertAtHead(40);
        list.insertAtHead(30);
        list.insertAtHead(20);
        list.insertAtHead(10);

        System.out.println("Lista inicial:");
        list.printList(); // 10->20->30->40->50->/

        System.out.println("\n\nInsertando 252 en la posición 2:");
        list.insertAtIndex(2, 252);
        list.printList(); // 10->20->99->30->40->50->/
    }
}
