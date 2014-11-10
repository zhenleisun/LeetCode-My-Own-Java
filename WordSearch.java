package com.oj.practice;

import java.util.Stack;

public class WordSearch {
	
	private class Position{
		int row, colum;
		
		public Position(){
			
		}
		public Position(int row, int colum){
			this.row = row;
			this.colum = colum;
		}
		public int getRow(){
			return this.row;
		}
		public int getColum(){
			return this.colum;
		}
		public String toString(){
			return "row:"+this.row+",colum:"+this.colum;
		}
	}
	
    public boolean exist(char[][] board, String word) {
    	int row = board.length;
    	int colum = board[0].length;
    	int[][] haveWalk = new int[row][colum];
    	int wordIndex = 0;
    	
    	Position position, previousPop=new Position();
    	Stack<Position> stack = new Stack<Position>();
    	
    	if(word.length()>row*colum){
    		return false;
    	}
    	for(int i=0; i<row; i++){
    		for(int j=0; j<colum; j++){
    			if (board[i][j] == word.charAt(0)){
    				
    				/*store the first char position in the board*/
    				position = new Position(i,j);
    				stack.push(position);
    				haveWalk = new int[row][colum];
    				haveWalk[i][j] = 1;
    				wordIndex = 0;
    				
    				while((!stack.empty()) && (wordIndex<word.length()-1)){
    					
    					/*search next char in the word*/
    					wordIndex++;
    					
    					if( (i-1>=0) && (word.charAt(wordIndex)==board[i-1][j]) && (0 == haveWalk[i-1][j])){
    						position = new Position(i-1,j);
    						stack.push(position);
    						haveWalk[i-1][j] = 1;
    						i--;
    					}
    					else if( (i+1<row) && (word.charAt(wordIndex)==board[i+1][j]) && (0 == haveWalk[i+1][j])){
    						position = new Position(i+1,j);
    						stack.push(position);
    						haveWalk[i+1][j] = 1;
    						i++;
    					}
    					else if( (j-1>=0) && (word.charAt(wordIndex)==board[i][j-1]) && (0 == haveWalk[i][j-1])){
    						position = new Position(i,j-1);
    						stack.push(position);
    						haveWalk[i][j-1] = 1;
    						j--;
    					}
    					else if( (j+1<colum) && (word.charAt(wordIndex)==board[i][j+1]) && (0 == haveWalk[i][j+1])){
    						position = new Position(i,j+1);
    						stack.push(position);
    						haveWalk[i][j+1] = 1;
    						j++;
    					}
    					else{
    						stack.pop();
    						
    						if(stack.isEmpty()){
    							break;
    						}
    						else{
    							wordIndex-=2;
    							position = stack.peek();
    							i = position.row;
        						j = position.colum;
    						}
    					}
    				}
    				if(!stack.empty()){
    					
    					while(!stack.empty()){
    						System.out.println(stack.pop()+";");
    					}
    					return true;
    				}
    			}
    		}
    	}
    	
		/**/
		if(stack.isEmpty()){
			return false;
		}
		else{
			
			System.out.println("Last----!!!");
			while(!stack.empty()){
				System.out.println(stack.pop()+";");
			}
			
			return true;
		}
    	
    }
    
    public static void main(String[] args){
    	
    	char[][] board = {{'A','B','C','E'},
    					  {'S','F','E','S'},
    					  {'A','D','E','E'}};
    	WordSearch ws = new WordSearch();
    	
    	String word;
    	
    	word = "ABCESEEEFS";
    	System.out.println(word + ws.exist(board, word));
    	
    	char[][] board2 = {{'a','b'},{'c','d'}};
    	word = "abcd";
    	System.out.println(word + ws.exist(board2, word));
    	
    	word = "SEE";
    	System.out.println(word + ws.exist(board, word));
    	
    	word = "ABCCED";
    	System.out.println(word + ws.exist(board, word));
    	
    	word = "ADEF";
    	System.out.println(word + ws.exist(board, word));
    	
    	word = "SFCS";
    	System.out.println(word + ws.exist(board, word));
    	
    	char[][] board1 = {{'a','a'}};
    	word = "aaa";
    	System.out.println(word + ws.exist(board1, word));
    	
    	
    	char[][] board3 = {{'C','A','A'},
						  {'A','A','A'},
						  {'B','C','D'}};
		word = "AAB";
		System.out.println(word + ws.exist(board3, word));

    }
}
