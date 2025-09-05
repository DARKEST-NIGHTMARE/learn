//import java.util.Arrays;
//
//public class ArraySort {
//    private static final int Array_size = 40;
//    private static final int Num_Thread = 4;
//
//    public static void main(String[] args) {
//        int[] ar = createArray();
//        System.out.println("before sort" + Arrays.toString(ar));
//        Thread[] t1 = new Thread[Num_Thread];
//        int segment = Array_size / Num_Thread;
//        for (int i = 0; i < Num_Thread; i++) {
//            int start = i * segment;
//            int end = (i == Num_Thread - 1) ? Array_size - 1 : (start + segment - 1);
//            t1[i] = new Thread((new SortTask(ar, start, end)));
//            t1[i].start();
//
//        }
//        for (Thread t2 : t1) {
//            try {
//                t2.join();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//
//            }
//        }
//        mergeSort(ar, 0, Array_size - 1);
//        System.out.println("After sorting " + Arrays.toString(ar));
//    }
//
//
//    private static int[] createArray() {
//        int[] array = new int[Array_size];
//        for (int i = 0; i < Array_size; i++) {
//            array[i] = (int) (Math.random() * 400);
//        }
//        return array;
//    }
//
//    private static void mergeSort(int[] array, int left, int right) {
//        if (left < right) {
//            int mid = (left + right) / 2;
//            mergeSort(array, left, mid);
//            mergeSort(array, mid + 1, right);
//            merge(array, left, mid, right);
//
//        }
//    }
//
//    private static void merge(int[] array, int left, int mid, int right) {
//        int[] temp = new int[right - left + 1];
//        int i = left, j = mid + 1, k = 0;
//        while (i <= mid && j <= right) {
//            if (array[i] <= array[j]) {
//                temp[k++] = array[i++];
//
//            } else {
//                temp[k++] = array[j++];
//            }
//        }
//        while (i <= mid) {
//            temp[k++] = array[i++];
//
//        }
//        while (j <= right) {
//            temp[k++] = array[j++];
//        }
//        System.arraycopy(temp, 0, array, left, temp.length);
//    }
//
//    static class SortTask implements Runnable {
//        private int[] array;
//        private int start;
//        private int end;
//
//        public SortTask(int[] array, int start, int end) {
//            this.array = array;
//            this.start = start;
//            this.end = end;
//
//
//        }
//
//        @Override
//        public void run() {
//            Arrays.sort(array, start, end + 1);
//        }
//    }
//
//}
//
//
import java.util.Arrays;


public class ArraySort {
    private static final int ARRAY_SIZE = 40;
    private static final int NUM_THREAD = 4;

    public static void main(String[] args) {
        int[] ar = createArray();
        System.out.println("Before sort: " + Arrays.toString(ar));

        Thread[] threads = new Thread[NUM_THREAD];
        int segment = ARRAY_SIZE / NUM_THREAD;

        for (int i = 0; i < NUM_THREAD; i++) {
            int start = i * segment;
            int end = (i == NUM_THREAD - 1) ? ARRAY_SIZE : (start + segment);
            threads[i] = new Thread(new SortTask(ar, start, end));
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        int step = segment;
        while (step < ARRAY_SIZE) {
            for (int i = 0; i < ARRAY_SIZE - step; i += 2 * step) {
                int left = i;
                int mid = i + step - 1;
                int right = Math.min(i + 2 * step - 1, ARRAY_SIZE - 1);
                merge(ar, left, mid, right);
            }
            step *= 2;
        }

        System.out.println("After sorting: " + Arrays.toString(ar));
    }

    private static int[] createArray() {
        int[] array = new int[ARRAY_SIZE];
        for (int i = 0; i < ARRAY_SIZE; i++) {
            array[i] = (int) (Math.random() * 400);
        }
        return array;
    }

    private static void merge(int[] array, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            if (array[i] <= array[j]) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = array[i++];
        }
        while (j <= right) {
            temp[k++] = array[j++];
        }
        System.arraycopy(temp, 0, array, left, temp.length);
    }

    static class SortTask implements Runnable {
        private int[] array;
        private int start;
        private int end;

        public SortTask(int[] array, int start, int end) {
            this.array = array;
            this.start = start;
            this.end = end;
        }

        @Override
        public void run() {
            Arrays.sort(array, start, end);
        }
    }
}
