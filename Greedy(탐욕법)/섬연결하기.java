package Greedy;
import java.util.HashMap;
import java.util.Arrays;
import java.util.Comparator;

public class 섬연결하기 {
	public int solution(int n, int[][] costs) {
		int answer = 0;
		HashMap<Integer,Integer> map = new HashMap<>();
		Arrays.sort(costs, new Comparator<int[]>() {
			public int compare(int[] a, int[] b){
				return a[2] - b[2];
			}
		});
		map.put(costs[0][0],costs[0][0]);
		map.put(costs[0][1],costs[0][0]);
		answer += costs[0][2];
		int check = 2;
		for(int i = 1 ; i < costs.length ; i++){
			if(check == n)
				break;
			if(!map.containsKey(costs[i][0]) && !map.containsKey(costs[i][1])) { // 둘다 없을 때
				map.put(costs[i][0],costs[i][0]);
			map.put(costs[i][1],costs[i][0]);
			answer += costs[i][2];
			check++;
			continue;
			}
			if(!map.containsKey(costs[i][0]) || !map.containsKey(costs[i][1])) { // 둘중 한 값이 없을 때
				if(!map.containsKey(costs[i][0])) {
					map.put(costs[i][0], costs[i][1]);
				}else {
					map.put(costs[i][1], costs[i][0]);
				}
				answer +=costs[i][2];
				check++;
				continue;
			}
			if(map.containsKey(costs[i][0]) && map.containsKey(costs[i][1])) {
				int a = find(map, costs[i][0]);
				int b = find(map, costs[i][1]); 
				if( a != b ) { // 사이클 형성X
					if( a == costs[0][0]) {
						map.put(costs[i][1], a);
						map.put(b, a);
					}else {
						map.put(costs[i][0], b);
						map.put(a,b);
					}
					answer +=costs[i][2];
					check++;
				}
			}
		}
		return answer;
	}
	public int find(HashMap<Integer,Integer> map, int a) {
		if(map.get(a) == a)
			return a;
		else {
			return find(map,map.get(a));
		}
	}
}
