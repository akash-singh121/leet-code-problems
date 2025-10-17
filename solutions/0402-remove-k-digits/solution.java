class Solution{
    public String removeKdigits(String num, int K){
        if (K==num.length()) return "0";
        StringBuilder stack =new StringBuilder();
        for (char digit:num.toCharArray()){
            while (K>0 && stack.length() >0 && stack.charAt(stack.length()-1) > digit){
                stack.deleteCharAt(stack.length()-1);
                K--;
            }
            stack.append(digit);
        }
        while (K>0 && stack.length() >0){
            stack.deleteCharAt(stack.length()-1);
            K--;
        }
        int i=0;
        while (i< stack.length() && stack.charAt(i) == '0') i++;
        String result=(i == stack.length()) ? "0" : stack.substring(i);;
        return result;
    }
}
