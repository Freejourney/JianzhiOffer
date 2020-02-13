import java.util.List;

/**
 * Created by ua28 on 2/10/20.
 */
public class _6_1_LinkList_Single {

    public class SingleListNode {
        int val;
        SingleListNode next;
        SingleListNode(int val) {
            this.val = val;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public SingleListNode getNext() {
            return next;
        }

        public void setNext(SingleListNode next) {
            this.next = next;
        }
    }

    private SingleListNode head;

    public _6_1_LinkList_Single(int val) {
        this.head = new SingleListNode(val);
    }

  // Add

    // Add head
    public void addHead(int val) {
        if (this.head == null) {
            this.head = new SingleListNode(val);
            return;
        }

        SingleListNode node = new SingleListNode(val);
        node.next = this.head;
        this.head = node;
    }

    // Add tail
    public void addTail(int val) {
        if (this.head == null)
            throw new NullPointerException();

        SingleListNode node = this.head;
        while (node.next != null) {
            node = node.next;
        }
        node.next = new SingleListNode(val);
    }

    // Add before list[n]
    public void addBeforeN(int n, int val) {
        if (this.head == null) {
            throw new NullPointerException();
        }

        if (n < 0) {
            throw new IllegalArgumentException();
        }

        SingleListNode node = this.head;
        int i = 0;
        while (node.next != null && i < n-1) {
            node = node.next;
            i++;
        }

        if (i == n-1) {
            SingleListNode nnode = new SingleListNode(val);
            nnode.next = node.next;
            node.next = nnode;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    // Add after list[n]
    public void addAfterN(int n, int val) {
        if (this.head == null) {
            throw new NullPointerException();
        }

        if (n < 0) {
            throw new IllegalArgumentException();
        }

        SingleListNode node = this.head;
        int i = 0;
        while (node.next != null && i < n) {
            node = node.next;
            i++;
        }

        if (i == n) {
            SingleListNode nnode = new SingleListNode(val);
            nnode.next = node.next;
            node.next = nnode;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

  // Delete

    // Delete indicated node
    public void deleteNode(SingleListNode node) {
        if (node == null || this.head == null) {
            throw new NullPointerException();
        }

        SingleListNode node1 = this.head;

        if (node1 == node) {
            this.head = node.next;
            return;
        }

        while (node1 != null) {
            if (node1.next == node) {
                node1.next = node.next;
                return;
            }
            node1 = node1.next;
        }
    }

    // Delete list[n]
    public void deleteN(int n) {
        // pointer
        if (this.head == null) {
            throw new NullPointerException();
        }

        // left bound
        if (n < 0) {
            throw new IllegalArgumentException();
        }

        // head
        if (n == 0) {
            this.head = this.head.next;
            return;
        }

        SingleListNode node = this.head;
        int i = 0;
        while (node.next != null && i < n-1) {
            node = node.next;
            i++;
        }

        // tail
        if (i == n-1) {
            // right bound
            if (node.next == null) {
                throw new IndexOutOfBoundsException();
            } else {
                node.next = node.next.next;
            }
        } else {
            throw new  IndexOutOfBoundsException();
        }
    }

    public void deleteNode2(SingleListNode node) {
        if (node == null) {
            throw new NullPointerException();
        }

        if (node == head) {
            head = head.next;
            return;
        }

        // when node is not the last node
        if (node.next != null) {
            node.val = node.next.val;
            node.next = node.next.next;
        } else {
            // Find the last 2th node
            SingleListNode node1 = head;
            while (node1.next.next != null) {
                node1 = node1.next;
            }
            node1.next = node1.next.next;
        }
    }


  // Modify

    // modify list[n]
    public void modifyN(int n, int val) {
        if (this.head == null) {
            throw new NullPointerException();
        }

        if (n < 0) {
            throw new IllegalArgumentException();
        }

        int i = 0;
        SingleListNode node = this.head;
        while (node.next != null && i < n) {
            node = node.next;
            i++;
        }
        if (i == n) {
            node.setVal(val);
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

  // Get

    // n is index [5]
    public int getNode(int n) {
        if (n < 0 || head == null){
            throw new IndexOutOfBoundsException();
        }

        SingleListNode node = head;

        // When while(a < b) is over, a == b

        // The n-th element when caculator above node = node.next , i ==> node, every circulation node is ahead of i for a unit.

        // This way is convinient for traversing.
//        1 2 3 4 5
//        1 2 3 4 5
//        int i = 0;
//        while (node != null && i < n) {
//            i++;
//            node = node.next;
//        }

        // The [n] element when caculator below node = node.next , j ==> node.next, every circulation node corresponds with j.
//        1 2 3 4 5
//        0 1 2 3 4

        int j = 0;
        while (node.next != null && j < n) {
            node = node.next;
            j++;
        }

        // j corresponds with node, when while() is finished, current node can't be null
        if (j != n) {
            throw new IndexOutOfBoundsException();
        } else {
            return node.getVal();
        }

    }

  // Traverse Single link list
    public void displayValues() {
        System.out.println("The current state of SingleLinkList : ");
        SingleListNode node = this.head;
        while (node != null) {
            System.out.print(node.getVal()+" ");
            node = node.next;
        }
        System.out.println();
    }

    public void displayValues(String des) {
        System.out.println(des + " The current state of SingleLinkList : ");
        SingleListNode node = this.head;
        while (node != null) {
            System.out.print(node.getVal()+" ");
            node = node.next;
        }
        System.out.println();
    }



    public void makeSingleList() {

    }

    public void testFunctions() {
        displayValues();

        addHead(1);
        displayValues("After addHead(1)");

        addAfterN(1, 10);
        displayValues("After addAfterN(1, 10)");

        addBeforeN(1, 8);
        displayValues("After addBeforeN(1, 8)");

        addTail(67);
        displayValues("After addTail(67)");

        addTail(85);
        displayValues("After addTail(85)");

        deleteN(1);
        displayValues("After deleteN(1)");

        deleteNode(this.head.next.next);
        displayValues("After deleteNode(head.next.next)");

        modifyN(2, 100);
        displayValues("After modifyN(2, 100)");

        System.out.println("Get value of List[2] : " + getNode(2));

    }

    public static void main(String[] args) {
        _6_1_LinkList_Single list = new _6_1_LinkList_Single(0);
        list.testFunctions();

        int i =0;
        SingleListNode node = list.head;
        System.out.println(i + "  :  " + node.val);
        while (node.next != null && i < 4) {
            node = node.next;
            i++;
            System.out.println(i + "  :  " + node.val);
        }

        int j = 0;
        SingleListNode node1 = list.head;
        System.out.println(j + "  :  " + node1.val);
        while (node1 != null && j < 4) {
            node1 = node1.next;
            j++;
            System.out.println(j + "  :  " + node1.val);
        }


//        if (list.head == null)
//            System.out.println("null");
//        else
//            System.out.println("not null");
    }

}

// The Core of LinkList is the traverse method, and the critical ways to traverse list are these:

/*
  (1) for given n
    int i = 0;
    LinkNode node = head;

    while(node.next != null && i < n) {
        node = node.next;
        i++;
    }

    if (i == n){
        ...
    } else {
        exception();
    }

  (2) for all
    LinkNode node = head;
    while(node != null) {
        node = node.next;
    }
 */