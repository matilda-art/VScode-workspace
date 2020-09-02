//冒泡排序

public class BubbleSort{

    public static void main(String[] args){
        int[] arr = {23,12,44,5,1,15};
        bubbleSort{arr};
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr){
        //外层循环控制每次排序的趟数
        for(int i = 0;i < arr.length-1;i++){
            //内层循环控制每一次排序多少次
            for(int j = 0;j < arr.length-i-1;j++){
                if(arr[j] > arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
    } 
}