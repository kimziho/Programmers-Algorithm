package Sort;
import java.util.Arrays;
public class K¹øÂ°¼ö {
	public int[] solution(int[] array, int[][] commands) {
        int length = commands.length;
        int[] answer = new int[length];
        for(int i = 0 ; i < length ; i++){
            int first = commands[i][0];
            int second = commands[i][1];
            int dst = commands[i][2];
            int[] newarray = new int[second - first +1];
            for( int j = 0 ; j < newarray.length ; j++){
                newarray[j] = array[first-1+j];
            }
            Arrays.sort(newarray);
            answer[i] = newarray[dst-1];
        }
        
        return answer;
    }
}
