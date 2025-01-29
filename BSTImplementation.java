public class BSTImplementation {

    public static void main(String[] args) {

        BinarySearchTree binarySearchTree = new BinarySearchTree(50);

        binarySearchTree.insert(10);
        binarySearchTree.insert(55);
        binarySearchTree.insert(60);
        binarySearchTree.insert(70);
        binarySearchTree.search(80);
        binarySearchTree.distance(10,90);
        binarySearchTree.traversal();
    }
}
