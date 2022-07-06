package com.example.gli.Exer11.list.exer;

/**
 * @author gsuiy
 * @create 2022-04-30 17:16
 */
public class CustomLinkedList {

    private Node headNode = null;
    private Node lastNode = null;


    public void add(Object obj) {
        if (headNode == null) {
            lastNode = headNode = new Node(obj, null, null);
        } else {

            Node newNode = new Node(obj, null, null);

            lastNode.next = newNode;
            newNode.pre = lastNode;
            lastNode = newNode;

        }
    }

    public void map() {
        if (headNode == null) {
            System.out.println("无数据");
        } else {
            Node nextPrintNode = headNode;
            System.out.println(nextPrintNode);
            while (nextPrintNode.next != null) {
                System.out.println(nextPrintNode.next);
                nextPrintNode = nextPrintNode.next;
            }
        }
    }


    class Node {
        public Object data;
        public Node pre;
        public Node next;

        public Node(Object data, Node pre, Node next) {
            this.data = data;
            this.pre = pre;
            this.next = next;
        }

        @Override
        public String toString() {
            Object prestr = "";
            Object nextstr = "";
            if (this.pre != null) {
                prestr = this.pre.data;
            }

            if (this.next != null) {
                nextstr = this.next.data;
            }
            return "Node{" +
                    "data=" + data +
                    ", pre=" + prestr +
                    ", next=" + nextstr +
                    '}';
        }
    }
}
