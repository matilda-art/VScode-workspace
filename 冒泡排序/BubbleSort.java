//冒泡排序

public class BubbleSort{
    public static void main(String[] args) {
        int[] arr = {12,2,7,1,9,5,4};
        bubbleSort(arr);
        System.out.println(Arrays.tostring(arr));
    }

    public static void bubbleSort(int[] arr){
        //外层循环控制每次排序的趟数
        for(int i = 0;i < arr.length-1;i++){
            //内层循环控制每一趟排序多少次
            for(int j = 0;j < arr.length-1-i;j++){
                if(arr[j] > arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
    }
}