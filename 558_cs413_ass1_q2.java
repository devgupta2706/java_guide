class Bubblesort {// Bubble sort class
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

}

class BinarySearch {
    int pos = -1;

    int search(int A[], int l, int r, int value) {
        if (r >= l) {
            int mid = l + (r - l) / 2;
            if (A[mid] == value)
                return mid;// if value equals to mid value it returns to the main class

            if (A[mid] > value) { // if value smaller than mid value then it goes to left of the mid value
                return search(A, l, mid - 1, value);// recursive call
            }
            // if value greater than mid value then it goes to right of the mid value
            return search(A, mid + 1, r, value);// recursive call

        }
        return -1;
    }
}

class MainClass {
    public static void main(String[] args) {
        int[] A = { 23, 25, 29, 10, 5, 34, 78 };// random elements are taken
        BinarySearch check = new BinarySearch();// reference of class Binarysearch
        Bubblesort obj = new Bubblesort();// reference of class Bubblesort
        obj.bubblesort(A);// method calling
        int get = check.search(A, 0, A.length - 1, 34);
        if (get > -1) {
            System.out.printf("Element Found at pos %d", get + 1);
        }

        else {
            System.out.printf("Element not Found ");
        }
    }
}
