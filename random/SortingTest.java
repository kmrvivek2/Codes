package random;

public class SortingTest {
    public static void main(String[] args) {
        int arr[] = {5,6,7,1,3,2};
        SortTest sortTest = new SortTest(arr);
        System.out.println("Unsorted Array :");
        sortTest.printNums();
        sortTest.Sort(1);
        System.out.println("\nSorted Array :");
        sortTest.printNums();
    }
}

class SortTest {

    private int[] nums;
    private int[] temp;

    public SortTest(int[] arr) {
        this.nums = arr;
    }

    public int[] getNums() {
        return this.nums;
    }

    public void printNums() {
        for(int i : this.nums) {
            System.out.print(i+" ");
        }
    }

    public void Sort(int i) {
        switch (i) {
            case 1: {
                this.MergeSort(0, this.nums.length - 1);
                break;
            }
            default: {
                System.out.println("Invalid input");
            }
        }
    }

    private void MergeSort(int low, int high) {
        if(low >= high) {
            return;
        }

        int middleIndex = (low+high)/2;
        MergeSort(low, middleIndex);
        MergeSort(middleIndex+1,high);
        Merge(low, middleIndex, high);
    }

    private void Merge(int low, int middle, int high) {
        this.temp = new int[this.nums.length];

        //System.out.println("Length : "+this.nums.length);

        for(int i = 0; i < this.nums.length; i++) {
            //System.out.println("Copy nums : "+i);
            this.temp[i] = this.nums[i];
        }

        int i = low;
        int j = middle + 1;
        int k = low;

        //System.out.println("Low : "+low+" Middle : "+middle+" High : "+high+" i : "+i+" j : "+j+" k : "+k);

        while(i<=middle && j<=high) {
            //System.out.println("Low : "+low+" Middle : "+middle+" High : "+high+" i : "+i+" j : "+j+" k : "+k);
            //System.out.println("Temp i : "+temp[i]+" Temp j : "+temp[j]);
            if(temp[i] <= temp[j]) {
                //System.out.println("condition 1");
                this.nums[k] = temp[i];
                i++;
            } else {
                //System.out.println("condition 2");
                this.nums[k] = temp[j];
                j++;
            }

            k++;
        }

        while(i<=middle) {
            //System.out.println("condition 3");
            this.nums[k] = temp[i];
            k++;
            i++;
        }

        while (j<=high) {
            //System.out.println("condition 4");
            this.nums[k] = temp[j];
            k++;
            j++;
        }
    }

    private void swap(int i, int j) {
        //System.out.println("Swapping "+i+" and "+j);
        int tempp = this.temp[i];
        this.temp[i] = this.temp[j];
        this.temp[j] = tempp;
    }
}
