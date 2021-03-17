package DP;

public class 정수삼각형 {
	public int solution(int[][] triangle) {
		int answer = 0;
		int len = triangle.length;

		for(int i = 1 ; i < len ; i++){
			for(int j = 0 ; j < i+1 ; j++){
				if(j == 0){ // 왼쪽경우
					triangle[i][j] +=triangle[i-1][0]; 
					continue;
				}
				else if(j == i){// 오른쪽경우
					triangle[i][j] +=triangle[j-1][j-1];
				}
				else{// 왼쪽 or 오른쪽 중 큰거 더하기
					int left = triangle[i-1][j-1];
					int right = triangle[i-1][j];
					if(left > right){
						triangle[i][j] += left;
					}else{
						triangle[i][j] += right;
					}
				}

			}
		}
		for(int i = 0 ; i < len ; i++ ){
			if(answer < triangle[len-1][i])
				answer = triangle[len-1][i];
		}
		return answer;
	}
}
