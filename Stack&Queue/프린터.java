package StackAndQueue;
import java.util.*;
public class «¡∏∞≈Õ {
	public int solution(int[] priorities, int location) {
		int answer = 0;

		Queue<int[]> q = new LinkedList<int[]>();

		for(int i = 0 ; i < priorities.length ; i++){
			q.add(new int[] {i,priorities[i]});
		}
		while(true){
			int[] a = q.poll();
			boolean out = true;

			for(int i = 0 ; i < priorities.length; i++){
				if(a[1] < priorities[i]){
					q.add(a);
					out = false;
					break;
				}
			}
			if(out == true){
				priorities[a[0]] = -1;
				answer++;
				if(a[0] == location)
					break;
			}
		}
		return answer;
	}

}
