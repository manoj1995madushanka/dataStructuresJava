package List;
//first crete Node class
// second then initialise first and last as null
//size method
//add/remove method
public class BasicLinkedList<X> {
    private Node first;
    private Node last;
    private int nodeCount;

    public BasicLinkedList() {
        first = null;
        last= null;
        nodeCount = 0;
    }

    public int size(){
        return nodeCount;
    }

    public void add(X item){
        if(first==null){
            first = new Node(item);
            last=first;
        }else{
            Node newLastNode = new Node(item);
            last.setNextNode(newLastNode);
        }
        nodeCount++;
    }

    public X remove(){
        if(first==null){
            throw new IllegalStateException("The linked list is empty");
        }
        X nodeItem = first.getNodeItem();
        first = first.getNextNode();
        nodeCount--;
        return nodeItem;
    }

    private class Node{
        private Node nextNode;
        private X nodeItem;

        public Node(X item) {
            this.nextNode = null;
            this.nodeItem = item;
        }

        public Node getNextNode() {
            return nextNode;
        }

        public void setNextNode(Node nextNode) {
            this.nextNode = nextNode;
        }

        public X getNodeItem(){
            return nodeItem;
        }
    }
}
