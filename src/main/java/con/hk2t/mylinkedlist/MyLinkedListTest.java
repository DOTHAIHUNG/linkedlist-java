package con.hk2t.mylinkedlist;

public class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList<String> myLinkedList = new MyLinkedList<String>();

        myLinkedList.addFirst("5");
        myLinkedList.addFirst("10");
        myLinkedList.addLast("15");
        myLinkedList.add(2, "19");
        myLinkedList.remove(2);

        myLinkedList.addLast("25");
        myLinkedList.addLast("9");
        myLinkedList.addLast("16");
        myLinkedList.addLast("11");

        myLinkedList.remove("16");
        System.out.println(myLinkedList.size());
        myLinkedList.clear();
        myLinkedList.printLink();
    }
}
