//希尔排序

public class ShellSort{
    public static void main(String[] args){
        int[] arr = {2,1,12,22,11,9,5};
        int[] drr = {5,3,1};
        for(int i = 0;i < drr.length;i++){
            shellSort(arr,drr[i]);
        }
        System.out.println(Arrays.toString(arr));
    }

    //gap为所分的组数
    //希尔排序在组内其实就是一个直接插入排序
    public static void shellSort(int[] arr,int gap){
        for(int i = gap;i < arr.length;i++){
            int tmp = arr[i];
            int j = i-gap;
            for( ;j >= 0;j = j-gap){
                if(arr[j] > tmp){
                    arr[j+gap] = arr[j];
                }else{
                    break;
                }
            }
            arr[j+gap] = tmp;
        }
    }
}