package con.hk2t.mylinkedlist;

public class MyLinkedList<E> {
    private Node head;
    private int numNodes;

    private class Node {
        private Node next;
        private Object data;

        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return data;
        }
    }

    public MyLinkedList() {
    }

    public void add(int index, E element) {
        Node temp = head;
        Node holder;

        for (int i = 0; i < index - 1 && temp.next != null; i++) {
            temp = temp.next;
        }
        holder = temp.next;
        temp.next = new Node(element);
        temp.next.next = holder;
        numNodes++;
    }

    public void addFirst(E element) {
        Node temp = head;
        head = new Node(element);
        head.next = temp;
        numNodes++;
    }

    public void addLast(E element) {
        Node temp = head;
        for (int i = 0; i < numNodes; i++) {
            if (temp.next != null) {
                temp = temp.next;
            }
            if (temp.next == null) {
                temp.next = new Node(element);
                numNodes++;
                break;
            }
        }
    }

    public void printLink() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public E remove(int index) {
        Node previous = head;
        for (int i = 1; i < index; i++) {
            previous = previous.next;
        }
        Node current = previous.next;
        previous.next = current.next;
        numNodes--;
        return (E) current;
    }

    public boolean remove(Object e) {
        int count = 0;
        Node temp = head;
        for (Node x = head; x != null; x = x.next) {
            count++;
            if (e.equals(x.data)) {
                for (int y = 0; y < count - 2; y++) {
                    temp = temp.next;
                }
                temp.next = temp.next.next;
                numNodes--;
                return true;
            }
        }
        return false;
    }

    public int size() {
        return numNodes;
    }

    public boolean contains(E o) {
        return indexOf(o) >= 0;
    }

    public int indexOf(E o) {
        int index = 0;
        if (o == null) {
            for (Node x = head; x != null; x = x.next) {
                if (x.data == null)
                    return index;
                index++;
            }
        } else {
            for (Node x = head; x != null; x = x.next) {
                if (o.equals(x.data))
                    return index;
                index++;
            }
        }
        return -1;
    }

    public Node get(int index) {
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public void clear() {
        for (Node x = head; x != null; ) {
            Node next = x.next;
            x.data = null;
            x.next = null;
            x = next;
        }
        head = null;
        numNodes = 0;
    }
}
