public class Solution {
    /**
     * @param A an integer array
     * @return void
     */
    public void sortIntegers(int[] A) {
        // Write your code here
        if (A == null || A.length == 0) {
            return;
        }
        
        int[] tmp = new int[A.length];
        mergeSort(0, A.length - 1, A, tmp);
    }
    
    private void mergeSort(int start, int end, int[] A, int[] tmp) {
        if (start >= end) {
            return;
        }
        
        int mid = (start + end) / 2;
        mergeSort(0, mid, A, tmp);
        mergeSort(mid + 1, end, A, tmp);
        merge(start, mid, end, A, tmp);
    }
    
    private void merge(int start, int mid, int end, int[] A, int[] tmp) {
        int left = start;
        int right = mid + 1;
        int idx = start;
        
        while (left <= mid && right <= end) {
            if (A[left] < A[right]) {
                tmp[idx++] = A[left++];
            } else {
                tmp[idx++] = A[right++];
            }
        }
        
        while (left <= mid) {
            tmp[idx++] = A[left++];
        }
        
        while (right <= end) {
            tmp[idx++] = A[right++];
        }
        
        for (int i = start; i <= end; i++) {
            A[i] = tmp[i];
        }
    }
}