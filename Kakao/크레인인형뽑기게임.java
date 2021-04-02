package Kakao;
import java.util.ArrayList;

public class 크레인인형뽑기게임 {
	public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int len = board.length;
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i = 0 ; i < moves.length ; i++ ){
            int move = moves[i] -1 ;
            for(int j = 0 ; j < len ; j++){
                if(board[j][move] != 0){
                    if(list.size() == 0){
                        list.add(board[j][move]);
                        board[j][move] = 0;
                        break;
                    }
                    if(list.get(list.size()-1) == board[j][move]){
                        list.remove(list.size()-1);
                        answer++;
                    }else{
                        list.add(board[j][move]);
                    }
                    board[j][move] = 0; 
                    break;
                }
            }
        }
        
        
        return answer*2;
    }
}
