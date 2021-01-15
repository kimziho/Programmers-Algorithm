package Hash;
import java.util.HashMap;
import java.util.Arrays;

public class º£½ºÆ®¾Ù¹ü {
	 public int[] solution(String[] genres, int[] plays) {
	        HashMap<String, Integer> first = new HashMap<String, Integer>();
	        HashMap<String, Integer> second = new HashMap<String, Integer>();
	        for(int i = 0; i < genres.length;i++){
	            if(first.containsKey(genres[i])){
	                if(plays[first.get(genres[i])] < plays[i]){
	                    first.put(genres[i], i);
	                }
	                    
	            }else{
	                first.put(genres[i], i);
	            }
	        }
	        
	        for(int i = 0; i < genres.length; i++){
	            if(!first.containsValue(i))
	                if(second.containsKey(genres[i])){
	                    if(plays[second.get(genres[i])] < plays[i])
	                        second.put(genres[i],i);
	                }else{
	                    second.put(genres[i],i);
	                }
	        }
	        int len = first.size() + second.size();
	        
	        int[] answer = new int[len];
	        for(int i = 0 ; i < len ; i++){
	            answer[i] = -1;
	        }
	        int[] temp = new int[len];
	        int k = 0;
	        for(String key : first.keySet()){
	            temp[k] = plays[first.get(key)];
	            k++;
	        }
	        for(String key : second.keySet()){
	            temp[k] = plays[second.get(key)];
	            k++;
	        }
	        Arrays.sort(temp);
	        k--;
	        for(int i = 0 ; i < temp.length ; i++){
	            int check = 0;
	            for(int j = 0 ; j < plays.length; j++){
	                if(plays[j] == -1)
	                    continue;
	                else{
	                    if(temp[k] == plays[j]){
	                    answer[i] = j;
	                    plays[j] = -1;
	                    check = 1;
	                        if(second.containsKey(genres[j])){
	                            i++;
	                            answer[i] = second.get(genres[j]);
	                            plays[second.get(genres[j])] = -1;
	                            break;
	                        }
	                    }    
	                }
	            }
	            k--;
	            if(check == 0)
	                i--;
	        }
	        return answer;
	    }
}
