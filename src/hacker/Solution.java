package hacker;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class Solution {
    public static int numberNeeded(String first, String second) {
    char [] fArr = first.toCharArray();
    char [] sArr = second.toCharArray();
     
    List<Character> fList = new ArrayList<Character>();
    for (char c : fArr) {
        fList.add(c);
    }
    
    List<Character> sList = new ArrayList<Character>();
    for (char c : sArr) {
        sList.add(c);
    }
    List<Character>tList = new ArrayList<Character>();
    for(Character c: fList){
    	if(sList.indexOf(c)>0){
    		tList.add(c);
    		sList.remove(c);
    	} 		
    	
    }
       
    int count = 0;    
    count += (fArr.length - tList.size() + sArr.length-tList.size());
       
    return count;
    }
  
    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        String a = "fsqoiaidfaukvngpsugszsnseskicpejjvytviya";
        String b = "ksmfgsxamduovigbasjchnoskolfwjhgetnmnkmcphqmpwnrrwtymjtwxget";
    	//String a = "cde";
    	//String b = "abc";
        System.out.println(numberNeeded(a, b));
    }
}