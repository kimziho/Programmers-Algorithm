package ¿ÏÀüÅ½»ö;

public class Ä«Æê {
	public int[] solution(int brown, int yellow) {
		int[] answer = new int[2];
		int a = 3 ;
		int b = 3 ;

		int sum = brown + yellow ;
		if(a*b == sum){ 
			answer[0] = a;
			answer[1] = b;
			return answer;
		}
		int i = 3;
		while(true){
			while(a >= i){
				if(a*i > sum)
					break;
				if(a*i == sum){
					if((a-2) * (i-2) == yellow) {
						answer[0] = a;
						answer[1] = i;
						return answer;
					}
				}
				i++;
			}
			a++;
			i=3;
		}
	}
}
