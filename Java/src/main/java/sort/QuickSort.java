package sort;


public class QuickSort {

    public static void quickSort(int[] arr){
        quickSortBetween(arr,0,arr.length-1);
    }

    private static  void quickSortBetween(int[] arr,int low,int high){
        if (low>=high)return ;
        int pivot = partition(arr,low,high);
        quickSortBetween(arr,low,pivot-1);
        quickSortBetween(arr,pivot+1,high);
    }

    private  static  int partition(int[] arr,int low,int high){
        int j = low ;
        int pivot = arr[low];
        int i = low + 1 ;
        while (i <= high){
            if (arr[i]<arr[low]){
                j ++ ;
                int tmp = arr[i];
                arr[i] =arr[j];
                arr[j] = tmp;
            }
            i++;
        }
        int tmp = arr[j];
        arr[j] =arr[low];
        arr[low] = tmp;
        return j;
    }

    public static void main(String[] args) {
        int[] arr = {3,2,14,6,1};
        quickSort(arr);
        for (int i:
             arr) {
            System.out.print(i+",");
        }
    }

}
