import java.util.Random;

public class Assignment13 {
    int[] arr;
    int kth_small;

    public Assignment13(int[] arr, int k) {
        this.arr = arr;
        kth_small = arr.length - k;
    }

    public int kthLargest(int left, int right) {
        if (left >= right) return arr[left];
        Random rd = new Random();
        int pivot_idx = left + rd.nextInt(right - left);
        pivot_idx = partition(left, right, pivot_idx);

        if (pivot_idx == kth_small) return arr[kth_small];
        else if (pivot_idx > kth_small) return kthLargest(left, pivot_idx - 1);
        else return  kthLargest(pivot_idx + 1, right);
    }

    public void swap(int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

    public int partition(int left, int right, int pivot_idx) {
        int pivot = arr[pivot_idx];
        swap(pivot_idx, right);
        int curr = left;
        for (int i=left; i <= right; i++) {
            if (arr[i] < pivot) {
                swap(curr, i);
                curr++;
            }
        }
        swap(curr, right);
        return curr;
    }
}
