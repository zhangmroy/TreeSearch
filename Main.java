import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        List<Integer> treeNodes = new LinkedList<Integer>();
        treeNodes.add(1);
        treeNodes.add(2);
        treeNodes.add(3);
        treeNodes.add(4);
        treeNodes.add(5);
        treeNodes.add(6);
        treeNodes.add(7);
        TreeNode root = buildTree(treeNodes);
        dfsScanTree(root);
        System.out.println();
        bfsScanTree(root);
        System.out.println();
        fScan(root);
        System.out.println();
        mScan(root);
        System.out.println();
        lScan(root);
    }

    public static TreeNode buildTree(List<Integer> list){
        if (list.size() == 0)return null;

        Iterator<Integer> it = list.iterator();
        Queue<TreeNode> quque = new LinkedList<TreeNode>();
        TreeNode root = new TreeNode(it.next());

        //add root into the queue
        quque.offer(root);

        //build the tree
        boolean itEmpty = false;
        while (it.hasNext()){
            Queue<TreeNode> tempQueue = new LinkedList<TreeNode>();
            while (!quque.isEmpty()){
                Integer integer = it.next();
                TreeNode treeNode = quque.poll();
                if (treeNode==null)break;
                treeNode.lChild = integer!=null?new TreeNode(integer):null;
                tempQueue.offer(treeNode.lChild);
                if (!it.hasNext())break;
                integer = it.next();
                treeNode.rChild = integer!=null?new TreeNode(integer):null;
                tempQueue.offer(treeNode.rChild);
            }
            quque = tempQueue;
        }
        return root;
    }

    public static void dfsScanTree(TreeNode root){
        if (root == null)return;
        System.out.println(root.val);
        if (root.lChild != null)dfsScanTree(root.lChild);
        if (root.rChild != null)dfsScanTree(root.rChild);
    }

    public static void bfsScanTree(TreeNode root){
        if (root == null)return;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while (!queue.isEmpty()){
            Queue<TreeNode> tQueue = new LinkedList<TreeNode>();
            while (!queue.isEmpty()){
                TreeNode temp = queue.poll();
                System.out.println(temp.val);
                if (temp.lChild != null)tQueue.offer(temp.lChild);
                if (temp.rChild != null)tQueue.offer(temp.rChild);
            }
            queue = tQueue;
        }
    }

    public static void fScan(TreeNode root){
        if (root == null)return;

        System.out.println(root.val);

        if (root.lChild != null)fScan(root.lChild);
        if (root.rChild != null)fScan(root.rChild);
    }

    public static void mScan(TreeNode root){
        if (root == null)return;

        if (root.lChild != null)mScan(root.lChild);
        System.out.println(root.val);
        if (root.rChild != null)mScan(root.rChild);
    }

    public static void lScan(TreeNode root){
        if (root == null)return;

        if (root.lChild != null)lScan(root.lChild);
        if (root.rChild != null)lScan(root.rChild);

        System.out.println(root.val);
    }
}
