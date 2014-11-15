/*
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.


A partially filled sudoku which is valid.

Note:
A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
 * */
package com.oj.practice;

public class Sudoku {
	
    public boolean isValidSudoku(char[][] board) {
    	int row;
    	int numRow;
    	int[] sqr = new int[3];
    	int[] colum = new int[9];
    	
    	for(int i=0; i<board.length; i++){
    		row = 0;
			if(i%3 == 0){
				sqr[0] = 0;
				sqr[1] = 0;
				sqr[2] = 0;
			}
			
    		for(int j=0; j<board[0].length; j++){
    			if (board[i][j] != '.'){
    				numRow = board[i][j]-'0';
    				
        			numRow = 1<<numRow;
        			
        			if(0< (row & numRow) || 0< (sqr[j/3] & numRow) || 0< (colum[j%9] & numRow)){
        				return false;
        			}
        			else{
        				row |= numRow;
        				sqr[j/3]|= numRow;
        				colum[j%9] |= numRow;
            		}
    			}
    		}
    	}
    	
    	return true;
    	
/**
 * use bit to solve the problem*/
/*
    if (board.length!=9||board[0].length!=9)    
        return false;

    int[] row= new int[9]; int[] col= new int[9];int[] sqr= new int[9];   

    for (int i=0;i<9;i++){
        for (int j=0;j<9;j++){
            if (board[i][j]!='.'){
                int num = board[i][j]-'0';
                if ((row[i]&1<<num)>0)
                    return false;
                else row[i]|=1<<num;

                if ((col[j]&1<<num)>0)
                    return false;
                else col[j]|=1<<num;

                int sqr_num=(i-i%3)+j/3;
                if ((sqr[sqr_num]&1<<num)>0)
                    return false;
                else sqr[sqr_num]|=1<<num;

            }
        }
    }    
    return true;    
*/
/**
* use hashset to solve the problems, time complexity and memory complexity is both bad.
* */
    	/*
        HashSet<Character> hashSetColumn, hashSetRow;
        HashSet<Character>[] hashSetSmallSudoku = new HashSet[3];
        
        
        for(int i=0; i<board.length; i++){
        	hashSetRow = new HashSet<Character>();
        	hashSetColumn = new HashSet<Character>();
    		if(i%3==0){
    			hashSetSmallSudoku[0] = new HashSet<Character>();
    			hashSetSmallSudoku[2] = new HashSet<Character>();
    			hashSetSmallSudoku[1] = new HashSet<Character>();
    		}
        	for(int j=0; j<board[0].length; j++){
        		//valid the rows and column first
        		if(hashSetSmallSudoku[j/3].contains(board[i][j]) || hashSetRow.contains(board[i][j]) || hashSetColumn.contains(board[j][i])){
        			return false;
        		}
        		else{
        			if(board[i][j]!='.'){
        				hashSetRow.add(board[i][j]);
        				hashSetSmallSudoku[j/3].add(board[i][j]);
        			}
        			
					if(board[j][i]!='.'){
						hashSetColumn.add(board[j][i]);  
					}
        		}
        		//valid small nine sudoku
        	}
        }

        return true;
        */
    }
}
