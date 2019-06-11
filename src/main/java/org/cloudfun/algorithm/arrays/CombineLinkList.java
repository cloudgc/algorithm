package org.cloudfun.algorithm.arrays;

/**
 * Copyright @ 2019/6/11
 *
 * @author cloudgc
 * @since 0.0.1
 */
public class CombineLinkList {


    public static void main(String[] args) {

        ListNode linkNode = LinkList.getLinkNode(10);
        ListNode linkNode1 = LinkList.getLinkNode(20);

        ListNode node = combineLinkList(linkNode, linkNode1);

        LinkList.printLinkNode(node);


    }

    private static ListNode combineLinkList(ListNode linkNode, ListNode linkNode1) {
        return null;
    }


}
