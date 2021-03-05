package 완전탐색;

public class 모의고사 {
public int[] solution(int[] answers) {
        
        // 첫번째 는 12345  12345
        // 두번째는 21 23 24 25 21 23 24 25
        // 세번째는 33 11 22 44 55
        int[] one = new int[answers.length];
        int[] two = new int[answers.length];
        int[] three = new int[answers.length];
        int twocheck = 1;
        int threecheck = 1;
        
        int[] num = {0, 0, 0};
        for(int i = 0 ; i < answers.length ; i++){
            one[i] = (i+1) % 5 ;
            if(one[i] == 0)
	            	one[i] = 5;
            
            if(i % 2 == 0){
                two[i] = 2;
            }else{
                if(twocheck == 2)
                    twocheck++;
                two[i] = twocheck;
                twocheck++;
                if(twocheck == 6)
                    twocheck = 1;
            }
            if(threecheck <= 2){
                three[i] = 3;
                threecheck++;
            }
            else if(threecheck <= 4){
                three[i] = 1;
                threecheck++;
            }
            else if(threecheck <= 6){
                three[i] = 2;
                threecheck++;
            }
            else if(threecheck <= 8){
                three[i] = 4;
                threecheck++;
            }
            else if(threecheck <= 10){
                three[i] = 5;
                threecheck++;
            }
                
            if(threecheck == 11)
                threecheck = 1;
        }
        for( int i = 0 ; i < answers.length ; i++){
            if(answers[i] == one[i]){
                num[0]++;
            }
            if(answers[i] == two[i]){
                num[1]++;
            }
            if(answers[i] == three[i]){
                num[2]++;
            }
        }
        int max = 0 ;
        for(int i = 0 ; i < 3 ;i++){
            if(num[i] > max)
                max = num[i];
        }
        int length = 0;
        for(int i = 0 ; i < 3 ;i++){
            if(num[i] == max)
                length++;
        }
        int[] answer = new int[length];
        length = 0;
        for(int i = 0 ; i < 3 ;i++){
            if(max == 0){
                answer[length] = 0;
                break;
            }
            if(num[i] == max){
                answer[length] = i+1;
                length++;
            }
                
        }
           
        return answer;
    }
}
