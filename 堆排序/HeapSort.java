//堆排序

public class HeapSort{
    public static void main(String[] args){
        int[] arr = {12,2,1,14,11,9,5,22};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void heapSort(int[] arr){
        createHeap(arr);
        int end = arr.length-1;
        while(end > 0){
            int tmp = arr[0];
            arr[0] = arr[end];
            arr[end] = tmp;

            adjustDown(arr,0,end);
            end--;
        }
    }

    //创建堆
    public static void createHeap(int[] arr){
        //从最后一个不为叶子节点的节点开始进行向下调整
        int i = (arr.length-1-1)/2;
        for( ;i >= 0;i--){
            adjustDown(arr,i,arr.length);
        }
    }

    //向下调整：创建大根堆
    public static void adjustDown(int[] arr,int root,int len){
        int parent = root;
        int child = 2*parent+1;

        //说明最起码有左孩子
        while(child < len){
            if(child+1 < len && arr[child] < arr[child+1]){
                child++;
            }
            if(arr[child] > arr[parent]){
                //交换孩子节点与父节点的值
                int tmp = arr[child];
                arr[child] = arr[parent];
                arr[parent] = tmp;

                //进一步交换
                parent = child;
                child = 2*parent+1;
            }else{
                break;
            }
        }
    }
}