//快速排序

public class QuickSort{
    public static void main(String[] args){
        int[] arr = {12,2,1,14,11,9,5,22};
        quickSort(arr);
        for(int i = 0;i < arr.length;i++){
            System.out.println(arr[i]);
        }
    }

    //快速排序
    public static void quickSort(int[] arr){
        quick(arr,0,arr.length-1);
    }

    //通过递归进行快速排序
    public static void quick(int[] arr,int left,int right){
        //递归结束的条件
        if(left >= right){
            return;
        }

        int par = partition(arr,left,right);
        //递归par左边的数组
        quick(arr,left,par-1);
        //递归par右边的数组
        quick(arr,par+1,right);
    }

    //找到基准位置par
    public static int partition(int[] arr,int low,int high){
        int tmp = arr[low];
        while(low < high){
            while(low < high && arr[high] >= tmp){
                high--;
            }
            arr[low] = arr[high];

            while(low < high && arr[low] <= tmp){
                low++;
            }
            arr[high] = arr[low];
        }
        //low == high
        arr[high] = tmp;
        return high;
    } 



    //快排优化
    public static void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    //三数取中法
    public static void three_nums_mid(int[] arr,int left,int right){
        //arr[mid] <= arr[left] <= arr[right]
        int mid = (left + right)/2;
        if(arr[mid] > arr[left]){
            swap(arr,mid,left);
        }
        if(arr[mid] > arr[right]){
            swap(arr,mid,right);
        }
        if(arr[left] > arr[right]){
            swap(arr,right,left);
        }
    }
    //通过递归进行快排
    public static void quick(int[] arr,int left,int right){
        if(left >= right){
            return;
        }

        //快排优化1 —— 当元素逐渐趋于有序时（当排序序列中的数据个数小于一定值），就可以使用直接插入
        if(right - left + 1 <= 100){
            inserSort(arr,left,right);
            return;
        }
        //快排优化2 —— 当元素已经有序，可以采用三数取中法
        three_nums_mid(arr,left,right);

        int par = partition(arr,left,right);
        quick(arr,left,par-1);
        quick(arr,par+1,right);
    }
}