package quiz_bkp.leetcode.easy;

public class MergeSortedList {

    static Node mergeSortedList(Node l1, Node l2) {

        Node dummy = new Node(0);
        Node tail = dummy;

        while (l1 != null && l2 != null) {

            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;

        }

        if (l1 != null) {
            tail.next = l1;
        } else if (l2 != null) {
            tail.next = l2;
        }

        return dummy.next;
    }

    static void printList(Node n) {
        while (n != null) {
            System.out.print(n.val + " ");
            n = n.next;
        }
    }

    public static void main(String[] args) {

        Node l1 = new Node(1, new Node(2, new Node(4, null)));
        Node l2 = new Node(1, new Node(3, new Node(4, null)));

        Node l3 = mergeSortedList(l1, l2);

        printList(l3);

    }

    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }

        Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }

    }

}
