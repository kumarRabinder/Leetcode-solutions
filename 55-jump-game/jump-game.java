class Solution {
    public boolean canJump(int[] nums) {
        int last_index=nums.length-1;
        int far =0;
        for(int i=0;i<nums.length;i++){
            
            if(i > far) return false;
            
            far = Math.max(far,i+nums[i]);
            
            if(far >= last_index){
                return true;
            }
            
        }
        return false;
    }
}