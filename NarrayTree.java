import java.util.*;
public class NarrayTree {

    private static class TreeNode{
        int val;
        List<TreeNode> children;

        TreeNode(int data){
            this.val = data;
            this.children = new ArrayList<>();
        }
    }

    TreeNode root;
    NarrayTree(){
        this.root = null;
    }


    // static construction of a NArrayTree
    void ConstructNarrayTree(){
        this.root = new TreeNode(1);
        this.root.children.add(new TreeNode(2));
        this.root.children.get(0).children.add(new TreeNode(3));
        this.root.children.get(0).children.add(new TreeNode(4));
        this.root.children.get(0).children.add(new TreeNode(6));


        this.root.children.add(new TreeNode(5));
        this.root.children.get(1).children.add(new TreeNode(7));

        this.root.children.add(new TreeNode(8));
        this.root.children.get(2).children.add(new TreeNode(9));
        this.root.children.get(2).children.add(new TreeNode(11));
    }


// PreOrder Traversal
    void preOrderTraversal (){

        preOrderRecurssion(root);
        System.out.println();

    }

    void preOrderRecurssion(TreeNode root){
        if(root == null) return;
        System.out.print(root.val+" ");
        for(int i = 0; i < root.children.size(); i++)
             preOrderRecurssion(root.children.get(i));


    }

//Post Order Traversal
    void postOrder(){
        postOrderReccursion(root);
    }

    void postOrderReccursion(TreeNode root){
        if(root == null) return;

        for(int i = 0; i < root.children.size();i++){
            postOrderReccursion(root.children.get(i));
        }
        System.out.print(root.val+" ");
    }














































}
