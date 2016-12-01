public class Solution {
    /**
     * @param A an integer array
     * @return void
     */
	public void sortIntegers(int[] A) {
	    // exception checking
		if (A == null || A.length == 0) {
			return;
		}

		quickSort(0, A.length - 1, A);
	}

	private void quickSort(int start, int end, int[] A) {
	    // only one element or the boundary is already overlapping
	    if (start >= end) {
	        return;
	    }
	    
		int left = start;
		int right = end;
		// pivot is the value not index
		int pivot = A[(start + end) / 2];
        
        // left <= right, not left < right
		while (left <= right) {
		    // A[left] < pivot not A[left] <= pivot
			while (left <= right && A[left] < pivot) {
				left++;
			}
			// A[right] > pivot not A[right] >= pivot
			while (left <= right && A[right] > pivot) {
				right--;
			}
			if (left <= right) {
                int tmp = A[left];
                A[left] = A[right];
                A[right] = tmp;
                // remember to change index of left and right
				left++;
				right--;
			}
		}

		// left and right have already changed their positions:
		// left is on the right while right is on the left
		quickSort(start, right, A);
		quickSort(left, end, A);
	}
}