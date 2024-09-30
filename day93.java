class CustomStack {
    private int[] stack; // Array to hold stack elements
    private int[] increment; // Array to hold increment values
    private int top; // Current top of the stack
    private int maxSize; // Maximum size of the stack
    
    public CustomStack(int maxSize) {
        this.stack = new int[maxSize];
        this.increment = new int[maxSize];
        this.top = -1; // Initially, the stack is empty
        this.maxSize = maxSize;
    }
    
    public void push(int x) {
        if (top + 1 < maxSize) { // Check if there's space
            top++;
            stack[top] = x; // Push x onto the stack
        }
    }
    
    public int pop() {
        if (top == -1) {
            return -1; // Stack is empty
        }
        int value = stack[top]; // Get the top value
        // Apply increment if there are any
        if (top > 0) {
            increment[top - 1] += increment[top]; // Transfer increment to the element below
        }
        int result = value + increment[top]; // Apply any increment
        increment[top] = 0; // Reset increment for the current top
        top--; // Remove the top element
        return result; // Return the value
    }
    
    public void increment(int k, int val) {
        // Increment the bottom k elements
        if (top == -1) {
            return; // Stack is empty, do nothing
        }
        // If k exceeds the number of elements in the stack, adjust it
        int effectiveK = Math.min(k, top + 1);
        increment[effectiveK - 1] += val; // Increment the appropriate position
    }
}
