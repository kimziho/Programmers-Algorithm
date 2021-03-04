package Heap;

import java.util.PriorityQueue;

public class 디스크컨트롤러 {
	public int solution(int[][] jobs) {
        int answer = 0;
        int time = 0;
        int min = jobs[0][0];
        int min_i = 0;
        for(int i = 0 ; i < jobs.length ; i++){
            if(jobs[i][0] < min){
                min = jobs[i][0];
                min_i = i;
            }
            if(min == 0)
                break;
        }
         // time += jobs[0][1];	// 시작이 0초가 아닐수도?
        answer = jobs[min_i][1];
        time = answer;
        jobs[min_i][0] = -1;
        int check = 0;
        while(true){
            
            if(check == jobs.length)
                break;
            check = 0;
            PriorityQueue<Integer> p = new PriorityQueue<>();
            
            for(int i = 0 ; i < jobs.length ; i++ ){
                if(jobs[i][0] == -1)
                {
                    check++;
                    continue;
                }
                if(jobs[i][0] <= time){
                    p.add(jobs[i][1]);
                }
            }
            
            if(!p.isEmpty()){
                int a = p.poll();
                for(int i = 0 ; i < jobs.length ; i++) {
                	if(jobs[i][0] == -1)
                		continue;
                	if(jobs[i][1] == a) {
                		time += a;
                		answer += (time - jobs[i][0]);
                		jobs[i][0] = -1;
                		break;
                	}
                }
                
            }else{
                time++;
            }

        }
        answer /= jobs.length;   
        return answer;
	}
}
