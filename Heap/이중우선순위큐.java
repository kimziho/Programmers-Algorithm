package Heap;

import java.util.*;

public class 이중우선순위큐 {
	public int[] solution(String[] operations) {
		int[] answer = new int[2];

		HashMap<Integer, Integer> map = new HashMap<>();

		for(int i = 0 ; i < operations.length ; i++){


			if(operations[i].equals("D 1")){    //최댓값 삭제
				if(map.size() == 0)
					continue;
				PriorityQueue<Integer> rp = new PriorityQueue<>(Collections.reverseOrder());
				map.forEach((key, value)
						-> rp.add(key));
				int rm = rp.poll();
				map.remove(rm);
				continue;
			}
			else if(operations[i].equals("D -1")){  // 최솟값 삭제
				if(map.size() == 0)
					continue;
				PriorityQueue<Integer> p = new PriorityQueue<>();
				map.forEach((key, value)
						-> p.add(key));
				int rm = p.poll();
				map.remove(rm);
				continue;
			}else if(operations[i].contains("I")){  // 숫자 삽입
				map.put(Integer.parseInt(operations[i].substring(2)),Integer.parseInt(operations[i].substring(2)));
				continue;
			}
		}
		if(map.size() == 0)
			return answer;
		PriorityQueue<Integer> rp = new PriorityQueue<>(Collections.reverseOrder());
		map.forEach((key, value)
				-> rp.add(key));
		PriorityQueue<Integer> p = new PriorityQueue<>();
		map.forEach((key, value)
				-> p.add(key));

		if(!rp.isEmpty())
			answer[0] = rp.poll();
		if(!p.isEmpty())
			answer[1] = p.poll();

		return answer;
	}

}
