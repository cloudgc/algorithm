package org.cloudfun.algorithm.arrays;

/**
 * Copyright @ 2019/6/4
 *
 * @author cloudgc
 * @since 0.0.1
 * <p>
 * Linklist with circle problem
 */
public class CircleLinkList {

    public static  ListNode generateCircleLinkList(int length, int pos) {

        if (pos >= length) {
            throw new IllegalStateException("post < length");
        }

        int v = 1;
        ListNode root = new ListNode(v);

        ListNode tmp = root;
        ListNode posNode = null;

        do{
            v++;
            tmp.next = new ListNode(v);
            if (pos == v) {
                posNode=tmp.next;
            }
            if(length==v){
                tmp.next.next=posNode;
                break;
            }
            tmp = tmp.next;

        }while (true);

        return root;

    }

    public static void main(String[] args) {

        ListNode listNode = CircleLinkList.generateCircleLinkList(10, 6);

        LinkList.printLinkNode(listNode);



    }


}
