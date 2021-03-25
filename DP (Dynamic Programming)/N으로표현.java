package DP;
import java.util.ArrayList;
public class N으로표현 {
	public int solution(int N, int number) {
        // 1개 먼저 체크
		// 2개 +*/- (4개)
		// 2+1         3
		// 3+1  2+2    4
		// 4+1 3+2     5
		// 5+1 4+2 3+3 6
		// 6+1 5+2 4+3 7
		int answer = 1;
		if(N == number)
			return answer;

		ArrayList<Integer> list2 = new ArrayList<>();
		ArrayList<Integer> list3 = new ArrayList<>();
		ArrayList<Integer> list4 = new ArrayList<>();
		ArrayList<Integer> list5 = new ArrayList<>();
		ArrayList<Integer> list6 = new ArrayList<>();
		ArrayList<Integer> list7 = new ArrayList<>();
        ArrayList<Integer> list8 = new ArrayList<>();
		list2.add(N);        

		for(int i = 0 ; i < 1 ; i++) {	//1+1
			int a = list2.get(i);
			plus(list2, N , a);
			minus(list2, N , a);
			mul(list2, N , a);
			div(list2, N , a);
		}
		answer++;
		NN(list2, N, answer);
		if(list2.contains(number))       // 2
			return answer;

		basic(list3, list2, N);			//2+1
		answer++;
		NN(list3, N, answer);
		if(list3.contains(number))       // 3
			return answer;

		basic(list4, list3, N);			//3+1
		addList(list4, list2, list2);	//2+2
		answer++;
		NN(list4, N, answer);
		if(list4.contains(number))       // 4
			return answer;

		basic(list5, list4, N);			//4+1
		addList(list5, list3, list2); 	//3+2
		answer++;
		NN(list5, N, answer);
		if(list5.contains(number))       // 5
			return answer;

		basic(list6, list5, N);			//5+1
		addList(list6, list4, list2);	//4+2
		addList(list6, list3, list3);	//3+3
		answer++;
		NN(list6, N, answer);
		if(list6.contains(number))       // 6
			return answer;

		basic(list7, list6, N);			//6+1
		addList(list7, list5, list2);   //5+2
		addList(list7, list4, list3);   //4+3
		answer++;
		NN(list7, N, answer);
		if(list7.contains(number))       // 7
			return answer;
        
        basic(list8, list7, N);			//7+1
		addList(list8, list6, list2);   //6+2
		addList(list8, list5, list3);   //5+3
        addList(list8, list4, list4);   //4+4
		answer++;
		NN(list8, N, answer);
		if(list8.contains(number))       // 8
			return answer;

		return -1;
        }
    
    public void basic(ArrayList<Integer> list, ArrayList<Integer> list2, int N) {
		for(int i = 0 ; i < list2.size() ; i++) {	//1+1
			int a = list2.get(i);
			plus(list, N , a);
			minus(list, N , a);
			mul(list, N , a);
			div(list, N , a);
		}
	}

	public void addList(ArrayList<Integer> list, ArrayList<Integer> list2, ArrayList<Integer> list3) {
		for(int i = 0 ; i < list2.size(); i++) {
			int a = list2.get(i);
			for(int j = 0; j < list3.size(); j++) {
				int b = list3.get(j);
				plus(list, a , b);
				minus(list, a , b);
				mul(list, a , b);
				div(list, a , b);
			}
		}
	}

    public void NN(ArrayList<Integer> list, int N, int answer) {
		String a = "";
		for(int i = 0 ; i < answer ; i++) {
			a += N;
		}
		list.add(Integer.parseInt(a));
	}
	
	public void plus(ArrayList<Integer> list, int N,int input) {
        if(!list.contains(input + N))
		    list.add(input + N);
	}
	public void minus(ArrayList<Integer> list, int N,int input) {
		if(input - N > 0) {
			if(!list.contains(input - N))
                if(input- N != 0)
				    list.add(input - N);
		}else {
			if(!list.contains(N - input))
                if(input- N != 0)
				    list.add(N - input);
		}
	}
	public void mul(ArrayList<Integer> list, int N,int input) {
        if(!list.contains(input * N))
		    list.add(input * N);
	}
	public void div(ArrayList<Integer> list, int N,int input) {
		if(input / N > 0)
            if(!list.contains(input / N))
			    list.add(input / N);
        if(N / input > 0)
            if(!list.contains(N / input))
			    list.add(N / input);
	}
}
