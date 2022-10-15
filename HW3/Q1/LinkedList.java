public class LinkedList {
    Node head;

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }

    }

    public int size() {
        Node andaze = head;
        if (andaze == null) {
            return 0;
        }
        int shomaresh = 0;
        while (andaze != null) {
            shomaresh++;
            andaze = andaze.next;
        }
        return shomaresh;
    }

    public boolean add(Integer element) {
        Node newnode = new Node(element);
        if (this.head == null) {
            this.head = newnode;
            return true;
        } else {
            newnode.next = null;
            Node Last = this.head;
            while (Last.next != null) {
                Last = Last.next;
            }
            Last.next = newnode;
        }
        return true;
    }

    public void add(int index, Integer element) {
        if (index < 0 || index > size()) {
            return;
        }
        if (index == 0) {
            Node node = new Node(element);
            node.next = head;
            head = node;
            return;
        }
        if (index == size()) {
            add(element);
            return;
        } else {
            Node temp = new Node(element);
            temp.next = head;
            Node counter = temp;
            for (int i = 0; i < index; i++) {
                counter = counter.next;
            }
            Node node = new Node(element);
            node.next = counter.next;
            counter.next = node;


        }
    }

    public boolean addAll(LinkedList linkedlist) {
        Node newnode = head;
        if (head == null) {
            head = linkedlist.head;
        } else if (size() == 0) {
            Node erfan = linkedlist.head;
            while (erfan.next != null) {
                erfan = erfan.next;
            }
            erfan.next = head;
            head = linkedlist.head;
        } else {
            for (int i = 0; i < size() - 1; i++) {
                if (newnode.next != null) {
                    newnode = newnode.next;
                }
            }
            Node temp = newnode.next;
            newnode.next = linkedlist.head;
            while (linkedlist.head.next != null) {
                linkedlist.head = linkedlist.head.next;
            }
            linkedlist.head.next = temp;
            return true;
        }
        return true;
    }

    public boolean addAll(int index, LinkedList linkedlist) {
        Node newnode = head;
        if (head == null) {
            head = linkedlist.head;
        } else if (index == 0) {
            Node erfan = linkedlist.head;
            while (erfan.next != null) {
                erfan = erfan.next;
            }
            erfan.next = head;
            head = linkedlist.head;
        } else {
            for (int i = 0; i < index - 1; i++) {
                if (newnode.next != null) {
                    newnode = newnode.next;
                }
            }
            Node temp = newnode.next;
            newnode.next = linkedlist.head;
            while (linkedlist.head.next != null) {
                linkedlist.head = linkedlist.head.next;
            }
            linkedlist.head.next = temp;
            return true;
        }
        return true;
    }
    public void addFirst(Integer element) {
        add(0, element);
    }

    public void addLast(Integer element) {
        add(element);
    }

    public void clear() {
        head = null;
    }

    public boolean contains(Integer i) {
        Node mosavi = head;
        while (mosavi != null) {
            if (mosavi.data == i) {
                return true;
            }
            mosavi = mosavi.next;
        }
        return false;
    }

    public Integer get(int index) {
        if (head == null) {
            return null;
        }
        int shomarande = 0;
        Node getter = head;
        while (getter != null) {
            if (shomarande == index) {
                return getter.data;
            }
            getter = getter.next;
            shomarande++;
        }
        return null;
    }

    public int indexOf(Integer i) {
        int counter = 0;
        Node newnode = head;
        if (head == null) {
            return -1;
        }
        while (newnode != null) {
            if (newnode.data == i) {
                return counter;
            }
            newnode = newnode.next;
            counter++;
        }
        return -1;
    }

    public Integer remove() {
        if (head != null) {
            Node newnode = head;
            head = head.next;
            return newnode.data;
        }
        return -1;
    }


    public Integer[] toArray() {
        Integer[] array = new Integer[size()];
        Node arraybuilder = head;
        for (int i = 0; i < size(); i++) {
            array[i] = arraybuilder.data;
            arraybuilder = arraybuilder.next;

        }
        return array;
    }

    public boolean isEmpty() {
        if (head == null) {
            return true;
        }
        return false;
    }

    public Integer remove(int index) {
        Node part1 = head;
        Node part2 = head;
        for (int i = 0; i < index - 1; i++) {
            part1 = part1.next;
        }
        for (int i = 0; i < index + 1; i++) {
            part2 = part2.next;
        }
        Node give = part1.next;
        part1.next = part2;
        return give.data;
    }

    public static void main(String[] args) {
        LinkedList linkedList1 = new LinkedList();
        linkedList1.add(1);
        linkedList1.add(3);
        linkedList1.add(1, 2);
        LinkedList linkedList2 = new LinkedList();
        linkedList2.add(1);
        linkedList2.add(2);
        linkedList2.add(3);

        linkedList2.addAll(0,linkedList1);
        Integer list[] = linkedList2.toArray();
        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i]); // 1 2 3
        }
    }
}


