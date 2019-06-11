package org.cloudfun.algorithm.arrays;

import org.junit.Before;
import org.junit.Test;

/**
 * Copyright @ 2019/5/9
 *
 * @author cloudgc
 * @since 0.0.1
 */
public class ReverseSingleLinkList {

    ListNode listNode;


    @Before
    public void setup() {

        listNode = LinkList.getLinkNode(10);


    }


    @Test
    public void reverseList() {

        LinkList.printLinkNode(listNode);

        ListNode node = reverseNode(listNode);
        LinkList.printLinkNode(node);


    }


    private ListNode reverseNode(ListNode listNode) {

        ListNode root = new ListNode(-1);

        root.next = listNode;

        ListNode pre = root.next;

        ListNode cur = pre.next;

        while (cur != null) {

            //pre连接下一次需要反转的节点
            pre.next = cur.next;

            //转节点Cur
            cur.next = root.next;

            //纠正头结点root的指向
            root.next = cur;

            //cur指向下一次要反转的节点
            cur = pre.next;
        }


        return root.next;
    }
}
