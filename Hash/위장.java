package Hash;
import java.util.HashMap;
public class ¿ß¿Â {
	public int solution(String[][] clothes) {
        int answer = 1;
        int len = clothes.length;
        HashMap<String, Integer> num = new HashMap<String, Integer>();
        
        for(int i = 0; i<len ; i++){
            if(num.containsKey(clothes[i][1]))
				num.put(clothes[i][1],num.get(clothes[i][1])+1);
			else{
				num.put(clothes[i][1],1);    
			}
        }
        
        
        
        if(num.size() !=1){
            for( String key : num.keySet() ){
			    answer = answer * (num.get(key)+1);     
		    }
            answer --;
        }
            
        else{
            for( String key : num.keySet() ){
			    answer = answer * num.get(key);     
		    }
        }
 
        return answer;
    }
}
