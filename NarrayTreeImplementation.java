public class NarrayTreeImplementation {
    public static void main(String[] args) {

        NarrayTree narrayTree = new NarrayTree();
        narrayTree.ConstructNarrayTree();
        narrayTree.preOrderTraversal();
        narrayTree.postOrder();
        System.out.println();
        narrayTree.levelOrderTraversal();
        System.out.println();
        narrayTree.zigzag();
    }
}
