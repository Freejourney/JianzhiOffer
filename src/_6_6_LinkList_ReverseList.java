import java.util.ArrayList;
import java.util.List;

/**
 * Created by ua28 on 2/11/20.
 */
public class _6_6_LinkList_ReverseList {

    /**
     *  Space Complex Degree : O(n), Time Complex Degree : O(n)
     *  Copy nodes of list to List and use index to link them reversely
     * @param head
     * @return
     */

    public SingleListNode reverseList_NewList(SingleListNode head) {
        if (head == null)
            return null;

        SingleListNode node = head;

        // Traverse LinkedList and save all nodes into List
        List<SingleListNode> nodelist = new ArrayList<>();
        nodelist.add(new SingleListNode(node.val));
        while (node.next != null) {
            node = node.next;
            nodelist.add(new SingleListNode(node.val));
        }

        for (int i = nodelist.size()-1; i >= 1; i--) {
            nodelist.get(i).next = nodelist.get(i-1);
        }

        return nodelist.get(nodelist.size()-1);
    }

    /**
     * Space Complex Degree : O(1)      Time Complex Degree : O(n)
     * Three pointers save pre-node , cur-node and next node to reverse direction of list
     * @param head
     * @return
     */
    public SingleListNode reverseList_Pointers(SingleListNode head) {
        if (head == null) {
            return null;
        }

        // initial condition
        SingleListNode prenode = null;
        SingleListNode curnode = head;
        while (curnode != null) {
            // save next node
            SingleListNode nextnode = curnode.next;
            // adjust direction
            curnode.next = prenode;

            // iterate
            prenode = curnode;
            curnode = nextnode;
        }

        return prenode;
    }

    /**
     * Space Complex Degree : O(1)      Time Complex Degree : O(n)
     *
     * Constantly moving every node to the head place
     * @param head
     * @return
     */
    public SingleListNode reverseList(SingleListNode head) {
        if (head == null)
            return null;

        SingleListNode node = head;
        while (node.next != null) {
            SingleListNode moved = node.next;
            node.next = moved.next;
            moved.next = head;
            head = moved;

            // Attention since it's a process of constantly moving next node to head, so we
            //      don't need to move current node to next node(next node is changing).
            //
            // "node = node.next" is not needed.
        }

        return head;
    }

    public SingleListNode buildList() {
        SingleListNode node1 = new SingleListNode(1);
        SingleListNode node2 = new SingleListNode(5);
        SingleListNode node3 = new SingleListNode(7);
        SingleListNode node4 = new SingleListNode(2);
        SingleListNode node5 = new SingleListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        return node1;
    }

    public void showList(SingleListNode head) {
        SingleListNode node = head;
        while (node != null) {
            System.out.print(node.getVal() + "->");
            node = node.next;
        }
        System.out.println();
    }

    public void test() {
        SingleListNode list = buildList();
        showList(list);

        showList(reverseList_NewList(list));
        showList(reverseList(list));
        showList(reverseList_Pointers(buildList()));
    }

    public static void main(String[] args) {
        new _6_6_LinkList_ReverseList().test();
    }
}
