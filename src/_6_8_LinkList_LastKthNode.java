/**
 * Created by ua28 on 2/11/20.
 */
public class _6_8_LinkList_LastKthNode {

    private _6_1_LinkList_Single list = new _6_1_LinkList_Single(0);

    // Two Traverses O(n)
    public SingleListNode getLastKthNode_twoTraverse(int k) {
        if (list.head == null) {
            throw new NullPointerException();
        }

        if (k <= 0) {
            throw new IllegalArgumentException();
        }

        int len = 1;
        SingleListNode node = list.head;
        while (node.next != null) {
            len++;
            node = node.next;
        }

        int i = 1;
        SingleListNode node1 = list.head;
        while (node1.next != null && i < len-k+1) {
            node1 = node1.next;
            i++;
        }
        return node1;
    }

    // Two Pointers O(n)
    public SingleListNode getLastKthNode_doublePointer(int k) {
        if (list.head == null) {
            throw new NullPointerException();
        }

        if (k <= 0) {
            throw new IllegalArgumentException();
        }

        SingleListNode node1 = list.head;
        SingleListNode node2 = list.head;

        for (int i = 0; i < k-1; i++) {
            if (node1.next != null)
                node1 = node1.next;
            else
                throw new IndexOutOfBoundsException();
        }

        while (node1.next != null) {
            node1 = node1.next;
            node2 = node2.next;
        }
        return node2;
    }

    public void test() {
        list.makeSingleList();
        list.displayValues();
        System.out.println(getLastKthNode_doublePointer(11).getVal());
        System.out.println(getLastKthNode_twoTraverse(11).getVal());
    }

    public static void main(String[] args) {
        _6_8_LinkList_LastKthNode llk = new _6_8_LinkList_LastKthNode();
        llk.test();
    }
}
