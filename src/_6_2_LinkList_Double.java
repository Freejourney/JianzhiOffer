/**
 * Created by ua28 on 2/10/20.
 */
public class _6_2_LinkList_Double {

    public class DoubleListNode {
        int val;
        DoubleListNode pre, next;
        DoubleListNode(int val) {
            this.val = val;
        }
    }

    private DoubleListNode head;

    public void addHead(int val) {
        if (head == null) {
            head = new DoubleListNode(val);
            return;
        }

        DoubleListNode node = new DoubleListNode(val);
        node.next = head;
        head.pre = node;
        head = node;
    }

    public void addTail(int val) {
        if (head == null) {
            head = new DoubleListNode(val);
            return;
        }

        DoubleListNode node = head;
        while (node.next != null) {
            node = node.next;
        }

        node.next = new DoubleListNode(val);
        node.next.pre = node;
    }

    public void addBeforeNthNode(int n, int val) {
        if (head == null) {
            throw new NullPointerException();
        }

        if (n <= 0) {
            throw new IllegalArgumentException();
        }

        if (n == 1) {
            DoubleListNode hnode = new DoubleListNode(val);
            hnode.next = head;
            head.pre = hnode;
            head = hnode;
            return;
        }

        int i = 1;
        DoubleListNode node = head;
        while (node.next != null && i < n) {
            node = node.next;
            i++;
        }

        if (i == n) {
            DoubleListNode node1 = new DoubleListNode(val);
            node1.next = node;
            node1.pre = node.pre;
            if (node.pre != null) {
                node.pre.next = node1;
            }
            node.pre = node1;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public void addAfterNthNode(int n, int val) {
        if (head == null) {
            throw new NullPointerException();
        }

        if (n <= 0) {
            throw new IllegalArgumentException();
        }

        // i corresponds with node, ith node ; 1 -- ith == [0] -- [i-1]
        DoubleListNode node = head;
        int i = 1;
        while (node.next != null && i < n) {
            i++;
            node = node.next;
        }

        if (i == n) {
            DoubleListNode node1 = new DoubleListNode(val);
            node1.pre = node;
            node1.next = node.next;
            node.next.pre = node1;
            node.next = node1;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public void deleteNode(DoubleListNode node) {
        if (node == null) {
            throw new NullPointerException();
        }

        if (node == head) {
            head = node.next;
        }

        node.pre.next = node.next;
        if (node.next != null)
            node.next.pre = node.pre;
    }

    public void deleteNthNode(int n) {
        if (head == null) {
            throw new NullPointerException();
        }

        if (n <= 0) {
            throw new IllegalArgumentException();
        }

        if (n == 1) {
            head = head.next;
            head.pre = null;
            return;
        }

        int i = 1;
        DoubleListNode node = head;
        while (node.next != null && i < n) {
            node = node.next;
            i++;
        }

        if (i == n) {
            node.pre.next = node.next;
            if (node.next != null) {
                node.next.pre = node.pre;
            }
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public void modifyNthNode(int n, int val) {
        if (head == null) {
            throw new NullPointerException();
        }

        if (n <= 0) {
            throw new IllegalArgumentException();
        }

        int i = 1;
        DoubleListNode node = head;
        while (node != null && i < n) {
            node = node.next;
            i++;
        }
        node.val = val;
    }

    public DoubleListNode GetNthNode(int n) {
        if (head == null) {
            throw new NullPointerException();
        }

        if (n <= 0) {
            throw new IllegalArgumentException();
        }

        int i = 1;
        DoubleListNode node = head;
        while (node != null && i < n) {
            node = node.next;
            i++;
        }

        if (i == n) {
            return node;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public void display(String str) {
        System.out.print("After "+str+" : ");
        DoubleListNode node = head;
        while (node != null) {
            System.out.print(node.val+" ");
            node = node.next;
        }
        System.out.println();
    }

    public void makeDoubleList() {
        this.head = new DoubleListNode(1);
        this.head.next = new DoubleListNode(2);
        this.head.next.next = new DoubleListNode(3);

        display("3 Nodes");
    }

    public void testFunctions() {
        addHead(1);
        display("addHead(1)");
        addTail(2);
        display("addTail(2)");
        addAfterNthNode(1,11);
        display("addAfterNthNode(1, 11)");
        addBeforeNthNode(1, 10);
        display("addBeforeNthNode(1, 10)");

        deleteNthNode(1);
        display("deleteNthNode(1)");
        deleteNode(GetNthNode(2));
        display("deleteNode(GetNthNode(2))");

        modifyNthNode(2, 100);
        display("modifyNthNode(2,100)");
    }

    public static void main(String[] args) {
        _6_2_LinkList_Double linkList = new _6_2_LinkList_Double();
//        linkList.makeDoubleList();

        // test double linked list
        linkList.testFunctions();
    }

}

/*
    All method that may change the head node should be considered alone
 */