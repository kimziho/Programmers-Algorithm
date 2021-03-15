package 완전탐색;
import java.util.ArrayList;
public class 소수찾기 {
	public int solution(String numbers) {
		int answer = 0;

		ArrayList<Integer> list = new ArrayList<>();


		int[] number = new int[numbers.length()];

		for(int i = 0 ; i <numbers.length() ; i++){
			number[i] = Integer.parseInt(numbers.substring(i,i+1));
		}
		for(int i = 1 ; i < numbers.length()+1 ; i++){
			boolean[] visited = new boolean[numbers.length()];
			num(number , visited, numbers.length() , i, list , 0);
		}

		for(int i = 0 ; i < list.size() ; i++) {
			int a = list.get(i);
			if(a == 1 || a== 0)
				continue;
			int check = 0;
			for(int j = 2 ; j < a ; j++ ) {
				if(a % j == 0 ) {
					check = 1;
					break;
				}
			}
			if(check == 0)
				answer++;
		}
		return answer;
	}

	void num(int[] number ,boolean[] visited, int length, int r, ArrayList<Integer> list, int seq_len) {

		for(int i = 0 ; i < length ; i++) {
			int[] seq = new int[r];
			seq[0] = number[i];
			visited[i] = true;
			next(number, visited, length ,r, list,seq_len+1, seq);
			visited[i] = false;
		}
	}
	void next(int[] number, boolean[] visited, int length, int r, ArrayList<Integer> list, int seq_len, int[] seq ) {
		if(seq_len == r) {
			print(seq , list);
			return;
		}

		for(int i = 0 ; i < length ; i++) {
			if(visited[i] != true) {
				seq[seq_len] = number[i];
				visited[i] = true;
				next(number, visited, length ,r, list,seq_len+1, seq);
				visited[i] = false;
			}
		}
	}

	void print(int[] seq, ArrayList<Integer> list) {
		String a = "";
		for(int i = 0 ; i < seq.length ; i++) {
			a += seq[i];
		}
		int b = Integer.parseInt(a);
		if(!list.contains(b))
			list.add(b);
	}
}
