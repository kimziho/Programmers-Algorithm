package Heap;

import java.util.PriorityQueue;

public class ´õ¸Ê°Ô {
	public int solution(int[] scoville, int K) {
		int answer = 0;
		PriorityQueue<Integer> p = new PriorityQueue<>();
		for(int i = 0 ; i < scoville.length ; i++){
			p.add(scoville[i]);
		}
		while(true){
			int sc = p.poll();   
			if(sc >= K)
				break;
			if(p.isEmpty())
				return -1;
			sc = sc + (p.poll()*2);
			p.add(sc);    
			answer++;
		}
		return answer;
	}
}
