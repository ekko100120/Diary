package mySort;

/**
 * Created by iak on 2016/11/23.
 */
public class myMergeSort {

    private int[] numbers;
    private int[] helper;
    public void sort(int[] array){

        this.numbers=array;
        this.helper=new int[array.length];
        mergesort(0,array.length-1);
    }
    private void mergesort(int low, int high){

        if(low<high){
            int mid =low+(high-low)/2;
            mergesort(low,mid);
            mergesort(mid+1,high);
            merge(low,mid,high);
        }
    }
    private  void merge(int start, int mid, int end){

        for(int i=start;i<=end;i++){
            helper[i] = numbers[i];
        }

        int i=start;
        int j=mid+1;
        int k=start;
        while (i<=mid&&j<=end){
            if(helper[i]<=helper[j]){
                numbers[k]=helper[i];
                i++;
            }else {
                numbers[k]=helper[j];
                j++;
            }
            k++;
        }
        while (i<=mid){
            numbers[k] =helper[i];
            k++;
            i++;
        }
        while (j<=end){
            numbers[k]=helper[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] array= { 12, 13, 24, 10, 3, 6, 90, 70,100,1000,1000,24 ,42, 153, 242, 1022, 323, 641, 920, 170,1020,100,120,240};
        myMergeSort sort= new myMergeSort();
        sort.sort(array);
        for(int i=0;i<array.length;i++){
            System.out.println(array[i]);
        }
    }

}
