import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by ua28 on 2/15/20.
 */
public class _7_1_BinaryTree {

    public class BinaryTreeNode {
        int val;
        BinaryTreeNode left, right;
        BinaryTreeNode(int val) {
            this.val = val;
        }
    }

    private void preorderTraverse(BinaryTreeNode root) {
        if (root == null) {
            return;
        }

        System.out.print(root.val + " ");
        preorderTraverse(root.left);
        preorderTraverse(root.right);
    }

    private void inorderTraverse(BinaryTreeNode root) {
        if (root == null) {
            return;
        }

        inorderTraverse(root.left);
        System.out.print(root.val + " ");
        inorderTraverse(root.right);
    }


    private void postorderTraverse(BinaryTreeNode root) {
        if (root == null) {
            return;
        }

        postorderTraverse(root.left);
        postorderTraverse(root.right);
        System.out.print(root.val + " ");
    }

    private void preorderTraverse(BinaryTreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        list.add(root.val);
        preorderTraverse(root.left, list);
        preorderTraverse(root.right, list);
    }

    private void inorderTraverse(BinaryTreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        inorderTraverse(root.left, list);
        list.add(root.val);
        inorderTraverse(root.right, list);
    }


    private void postorderTraverse(BinaryTreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        postorderTraverse(root.left);
        postorderTraverse(root.right);
        list.add(root.val);
    }

    private List<Integer> preorderTraverse_Nonrec(BinaryTreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Stack<BinaryTreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            BinaryTreeNode node = stack.pop();
            result.add(node.val);

            if (node.right!=null)
                stack.push(node.right);
            if (node.left!=null)
                stack.push(node.left);
        }
        return result;
    }

    private List<Integer> inorderTraverse_Nonrec(BinaryTreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Stack<BinaryTreeNode> stack = new Stack<>();
        BinaryTreeNode cur = root;
        // 当前节点和栈不会同时为空
        while(cur!=null || !stack.empty()) {
            // 左
            while(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            // 中
            cur = stack.pop();
            result.add(cur.val);

            // 右
            cur = cur.right;
        }

        return result;
    }

    /**
     * get the number of nodes in this tree
     * @param root
     * @return
     */
    public int getNodesNum(BinaryTreeNode root) {
        if (root == null)
            return 0;

        int left = getNodesNum(root.left);
        int right = getNodesNum(root.right);

        return left+right+1;
    }


    public void test() {
        BinaryTreeNode node1 = new BinaryTreeNode(1);
        BinaryTreeNode node2 = new BinaryTreeNode(2);
        BinaryTreeNode node3 = new BinaryTreeNode(3);
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node5 = new BinaryTreeNode(5);

        node1.right = node2;
        node2.left = node3;

        node3.left = node4;
        node4.left = node5;

        System.out.print("preorder_rec : ");
        preorderTraverse(node1);
        System.out.println();
        System.out.println("inorder_rec : ");
        inorderTraverse(node1);
        System.out.println();
        System.out.println("postorder_rec : ");
        postorderTraverse(node1);
        System.out.println();

        System.out.println("preorder_return");
        List<Integer> list = new ArrayList<>();
        preorderTraverse(node1, list);
        for (int i = 0; i < list.size(); i++)
            System.out.print(list.get(i) + " ");
        System.out.println();

        System.out.println("inorder_Nonrec");
        List<Integer> list_in = inorderTraverse_Nonrec(node1);
        for (int i : list_in)
            System.out.print(i + " ");
        System.out.println();

        System.out.println("preorder_Nonrec");
        List<Integer> list1 = preorderTraverse_Nonrec(node1);
        for (int i : list1)
            System.out.print(i+" ");
        System.out.println();

        System.out.println("There are "+getNodesNum(node1)+" nodes in this tree.");
    }


    public static void main(String[] args) {
        _7_1_BinaryTree bt = new _7_1_BinaryTree();
        bt.test();
    }
}
