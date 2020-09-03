//归并排序

public class MergeSort{

    public static void main(String[] args){
        int[] arr = {12,2,1,14,11,9,5,22};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr){
        mergeSortInternal(arr,0,arr.length-1);
    }

    public static void mergeSortInternal(int[] arr,int left,int right){
        //递归结束的条件
        if(left >= right){
            return;
        }

        //分解
        int mid = (left + right)/2;
        mergeSortInternal(arr,left,mid);
        mergeSortInternal(arr,mid+1,right);

        //合并
        merge(arr,left,mid,right);
    }

    //合并
    public static void merge(int[] arr,int left,int mid,int right){
        int s1 = left;
        int s2 = mid+1;
        int len = right-left+1;
        //创建一个临时空间，用于存放合并之后的元素分类
        int[] ret = new int[len];
        int i = 0;//表示ret数组的下标
        //当两个分类都有元素时
        while(s1 <= mid && s2 <= right){
            if(arr[s1] <= arr[s2]){
                ret[i++] = arr[s1++];
            }else{
                ret[i++] = arr[s2++];
            }
        }
        while(s1 <= mid){
            ret[i++] = arr[s1++];
        }
        while(s2 <= right){
            ret[i++] = arr[s2++];
        }

        //合并好的元素存放在ret数组中，但最后打印的却是arr数组
        //需要将ret数组元素拷贝到arr数组中
        for(int j = 0;j < ret.length;j++){
            arr[j + left] = ret[j];
        }
    }
}