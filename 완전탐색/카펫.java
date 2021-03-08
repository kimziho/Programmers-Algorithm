package ¿ÏÀüÅ½»ö;

public class Ä«Æê {
	public int[] solution(int brown, int yellow) {
		int[] answer = { 3, 3 };
		int sum = brown + yellow;
		int check = 1;
		while (true) {
			if (answer[0] * answer[1] == sum) {
				break;
			}
			answer[0]++;

			while (answer[1] <= answer[0]) { 
				if (answer[0] * answer[0] < sum)
					break;

				if (answer[0] * answer[1] == sum) {
					int a = (answer[0]*2)+ 2*(answer[1]-2);
					if( a == brown){
						check = 0;
						break; 
					}
				}
				answer[1]++;
			}

			if (check == 0)
				break;
			answer[1] = 3;
		}

		return answer;
	}
}
