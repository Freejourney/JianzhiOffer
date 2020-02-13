import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Created by ua28 on 2/11/20.
 */
public class _6_3_LinkList_TheFirstPublicNodeOfTwoLists {

    private _6_1_LinkList_Single list1 = new _6_1_LinkList_Single(0);
    private _6_1_LinkList_Single list2 = new _6_1_LinkList_Single(7);
    private _6_1_LinkList_Single commlist = new _6_1_LinkList_Single(11);

    // Set save nodes, space O(n), time O(n)
    public SingleListNode getTheFirstPublicNode_hashMap() {
        if (list1.head == null || list2.head == null){
            throw new NullPointerException();
        }

        Set<SingleListNode> set = new HashSet<>();
        SingleListNode node = list1.head;
        while (node!=null) {
            set.add(node);
            node = node.next;
        }

        SingleListNode node1 = list2.head;
        while (node1!=null) {
            if (set.contains(node1)) {
                return node1;
            }
            node1 = node1.next;
        }
        return null;
    }

    // Stack, search from back to front
    public SingleListNode getTheFirstPublicNode_stack() {
        if (list1.head == null || list2.head == null) {
            throw new NullPointerException();
        }

        Stack<SingleListNode> stack1 = new Stack<>();
        Stack<SingleListNode> stack2 = new Stack<>();

        SingleListNode node1 = list1.head;
        while (node1 != null) {
            stack1.push(node1);
            node1 = node1.next;
        }

        SingleListNode node2 = list2.head;
        while (node2 != null) {
            stack2.push(node2);
            node2 = node2.next;
        }

        SingleListNode tmp1 = stack1.pop();
        SingleListNode tmp2 = stack2.pop();
        SingleListNode result = tmp1;
        while (tmp1 == tmp2) {
            result = tmp1;
            tmp1 = stack1.pop();
            tmp2 = stack2.pop();
        }

        return result;
    }

    // Calculate len , search from front to back
    public SingleListNode getTheFisrtPublicNodeOfTwoLists() {
        if (list1 == null || list2 == null) {
            throw new NullPointerException();
        }

        int len1 = 1;
        SingleListNode node1 = list1.head;
        while (node1.next != null) {
            node1 = node1.next;
            len1++;
        }

        int len2 = 1;
        SingleListNode node2 = list2.head;
        while (node2.next != null) {
            node2 = node2.next;
            len2++;
        }

        node1 = list1.head;
        node2 = list2.head;

        if (len1 > len2) {
            int cut = len1 - len2;
            for (int i = 0; i < cut; i++) {
                node1 = node1.next;
            }
        } else {
            int cut = len2 - len1;
            for (int i = 0; i < cut; i++) {
                node2 = node2.next;
            }
        }

        while (node1 != node2) {
            node1 = node1.next;
            node2 = node2.next;
        }
        return node1;
    }

    public void test() {
        list1.makeSingleList(7);
        list2.makeSingleList(9);
        commlist.makeSingleList(4);
        list1.getNthNode(8).next = commlist.head;
        list2.getNthNode(10).next = commlist.head;
        list1.displayValues();
        list2.displayValues();
        System.out.println(getTheFirstPublicNode_hashMap().getVal());
        System.out.println(getTheFirstPublicNode_stack().getVal());
        System.out.println(getTheFisrtPublicNodeOfTwoLists().getVal());
    }

    public static void main(String[] args) {
        _6_3_LinkList_TheFirstPublicNodeOfTwoLists ltfpnot = new _6_3_LinkList_TheFirstPublicNodeOfTwoLists();
        ltfpnot.test();
    }
}
