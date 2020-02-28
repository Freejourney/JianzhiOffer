import java.util.HashMap;

/**
 * Created by ua28 on 2/11/20.
 */
public class _6_4_LinkList_CopyComplicatedList {

    class ComplexListNode {
        int val;
        ComplexListNode next;
        ComplexListNode sibling;
        ComplexListNode(int val) {
            this.val = val;
        }
    }

    public ComplexListNode buildList() {
        ComplexListNode node1 = new ComplexListNode(1);
        ComplexListNode node2 = new ComplexListNode(2);
        ComplexListNode node3 = new ComplexListNode(3);
        ComplexListNode node4 = new ComplexListNode(4);
        ComplexListNode node5 = new ComplexListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        node1.sibling = node3;
        node2.sibling = node5;
        node4.sibling = node2;

        return node1;
    }

    public void test() {
        ComplexListNode list = buildList();
        showComList(list);

        System.out.println("\nUse Direct Traverse to Copy: ");
        ComplexListNode directCopyedList = directCopy(list);
        showComList(directCopyedList);

        System.out.println("\nUse HashMap to Copy: ");
        ComplexListNode hashCopyedList = hashMapCopy(list);
        showComList(hashCopyedList);
    }

    /**
     *  Space Complex Degree : O(n)(hashmap)     Time Complex Degree : O(n)
     *  Use HashMap to Copy ComplexList
     *      1. Traverse next pointers to organize basic structure
     *          a) use a hashmap to save one to one pairs of original and new node
     *      2. Traverse next pointers and use hashmap.get() to obtain corresponding sibling
     *                                                  node(original sibling node linked the new copy node)
     * @param head
     * @return
     */
    public ComplexListNode hashMapCopy(ComplexListNode head) {
        if (head == null)
            return null;

        ComplexListNode node = head;
        ComplexListNode coNode = new ComplexListNode(node.val);
        ComplexListNode coHead = coNode;

        // save corresponding nodes to hashmap
        HashMap<ComplexListNode, ComplexListNode> map = new HashMap<>();
        map.put(node, coNode);
        while (node.next != null) {
            // generate basic structure
            coNode.next = new ComplexListNode(node.next.val);
            node = node.next;
            coNode = coNode.next;
            map.put(node, coNode);
        }

        // traverse again and set siblings
        node = head;
        coNode = coHead;
        while (node != null) {
            if (node.sibling != null) {
                coNode.sibling = map.get(node.sibling);
            }
            node = node.next;
            coNode = coNode.next;
        }

        return coHead;
    }

    /**
     * Space Complex Degree : O(1)     Time Complex Degree : O(n^2)
     * Direct Traverse to Copy Original List
     * Traverse 2 pointers to copy nodes:
     *              (1) Traverse next pointer to copy and link every node
     *              (2) Traverse next pointer and judge sibling pointer to link sibling pointers
     *                   a. If current node has sibling object(not null), then re-traverse the list from head to
     *                      target node to get the step length
     *                   b. according to step length traverse new list and find the target node, make node's sibling
     *                      to be this target node
     * @param head
     * @return
     */
    public ComplexListNode directCopy(ComplexListNode head) {
        if (head == null)
            return null;

        // copy next
        ComplexListNode node = head;
        ComplexListNode coNode = new ComplexListNode(head.val);
        ComplexListNode coHead = coNode;
        while (node.next != null) {
            coNode.next = new ComplexListNode(node.next.val);
            node = node.next;
            coNode = coNode.next;
        }

        // copy sibling
        node = head;
        coNode = coHead;
        while (node.next != null) {
            if (node.sibling != null) {
                // caculate the step length from head to its sibling node
                int step = 0;
                ComplexListNode tmp = head;
                while (tmp != null) {
                    tmp = tmp.next;
                    step++;
                    if (tmp == node.sibling)
                        break;
                }

                // move same steps in colist to make coNode's sibling points to relevant node
                ComplexListNode co_tmp = coHead;
                for (int i = 0; i < step; i++) {
                    co_tmp = co_tmp.next;
                }
                coNode.sibling = co_tmp;
            }
            node = node.next;
            coNode = coNode.next;
        }

        return coHead;
    }

    public void showComList(ComplexListNode head) {
        ComplexListNode node = head;
        System.out.print("Next Result: ");
        while (node != null) {
            System.out.print(node.val+"->");
            node = node.next;
        }
        System.out.println();

        node = head;

        System.out.print("Sibling Result: ");
        while (node != null) {
            if (node.sibling != null) {
                System.out.print("["+node.val+"]->["+node.sibling.val+"]"+"  ");
            }
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        new _6_4_LinkList_CopyComplicatedList().test();
    }
}
