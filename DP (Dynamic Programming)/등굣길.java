package DP;

public class 등굣길 {
	public int solution(int m, int n, int[][] puddles) {
		// 01 부터 갈 수 있는 방법을 더해나간다
		// puddles 부분은 피해가면 끝

		int[][] path = new int[m][n];
		for(int i = 0 ; i < puddles.length ; i++){
			path[puddles[i][0]-1][puddles[i][1]-1] = -1;
		}

		for(int i = 0 ; i < m ; i++){
			for(int j = 0 ; j < n ; j++){
				if(i==0 && j == 0){
					path[i][j] = 1;
					continue;
				}
				if(path[i][j] == -1)
					continue;
				if(i==0){
					path[i][j] += path[i][j-1];
					continue;
				}
				if(j == 0){
					path[i][j] += path[i-1][j];
					continue;
				}
				int up = path[i-1][j];
				int left = path[i][j-1];
				if(up != -1)
					path[i][j] += up;
				if(left != -1)
					path[i][j] += left;
				path[i][j] = path[i][j] % 1000000007;

			}
		}
		int answer = path[m-1][n-1];
		return answer;
	}
}
