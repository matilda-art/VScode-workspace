//冒泡排序O(n²)
//比较相邻的元素，如果第一个比第二个大，则交换他们两个，就这样从第一对到最后一对
//排序，第一趟排序下来，最后的一个元素就是最大的元素，说明最后一个元素已经有序，
//之后可以不必进行比较。然后让越来越少的元素重复以上的步骤，直到所有的元素都有序。
//也就是说冒泡排序每一趟都会将一个元素挤到他对应的位置上，然后剩下的元素继续进行排序
public static void bubbleSort(int[] arr){
	for(int i = 0;i < arr.length-1;i++){
		for(int j = 0;j < arr.length-1-i;j++){
			if(arr[j] > arr[j+1]){
				int tmp = arr[j];
				arr[j] = arr[j+1];
				arr[j+1] = tmp;
			}
		}
	}
}
//选择排序O(n²)
//每次从待排序序列中选取一个最大或最小的元素，放在序列的起始位置，直到全部待排序序列排完
public static void selectSort(int[] arr){
	for(int i = 0;i < arr.length;i++){
		for(int j = i+1;j < arr.length;j++){
			if(arr[i] > arr[j]){
				int tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
			}
		}
	}
}
//直接插入排序O(n²)
//每一次将一个待排序的元素插入到已排序好的有序表中，从而得到一个新的有序表
public static void insertSort(int[] arr){
	for(int i = 1;i < arr.length;i++){
		int tmp = arr[i];
		int j = i-1;
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
//希尔排序O(n²)
//先选定一个整数，把所有待排序的元素分组，所有距离相同的元素分到一个组内，对组
//内元素进行排序，之后取出元素，重复上述分组和排序的工作，等分组的组数到达1时，
//所有的几句在统一的组内排好序
public static void shellSort(int[] arr){
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
//堆排序O(nlog₂n)
//是选择排序，只是不在使用遍历的方式查找最大或最小的元素，而是通过堆来选择
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
public static void createHeap(int[] arr){
	int i = (arr.length-1-1)/2;
	for( ;i >= 0;i--){
		adjustDown(arr,i,arr.length);
	}
}
public static void adjustDown(int[] arr,int root,int len){
	int parent = root;
	int child = 2*parent+1;
	
	while(child < len){
		if(child < len && arr[child] < arr[child+1]){
			child++;
		}
		if(arr[child] > arr[parent]){
			int tmp = arr[child];
			arr[child] = child[parent];
			arr[parent] = tmp;
			
			parent = child;
			child = 2*parent+1;
		}else{
			break;
		}
	}
}
//快速排序O(nlog₂n)
//从元素中取出一个基准数，将倒排序元素分割为两个部分，将比这个数大的放到右边，
//小于或等于它的数全放到它的左边，之后再对左右区间不断循环上述操作，直到有序
public static void quickSort(int[] arr){
	quick(arr,0,arr.length);
}
public static void quick(int[] arr,int left,int right){
	if(left >= right){
		return;
	}
	int par = parition(arr,0,arr.length);
	quick(arr,left,par-1);
	quick(arr,par+1,right);
}
public static int parition(int[] arr,int left,int right){
	int tmp = arr[left];
	while(left < right){
		if(left < right && arr[right] >= tmp){
			right--;
		}
		arr[left] = arr[right];
		if(left < right && arr[left] <= tmp){
			left++;
		}
		arr[right] = arr[left];
	}
	arr[right] = tmp;
	return right;
}
//归并排序O(nlog₂n)
//将已经有序的子序列合并，得到完全有序的序列，即先使每个子序列有序，再使子序列的段间有序
public static void mergeSort(int[] arr){
	mergeSortInternal(arr,0,arr.length);
}
public static void mergeSortInternal(int[] arr,int left,int right){
	if(left >= right){
		return;
	}
	
	int mid = (left+right)/2;
	mergeSortInternal(arr,0,mid);
	mergeSortInternal(arr,mid+1,right);
	
	merge(arr,left,mid,right);
}
public static void merge(int[] arr,int left,int mid,int right){
	int s1 = left;
	int s2 = mid+1;
	int len = right-left+1;
	int[] ret = new int[len];
	int i = 0;
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
	
	for(int j = 0;j < ret.length;j++){
		arr[j+left] = ret[j];
	}
}
