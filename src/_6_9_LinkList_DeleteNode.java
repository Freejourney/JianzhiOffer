/**
 * Created by ua28 on 2/11/20.
 */
public class _6_9_LinkList_DeleteNode {

    private  _6_1_LinkList_Single list = new _6_1_LinkList_Single(0);

    // (1) Sequence Search o(n)
    public void deleteNode_Seq(SingleListNode node) {
        if (list.head == null || node == null) {
            throw new NullPointerException();
        }

        if (list.head == node) {
            list.head = node.next;
        }

        SingleListNode node1 = list.head;
        while (node1.next != null) {
            if (node1.next == node) {
                node1.next = node.next;
                return;
            }
            node1 = node1.next;
        }
    }

    // (2) Direct Replace O(1)
    public void deleteNode_Replace(SingleListNode node) {
        if (list.head == null || node == null) {
            throw new NullPointerException();
        }

        if (node == list.head) {
            list.head = node.next;
        }

        if (node.next != null) {
            node.val = node.next.val;
            node.next = node.next.next;
        } else {
            deleteNode_Seq(node);
        }
    }

    public void test() {
        list.makeSingleList();
        list.displayValues();
        deleteNode_Seq(list.getNthNode(3));
        list.displayValues();
        deleteNode_Seq(list.getNthNode(5));
        list.displayValues();
    }

    public static void main(String[] args) {
        _6_9_LinkList_DeleteNode ldn = new _6_9_LinkList_DeleteNode();
        ldn.test();
    }
}
