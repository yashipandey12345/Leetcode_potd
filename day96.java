class Solution {
    public int minSubarray(int[] nums, int p) {
        int  sum = 0;
        for(int i = 0;i<nums.length;i++){
            sum = (sum+nums[i])%p;
            // saaree cumalitive sum store krte
        }
        int target = sum%p;
        if(target == 0){
            return 0;
            // matlab tera sum hi divisible hai no operation reqd
        }
        HashMap<Integer,Integer>mapi = new HashMap<>();
        int curr = 0;
        mapi.put(0,-1);
        int ans = nums.length;
        // sum tee ohh kehdee index te aaya ohh store krro
        for(int j = 0;j<nums.length;j++){
            curr = (curr+nums[j])%p;
            // ehh curr agar mai dakhya va ta stor krr min length nu
            // nhita
            int remaining =  (curr-target + p)%p; 
            if(mapi.containsKey(remaining)){
                ans = Math.min(ans,j-mapi.get(remaining));
            }
            mapi.put(curr,j);
        }
        if(ans == nums.length){
            return -1;
        }
        return ans;
    }
}
