import java.util.*;

class NaryTreeNode{
    String val;
    boolean isLocked = false;;
    NaryTreeNode parent;
    List<NaryTreeNode> children  = new ArrayList<>();

     NaryTreeNode(String val){
        this.val = val;
    }


    void addChild(NaryTreeNode child){
        child.parent = this;
        this.children.add(child);
    }


    public void lock(){
        if(!isLocked && !isAnyChildrenLocked() && !isAnyParentLocked()){
            isLocked = true;
            System.out.println("Locked");

        }
        else{
            System.out.println("Is Already Locked");
        }
    }


    private boolean isAnyChildrenLocked(){

        for(NaryTreeNode child : this.children)
            if(child.isLocked || child.isAnyChildrenLocked() )
            return true;

        return false;
    }

private boolean isAnyParentLocked(){

    NaryTreeNode current = this.parent;

    while(current != null){
        if(current.isLocked) return true;
        current = current.parent;
    }


    return false;
}

}




public class NAryLock {
    public static void main(String[] args) {
        NaryTreeNode root = new NaryTreeNode("world");
        NaryTreeNode child1 = new NaryTreeNode("asia");
        NaryTreeNode child2 = new NaryTreeNode("india");
        NaryTreeNode child3 = new NaryTreeNode("china");

        root.addChild(child1);
        child1.addChild(child2);
        child1.addChild(child3);

        child2.lock();
        child2.lock();
        child3.lock();






    }
}
