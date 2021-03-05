package 완전탐색;
import java.util.Arrays;
public class 모의고사 {
	public int[] solution(int[] answers) {


		int[] first = {1,2,3,4,5}; // length 5
		int[] second = {2,1,2,3,2,4,2,5}; // length 8
		int[] third = {3,3,1,1,2,2,4,4,5,5}; // length 10
		int[] point = new int[3];
		for(int i = 0 ; i < answers.length ; i++ ){
			if(answers[i] == first[i%5])
				point[0]++;
			if(answers[i] == second[i%8])
				point[1]++;
			if(answers[i] == third[i%10])
				point[2]++;
		}
		int[] temp = point.clone();
		Arrays.sort(point);
		int ans_len = 0;
		for(int i = 0 ; i < 3 ; i++){
			if(temp[i] == point[2])
				ans_len++;
		}
		int[] answer = new int[ans_len];
		int j = 0;
		if(temp[0] == point[2]){
			answer[j] = 1;
			j++;
		}
		if(temp[1] == point[2]){
			answer[j] = 2;
			j++;
		}
		if(temp[2] == point[2])
			answer[j] = 3;        


		return answer;
	}
}
