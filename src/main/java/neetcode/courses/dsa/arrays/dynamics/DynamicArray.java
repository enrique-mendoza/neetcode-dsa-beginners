package neetcode.courses.dsa.arrays.dynamics;

public class DynamicArray {

    private int capacity;

    private int length;

    private int[] arr;

    public DynamicArray(int capacity) {
        this.capacity = capacity;
        this.length = 0;
        this.arr = new int[capacity];
    }

    // Get value at i-th index
    public int get(int i) {
        if (i < length) {
            return arr[i];
        }

        return -1;
    }

    // Insert n at i-th index
    public void set(int i, int n) {
        if (i < length) {
            arr[i] = n;
        }
    }

    // Insert n in the last position of the array
    public void pushback(int n) {
        if (length == capacity) {
            this.resize();
        }

        // insert at next empty position
        arr[length] = n;
        length++;
    }

    // Remove the last element in the array
    public int popback() {
        int element = -1;

        if (length > 0) {
            element = arr[length - 1];
            arr[length - 1] = 0;
            length--;
        }

        return element;
    }

    private void resize() {
        // Create new array of double capacity
        capacity *= 2;
        int[] newArr = new int[capacity];

        // Copy elements to newArr
        System.arraycopy(arr, 0, newArr, 0, length);
        arr = newArr;
    }

    // Get length
    public int getSize() {
        return length;
    }

    // Get capacity
    public int getCapacity() {
        return capacity;
    }
}
