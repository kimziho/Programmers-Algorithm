package Sort;
import java.util.Arrays;
public class 가장큰수 {
	public String solution(int[] numbers) {
		String answer = "";

		String[] Snumber = new String[numbers.length];
		for(int i = 0 ; i < numbers.length ; i++){
			Snumber[i] = Integer.toString(numbers[i]);
		}
		Arrays.sort(Snumber, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
		if(Snumber[0].equals("0"))
			answer += Snumber[0]; 
		else{
			for(int i = 0 ; i < numbers.length; i++){  
				answer += Snumber[i];
			}
		}
		return answer;
	}
}
