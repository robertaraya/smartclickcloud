package smartclick.cloud;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SmartclickcloudApplicationTests {

	//@Test
	public void contextLoads() {
		name = "";
		String s1 = "Java";
		String s2 = "Java";
		StringBuilder sb1 = new StringBuilder();
		sb1.append("Ja").append("va");
		
		OUTER: for (int i = 0; i < 3;)
			INNER: do {
				i++;
				System.out.println(i);
			} while(i<2);
		
		System.out.println(s1 == s2);
		System.out.println(s1.equals(s2));
		System.out.println(sb1.toString() == s1);
		System.out.println(sb1.toString().equals(s1));
		System.out.println(1 % 3);
		System.out.println(3 % 3);
		System.out.println(5 % 3);
	
		List<Integer> list = new ArrayList<Integer>();
		int y = 9;
		list.add(--y);
		System.out.println(list);
		
	}
	
	@Test
	public void testArrays() {
//		List<String> list1 = new ArrayList<String>();1230000
//		List<String> list2 = new ArrayList<String>();
		long start = System.currentTimeMillis();
		IntStream.range(0, 10000000).forEach(i -> {
			containLetter("name", "caracteristic");
		});
		long elapsedTime = System.currentTimeMillis() - start;
		System.out.println("Array 1: " + elapsedTime/1000F);
	}
	
	@Test
	public void testArrays2() {
//		List<String> list1 = new ArrayList<String>();1230000
//		List<String> list2 = new ArrayList<String>();
		long start = System.currentTimeMillis();
		IntStream.range(0, 10000000).forEach(i -> {
			containLetter2("name", "caracteristic");
		});
		long elapsedTime = System.currentTimeMillis() - start;
		System.out.println("Array 2: " + elapsedTime/1000F);
	}
	
	@Test
	public void testArrays3() {
//		List<String> list1 = new ArrayList<String>();1230000
//		List<String> list2 = new ArrayList<String>();
		long start = System.currentTimeMillis();
		IntStream.range(0, 10000000).forEach(i -> {
			containLetter3("name", "caracteristic");
		});
		long elapsedTime = System.currentTimeMillis() - start;
		System.out.println("Array 3: " + elapsedTime/1000F);
	}
	
	public boolean containLetter3(String s1, String s2) {
		char[] charArray = s1.toCharArray();
		//final int len = charArray.length;
		for (int i = 0; i < charArray.length; i++) {
			if (s2.contains(Character.toString(charArray[i]))) {
				return true;
			}
		}
		return false;
	}
	
	public boolean containLetter(String s1, String s2) {
		String[] wordArray = s1.split("");
		for (String letter : wordArray) {
			if (s2.contains(letter)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean containLetter2(String s1, String s2) {
		String[] wordArray = s1.split("");
		for (String letter : wordArray) {
			if (s2.indexOf(letter) > -1) {
				return true;
			}
		}
		return false;
	}
	
	@Test
	public void tested() {
		    int VALID = 1;
		    int INVALID = 2;
		    int ERROR = 3;
		  

		    //Given a string composed only by round parentheses
		    //check that all the opening parentheses has a matching closing one
		    //Nested parentheses should be closed before their parent
		    String array1 = "()()"; 
		    String array2 = ")()(())()"; 
		    String array3 = "((((()))"; 
		    String array4 = "((())()(()()"; 
		    String array5 = "((()))()()(())";
		    String array6 = "())()()"; 

		    //
		    
		    System.out.println(validateParentheses(array1) == VALID ?  "PASSED": "FAILED"); 
		    System.out.println(validateParentheses(array2) == INVALID ?  "PASSED": "FAILED"); 
		    System.out.println(validateParentheses(array3) == INVALID ?  "PASSED": "FAILED"); 
		    System.out.println(validateParentheses(array4) == INVALID ?  "PASSED": "FAILED");
		    System.out.println(validateParentheses(array5) == VALID ?  "PASSED": "FAILED"); 
		    System.out.println(validateParentheses(array6) == INVALID ?  "PASSED": "FAILED");

	}
	
	public  int validateParentheses(String text){
		int VALID = 1;
	    int INVALID = 2;
	    int ERROR = 3;
	    
		char[] charArray = text.toCharArray();
		
		int openParentheses = 0;
		int closedParentheses = 0;
		
		char openParenthese = '(';
		char closedParenthese = ')';
		
		if(charArray[0] == closedParenthese){
			return INVALID;
		}
		
		for (int i = 0; i < charArray.length; i++) {
			char charLetter = charArray[i];
			
			if(charLetter == openParenthese){
				openParentheses++;
			}
			else {
				closedParentheses++;  
			}
			
			if(closedParentheses > openParentheses) {
				return INVALID;
			}
		}
		
		return closedParentheses == openParentheses ? VALID : INVALID;
	}
		
	private String name;

}
