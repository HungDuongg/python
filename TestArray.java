import java.util.Arrays;
import java.util.Random;

class ArrayMuni {
    private int[] array;

    public ArrayMuni(int n) {
        array = new int[n];
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(101) - 50;  // Generates a random integer between -50 and 50
        }
    }

    public int geti(int i) throws ArrayIndexOutOfBoundsException {
        try {
            return array[i];
        } catch (IndexOutOfBoundsException e) {
            throw new ArrayIndexOutOfBoundsException("Index out of bounds");
        }
    }

    public void seti(int i, int value) throws ArrayIndexOutOfBoundsException {
        try {
            array[i] = value;
        } catch (IndexOutOfBoundsException e) {
            throw new ArrayIndexOutOfBoundsException("Index out of bounds");
        }
    }

    public String toString() {
        return Arrays.toString(array);
    }

    public int[] subarray() {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        int start = 0;
        int end = 0;
        int tempStart = 0;

        for (int i = 0; i < array.length; i++) {
            currentSum += array[i];

            if (currentSum > maxSum) {
                maxSum = currentSum;
                start = tempStart;
                end = i;
            }

            if (currentSum < 0) {
                currentSum = 0;
                tempStart = i + 1;
            }
        }

        return Arrays.copyOfRange(array, start, end + 1);
    }
}

public class TestArray {
    public static void main(String[] args) {
        // Test Case 1
        ArrayMuni myArr1 = new ArrayMuni(9);
        System.out.println("MyArr1: " + Arrays.toString(myArr1.subarray()));
        myArr1.seti(0, -3);
        myArr1.seti(1, 5);
        myArr1.seti(2, -3);
        myArr1.seti(3, 6);
        myArr1.seti(4, -2);
        myArr1.seti(5, 4);
        myArr1.seti(6, 11);
        myArr1.seti(7, -5);
        myArr1.seti(8, 4);
        try {
            System.out.println("Geti(0): " + myArr1.geti(0));
            System.out.println("Geti(2): " + myArr1.geti(2));
            System.out.println("Geti(10): " + myArr1.geti(10));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Test Case 2
        ArrayMuni myArr2 = new ArrayMuni(10);
        for (int i = 0; i < 10; i++) {
            myArr2.seti(i, 1);
        }
        System.out.println("\nMyArr2: " + Arrays.toString(myArr2.subarray()));

        // Test Case 3
        ArrayMuni myArr3 = new ArrayMuni(5);
        myArr3.seti(0, 5);
        myArr3.seti(1, 4);
        myArr3.seti(2, -1);
        myArr3.seti(3, 7);
        myArr3.seti(4, 8);
        System.out.println("\nMyArr3: " + Arrays.toString(myArr3.subarray()));

        // Test Case 4
        ArrayMuni myArr4 = new ArrayMuni(20);
        System.out.println("\nMyArr4: " + Arrays.toString(myArr4.subarray()));
    }
}
