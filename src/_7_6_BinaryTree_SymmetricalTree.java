import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ua28 on 3/4/20.
 */
public class _7_6_BinaryTree_SymmetricalTree {

    /**
     * use Queue to conduct "level-Sequence" Traverse, symmetrically add/get corresponding nodes into/from queues.
     * use poll() to remove element of queue, which can avoid exception of removing null elements.
     *
     * Queue add() function can add "null" without any exception
     * @param root
     * @return
     */
    public boolean isSymmetricalTree(BinaryTreeNode root) {
        // null will be considered as false
        if (root == null)
            return false;

        // if there is only root node in the tree, it's symmetrical
        if (root.left == null && root.right == null)
            return true;

        // Two queues to follow each subtree
        Queue<BinaryTreeNode> queue1 = new LinkedList<>();
        Queue<BinaryTreeNode> queue2 = new LinkedList<>();

        // the left node corresponds the right node
        queue1.add(root.left);
        queue2.add(root.right);

        // two queues should have same size in the process of traversing
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            // get corresponding elements to compare
            BinaryTreeNode node1 = queue1.poll();
            BinaryTreeNode node2 = queue2.poll();

            // both of them are null
            if (node1 == null && node2 == null) {

            } // one of them is null
            else if (node1 == null || node2 == null) {
                return false;
            } // none of them is null
            if (node1 != null && node2 != null) {
                // compare value
                if (node1.val != node2.val) {
                    return false;
                }
            }

            // only when node is not null, we can get its sub-nodes(sub-nodes can be null)
            if (node1 != null) {
                queue1.add(node1.left);
                queue1.add(node1.right);
            }

            // only when node is not null, we can get its sub-nodes(sub-nodes can be null)
            if (node2 != null) {
                queue2.add(node2.right);
                queue2.add(node2.left);
            }
        }

        // if they have different sizes, it means they are not symmetrical
        if (!queue1.isEmpty() || !queue2.isEmpty())
            return false;

        return true;
    }

    /**
     * Master and Core to constuct recursive structure.
     * Convey the same tree at the same time to recursively traverse.
     * @param root
     * @return
     */
    public boolean isSymmetrical_Recursive(BinaryTreeNode root) {
        return isSymmetrical_Recursive(root, root);
    }

    /**
     * Only compare two nodes once a time
     * Recursively compare left and right nodes of the root
     * @param roo1
     * @param root2
     * @return
     */
    public boolean isSymmetrical_Recursive(BinaryTreeNode roo1, BinaryTreeNode root2) {
        if (roo1 == null && root2 == null) {
            return true;
        }

        if (roo1 == null || root2 == null) {
            return false;
        }

        if (roo1.val != root2.val) {
            return false;
        }

        return isSymmetrical_Recursive(roo1.left, root2.right) && isSymmetrical_Recursive(roo1.right, root2.left);
    }

    public BinaryTreeNode buildTree() {
        BinaryTreeNode root = new BinaryTreeNode(0);

        BinaryTreeNode node1 = new BinaryTreeNode(1);
        BinaryTreeNode node2 = new BinaryTreeNode(1);

        BinaryTreeNode node3 = new BinaryTreeNode(3);
        BinaryTreeNode node4 = new BinaryTreeNode(3);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node2.right = node4;

        return root;
    }

    public void test() {
        BinaryTreeNode root = buildTree();
        System.out.println(isSymmetricalTree(root));
        System.out.println(isSymmetrical_Recursive(root, root));
    }

    public static void main(String[] args) {
        new _7_6_BinaryTree_SymmetricalTree().test();
    }
}
