package org.cloudfun.algorithm.arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Copyright @ 2019/3/31
 *
 * @author cloudgc
 * @since 0.0.1
 */
public class LinkList {

    private final static Logger log = LoggerFactory.getLogger(LinkList.class);


    public static ListNode getLinkNode(int nodeNum) {

        ListNode listNode = new ListNode(0);
        ListNode t = listNode;
        for (int i = 1; i < nodeNum; i++) {
            t.next = new ListNode(i);
            t = t.next;


        }
        return listNode;
    }


    public static void printLinkNode(ListNode listNode) {


        if (listNode == null) {

            log.info("[{}]", ">");


        }
        StringBuilder stringBuilder = new StringBuilder();

        getStrListNode(listNode, stringBuilder);

        log.info("list:[{}]", stringBuilder.toString());


    }

    private static void getStrListNode(ListNode listNode, StringBuilder stringBuilder) {

        stringBuilder.append(">" + listNode.val);

        if (listNode.next != null) {
            getStrListNode(listNode.next, stringBuilder);
        }
    }

    public static void main(String[] args) {

        ListNode linkNode = getLinkNode(10);
        printLinkNode(linkNode);


    }

}

