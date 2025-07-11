package A_hot100;

import java.util.Arrays;

class MinStack {

    private static class N{
        int data;
        int min;
    }

    private static class Q{
        N[] qeque = new N[20];
        int length = 0;
        int max_length = 20;
    }

    private final Q q = new Q();
    
    public void push(int val) {
        // 超过范围之后 重新申请范围
        if(q.length >= q.max_length){
            N[] new_qeque = new N[q.qeque.length*2];
            System.arraycopy(q.qeque, 0, new_qeque, 0, q.qeque.length);
            q.qeque = new_qeque;
            q.max_length = q.qeque.length * 2;
        }
        q.qeque[q.length] = new N();
        q.qeque[q.length].data = val;
        if(q.length == 0){
            q.qeque[q.length].min = val;
        }else {
            q.qeque[q.length].min = Math.min(q.qeque[q.length-1].min, val);
        }
        q.length++;
    }
    
    public void pop() {
        if(q.length == 0){
            return;
        }
        q.qeque[q.length-1].data = 0;
        q.qeque[q.length-1].min = 0;
        q.length--;
    }
    
    public int top() {
        return q.length > 0 ? q.qeque[q.length-1].data : -1;
    }
    
    public int getMin() {
        return q.length > 0 ? q.qeque[q.length-1].min : -1;
    }
}