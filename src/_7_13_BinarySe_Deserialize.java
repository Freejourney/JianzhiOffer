import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by ua28 on 3/9/20.
 */
public class _7_13_BinarySe_Deserialize implements TreeTest {

    public void Serialize(BinaryTreeNode root, OutputStream outputStream) throws IOException {
        if (root == null) {
            outputStream.write("$,".getBytes());
            return;
        }

        outputStream.write((root.val+"").getBytes());
        outputStream.write(',');

        Serialize(root.left, outputStream);
        Serialize(root.left, outputStream);
    }
    //使用前序遍历序列化二叉树
    String Serialize(BinaryTreeNode root) {
        StringBuffer sb=new StringBuffer();
        if(root==null){
            //空节点（#）
            sb.append("#,");
            return sb.toString();
        }
        sb.append(root.val+",");
        sb.append(Serialize(root.left));
        sb.append(Serialize(root.right));
        return sb.toString();
    }
    //反序列化：根据某种遍历方式得到的序列化字符串结果，重构二叉树
    int index=-1;
    BinaryTreeNode Deserialize(String str) {
        index++;
        int len=str.length();
        if(index>=len) return null;
        //以逗号分隔，返回一个字符串数组
        String[] str1=str.split(",");
        BinaryTreeNode node=null;
        //遍历str1数组，重构二叉树：当前遍历元素非 # 则作为一个结点插入树中，作为上一个结点的左儿子；
        //当前遍历元素为 # 则表示此子树已结束，遍历下一个元素作为上一个结点的右孩子
        //即遍历到数字作为上一个结点的左孩子，遇到#变向作为上一个结点的右孩子
        if(!str1[index].equals("#")){
            node=new BinaryTreeNode(Integer.valueOf(str1[index]));
            node.left=Deserialize(str);
            node.right=Deserialize(str);
        }
        return node;
    }
    
    @Override
    public BinaryTreeNode buildTree() {
        BinaryTreeNode root = new BinaryTreeNode(1);
        BinaryTreeNode node2 = new BinaryTreeNode(2);
        BinaryTreeNode node3 = new BinaryTreeNode(3);
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node5 = new BinaryTreeNode(5);
        BinaryTreeNode node6 = new BinaryTreeNode(6);

        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node3.left = node5;
        node3.right = node6;

        return root;
    }

    @Override
    public void test() throws IOException {

        System.out.println(Serialize(buildTree()));

    }

    public static void main(String[] args) throws IOException {
        new _7_13_BinarySe_Deserialize().test();
    }
}
