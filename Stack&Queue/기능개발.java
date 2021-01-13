package StackAndQueue;
import java.util.*;
public class 기능개발 {
	public int[] solution(int[] progresses, int[] speeds) {

		int[] days = new int[progresses.length];
		ArrayList<Integer> ans = new ArrayList<Integer>();
		for(int i = 0 ; i < speeds.length ; i++){
			int day = (100 - progresses[i]) / speeds[i];
			if(day*speeds[i] + progresses[i] == 100){
				days[i] = day;
			}else{
				days[i] = day+1;
			}
		}
		int a = 0;
		for(int i = a ; i < days.length; i++){
			int temp = 0;
			if(i!=a)
				continue;
			for(int j = i ; j < days.length; j++){
				if(days[j] <= days[i])
					temp++;
				else{
					a = j;
					break;
				}

			}
			if(temp != 0)
				ans.add(temp); 
		}
		int[] answer = new int[ans.size()];
		for(int i = 0 ; i < ans.size(); i++){
			answer[i] = ans.get(i);
		}
		return answer;
	}

}
