//二分查找

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {4,9,2,6,7,11};
        System.out.println(binarySearch(arr,7));
    }

    public static void binarySearch(int[] arr, int toFind){
        int left = 0;
        int right = arr.length-1;

        while(left <= right){
            int mid = (left + right) / 2;
            if(toFind < arr[mid]){
                right = mid - 1;
            }else if(toFind > arr[mid]){
                left = mid + 1;
            }else {
                return mid;
            }
        }
        return -1;
    }
}