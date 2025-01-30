public class AvlTree {

    //Node Class
    class Node{
        int key, height;
        Node left,right;

        Node(int val){
            this.key = val;
            this.height = 1;
        }
    }

//Root Node
    private Node root;


    //Insert Node in AVL Tree
    void  insert(int val){

        root = insert(root,val);
    }
    Node insert(Node root, int val){

        if(root == null) return new Node(val);


        if(val < root.key){
            root.left = insert(root.left, val);
        }
        else if(val  > root.key){
            root.right = insert(root.right, val);
        }
        else{
            return root;
        }

        root.height = 1 + Math.max(findHeight(root.left) , findHeight(root.right));
        int balance = getBalance(root);

        //left left rotate
        if(balance > 1 && val < root.left.key){
            return rightRotate(root);
        }
        // right Rotate
        else if(balance < -1 && val > root.right.key){
            return leftRotate(root);
        }

        //left Right Rotate
        else if(balance > 1 && val > root.left.key){
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        //Right Left Rotate
        else if(balance < -1 && val < root.right.key){
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }
        return root;
    }


    //Finding Height for each SubTree
    int findHeight(Node root){
        if(root == null) return  0;

        return root.height;
    }

    //getting Balance for Each Node
    int getBalance(Node root){
        if(root == null) return 0;
        return findHeight(root.left) - findHeight(root.right);
    }

    //left Rotate
    Node leftRotate(Node root){
        Node y = root.right;
        Node t1 = y.left;
        y.left = root;
        root.right = t1;

        root.height = Math.max(findHeight(root.left), findHeight(root.right))+1;
        y.height = Math.max(findHeight(y.left), findHeight(y.right))+1;
        return y;
    }

//right Rotate
    Node rightRotate(Node root){
        Node y = root.left;
        Node t1 = y.right;
        y.right  = root;
        root.left = t1;
        root.height = Math.max(findHeight(root.left), findHeight(root.right))+1;
        y.height = Math.max(findHeight(y.left), findHeight(y.right))+1;
        return y;
    }


    //InOrderTraversal
    void sort(){
        inOrderTraversal(root);
    }

    void inOrderTraversal(Node root){
        if(root == null) return ;
        inOrderTraversal(root.left);
        System.out.print(root.key+" ");
        inOrderTraversal(root.right);


    }
}
