package StackAndQueue;

public class 주식가격 {
	public int[] solution(int[] prices) {        
        int[] answer = new int[prices.length];
        
        for(int i = 0 ; i < answer.length ; i++){
            if(i == answer.length-1)
                continue;
            for(int j = i+1 ; j < answer.length; j++){
                if(prices[i] > prices[j]){
                    answer[i] = j - i;
                    break;
                }
            }
            if(answer[i] == 0)
                answer[i] = answer.length-i-1;
        }   
        return answer;
    }
}
