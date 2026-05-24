class Solution {
    public int[] limitOccurrences(int[] nums, int k) {
        List <Integer>list =new LinkedList<>();
        int count  =0;
        int previous =-1;
        for (int present : nums){
            if (present == previous){
                count++;
            }
            else{
                previous = present;
                count=1;
            }
            if(count <=k){

                list.add(present);
            }
            
        }
        int[] jawab =new int[list.size()];
            int current =0;
            for (Integer  num :list){
                jawab[current++]=num;
            
        }
        return jawab;
    }
}
