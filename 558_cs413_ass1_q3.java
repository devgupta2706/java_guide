class Bubblesort {
    void bubblesort(int A[]) {// bubble sort method
        int size = A.length;// size of array
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - i - 1; j++) {// At every iteration we are
                if (A[j] > A[j + 1]) { // putting the large value of the current array
                                       // at position size-i-1
                    int temp = A[j]; // swaping the values
                    A[j] = A[j + 1];
                    A[j + 1] = temp;
                }
            }
        }
    }

    void printarray(int A[]) {// printing the array
        for (int j = 0; j < A.length; j++) {
            System.out.printf("%d ", +A[j]);
        }
    }

}

class MainClass {
    public static void main(String[] args) {
        int[] arr = { 23, 25, 29, 10, 5 };
        Bubblesort B = new Bubblesort();// reference of the class Bubblesort
        B.bubblesort(arr);// method calling
        B.printarray(arr);// method calling
    }
}
