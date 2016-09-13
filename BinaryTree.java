import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
    TreeNode root;

    private static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val){
            this.val = val;
        }
    }

    public BinaryTree(int []array){
        root=buildTree(array,1);
    }


    /**
     * 采用递归的方式创建一颗二叉树
     * 传入的是二叉树的数组表示法
     * 构造后是二叉树的二叉链表表示法
     */
    public static TreeNode buildTree(int[] array,int index){
        if(index<array.length){
            int value=array[index];
            if(value!=0){
                TreeNode t=new TreeNode(value);
                array[index]=0;
                t.left=buildTree(array,index*2);
                t.right=buildTree(array,index*2+1);
                return t;
            }
        }
        return null;
    }

    /*
    * 深度优先遍历：栈
    * */
    public void depthFirstSearch(){
        if (root == null)return;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        while (!stack.empty()){
            TreeNode treeNode = stack.pop();

            //print this node
            System.out.print(treeNode.val+",");

            //search
            if (treeNode.left!=null)stack.push(treeNode.left);
            if (treeNode.right!=null)stack.push(treeNode.right);
        }
        System.out.println();
    }

    /*
    * 层次遍历:队列
    * */
    public void levelFirstSearch(){
        if (root == null)return;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while (!queue.isEmpty()){
            TreeNode treenode = queue.poll();

            //print this node
            System.out.print(treenode.val+",");

            //search
            if (treenode.left!=null)queue.offer(treenode.left);
            if (treenode.right!=null)queue.offer(treenode.right);
        }
        System.out.println();
    }


    public static void main(String[] args) {
        System.out.println("Hello World!");
        int[] arr={0,13,65,5,97,25,0,37,22,0,4,28,0,0,32,0};
        BinaryTree tree=new BinaryTree(arr);
        tree.depthFirstSearch();
        tree.levelFirstSearch();
    }
}
