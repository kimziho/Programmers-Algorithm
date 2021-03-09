package Greedy;
import java.util.Arrays;
public class 구명보트 {
	public int solution(int[] people, int limit) {
		int answer = people.length;
		Arrays.sort(people);

		int i ; 
		int j = people.length-1;
		for(i=0 ; i < people.length; i++){
			if(i >= j)
				break;
			while(true){
				if(i == j || j < 0){
					break;
				}

				if(people[i]+people[j] <= limit){
					answer--;
					j--;
					break;
				}
				j--;
			}
		}
		return answer;
	}
}
