package Greedy;
import java.util.Arrays;
public class 구명보트 {
	public int solution(int[] people, int limit) {
        int answer = people.length;
        Arrays.sort(people);        
        
        int i = 0;
        int j = people.length-1;
        
        while(i < j){
            int sum = people[i] + people[j];
            if(sum <= limit){
                answer--;
                i++;
                j--;
            }else{
                j--;
            }   
        }
        return answer;
    }
}

