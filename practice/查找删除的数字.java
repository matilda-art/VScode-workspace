//给0-n（n+1）个数字，放入容量为n的数组中，查找删除的那个数字

public int missingNumber(int[] nums){
    int i = 0;
    int j = nums.length-1;
    while(i <= j){
        int mid = (i+j)/2;
        if(nums[mid] == mid){
            i = mid+1;
        }else{
            j = mid-1;
        }
    }
    return i;
} 