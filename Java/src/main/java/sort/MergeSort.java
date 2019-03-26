package sort;

public class MergeSort {

    public static void mergeSort(int[] arr){
        mergeSortBetween(arr,0,arr.length-1);
    }

    public static void mergeSortBetween(int[] arr,int low,int high){
        if (low>=high)return ;
        int mid = (low+high)/2;
        mergeSortBetween(arr,low,mid);
        mergeSortBetween(arr,mid+1,high);
        merge(arr,low,mid,high);

    }

    public static void merge(int[] arr,int low, int mid, int high){
        int i = low ;
        int j = mid+1;
        int[] tmpArr = new int[high-low+1];
        int tmpPosition = 0 ;
        while (i<=mid && j<=high){
            if (arr[i]<=arr[j]) tmpArr[tmpPosition++] = arr[i++];
            else tmpArr[tmpPosition++] = arr[j++];
        }
        if (i<=mid){
            while (i<=mid){
                tmpArr[tmpPosition++] = arr[i++];
            }
        }else{
            while (j<=high){
                tmpArr[tmpPosition++] = arr[j++];
            }
        }

        for(int k = 0;k<tmpArr.length;k++){
            arr[low++] = tmpArr[k];
        }
    }

    public static void main(String[] args) {
        int[] arr = {3,2,1,5};
        mergeSort(arr);
        for (int i:
             arr) {
            System.out.println(i);
        }
    }

}
