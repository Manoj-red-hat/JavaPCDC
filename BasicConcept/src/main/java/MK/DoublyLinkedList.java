package MK;

import static edu.rice.pcdp.PCDP.isolated;

/**
 * Created by Manoj Kumar on 10/31/2017.
 * Contact: manoj.kumar.mbm@gmail.com
 */
public class DoublyLinkedList {
   private class Node {
       int data;
       Node next=null;
       Node prev=null;
       Node(int i){
           this.data=i;
       }
   }

   Node root=null;

   public void addNode(int i){
       isolated(()-> {
           Node newNode = new Node(i);
           if (root == null) {
               root = newNode;
           } else {
               Node tmp;
               tmp = root;
               while (tmp.next != null) {
                   tmp = tmp.next;
               }
               tmp.next = newNode;
               newNode.prev = tmp;
           }
       });
   }

   public void deleteNode(int i){
       isolated(()->{
       Node tmp;
       tmp=root;
       while(tmp!=null){
           if(tmp.data == i) {
               tmp.prev.next = tmp.next;
               tmp.next.prev = tmp.prev;
               break;
           }
           tmp=tmp.next;
       }});
   }

    public boolean Contains (int i){

        Node tmp;
        tmp=root;
        while(tmp!=null){
            if(tmp.data == i) {
                return true;
            }
            tmp=tmp.next;
        }
        return false;
    }

   @Override
   public String toString(){
       StringBuffer sb=new StringBuffer();
       Node trv=root;
       while(trv!=null){
           sb.append(trv.data+"->");
           trv=trv.next;
       }
       return sb.toString();
   }
}
