/**
 * Created by ua28 on 2/29/20.
 */
public class _7_3_BinaryTree_NextInorderNode {

    class BinaryTreeNode {
        char val;
        BinaryTreeNode parent;
        BinaryTreeNode left;
        BinaryTreeNode right;

        BinaryTreeNode(char val) {
            this.val = val;
        }
    }

    /**
     *  Three Cases for Next Node
     *  1) if the node has right subtree, then its next node will be the most left node of its right subtree.
     *  2) if the node doesn't have right subtree:
     *          a. if the node is left node of its parent node, then its next node will be its parent node.
     *          b. if the node is right node of its parent node, then walking up the binary tree toward root
     *             until current node is the left node of its parent node, then the parent node will be the
     *             next node.
     * @param node
     * @return
     */
    public BinaryTreeNode nextInorderNode(BinaryTreeNode node) {
        if (node == null)
            return null;

        BinaryTreeNode nextnode = null;

        if (node.right != null) {
            BinaryTreeNode tnode = node.right;
            while (tnode.left != null) {
                tnode = tnode.left;
            }
            nextnode = tnode;
        } else {
            if (node.parent.left == node) {
                nextnode = node.parent;
            } else if (node.parent.right == node) {
                BinaryTreeNode tnode = node.parent;
                while (tnode != tnode.parent.left) {
                    tnode = tnode.parent;
                }
                nextnode = tnode;
            }
        }

        return nextnode;
    }

    public BinaryTreeNode buildTree() {
        BinaryTreeNode root = new BinaryTreeNode('a');
        BinaryTreeNode nodeb = new BinaryTreeNode('b');
        BinaryTreeNode nodec = new BinaryTreeNode('c');
        BinaryTreeNode noded = new BinaryTreeNode('d');
        BinaryTreeNode nodee = new BinaryTreeNode('e');;
        BinaryTreeNode nodef = new BinaryTreeNode('f');
        BinaryTreeNode nodeg = new BinaryTreeNode('g');
        BinaryTreeNode nodeh = new BinaryTreeNode('h');
        BinaryTreeNode nodei = new BinaryTreeNode('i');

        root.left = nodeb;
        root.right = nodec;
        nodeb.left = noded;
        nodeb.right = nodee;
        nodee.left = nodeh;
        nodee.right = nodei;
        nodec.left = nodef;
        nodec.right = nodeg;

        nodeh.parent = nodee;
        nodei.parent = nodee;
        noded.parent = nodeb;
        nodee.parent = nodeb;
        nodeb.parent = root;

        nodef.parent = nodec;
        nodeg.parent = nodec;
        nodec.parent = root;

        return nodeh;
    }
    
    public void test() {
        System.out.println(nextInorderNode(buildTree()).val);
    }

    public static void main(String[] args) {
        new _7_3_BinaryTree_NextInorderNode().test();
    }
}
