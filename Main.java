import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) {
		int n = 3;
		int[][] computers = {{1,1,0},{1,1,0},{0,0,1}};
//		int[][] computers = {{1,1,0},{1,1,1},{0,1,1}};
//		int n = 5;
//		int[][] computers = {{1,1,1,0,0},{1,1,0,1,0},{1,0,1,0,0},{0,1,0,1,1},{0,0,0,1,1}};
		
		System.out.println(new Solution().solution(n, computers));
	}

}
class Solution {
    public int solution(int n, int[][] computers) {
    	int answer = 0;
    	boolean[] visited = new boolean[n];
    	
    	Queue<Integer> queue = new LinkedList<Integer>();
    	for (int i = 0; i < n; i++) {
    		// 아직 네트워크 조사를 거치지 않았을 때 인접하는 computer를 queue에 넣어주고 조사거친것 체크, 네트워크 개수 +1
    		if (visited[i] == false) {
    			visited[i] = true;
    			for (int j = i + 1; j < n; j++) 
    				if (computers[i][j] == 1)
    					queue.add(new Integer(j));
    			answer++;
    		}
    		//	queue에 존재하는 모든 computer에 대해 bfs탐색
    		while(!queue.isEmpty()) {
    			Integer com = queue.remove();
    			if (visited[com] == false) {
    				visited[com] = true;
    				for (int j = 0; j < n; j++) 
        				if (computers[com][j] == 1)
        					queue.add(new Integer(j));
    			}
    		}
    	}
        return answer;
    }
}