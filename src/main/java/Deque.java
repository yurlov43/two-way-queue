import java.util.*;

public class Deque<T> {

    LinkedList2<T> linkedList2;

    public Deque() {
        linkedList2 = new LinkedList2<>();
    }

    public void addFront(T item) {
        linkedList2.addInTail(new Node<>(item));
    }

    public void addTail(T item) {
        linkedList2.insertAfter(null, new Node<>(item));
    }

    public T removeFront() {
        if (size() == 0) {
            return null;
        }
        T item = (T) linkedList2.tail.value;
        linkedList2.deleteNode(linkedList2.tail);
        return item;
    }

    public T removeTail() {
        if (size() == 0) {
            return null;
        }
        T item = (T) linkedList2.head.value;
        linkedList2.deleteNode(linkedList2.head);
        return item;
    }

    public int size() {
        return linkedList2.count();
    }
}

class LinkedList2<T> {

    public Node head;
    public Node tail;

    public LinkedList2() {
        head = null;
        tail = null;
    }

    public void deleteNode(Node node) {
        if (node == this.head) {
            if (node.next == null) {
                this.head = null;
                this.tail = null;
            } else {
                this.head = node.next;
                this.head.prev = null;
            }
        } else {
            if (node.next == null) {
                this.tail = node.prev;
                this.tail.next = null;
            } else {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }
        }
    }

    public void addInTail(Node item) {
        if (head == null) {
            this.head = item;
            this.head.next = null;
            this.head.prev = null;
        } else {
            this.tail.next = item;
            item.prev = tail;
        }
        this.tail = item;
    }

    public Node find(T value) {
        Node node = this.head;
        while (node != null) {
            if (node.value == value)
                return node;
            node = node.next;
        }
        return null;
    }

    public ArrayList<Node> findAll(T value) {
        ArrayList<Node> nodes = new ArrayList<Node>();
        Node node = this.head;
        while (node != null) {
            if (node.value == value) {
                nodes.add(node);
            }
            node = node.next;
        }
        return nodes;
    }

    public boolean remove(T value) {
        Node node = this.head;

        while (node != null) {
            if (node.value == value) {
                deleteNode(node);
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public void removeAll(T value) {
        while (remove(value)) {

        }
    }

    public void clear() {
        this.head = null;
        this.tail = null;
    }

    public int count() {
        Node node = this.head;
        int length = 0;

        while (node != null) {
            length = length + 1;
            node = node.next;
        }
        return length;
    }

    public void insertAfter(Node nodeAfter, Node nodeToInsert) {
        Node node = this.head;

        if (node == null) {
            this.head = nodeToInsert;
            this.tail = nodeToInsert;
        }

        while (node != null) {
             if (node == nodeAfter) {
                nodeToInsert.next = node.next;
                if (node.next == null) {
                    this.tail = nodeToInsert;
                } else {
                    node.next.prev = nodeToInsert;
                }
                node.next = nodeToInsert;
                nodeToInsert.prev = node;
            }
            if (nodeAfter == null) {
                nodeToInsert.next = node;
                node.prev = nodeToInsert;
                this.head = nodeToInsert;
                break;
            }
            node = node.next;
        }
    }
}

class Node<T> {
    public T value;
    public Node next;
    public Node prev;

    public Node(T value) {
        this.value = value;
        this.next = null;
        this.prev = null;
    }
}
