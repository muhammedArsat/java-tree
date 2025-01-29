import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {

    private static class TreeNode{

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int value){
            this.val = value;
            this.left = null;
            this.right = null;
        }


    }
    TreeNode root;
    BinarySearchTree(int value){
        this.root = new TreeNode(value);
    }

    public void insert(int val){
      root = insertRec(root, val);

    }
    public TreeNode insertRec(TreeNode root, int val){
        TreeNode newNode = new TreeNode(val);

        if(root == null ){
            root = newNode;
            return root;
        }
        if(val < root.val){
           root.left =  insertRec(root.left, val);
        }else{
            root.right = insertRec(root.right, val);
        }
        return root;
    }

    public void traversal(){
        System.out.println("In Ascending Order: ");
        inOrderTraversal(root);

    }
    public void inOrderTraversal(TreeNode root){
        if(root == null) return;
        inOrderTraversal(root.left);
        System.out.print(root.val+" ");
        inOrderTraversal(root.right);
    }


    public void search(int val){

        boolean isPresented = isNodeExist(root, val);
        System.out.println(isPresented);
    }

    public boolean isNodeExist(TreeNode root, int val){

        if(root == null) return false;
        if(val < root.val)
            return isNodeExist(root.left, val);
        else if(val > root.val)
            return isNodeExist(root.right, val);
        else
            return true;
    }


    public void distance(int p, int q){

        boolean node1 = isNodeExist(root, p);
        boolean node2 = isNodeExist(root, q);

        if(!node1&& !node2){
            System.out.println("Element Not Found");
            return;
        };
        TreeNode ancestor =   leastCommonAncestor(root, p, q);

        int heightOfLeftTree = findHeight(ancestor, p);
        int heightOfRightTree = findHeight(ancestor, q);
        int distance = heightOfRightTree + heightOfLeftTree;
        if(distance >= 0)
        System.out.println("Distance between " + p +  " and "+ q + ":"+(heightOfLeftTree + heightOfRightTree));
        else
        System.out.println("Element Not Found");

    }

    public TreeNode leastCommonAncestor(TreeNode root, int p, int q ){
        if(root == null) return null;

        if(p == root.val || q == root.val) return root;
        TreeNode leftTree = leastCommonAncestor(root.left, p, q);
        TreeNode rightTree = leastCommonAncestor(root.right, p, q);

        if(leftTree != null && rightTree != null) return root;
        else if(leftTree == null) return rightTree;
        else return leftTree;

    }

    public int findHeight(TreeNode root, int val){
        int distance = 0;
        TreeNode current = root;
        while(current != null){
            if(current.val == val) return distance;
            else if (current .val > val) current = current.left;
            else current = current.right;

            distance++;
        }

        return -1;
    }
    public void delete(int val){
       root = deleteNode(root, val);
    }

    public static  TreeNode deleteNode(TreeNode root, int val){
        if(root == null) return null;

        if(val < root.val){
         root.left =    deleteNode(root.left, val);
        }else if(val > root.val){
          root.right=   deleteNode(root.right, val);
        }else{
            if(root.left == null && root.right == null)
            root = null;
            else if(root.left == null ){
                root = root.right;
            }else if(root.right ==null)
            {
                root = root.left;
            }
            else{
                root.val = minRight( root.right);
                root.right = deleteNode(root.right, root.val);
            }
        }
        return root;
    }

    static int minRight(TreeNode root){
        int min =-1;

        while(root != null){
            min = root.val;
            root = root.left;
        }

        return min;
    }


    public void serialize(){
        if(root == null) {
            System.out.println("Empty Tree");
            return;
        }
        Queue <TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        StringBuilder string = new StringBuilder();
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node == null){
                string.append("#$"); continue;
            }
            string.append(Integer.toString(node.val));
            string.append("$");

            queue.offer(node.left);



            queue.offer(node.right);

        }
        string.deleteCharAt(string.length()-1);
        String serialized = string.toString();
        System.out.println(serialized);

    }
    TreeNode head ;
    public void deSerialize(String s) {
        String word[] = s.split("\\$");

        if (word.length == 0 || word[0].equals("#")) {
            root = null;
            return;
        }

        root = new TreeNode(Integer.parseInt(word[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int index = 1;
        while (!queue.isEmpty()) {
            TreeNode parent = queue.poll();

            if (index < word.length && !word[index].equals("#")) {
                parent.left = new TreeNode(Integer.parseInt(word[index]));
                queue.offer(parent.left);
            }
            index++;

            if (index < word.length && !word[index].equals("#")) {
                parent.right = new TreeNode(Integer.parseInt(word[index]));
                queue.offer(parent.right);
            }
            index++;
        }
    }

public void levelOrderTraversal(){
    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);

    while(!q.isEmpty()){
        TreeNode node = q.poll();
        System.out.print(node.val +" ");
        if(node.left != null) q.offer(node.left);
        if(node.right != null) q.offer(node.right);

    }
}




     }
