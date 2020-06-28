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
    
    public static ListNode generateCircleLinkList(int length, int pos) {
        
        if (pos >= length) {
            throw new IllegalStateException("post < length");
        }
        
        int v = 1;
        ListNode root = new ListNode(v);
        
        ListNode tmp = root;
        ListNode posNode = null;
        
        do {
            v++;
            tmp.next = new ListNode(v);
            if (pos == v) {
                posNode = tmp.next;
            }
            if (length == v) {
                tmp.next.next = posNode;
                break;
            }
            tmp = tmp.next;
            
        } while (true);
        
        return root;
        
    }
    
    public static boolean hasCircle(ListNode node) {
        
        ListNode fast = node;
        ListNode low = node;
        
        while (true) {
            low = low.next;
            fast = fast.next.next;
            if (fast == null || low == null) {
                return false;
            }
            
            if (low.equals(fast)) {
                System.out.println(low + ";" + fast);
                return true;
            }
        }
    }
    
    
    public static int circlePoint(ListNode circleNode) {
        
        ListNode slowTmp = circleNode;
        ListNode fastTmp = circleNode;
        
        ListNode finalNode = null;
        
        int index = 0;
        
        long maxIndex = 0;
        
        while (true) {
            
            maxIndex++;
            
            slowTmp = slowTmp.next;
            // ignore next null
            fastTmp = fastTmp.next.next;
            
            if (slowTmp.equals(fastTmp)) {
                fastTmp = circleNode;
                while (true) {
                    fastTmp = fastTmp.next;
                    slowTmp = slowTmp.next;
                    index++;
                    if (slowTmp.equals(fastTmp)) {
                        finalNode = slowTmp;
                        System.out.println("meet node :" + finalNode.val);
                        break;
                    }
                }
                
                break;
                
            }
            
            if (maxIndex > Integer.MAX_VALUE) {
                break;
            }
            
        }
        return index;
    }
    
    
    public static void main(String[] args) {
        
        ListNode listNode = CircleLinkList.generateCircleLinkList(10, 6);
        
        if (!CircleLinkList.hasCircle(listNode)) {
            LinkList.printLinkNode(listNode);
        } else {
            
            System.out.println("has circle");
        }
        
        CircleLinkList.circlePoint(listNode);
        
        
    }
    
    
}
