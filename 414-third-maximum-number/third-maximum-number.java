class Solution {
    public int thirdMax(int[] nums) {
        Long first =Long.MIN_VALUE;
        Long second =Long.MIN_VALUE;
        Long third =Long.MIN_VALUE;
        for(int i=0;i<nums.length ; i++){
            if(nums[i] == first || nums[i] == second || nums[i] == third){
                continue;
            }
            if(nums[i] > first){
                third = second;
                second = first;
                first = (long)nums[i];
            }else if(nums[i] > second){
                third = second;
                second = (long)nums[i];
            }else if(nums[i] > third){
                third = (long)nums[i];
            }
        }
        return third == Long.MIN_VALUE ? first.intValue() : third.intValue() ;
    }
}