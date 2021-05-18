public class BigBoard {

		//private members
		private SmallBoard[] smallboards;		 
		private int boardRowSize = 3; 
		private int boardColSize = 3;	 
		private int xCount = 0; 
		private int oCount = 0;
		
		//constructors  
 		public BigBoard() { 
 			smallboards = new SmallBoard[boardRowSize * boardColSize];
 			this.init();
		} 
		
 		//setters and getters for setting up the ultimate tic tac toe board
 		public SmallBoard[] getBoards() {
			return smallboards;    
		} 

 		public void setBoards(SmallBoard[] boards) {
			this.smallboards = boards;
		}

 		public SmallBoard getBoard(int boardNo) {
			return smallboards[boardNo];
		}
		
 		public void setBoardSize(int row, int col) {
 			this.boardRowSize =  row;
 			this.boardColSize = col; 
 		}
 		public int getBoardRowSize() {
			return boardRowSize;
		} 

 		public int getBoardColSize() {
			return boardColSize;
		} 

 		//creates the small boards
 		private void init() {
 			for (int a = 0; a < smallboards.length; a++)
 				smallboards[a] = new SmallBoard(); 	
		}
		
 		//checks to see if each small board is full 
 		public boolean isFull() {
 			for(SmallBoard b: smallboards) {
 				if (!b.isFull())
					return false;
			}
 			return true; 
		} 
			
 		//checks if move was made on a small board on a specific spot
 		public boolean makeMove(String mark, int board, int index) {
 			return smallboards[board].selectSquare(mark, index);
		}
			 
 		//returns the spot where a move was made
 		public String getMark(int board, int row, int col) {
			return smallboards[board].getBoxes()[row * this.boardColSize+col].getPlaceholder(); 
		}
			
 		//prints out entire board
 		public void printUltimateBoard() {
 			for (int a = 0; a < smallboards.length - 2; a = a + 3)
				printSmallBoards(a);
		} 
		 
 		//prints out new small boards after each turn of each player
 		private void printSmallBoards(int num) { 
 			for (int a = 0; a < smallboards.length; a = a + 3) {
				for (int b = num; b < num + 3; b++) {
					System.out.print("BOARD #" + b + " ");
					smallboards[b].print(a);
				}  
				System.out.println();	
			}
		}  

 		//checks to see if a specific small board is full
 		public boolean isFull(int num) {
			return smallboards[num].isFull();
		}
		
 		//sets board winner to given player: X or O
 		public void setBoardWinner(int num, String mark) {
 			smallboards[num].setWinner(mark);
		}
		
 		//gets winner of specific small board
 		public String getBoardWinner(int num) {
 			if(smallboards[num].getWinner()=="X")
 				xCount++;
 			else
 				oCount++;
			return smallboards[num].getWinner();
			 
		}	
 		
 		//checks to see if x player won or the o player
 		public int findWinner(int xCount, int oCount) {
 			if(xCount > oCount)
 				return xCount;
 			else if(oCount > xCount)
 				return oCount;
 			return 0;
 		}

 		//sets rest of board to placeholder when a winner is established
 		public void noavailability(int num) {
 			smallboards[num].noavailability();
		}

}