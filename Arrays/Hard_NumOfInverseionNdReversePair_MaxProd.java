package Arrays;
class Hard_NumOfInverseionNdReversePair_MaxProd {
    public int numofinversionbrute(int[] nums){
        int count = 0;
        for(int i=0;i<nums.length;i++){
            for(int j= i+1;j<nums.length;j++){
                if(nums[i]>nums[j]){
                    count++;
                }
            }
        }
        return count;
    }
    
    public int numofinversionoptimal(int[] nums){
        return mergesort(nums,0,nums.length-1);
    }
    private int mergesort(int[] nums, int low , int high){
        int count = 0;
        if(low>=high) return count;
        int mid = (high+low)/2;
        count = count + mergesort(nums,low,mid);
        count = count + mergesort(nums,mid+1,high);
        count  = count + countfn(nums,low,mid,high);
        return count;
    }
    private int countfn(int[] nums,int low,int mid,int high){
        int l = low;
        int r = mid+1;
        int count =0;
        int[] temp = new int[high-low+1];
        int k = 0;
        while(l<=mid&&r<=high){
            if(nums[l]>nums[r]){
                count = count + mid-l+1;
                temp[k++] = nums[r++];
            }
            else{
              temp[k++] = nums[l++];  
            }
        }
        while(l<=mid){
            temp[k++] = nums[l++];
        }
        while(r<=high){
            temp[k++] = nums[r++];
        }
        for(int i=0;i<temp.length;i++){
        nums[low+i] = temp[i];
    }
        return count;
    }
    
public int reversepair(int[] nums){
        return divide(nums,0,nums.length-1);
    }
    
    
private int divide(int[] nums,int low , int high){
    int c = 0;
    if(low>=high) return c;
    int mid = (high+low)/2;
    c = c+ divide(nums,low,mid);
    c= c+ divide(nums,mid+1,high);
    c = c + givecount(nums , low, mid , high);
    merge1(nums,low,mid,high);
    return c;
}    
private int givecount(int[] nums,int low,int mid, int high){
    int count = 0;
    // int l = low;
    int r = mid+1;
    for(int l = low;l<=mid;l++){
        while(r<=high && (long)nums[l]> 2L * nums[r]){
            r++;
        }
        count = count + r-(mid+1);
    }
    return count;
    }
 
private void merge1(int[] nums, int low, int mid , int high){
    int l = low;
    int r = mid+1;
    int[] temp = new int[high-low+1];
    int k = 0;
    while(l<=mid&&r<=high){
        if(nums[l]>nums[r]){
            temp[k++] = nums[r++];
        }
        else{
            temp[k++] = nums[l++];
        }
    }
    while(l<=mid){
        temp[k++] = nums[l++];
    }
    while(r<=high){
        temp[k++] = nums[r++];
    }
    for(int i=0;i<temp.length;i++){
        nums[low+i] = temp[i];
    }
}

private int maxproduct(int[] nums){
    int maxp = nums[0];
    int minp = nums[0];
    int ans = nums[0];
    for(int i=1;i<nums.length;i++){
        int curr = nums[i];
        if(curr<0){
            int temp = maxp;
            maxp = minp;
            minp = temp;
        }
        maxp = Math.max(curr,curr*maxp);
        minp = Math.min(curr,curr*minp);
        ans = Math.max(ans,maxp);
    }
    return ans;
}
    
    public static void main(String[] args) {
        Hard_NumOfInverseionNdReversePair_MaxProd m = new Hard_NumOfInverseionNdReversePair_MaxProd();
        int[] qst = {2,3,-2,4};
        // int[] qst = {5,7,9,3,1,2};
        // int[] qst2 = {-10, -5, 6, 11, 15, 17};
        // int ans = m.reversepair(qst);
        int ans = m.maxproduct(qst);
        System.out.println(ans);
    }
}