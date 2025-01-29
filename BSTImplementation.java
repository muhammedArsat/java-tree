public class BSTImplementation {

    public static void main(String[] args) {

        BinarySearchTree binarySearchTree = new BinarySearchTree(50);

        binarySearchTree.insert(20);
        binarySearchTree.insert(79);
        binarySearchTree.insert(10);
        binarySearchTree.insert(25);
        binarySearchTree.insert(60);
        binarySearchTree.insert(90);

        binarySearchTree.serialize();
        String s = "50$20$79$10$25$60$90$#$#$#$#$#$#$#$#";
        binarySearchTree.deSerialize(s);
        binarySearchTree.levelOrderTraversal();
    }
}
