package feb;

public class Feb02_20_04 {

//	문자열 myString이 주어집니다. 
//	myString에서 알파벳 "a"가 등장하면 전부 "A"로 변환하고, 
//	"A"가 아닌 모든 대문자 알파벳은 소문자 알파벳으로 변환하여 
//	return 하는 solution 함수를 완성하세요.
	
	public String solution(String myString) {
        String answer = "";
        
        String str = myString.toLowerCase();
        String[] arr = str.split("");
        
        for(int i =0; i < arr.length; i++) {
        	if(arr[i].equals("a")|| arr[i].equals("A")) {
        		arr[i] = arr[i].toUpperCase();
        	}
        }
        
        for(int i = 0; i<arr.length; i++) {
        	answer += arr[i];
        }
        
        return answer;
    }
	
}
