import java.io.IOException;
//Madhuri Maniar
//CS2336.0W1
/* 
Analysis: In the Ultimate TicTacToe Game, we make a large game of tic tac toe 
which encompasses nine smaller games of tic tac toe. To win the overall game, 
you must have more number of wins in the smaller games. The first player will 
pick the board number to start with, then you have to go to that selected board 
and pick a square value to place your mark in. Then your opponent will have to take
the value that you picked during your turn and go to that number board. Now the two 
opponents will go back and forth until all nine games have a winner.

Design: I first call the UTTTGame class in the DriverMain class. By calling the default 
constructor, the main board, smaller boards, tttgames, and players are all set up. By calling 
the BigBoard, I create the 9 smaller boards which then creates the 9 smaller games which contain
9 boxes for each square. Now the game starts, I first print out the original big board which 
shows the 9 smaller boards. Now the first player (computer player) can pick the board number; 
then the opponent can pick the square value for that board. Then the human player and computer 
player go back and forth picking values for the previous chosen board number. Each time the players 
make a move, I print out the updated version of the board, switch the players, and check for winners. 
If there is a winner, I change the rest of the numbers of that board to a placeholder (*) to show that 
the board has already been won and I print who the board winner is for the specific smaller board. If a 
board number chosen by one of the players is full, I notify the user and have them pick a different valid 
board number. When all nine games have been won, the game is over and I check to see which player has won 
by checking which player has more number of wins. Then I print out the overall winner. */


public class DriverMain { 
	public static void main(String[] args) throws NumberFormatException, IOException { 
		//starts the game 
		UTTTGame UltimateGame = new UTTTGame();
	}
}                                 