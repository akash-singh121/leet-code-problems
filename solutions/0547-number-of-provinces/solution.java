class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n =isConnected.length;
        boolean[] visited= new boolean[n];
        int provinces =0;
        for (int i=0; i<n; i++){
            if (!visited[i]){
                Queue<Integer> queue= new LinkedList<>();
                queue.offer(i);
                while(!queue.isEmpty()){
                    int city=queue.poll();
                    visited[city] =true;
                    for (int j=0; j<n; j++){
                        if (isConnected[city][j] ==1 && !visited[j]){
                            queue.offer(j);
                        }
                    }
                }
                provinces++;
            }
        }
        return provinces;    
    }
}
