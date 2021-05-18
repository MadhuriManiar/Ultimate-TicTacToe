public class TTTGame {
	
		//private members
		private SmallBoard board;		   
		private int gameRowSize;	 
		private int gameColSize;	 
		private int indexCurrentPlayer = -1;		 
		 
		//constructors 
 		public TTTGame(SmallBoard board) {
			this.board=board; 
		}
		  
 		public TTTGame() { 
			start();
		}
		
 		//setters and getters for setting up the TTT Game
 		public void setBoard(SmallBoard board) {  
			this.board = board;
		}
 		 
 		public SmallBoard getBoard() {
			return board;
		}

 		public void setIndexCurrentPlayer(int indexCurrentPlayer) {
			this.indexCurrentPlayer = indexCurrentPlayer;
		}
 		
 		public int getIndexCurrentPlayer() {
			return indexCurrentPlayer;
		}

 		public void setGameSize(int row, int col) {
 			this.gameRowSize = row;
 			this.gameColSize = col;
 		}
 	
 		public int getGameRowSize() {
			return gameRowSize;
		}

 		public int getGameColSize() {
			return gameColSize;
		}
  
		public void start() {
			setBoard();
			setGameSize(board.getRowSize(), board.getColSize());
		}

		 
		private void setBoard() {
			board=new SmallBoard();
		}
		
		//checks if there is three in a row on the small board
 		public boolean isWinner(String mark) {
 			if(checkRow(mark))
 				return true;
 			if(checkCol(mark))
 				return true;
 			if(checkDiagLR(mark))
 				return true;
 			if(checkDiagRL(mark))
 				return true;
 			return false; 
		}
 		 
 		//finds which player is the winner or if it is a tie
 		public String findWinner(String X, String O) {
 			if (isWinner(X)) {
				return X;
			}
			else if (isWinner(O)) {
				return O;
			}
			else
				return "Tie";
		}
 		
 		//checks if there is three in a diagonal from right to left
 		public boolean checkDiagRL(String mark) {
 			if(board.getMark(0, 2).equals(mark))
 				if(board.getMark(1, 1).equals(mark))
 					if(board.getMark(2, 0).equals(mark))
 						return true;
 			return false;
		}
 		 
 		//checks if there is three in a diagonal from left to right
 		public boolean checkDiagLR(String mark) {
 			if(board.getMark(0, 0).equals(mark))
 				if(board.getMark(1, 1).equals(mark))
 					if(board.getMark(2, 2).equals(mark))
 						return true;
 			return false;
		}
 
 		//checks if there is a three in a column
 		 public boolean checkCol(String mark) {
 			 for (int a = 0; a < board.getRowSize(); a++) {
					int count = 0;
					for (int b = 0; b < board.getRowSize(); b++) {
						if (!board.getMark(b, a).equals(mark)) {
							count++;
							break;
						}
					}
					if (count==0)
						return true;  
				}
				return false;
		} 

 		 //checks if there is three in a row 
 		 public boolean checkRow(String mark) {
 			for (int a = 0; a < board.getRowSize(); a++) {
				int count = 0;
				for (int b = 0; b < board.getRowSize(); b++) {
					if (!board.getMark(a, b).equals(mark)) {
						count++;
						break;
					}
				}
				if (count==0)
					return true;
			}
			return false;
		}
}