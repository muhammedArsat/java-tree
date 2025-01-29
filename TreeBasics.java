public class TreeBasics {

    public static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int val){
            this.data = val;
            this.left = null;
            this.right = null;
        }
    }
    public static TreeNode getTree(){

        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);

        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);

        treeNode.right.left = new TreeNode(6);
        treeNode.right.right = new TreeNode(7);

        return treeNode;
    }
    public static void preOrderTraversal(TreeNode root){
        if(root == null) return;
        System.out.print(root.data+" ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);

    }
    public static void postOrderTraversal(TreeNode root){
        if(root == null) return;
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.data+" ");
    }
    public static void inOrderTraversal(TreeNode root){
        if(root == null) return;
        inOrderTraversal(root.left);
        System.out.print(root.data+" ");
        inOrderTraversal(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = getTree();
        //PostOrder Traversal (data -> left -> right)
        System.out.print("PreOrder Traversal : ");
        preOrderTraversal(root);
        System.out.println();

        //InOrder Traversal ( left -> data -> right)
        System.out.print("InOrder Traversal : ");
        inOrderTraversal(root);
        System.out.println();

        //PostOrder Traversal ( left -> right ->data)
        System.out.print("PostOrder Traversal : ");
        postOrderTraversal(root);

    }
}
