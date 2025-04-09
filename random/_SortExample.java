package random;

public class _SortExample {
    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7, 1, 12, 3, 7, 8, 9, 18 };
        MergeSort mergeSort = new MergeSort(arr);
        System.out.println("Before sorted:");
        mergeSort.displaySortedArray();
        mergeSort.sort();
        System.out.println("After merge sorted:");
        mergeSort.displaySortedArray();
        System.out.println("Total time taken: "+mergeSort.getTotalTime());
    }
}

class MergeSort {

    private int[] arr = null;
    private int[] tempArr = null;
    private long totalTime;

    public MergeSort(int[] arr){
        this.arr = arr;
        this.tempArr = new int[arr.length];
        this.totalTime = 0;
    }

    public void sort() {
        long startTime = System.currentTimeMillis();
        mergeSort(0, arr.length-1);
        long endTime = System.currentTimeMillis();
        System.out.println("Start Time: "+startTime+" End Time: "+endTime);
        totalTime = endTime - startTime;
    }

    private void mergeSort(int start, int last) {
        if(start>=last)
            return;

        int mid = (start + last)/2;
        mergeSort(start, mid);
        mergeSort(mid+1, last);

        //System.out.println("start: "+start+" mid: "+mid+" last: "+last);
        //displaySortedArray();
        merge(start, mid, last);
    }

    private void merge(int start, int mid, int last) {

        /*
        System.out.println("Merge start: "+start+" mid: "+mid+" last: "+last);
        displaySortedArray();
        displayTempArray();
        */

        for(int i=start;i<=last;i++)
            tempArr[i] = arr[i];

        int i = start;
        int j = mid+1;
        int z = start;

        //System.out.println("i: "+i+" j: "+j+" z: "+z+" start: "+start+" mid: "+mid+" last: "+last);
        while((i<=mid) && (j<=last)) {
            if(tempArr[i] < tempArr[j]) {
                //System.out.println("con1");
                arr[z] = tempArr[i];
                i++;
            } else {
                //System.out.println("con2");
                arr[z] = tempArr[j];
                j++;
            }
            z++;
        }

        //System.out.println("i: "+i+" j: "+j+" z: "+z+" start: "+start+" mid: "+mid+" last: "+last);
        while(i<=mid) {
            //System.out.println("con3");
            arr[z] = tempArr[i];
            i++;
            z++;
        }

        //System.out.println("i: "+i+" j: "+j+" z: "+z+" start: "+start+" mid: "+mid+" last: "+last);
        while(j<=last) {
            //System.out.println("con4");
            arr[z] = tempArr[j];
            j++;
            z++;
        }

        /*
        System.out.println("On Merge end:");
        displaySortedArray();
        displayTempArray();
        */
    }

    public void displaySortedArray() {
        for(int a : arr) {
            System.out.print(a+" ");
        }

        System.out.println();
    }

    public void displayTempArray() {
        for(int a : tempArr) {
            System.out.print(a+" ");
        }

        System.out.println();
    }

    public long getTotalTime() {
        return totalTime;
    }
}


