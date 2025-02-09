public class AVlTree{


    class Node{
        int val, height;
        Node left, right;

        Node(int val){
            this.val = val;
            this.height = 0;
        }
    }

private Node root;
    void insert(int val){
        root =insert(root, val);
    }

    Node insert(Node root, int val){

        if(root == null) return new Node(val);
        if(val < root.val){
            root.left = insert(root.left, val);
        }
        else if(val > root.val){
            root .right= insert(root.right, val);
        }
        else{
            return root;
        }

        root.height = findHeight(root);
        int balance = getBalance(root);

        if(balance < -1 && val > root.right.val){
            return leftRotate(root);
        }
        else if(balance > 1 && val < root.left.val) {
            return rightRotate(root);
        }
        else if(balance < -1 && val <   root.right.val){
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }
        else if(balance > 1 && val > root.left.val){
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        return root;
    }


    int findHeight(Node root){
        if(root == null) return 0;
        return root.height;
    }

    int getBalance(Node root){
        if(root == null) return 0;
        return findHeight(root.left) - findHeight(root.right);
    }


    Node leftRotate(Node x){

        Node y = x.right;
        Node t1 = y.left;
        y.left = x;
        x.right = t1;

        x.height = Math.max(findHeight(x.left) ,  findHeight(x.right)) + 1;
        y.height = Math.max(findHeight(y.left), findHeight(y.right))+1;

        return y;

    }

    Node rightRotate(Node x){

        Node y = x.left;
        Node t1 = y.right;
            y .right = x;
            x.left = t1;
            x.height = Math.max(findHeight(x.left) ,  findHeight(x.right)) + 1;
            y.height = Math.max(findHeight(y.left), findHeight(y.right))+1;
            return y;

    }


    void sort(){
        inOrderTraversal(root);
    }

    void inOrderTraversal(Node root){
        if(root == null) return;
        inOrderTraversal(root.left);
        System.out.print(root.val+" ");
        inOrderTraversal(root.right);
    }



}
