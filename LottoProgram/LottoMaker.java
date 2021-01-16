import java.util.Random;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Arrays;

public class LottoMaker {
	public static void main(String[] args) {
		System.out.println("몇줄의 로또 번호를 원하십니까?");
		Scanner input = new Scanner(System.in);
		int a = input.nextInt();
		makeLotto(a);
	}

	private static void makeLotto(int input) {
		if(input == 0)
			return;
		Random rand = new Random();
		HashMap<Integer,Integer> check = new HashMap<Integer,Integer>();
		int[] temp = new int[6];
		int bonus = 0;
		for(int i = 0 ; i < 7 ; i++) {
			
			int lotto_num = rand.nextInt(45)+1;
			if(!check.containsValue(lotto_num)){
				if(i == 6) {
					bonus = rand.nextInt(45)+1;
					break;
				}
				temp[i] = lotto_num; 
				check.put(i, lotto_num);
			}else {
				i--;
			}
		}
		Arrays.sort(temp);
		for(int i = 0; i < temp.length ; i++) {
			System.out.print(temp[i]+"	");
		}
		System.out.print("보너스 번호 :"+bonus);
		System.out.println();
		makeLotto(input-1);
	}
		
}
