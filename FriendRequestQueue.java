public class FriendRequestQueue {
    private FriendRequest[] queue;
    private int front, rear, capacity, size;

    public FriendRequestQueue(int capacity) {
        queue = new FriendRequest[capacity];
        this.capacity = capacity;
        size = 0;
        front = 0;
        rear = -1;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(FriendRequest req) {
        if (isFull()) {
            System.out.println("The queue requestes is full!");
            return;
        }
        rear = (rear + 1) % capacity;
        queue[rear] = req;
        size++;
    }

    public FriendRequest remove() {
        if (isEmpty()) {
            System.out.println("THe queue is empty!");
            return null;
        }
        FriendRequest req = queue[front];
        front = (front + 1) % capacity;
        size--;
        return req;
    }
}
