package Arrays;
import java.util.Stack;
class Stackdailytemp_nextGreater  {
    
     public int[] dailyTemperatures(int[] nums) {
        //739
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[nums.length];
       for(int i=nums.length-1;i>=0;i--){
       while(!st.isEmpty()&&nums[st.peek()]<=nums[i]){
           st.pop();
       }
       ans[i] = st.isEmpty() ? 0 : st.peek()-i;
     st.push(i);
       }
     return ans;
    }
    
    public int[] nextGreaterElements(int[] nums) {
    Stack<Integer> st = new Stack<>();
        int[] ans = new int[nums.length];
       for(int i=nums.length-1;i>=0;i--){
       while(!st.isEmpty()&&st.peek()<=nums[i]){
           st.pop();
       }
       ans[i] = st.isEmpty() ? -1 : st.peek();
     st.push(nums[i]);
       }
     return ans;   
    }
    
    public static void main(String[] args) {
        Stackdailytemp_nextGreater  m = new Stackdailytemp_nextGreater ();
        int[] qstn = {70,71,69,74,81};
        int[] ans = m.nextGreaterElements(qstn);
        for(int i=0;i<ans.length;i++){
            System.out.println(ans[i]);
        }
    }
}
