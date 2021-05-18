
public class SmallBoard{
	
		//private members
		private Box[] boxes;	
		private int boardRowSize;
		private int boardColSize;		  
		private String holder = "";		  
		
		//constructors
 		public SmallBoard() {
			this(3, 3);		  
		}
		
		public SmallBoard(int row,int col) {	
			this.setSize(row, col);
 			this.init();
		}
 
		//setters and getters for setting up the small boards
		private void setBoxes(Box[] boxes) { 
			this.boxes = boxes;
		}

 		public Box[] getBoxes() {
			return boxes;
		}
 		
 		private void setSize(int row, int col) {
 			if(row < 3 || col < 3)
 				System.out.println("Minimum board size is 3*3");
 			else {
 				this.boardRowSize = row;
 				this.boardColSize = col;
 			}
 		}
 
 		public int getRowSize() {
			return boardRowSize;
		}
 		
 		public int getColSize() {
			return boardColSize;
		}

 		public void setWinner(String winner) { 
			this.holder = winner;
		}
 		
 		public String getWinner() {
			return holder;
		}
 
 		//creates small board with given dimensions
 		private void init() {
 			boxes = new Box[boardRowSize * boardColSize];
					
 			for (int a = 0; a < boxes.length; a++) {
 				Box b = new Box();
				boxes[a] = b;
			}		
 			print();	
		}

 		//prints out numbers on small board
 		private void print() {
 			for (int a = 0; a < boxes.length; a++)
				boxes[a].setPlaceholder(a+"");	 
		} 

 		//checks if move was made
 		public boolean makeMove(String mark, int row,int col) {
			return boxes[row * this.boardColSize+col].setPlaceholder(mark);
		} 
		 
 		//checks if specific box on small board has a move in it
 		public boolean selectSquare(String mark, int index) {
			return boxes[index].setPlaceholder(mark);
		} 
 		
 		//checks if small board is full
 		public boolean isFull() {
 			for(Box b: boxes) {
 				if (b.isAvailable()) 
					return false;
			}
			return true;
		} 
		
 		//makes move on small board
 		public String getMark(int row, int col) {
			return boxes[row * this.boardColSize+col].getPlaceholder();
		}
		
 		//prints out new small board with move made
 		public void print(int index) { 
 			for (int a = index; a < index+3; a++) {
				boxes[a].print();	 
			}
			System.out.print(" || ");
		}

 		//after a board is won, the numbers are replaced with placeholders to show that the board is already won
 		public void noavailability() {
 			for (int a = 0; a < boxes.length; a++) {
 				if (boxes[a].isAvailable()) 
					boxes[a].setPlaceholder("*");
			}
			 
		}
}

	
