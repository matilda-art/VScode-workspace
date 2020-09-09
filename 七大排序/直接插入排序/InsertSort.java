//直接插入排序

public class InsertSort{
    public static void main(String[] args){
        int[] arr = {12,33,42,1,7,10};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void insertSort(int[] arr){
        //从第二项开始
        for(int i = 1;i < arr.length;i++){
            int tmp = arr[i];
            int j = i-1；
            for( ;j >= 0;j--){
                if(arr[j] > tmp){
                    arr[j+1] = arr[j];
                }else{
                    //arr[j+1] = tmp;
                    break;
                }
            }
            arr[j+1] = tmp;
        }
    }
}
