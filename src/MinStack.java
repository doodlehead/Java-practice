import java.util.ArrayList;

//V1: MinStack backed by a linkedlist and using references to keep track of the min
//Runtime 11 ms
//Memory usage: 45.3 MB
public class MinStack {
    /** initialize your data structure here. */
    StackNode head;
    StackNode minNode;

    public MinStack() {}

    public void push(int x) {
        if (this.head == null) {
            this.head = new StackNode(x, null);
            this.minNode = this.head;
        } else {
            StackNode newHead;
            //It's smaller than the min value
            if (x < this.minNode.value) {
                newHead = new StackNode(x, this.head, this.minNode);
                this.minNode = newHead;
            } else {
                newHead = new StackNode(x, this.head);
            }
            this.head = newHead;
        }
    }

    //Remove the node at the top
    public void pop() {
        if (this.minNode == this.head) {
            //Update the minNode
            this.minNode = this.head.prevMin;
        }
        this.head = this.head.prev;
    }

    /**
     * Peek
     * @return the top
     */
    public int top() {
        return this.head.value;
    }

    /**
     * Get the smallest value
     * @return
     */
    public int getMin() {
        return this.minNode.value;
    }
}

class StackNode {
    public int value;
    public StackNode prev;
    public StackNode prevMin;

    public StackNode(int value, StackNode prev) {
        this.value = value;
        this.prev = prev;
    }
    public StackNode(int value,StackNode prev, StackNode prevMin) {
        this(value, prev);
        this.prevMin = prevMin;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
