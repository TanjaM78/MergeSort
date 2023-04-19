package advanced;

class MergeSort {
    // Mischfolge von 2 subarrays arr[].
    // 1.subarray arr[l..m]
    // 2.subarray arr[m+1..r]
    void merge(int arr[], int l, int m, int r) {
        // Grösse von subarrays finden
        int leftSize = m - l + 1;
        int rightSize = r - m;
        // temporäre Arrays anlegen
        int[] left = new int[leftSize];
        int[] right = new int[rightSize];

        // Daten in arrays kopieren
        for (int i = 0; i < leftSize; ++i)
            left[i] = arr[l + i];
        for (int j = 0; j < rightSize; ++j)
            right[j] = arr[m + 1 + j];

        int leftIndex = 0, rightIndex = 0;
        int totalIndex = l;

        while (leftIndex < leftSize && rightIndex < rightSize) {
            if (left[leftIndex] <= right[rightIndex]) {
                arr[totalIndex] = left[leftIndex];
                leftIndex++;
            } else {
                arr[totalIndex] = right[rightIndex];
                rightIndex++;
            }
            totalIndex++;
        }
        while (leftIndex < leftSize) {
            arr[totalIndex] = left[leftIndex];
            leftIndex++;
            totalIndex++;
        }

        while (rightIndex < rightSize) {
            arr[totalIndex] = right[rightIndex];
            rightIndex++;
            totalIndex++;
        }
    }

    void split(int arr[], int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            split(arr, l, m);
            split(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String args[]) {
        int arr[] = {12, 11, 13, 5, 6, 7, 24, 29, 78};
        System.out.println("Ürsprünglicher Array");
        printArray(arr);

        MergeSort ob = new MergeSort();
        ob.split(arr, 0, arr.length - 1);

        System.out.println("\nSortierter Array");
        printArray(arr);
    }
}
