package Sort;
import java.util.Arrays;
public class K¹øÂ°¼ö {
	public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];     
        int a,b,c;   
        for(int i = 0 ; i < commands.length ; i++){
            a = commands[i][0];
            b = commands[i][1];
            c = commands[i][2];
            int[] temp = Arrays.copyOfRange(array, a-1, b);
            Arrays.sort(temp);
            answer[i] = temp[c-1];
        }
        return answer;
    }
}
