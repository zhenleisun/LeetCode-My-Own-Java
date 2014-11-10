package com.oj.practice;

import java.util.regex.Pattern;

public class ValidNumber {
	
	String reg = "( *)[+-]?(\\d+|\\d+\\.\\d*|\\d*\\.\\d+)([eE][lg]?[ln]?[+-]?\\d+)?";
	
	String regular = "\\d*(ln|lg)\\d+";

    
    String regex = "\\s*[-+]?(\\d*(lg|ln)?\\d+)?((\\d+\\.?)|(\\.\\d+))\\d*([eE][-+]?\\d+)?\\s*"; 
	
    
    public boolean isNumber(String s) {
    	
    	if(null == s || (0==s.trim().length()))
    		return false;
    	

    	if (s.length()<100000)
    		return s.matches(regex);
    	
    	/**/
    	s = s.trim();
    	if( (s.charAt(0) == '+') || (s.charAt(0) == '-')){
    		s = s.substring(1);
    		if(s.length()<1)
    			return false;
    	}
    	
    	if((1 < s.trim().length()) && isPureNumber(s.replaceFirst("\\.", "1"))){
    		return true;
    	}
    	
    	if(s.endsWith("%")){
    		s = s.substring(0, s.length()-1);
    		if(!(1 == s.length()) && isPureNumber(s.replaceFirst("\\.", "1"))){
        		return true;
        	}
    		return false;
    	}
    	else if(!s.startsWith("/") && (!s.trim().endsWith("/")) && isPureNumber(s.replaceFirst("/", "1"))){
    		
    		return true;
    	}
    	else if(!s.startsWith("e") && (!s.endsWith("e")) && isPureNumber(s.replaceFirst("e", "1"))){
    		
    		return true;
    	}
    	else if((!s.endsWith("lg")) && isPureNumber(s.replaceFirst("lg", "1"))){
    		
    		return true;
    	}
    	else if((!s.endsWith("ln")) && isPureNumber(s.replaceFirst("ln", "1"))){
    		
    		return true;
    	}
    	else
    		return isPureNumber(s.trim());
    	
    }
    
    public boolean isPureNumber(String str){
    	
    	if(null == str){
    		return true;
    	}
    	
    	str = str.trim();
    	
		for(int i=0; i<str.length(); i++){
			if ((str.charAt(i)>='0') && (str.charAt(i)<='9')){
				continue;
			}
			else{
				return false;
			}
		}
		
		return true;
    		
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ValidNumber vn = new ValidNumber();
		String str;
		
		str = " ";
		System.out.println(str+" is number:"+vn.isNumber(str));
		
		str = ".6";
		System.out.println(str+" is number:"+vn.isNumber(str));
		
		str = "2/5";
		System.out.println(str+" is number:"+vn.isNumber(str));
		
		str = "1.2323234.";
		System.out.println(str+" is number:"+vn.isNumber(str));
		
		str = "0.2";
		System.out.println(str+" is number:"+vn.isNumber(str));
		
		str = "30.5%";
		System.out.println(str+" is number:"+vn.isNumber(str));
		
		str = "2e5";
		System.out.println(str+" is number:"+vn.isNumber(str));
		
		str = "3lg5";
		System.out.println(str+" is number:"+vn.isNumber(str));
		
		str = "5ln5";
		System.out.println(str+" is number:"+vn.isNumber(str));
		
		str = "loge20";
		System.out.println(str+" is number:"+vn.isNumber(str));
		
		str = "1212431232 54246537456869";
		System.out.println(str+" is number:"+vn.isNumber(str));
		
		str = "2e4%2";
		System.out.println(str+" is number:"+vn.isNumber(str));
		
		str = ".6";
		System.out.println(str+" is number:"+vn.isNumber(str));
		
		str = "3.";
		System.out.println(str+" is number:"+vn.isNumber(str));
		
		str = "e9";
		System.out.println(str.trim()+" is number:"+vn.isNumber(str));
		
		str = "3.%";
		System.out.println(str.trim()+" is number:"+vn.isNumber(str));
		
		str = ".3%";
		System.out.println(str.trim()+" is number:"+vn.isNumber(str));
		
		str = " .";
		System.out.println(str.trim()+" is number:"+vn.isNumber(str)+!str.trim().endsWith("\\.")+ str.replaceFirst("\\.", "1"));

		str = " -.";
		System.out.println(str.trim()+" is number:"+vn.isNumber(str)+!str.trim().endsWith("\\.")+ str.replaceFirst("\\.", "1"));

		str = "+ .";
		System.out.println(str.trim()+" is number:"+vn.isNumber(str));
		
		str = "+ 1";
		System.out.println(str.trim()+" is number:"+vn.isNumber(str));
		
		str = " +.3e2   ";
		System.out.println(str.trim()+" is number:"+vn.isNumber(str)+!str.trim().endsWith("\\.")+ str.replaceFirst("\\.", "1"));
	}

}
