import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by ua28 on 3/12/20.
 */
public class _7_17_BinaryTree_CommonParentNode {

    public class BinaryNode {
        char val;
        BinaryNode left;
        BinaryNode right;

        BinaryNode(char val) {
            this.val = val;
        }
    }

    /**
     * find nodes in leftTree and rightTree respectively
     * if both leftTree and rightTree don't have given nodes, it means
     * the current root node is the common node, then return the root.
     * if given nodes are in leftTree or rightTree, then we find them
     * in leftTree or rightTree
     * @param node1
     * @param node2
     * @param root
     * @return
     */
    public BinaryNode findCommonParentNode(BinaryNode node1, BinaryNode node2, BinaryNode root) {
        if (root == null)
            return null;

        boolean inLeftSubTree = hasNodes(node1, node2, root.left);
        boolean inRightSubTree = hasNodes(node1, node2, root.right);

        if (!inLeftSubTree && !inRightSubTree)
            return root;

        if (inLeftSubTree)
            return findCommonParentNode(node1, node2, root.left);
        else
            return findCommonParentNode(node1, node2, root.right);
    }

    /**
     * This is a level-sequence Traverse to find node1 and node2 in the given tree
     * @param node1
     * @param node2
     * @param root
     * @return
     */
    private boolean hasNodes(BinaryNode node1, BinaryNode node2, BinaryNode root) {
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);

        boolean hasNode1 = false;
        boolean hasNode2 = false;

        while (!queue.isEmpty()) {
            BinaryNode node = queue.remove();

            // mark node1 and node2
            if (node == node1)
                hasNode1 = true;
            else if (node == node2)
                hasNode2 = true;

            // given tree has node1 and node2
            if (hasNode1 && hasNode2)
                return true;

            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);
        }
        return false;
    }


    public List<BinaryNode> buildTree() {
        BinaryNode nodeA = new BinaryNode('A');
        BinaryNode nodeB = new BinaryNode('B');
        BinaryNode nodeC = new BinaryNode('C');
        BinaryNode nodeD = new BinaryNode('D');
        BinaryNode nodeE = new BinaryNode('E');
        BinaryNode nodeF = new BinaryNode('F');
        BinaryNode nodeG = new BinaryNode('G');
        BinaryNode nodeH = new BinaryNode('H');
        BinaryNode nodeI = new BinaryNode('I');

        nodeA.left = nodeB;
        nodeA.right = nodeC;

        nodeB.left = nodeD;
        nodeB.right = nodeE;

        nodeD.left = nodeF;
        nodeD.right = nodeG;

        nodeE.left = nodeH;
        nodeE.right = nodeI;

        List<BinaryNode> list = new ArrayList<>();
        list.add(nodeA);
        list.add(nodeF);
        list.add(nodeH);

        return list;
    }


    public void test() {
        List<BinaryNode> list = buildTree();
        System.out.println(findCommonParentNode(list.get(1), list.get(2), list.get(0)).val);
    }

    public static void main(String[] args) {
        new _7_17_BinaryTree_CommonParentNode().test();
    }
}
