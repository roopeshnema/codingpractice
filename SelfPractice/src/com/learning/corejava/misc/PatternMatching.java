package com.learning.corejava.misc;

public class PatternMatching {
	
	
	public static String calculateScore(String str, String preText, String postText) {
		
		int preCounter = 0;
		int finalPreIndex = 0;
		int finalPostIndex = 0;
		int postCounter = 0;
		for(int i=0;i<preText.length();i++) {
			int temp = 0;
			if(str.startsWith(""+preText.charAt(i))) {
				int preIndex = preText.indexOf(preText.charAt(i));						
				int j=0;
				while(preIndex < preText.length() && str.length() > j) {
					if(str.charAt(j) == preText.charAt(preIndex)){
						temp++;
					} else {
						break;
					}
					preIndex++;
					j++;
				}
				if(temp > preCounter)
					preCounter = temp; 
					finalPreIndex = preIndex - 1;
			}
		}
		
		for(int i=0;i<postText.length();i++) {
			int temp = 0;
			if(str.endsWith(""+postText.charAt(i))) {
				int postIndex = postText.indexOf(postText.charAt(i));						
				int j=str.length()-1;
				boolean flag = true;
				while(postIndex >= 0 && j >= 0) {
					
					if(str.charAt(j) == postText.charAt(postIndex)){
						temp++;
						if(flag) {
							finalPostIndex = postIndex;
							flag = false;
						}
					
					} else {
						break;
					}
					postIndex--;
					j--;
				}
				if(temp > postCounter)
					postCounter = temp; 
						
			}
		}		
		System.out.println("" + finalPreIndex + "" + finalPostIndex);	
		
		
		return  str.substring(str.indexOf(preText.charAt(finalPreIndex))-1,str.indexOf(postText.charAt(finalPostIndex))+1);
		
		
	}
	
	public static void main(String[] args) {
		String score = calculateScore("nothing","bruno","ingenious");
		System.out.println(score);
	}
	
}
