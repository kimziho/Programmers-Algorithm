package Greedy;

public class 체육복 {
	public int solution(int n, int[] lost, int[] reserve) {
		int answer = n;
		for(int i = 0 ; i < lost.length ; i++){ // 여분있고 도난
			for(int j = 0 ; j < reserve.length; j++){
				if(lost[i] == reserve[j]){
					lost[i] = -1;
					reserve[j] = n+n;
				}
			}
		}
		for(int i = 0 ; i < lost.length ; i++){
			int check = 0 ;
			for(int j = 0 ; j < reserve.length ; j++){

				if(lost[i]+1 == reserve[j] || lost[i]-1 == reserve[j]){ // 빌릴수 있음
					check++;
					reserve[j] = n+n;
					break;
				}
			}
			if(check == 0 && lost[i] != -1 ){   // 못빌림
				answer--;
			}
		}
		return answer;
	}
}
