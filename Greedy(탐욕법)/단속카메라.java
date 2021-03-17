package Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class 단속카메라 {
	public int solution(int[][] routes) {
		int answer = 0;
		int len = routes.length;
		int[][] out = routes.clone();

		Arrays.sort(routes, new Comparator<int[]>(){
			public int compare(int[] a , int[] b){
				return a[0] - b[0];
			}
		});

		Arrays.sort(out, new Comparator<int[]>(){
			public int compare(int[] a , int[] b){
				return a[1] - b[1];
			}
		});
		int in_idx = 0;
		int temp = 0;
		for(int i = 0 ; i < len ; i++){
			int out_time = out[i][1];
			if(out_time == -1 || out_time < routes[in_idx][0])
				continue;
			int check = 0;
			for(int j = in_idx ; j < len ; j++){
				if(out_time >= routes[j][0]){
					routes[j][1] = -1;
					check++;
					temp = j+1;
				}else{
					break;
				}
			}
			if(check != 0)
				answer++;
			if(temp < len)
				in_idx = temp;
		}  
		return answer;
	}
}	
