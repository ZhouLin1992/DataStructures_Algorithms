public class Solution {
	public static void merge(int[] arr, int left, int mid, int right) {
		// array length of first and second half
		// first half arr[left, mid]
		// second half arr[mid + 1, right]
		int len1 = mid - left + 1;
		int len2 = right - mid;

		// crete tmp array for each half
		int[] L = new int[len1];
		int[] R = new int[len2];

		// copy array elements in each half
		for (int l = 0; l < len1; l++) 
			L[l] = arr[left + l];
		for (int r = 0; r < len2; r++)
			R[r] = arr[mid + 1 + r];

		// merge two arrays
		int p = left, l = 0, r = 0;
		while (l < len1 && r < len2) {
			if (L[l] < R[r]) {
				arr[p] = L[l];
				l++;
			} else {
				arr[p] = R[r];
				r++;
			}
			p++;
		}

		while (l < len1) {
			arr[p] = L[l];
			l++;
			p++;
		}

		while (r < len2) {
			arr[p] = R[r];
			r++;
			p++;
		}
	} 


	public static void sort(int[] arr, int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;

			sort(arr, left, mid);
			sort(arr, mid + 1, right);

			merge(arr, left, mid, right);
		}
	}
}