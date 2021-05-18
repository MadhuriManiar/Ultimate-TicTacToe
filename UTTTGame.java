import java.io.IOException;


public class UTTTGame {
	
		//private members	 
		private APlayer[] players = new APlayer[2];	 
		private BigBoard Bigboard;
		private TTTGame[] games;
		private int xCount = 0;
		private int oCount = 0; 
		private int winners = 0; 
		private int ultimateRowSize;	  
		private int ultimateColSize;	  
		private int currentPlayerIndex = -1;		   
		  
		//constructors
 		public UTTTGame() throws NumberFormatException, IOException{
 			//the game begins by setting up the boards, players, and games
 			setBigBoard();		 
			setPlayers();	 
			setUltimateSize(Bigboard.getBoardRowSize(), Bigboard.getBoardColSize());
			setSmallBoards();	
			gameStarted();	
		}
 		
 		public UTTTGame(BigBoard Bigboard) { 
			this.Bigboard = Bigboard;
		}
		
 		//setters and getters for setting up sizes for rows and columns
 		public void setUltimateSize(int row, int col) {
 			this.ultimateColSize = col;
 			this.ultimateRowSize = row;
 		}
 		 
 		public int getUltimateRowSize() {
			return ultimateRowSize;
		}

 		public int getUltimateColSize() {
			return ultimateColSize;
		}

 		//creates new big board to hold the smaller boards
 		private void setBigBoard() {
 			Bigboard = new BigBoard(); 
		}
 				
 		private void setSmallBoards() {
 			//creates 9 TTT games for the smaller boards
 			games = new TTTGame[9]; 
			for (int a = 0; a < games.length; a++)
				games[a] = new TTTGame();
		}

		//sets up computer and human player, i let the computer go first
 		private void setPlayers() {
			currentPlayerIndex = 1;		 
			players[currentPlayerIndex--] = new ComputerPlayer("O Player", "O");
 			players[currentPlayerIndex++] = new HumanPlayer("X Player", "X");	 
				 
		}
 		
 		//switch players each time the opponent picks a spot
 		private void switchPlayers() { 
 			if (currentPlayerIndex==0)
 				currentPlayerIndex++;
 			else
 				currentPlayerIndex--;
		}
		 
 		//plays the game until the game is over
		private void gameStarted() throws NumberFormatException, IOException {
			System.out.println("Welcome to the Ultimate Tic-Tac-Toe Game!");
			//sets up values for each player to make their moves
 			boolean available[] = new boolean[9];  
 			availability(available);
 			Bigboard.printUltimateBoard(); 
			int value = Bigboard.getBoardRowSize() * Bigboard.getBoardColSize();
 			int num = players[currentPlayerIndex].selectBoardNum(value);
 			System.out.println("Current player: " + players[currentPlayerIndex].getMark());
 			System.out.println();
			
 			//continues to allow players to make moves, and prints the board each time until the game is over
 			while (!gameOver()) {
 				int square = selectSquare(num);
 				if(!available[num] && winnerCount(num)) { 
 					noavailability(num);		 
					available[num] = true;		 
					Bigboard.setBoardWinner(num, findWinner(num));	 
				}
 				Bigboard.printUltimateBoard();	 
 				if (Bigboard.isFull(num)) {
 					Bigboard.setBoardWinner(num, findWinner(num));
				}
 				else { 
 					//System.out.println("No Winner"); 
 				}
 				//prints the board winner and switches players
 				printBoardWinner();	
				switchPlayers();	
				num = square;		 
				//prints the current player and the board they selected
 				if (!gameOver()) {
 					System.out.println("Current player: " + players[currentPlayerIndex].getMark());
 					//System.out.println();
					System.out.println("Selected board : " + num);
				}
			}
 			printUltimateWinner(); 
		}
 		
 		//makes small board unavailable if there is a winner
 		private void availability(boolean[] available) {
			for (int a = 0; a < 9; a++) {
				available[a]=false;
			}  
		}

 		//prints the winner of the entire game based on which player has more small board wins
 		private void printUltimateWinner() { 
 			if(xCount > oCount)
 				System.out.println("Game winner is X");
 			else if(oCount > xCount)
 				System.out.println("Game winner is O"); 
 			else
 				System.out.println("There is no winner");
		} 

 		//replaces the other spaces with a new placeholder when a winner of that board is already established
 		private void noavailability(int num) {
 			Bigboard.noavailability(num);
		}

 		//counts how many winners are there, if there are 9 winners, the game is over
 		private boolean winnerCount(int num) {
			if(findWinner(num).equals("X") || findWinner(num).equals("O")) {
				winners++;
				return true;
			}
			return false;
		}
 		 
 		//returns the number of overall wins in the game
 		private int countWinners() {
 			return winners;
 		}
 
 		//prints the winner of the small board each time the game runs 
 		private void printBoardWinner() {
 			for (int i=0;i<9;i++) { 
				if (!Bigboard.getBoardWinner(i).equals("")) {
					System.out.println("The Board #"+i+ " winner is " + Bigboard.getBoardWinner(i));
					if(Bigboard.getBoardWinner(i) == "X")
						xCount++;
					if(Bigboard.getBoardWinner(i) == "O")
						oCount++;
				}
			}
			System.out.println(); 
		} 

 		//finds the winner of a specific small board
 		private String findWinner(int num) {
			games[num].setBoard(Bigboard.getBoard(num));
			return games[num].findWinner(players[0].getMark(),players[1].getMark());
		}
		 
 		//if there are 9 wins in the game, then the game is over
 		private boolean gameOver () {
 			if(countWinners() == 9)
 				return true; 
 			return false; 
		} 
 		
 		//player will select square during their turn
 		private int selectSquare(int num) throws NumberFormatException, IOException {
 			if (!Bigboard.isFull(num)) {
				//System.out.println("is not full");	 
			} 
 			//checks to make sure the board selected is not full
 			else {
 				int area = getUltimateColSize() * getUltimateRowSize();
 				System.out.println("The selected board is full");	 
 				while (Bigboard.isFull(num)) { 	
 					num = players[currentPlayerIndex].selectBoardNum(area);
				}
				System.out.println("Selected board : " + num);
 			} 
 			int square = players[currentPlayerIndex].selectSquareNum(num);
 			while(!Bigboard.makeMove(players[currentPlayerIndex].getMark(), num, square)) {
 				square = players[currentPlayerIndex].selectSquareNum(num);
			}
 			if (players[currentPlayerIndex].getMark()=="X") 
				System.out.println("Selected Square : " + square);
 			else if(players[currentPlayerIndex].getMark()=="O")
 				System.out.println("Selected Square : " + square);
			return square;
		}
}