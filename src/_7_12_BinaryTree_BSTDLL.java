import java.util.ArrayList;
import java.util.List;

/**
 * Created by ua28 on 3/9/20.
 */
public class _7_12_BinaryTree_BSTDLL implements TreeTest{

    private List<BinaryTreeNode> nodes = new ArrayList<>();

    public BinaryTreeNode Convert(BinaryTreeNode root) {
        BinaryTreeNode lastNode = new BinaryTreeNode(0);
        ConvertNode(root, lastNode);

        BinaryTreeNode tnode = lastNode;
        while (tnode.left != null)
            tnode = tnode.left;

        return tnode;
    }

    private void ConvertNode(BinaryTreeNode root, BinaryTreeNode lastNode) {
        if (root == null)
            return;

        ConvertNode(root.left, lastNode);

        BinaryTreeNode currentNode = root;
        currentNode.left = lastNode;
        lastNode.right = currentNode;
        lastNode = currentNode;
        nodes.add(lastNode);

        ConvertNode(root.right, lastNode);
    }

    /**
     * Inorder Traverse + List Traverse
     * @param root
     * @return
     */
    public BinaryTreeNode transferBSTtoDLL(BinaryTreeNode root) {
        if (root == null)
            return null;

        List<BinaryTreeNode> list = new ArrayList<>();
        transferBSTtoDLL(root, list);

        for (int i = 0; i < list.size()-1; i++) {
            list.get(i).right = list.get(i+1);
            list.get(i+1).left = list.get(i);
        }

        list.get(0).left = null;
        list.get(list.size()-1).right = null;

        return list.get(0);
    }

    private void transferBSTtoDLL(BinaryTreeNode node, List<BinaryTreeNode> list) {
        if (node == null)
            return;

        transferBSTtoDLL(node.left, list);
        list.add(node);
        transferBSTtoDLL(node.right, list);
    }

    @Override
    public BinaryTreeNode buildTree() {
        BinaryTreeNode root = new BinaryTreeNode(10);
        BinaryTreeNode node6 = new BinaryTreeNode(6);
        BinaryTreeNode node14 = new BinaryTreeNode(14);
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node8 = new BinaryTreeNode(8);
        BinaryTreeNode node12 = new BinaryTreeNode(12);
        BinaryTreeNode node16 = new BinaryTreeNode(16);

        root.left = node6;
        root.right = node14;
        node6.left = node4;
        node6.right = node8;
        node14.left = node12;
        node14.right = node16;

        return root;
    }

    @Override
    public void test() {
        BinaryTreeNode node = transferBSTtoDLL(buildTree());
        BinaryTreeNode cur = node;
        while (cur != null) {
            System.out.print(cur.val+" ");
            cur = cur.right;
        }
        System.out.println();

        BinaryTreeNode tnode = Convert(buildTree());
        cur = tnode;
        while (cur != null) {
            System.out.print(cur.val+" ");
            cur = cur.right;
        }
    }

    public static void main(String[] args) {
        new _7_12_BinaryTree_BSTDLL().test();
    }
}
