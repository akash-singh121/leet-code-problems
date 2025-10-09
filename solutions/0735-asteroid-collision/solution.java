class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> Stack=new Stack<>();
        for (int a:asteroids){
            boolean destroyed= false;
            while (!Stack.isEmpty() && a<0 && Stack.peek() > 0){
                if (Stack.peek() < -a){

                    Stack.pop();
                    continue;
                }

                else if (Stack.peek() == -a){
                    Stack.pop();
                }
                destroyed =true;
                break;
            }
            if (!destroyed){
                Stack.push(a);

            }

        }
        int[] result =new int[Stack.size()];
        for (int i= result.length -1; i>=0; i--){
            result[i] = Stack.pop();
        }
        return result;
        
    }
}
