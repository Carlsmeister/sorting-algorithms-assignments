public class MergeInsertSorter implements IntSorter {

    private int M = 75;
    private IntSorter insertionSorter = new InsertionSorter();

    public void sort(int[] a, int[] temp, int lo, int hi) {
        if (hi <= lo) return;

        if (hi - lo <= M) {
            int[] sortTemp = new int[hi-lo+1];
            for (int i = lo; i <= hi; i++) sortTemp[i-lo] = a[i];
            insertionSorter.sort(sortTemp);
            for (int i = lo; i <= hi; i++) a[i] = sortTemp[i-lo];
            return;
        }

        int mid = lo + (hi - lo) / 2;

        sort(a, temp, lo, mid);
        sort(a, temp, mid+1, hi);

        if (a[mid] <= a[mid+1]) return;

        merge(a, temp, lo, mid, hi);
    }

    @Override
    public void sort(int[] a) {
        int[] temp = new int[a.length];
        sort(a, temp, 0, a.length - 1);
    }

    private void merge(int[] a, int[] temp, int lo, int mid, int hi) {
        for (int k = lo; k <= hi; k++) temp[k] = a[k];

        int i = lo, j = mid+1;

        for (int k = lo; k <= hi; k++) {
            if      (i > mid)                   a[k] = temp[j++];
            else if (j > hi)                    a[k] = temp[i++];
            else if (temp[j] < temp[i])         a[k] = temp[j++];
            else                                a[k] = temp[i++];
        }
    }
}
