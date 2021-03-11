package Greedy;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;

public class 조이스틱 {
	public int solution(String name) {
        int answer = 0;
        
        int[] string_name = new int[name.length()];
        Queue<Integer> q = new LinkedList<>();
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0; i < name.length() ; i++){
            
            if(-65 + name.charAt(i) != 0 && i != 0){
                q.add(i);
                st.push(i);
            }
            string_name[i] += -65 + name.charAt(i);
            
            if(-65 + name.charAt(i) > 13)
                string_name[i] = 26 - (-65 + name.charAt(i)) ;
            
        }
        answer += string_name[0];
        int now = 0;
        while(!q.isEmpty()){
            int next = q.poll();
            int last = st.peek();
            
            int front = next - now ;
            int back = (string_name.length - last) + (now);
            
            if(front <= back){   // 정방향으로 가는게 빠를때
                answer += (string_name[next] + front);
            }else{  //뒤로 가는게 빠를때
                answer += (now+1) ;
                for(int i = string_name.length-1 ; i > next ; i--){
                    answer += (string_name[i]+1);
                }
                answer +=(string_name[next]);
                
                break;
                    
            }
            
            now = next ;    
        }
        
        // 너무 단순하게 해결하려 했다
        // 다음 A가 아닌 목적지가 뒤로가는게 더 빠르면 그떄부터 뒤로 쭉
        
        return answer;
    }
}
