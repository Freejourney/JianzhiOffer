/**
 * Created by ua28 on 2/11/20.
 */
public class _6_5_LinkList_JoinTwoLists {
    _6_1_LinkList_Single list1 = new _6_1_LinkList_Single(0);
    _6_1_LinkList_Single list2 = new _6_1_LinkList_Single(0);

    public SingleListNode joinTwoLists() {
        if (list1.head == null && list2.head == null) {
            throw new NullPointerException();
        }

        if (list1.head == null) {
            return list2.head;
        }

        if (list2.head == null) {
            return list1.head;
        }

        SingleListNode nnode = new SingleListNode(-1);
        SingleListNode nnodeHead = nnode;
        SingleListNode node1 = list1.head;
        SingleListNode node2 = list2.head;

        // If we use node.next to judge and we get the last element of list1 , the selected element may not be list1
        while (node1 != null && node2 != null) {
            if (node1.val < node2.val) {
                nnode.next = node1;
                node1 = node1.next;
            } else {
                nnode.next = node2;
                node2 = node2.next;
            }
            nnode = nnode.next;
        }

        if (node1 != null) {
            nnode.next = node1;
        } else {
            nnode.next = node2;
        }

        return nnodeHead.next;
    }

    public void test() {
        list1.makeSingleList();
        list2.makeSingleList(15);
        SingleListNode node = joinTwoLists();
        System.out.print(node.getVal()+" ");
        while (node.next != null) {
            node = node.next;
            System.out.print(node.getVal()+" ");
        }
    }

    public static void main(String[] args) {
        _6_5_LinkList_JoinTwoLists ljt = new _6_5_LinkList_JoinTwoLists();
        ljt.test();
    }
}
