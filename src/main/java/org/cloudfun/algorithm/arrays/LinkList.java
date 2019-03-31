package org.cloudfun.algorithm.arrays;

import org.junit.Before;

/**
 * Copyright @ 2019/3/31
 *
 * @author cloudgc
 * @since 0.0.1
 */
public class LinkList {

@Before
public void set(){
    ListNode listNode=new ListNode(0);
    for(int i=1;i<4;i++){
        listNode.next=new ListNode(i);
    }
}


 public class ListNode {
     int val;
     ListNode next;

     ListNode pev;

     ListNode(int x) {
         val = x;
     }


 }

}

