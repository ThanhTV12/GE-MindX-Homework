package lesson003.onclass;

public class CircularQueue {
    public static void main(String[] args) {
//        ["MyCircularQueue","enQueue","enQueue","enQueue","enQueue","Rear","isFull","deQueue","enQueue","Rear"]
//[[3],[1],[2],[3],[4],[],[],[],[4],[]]

        MyCircularQueue circularQueue = new MyCircularQueue(3);
        boolean isValid1 = circularQueue.enQueue(1);
        boolean isValid2 = circularQueue.enQueue(2);
        boolean isValid3 = circularQueue.enQueue(3);
        boolean isValid4 = circularQueue.enQueue(4);

        int rear = circularQueue.Rear();
        boolean isFull = circularQueue.isFull();
        boolean dequeue = circularQueue.deQueue();
        int rear2 = circularQueue.Rear();
        int rear3 = circularQueue.Rear();

    }

    /**
     * Your MyCircularQueue object will be instantiated and called as such:
     * MyCircularQueue obj = new MyCircularQueue(k);
     * boolean param_1 = obj.enQueue(value);
     * boolean param_2 = obj.deQueue();
     * int param_3 = obj.Front();
     * int param_4 = obj.Rear();
     * boolean param_5 = obj.isEmpty();
     * boolean param_6 = obj.isFull();
     */
    private static class MyCircularQueue {

        int[] queue;
        int head = -1;
        int tail = -1;
        int size;
        public MyCircularQueue(int k) {
            this.size = k;
            queue = new int[k];
        }

        public boolean enQueue(int value) {
            if(isFull()) {
                return false;
            }
            tail++;
            if(tail == size) {
                tail = 0;
            }
            queue[tail] = value;
            if(head == -1) {
                head = 0;
            }
            return true;
        }

        public boolean deQueue() {
            if(isEmpty()) {
                return false;
            }
            if(head == tail) {
                head = -1;
                tail = -1;
                return true;
            }
            head++;
            if(head == size) {
                head = 0;
            }
            return true;
        }

        public int Front() {
            if(isEmpty()) {
                return -1;
            }
            return queue[head];
        }

        public int Rear() {
            if(isEmpty()) {
                return -1;
            }
            return queue[tail];
        }

        public boolean isEmpty() {
            if(tail == -1 && head == -1) {
                return true;
            }
            return false;
        }

        public boolean isFull() {
            if(tail + 1 == head) {
                return true;
            }
            if(head == 0 && tail == size - 1) {
                return true;
            }
            return false;
        }
    }


}
