package Sort;
import java.util.Arrays;
public class H_Index {
	public int solution(int[] citations) {
		int answer = citations.length;
		Arrays.sort(citations);
		int[] temp = citations.clone();
		for(int i = 0 ; i < citations.length ; i++){
			citations[i] = temp[temp.length - (1+i)];
		}
		for(int i = 0 ; i < citations.length ; i++){
			if(citations[i] < (i+1) )
				return i;
		}
		return answer;
	}
}
