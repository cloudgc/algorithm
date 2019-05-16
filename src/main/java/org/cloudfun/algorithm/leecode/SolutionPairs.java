package org.cloudfun.algorithm.leecode;

import org.cloudfun.algorithm.arrays.ListNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Copyright @ 2019/5/16
 *
 * @author cloudgc
 * @since 0.0.1
 */
public class SolutionPairs {

    private final static Logger log = LoggerFactory.getLogger(SolutionPairs.class);


    public static ListNode getData() {
        ListNode listNode = new ListNode(1);
        ListNode tmp = listNode;
        for (int i = 2; i < 5; i++) {
            tmp.next = new ListNode(i);
            tmp = tmp.next;
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
        ListNode data = getData();

        printLinkNode(data);
        ListNode pairs = reversePairs(data);

        printLinkNode(pairs);

    }

    private static ListNode reversePairs(ListNode data) {

        //create root for start
        ListNode preRoot = new ListNode(-1);

        //connection
        preRoot.next = data;

        ListNode tmpRoot = preRoot;

        ListNode pairPre = data;
        ListNode pairNext = data.next;

        while (pairNext != null) {
            pairPre.next = pairNext.next;

            pairNext.next = pairPre;

            preRoot.next = pairNext;

            preRoot = pairPre;

            if (pairPre.next != null) {
                pairNext = preRoot.next.next;
            } else {
                break;
            }
            pairPre = pairPre.next;
        }


        return tmpRoot.next;
    }


    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
