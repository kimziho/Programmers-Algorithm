package Greedy;

public class 큰수만들기 {
	public String solution(String number, int k) {
		String answer = "";

		int[] temp = new int[number.length()];
		for(int i = 0 ; i < temp.length ; i++){
			temp[i] = Integer.parseInt(number.substring(i,i+1));
		}
		int start_idx = 0;
		int max_idx = 0;
		while(k > 0) {
			if(k == temp.length - start_idx) {
				for(int i = max_idx+1 ; i < temp.length ; i++) {
					temp[i] = -1;
					k--;
				}
			}
			max_idx= maxnum(temp, k, start_idx);
			if(start_idx == max_idx) {
				start_idx++;
				continue;
			}else {
				for(int i = start_idx ; i < max_idx ; i++){
					temp[i] = -1;
					k--;
				}
				start_idx = max_idx;
			}
		}
		for(int i = 0 ; i < temp.length ; i++) {
			if(temp[i] != -1)
				answer+= temp[i];
		}
		return answer;
	}

	public static int maxnum(int[] temp, int k, int start_idx) {
		int max = -1;
		int max_idx = -1;
		for(int i = 0 ; i < k+1 ; i++){ // 앞자리수 정하기
			if(max == 9)
				break;
			if(temp[i+start_idx] > max){
				max = temp[i+start_idx];
				max_idx = i+start_idx;
			}
		}
		return max_idx;
	}
}
