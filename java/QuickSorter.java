public class QuickSorter implements IntSorter {

    private int M = 15;
    private IntSort insertionSorter = new InsertionSort();
    public void sort(int[] a, int lo, int hi) {
        if (hi <= lo) return;

        if (hi - lo <= M) {
            insertionSorter.sort(a);
            return;
        }

        int p = partition(a, lo, hi);
        sort(a, lo, p-1);
        sort(a, p+1, hi);
    }

    @Override
    public void sort(int[] a) {
        //ArrayUtils.shuffle(a);
        sort(a, 0, a.length-1);
    }

    private int partition(int[] a, int lo, int hi) {

        int i = lo, j = hi+1;

        while (true) {
            while (a[++i] < a[lo]) if (i == hi) break;
            while (a[lo] < a[--j]) if (j == lo) break;
            if (i >= j) break;
            int t = a[i]; a[i] = a[j]; a[j] = t;
        }
        int t = a[lo]; a[lo] = a[j]; a[j] = t;
        return j;
    }
}


