class MyCircularDeque {

    private int[] deq;         
    private int K;             
    private int front;         
    private int rear;         
    private int currentCount;  

    
    public MyCircularDeque(int k) {
        K = k;
        deq = new int[K];      
        front = 0;
        rear = K - 1;
        currentCount = 0;
    }

    
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        front = (front - 1 + K) % K;
        deq[front] = value;
        currentCount++;
        return true;
    }

    
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        rear = (rear + 1) % K;
        deq[rear] = value;
        currentCount++;
        return true;
    }

    
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        front = (front + 1) % K;
        currentCount--;
        return true;
    }

    
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        rear = (rear - 1 + K) % K;
        currentCount--;
        return true;
    }

    
    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return deq[front];
    }

    
    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return deq[rear];
    }

    
    public boolean isEmpty() {
        return currentCount == 0;
    }

    
    public boolean isFull() {
        return currentCount == K;
    }
}
