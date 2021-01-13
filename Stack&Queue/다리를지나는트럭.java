package StackAndQueue;
import java.util.*;
public class 다리를지나는트럭 {
	 public int solution(int bridge_length, int weight, int[] truck_weights) {
	        int answer = 0;
			Queue<Integer> q = new LinkedList<Integer>();  

			int[] going = new int[truck_weights.length];
			int[] time = new int[truck_weights.length];

			int j = 0;
			int sum = 0;
			int time_index = 0;
			while(true){
				if(time[truck_weights.length-1] == bridge_length) 
					break;

				if(time[time_index] == bridge_length){			
					sum -= q.poll();
					time_index++;
				}
				if(j < truck_weights.length)	
					if(sum+truck_weights[j] <= weight){
						q.add(truck_weights[j]);
						sum += truck_weights[j];
						going[j]++;
						j++;
					}
				for(int i = 0 ; i < time.length;i++) {
					if(going[i] == 1)
						time[i]++;
				}
				answer++;
			}
			answer++;
			return answer;
	    }

}
