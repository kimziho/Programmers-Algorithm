package Hash;

import java.util.HashMap;

public class 완주하지못한선수 {
	public String solution(String[] participant, String[] completion) {
		String answer = "";
		HashMap<String,Integer> par = new HashMap<String,Integer>();
		for(int i = 0 ; i < participant.length;i++){
			if(par.containsKey(participant[i]))
				par.put(participant[i],par.get(participant[i])+1);
			else{
				par.put(participant[i],1);    
			}
		}
		for(int i = 0 ; i < completion.length;i++){
			if(par.containsKey(completion[i]))
				par.put(completion[i],par.get(completion[i])-1);
		}
		for( String key : par.keySet() ){
			if(par.get(key) == 1){
				answer = key;
				break;
			}       
		}
		return answer;
	}
}
