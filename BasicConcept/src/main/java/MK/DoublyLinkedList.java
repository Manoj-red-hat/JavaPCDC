package MK;

public class DoublyLinkedList {
    private class node{
        int value=0;
        node(int i){
            this.value=i;
        }
        node next=null;
        node previous=null;
    }

    node root=null;
    public node add(node x){

        node traverse;
        if(this.root==null){
            root=x;
        }else{
            traverse=root;
            while(traverse.next!=null){
                traverse=traverse.next;
            }
            traverse.next=x;
            x.previous=traverse;
        }
        return root;
    }
}
