package DFSandBFS;

public class 네트워크 {
	public int solution(int n, int[][] computers) { 
		int answer = 0;
		int[] connect = new int[n];

		for(int i = 0 ; i < n ; i++){
			connect[i] = i;
		}

		for(int i = 0 ; i < n ; i++){
			for(int j = 0 ; j < n ; j++){   // i -> j
				if(i==j)
					continue;

				if(computers[i][j] == 1) {	
					int a = find(connect, i);
					int b = find(connect, j);
					if(a != b) // union
						union(connect, a, b);
				}
			}
		}
		for(int i = 0 ; i < n ; i++){
			if(connect[i] == i)
				answer++;
		}
		return answer;
	}

	public int find(int[] connect, int a){
		if(connect[a] == a)
			return a;
		else{
			return find(connect, connect[a]);
		}
	}
	public void union(int[] connect , int a, int b){
		if(a < b)
			connect[b] = a;
		else{
			connect[a] = b;
		}
	}
}
