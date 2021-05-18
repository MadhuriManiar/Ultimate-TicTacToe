import java.util.Scanner;
 
class HumanPlayer extends APlayer {		
	
	//constructor
	public HumanPlayer(String name, String mark) { 
		super(name, mark); 
	} 
 
	@Override 
	//Human player selects board number
	public int selectBoardNum(int range){ 
		int board;  
		do { 
			Scanner input = new Scanner(System.in); 
			System.out.println("Select a valid board between 0-8: "); 
			System.out.print("Selected Board: ");  
			board = input.nextInt();
			if(board < 0 || board > 8) {
				System.out.println("The number entered was invalid");	 
				System.out.println("Please select a valid board: "); 
				System.out.print("Selected Board : ");
				board=input.nextInt();
			}
		}while(board < 0 || board > 8);
		return board; 
	} 

	@Override
	//human player selects square number in small board
	public int selectSquareNum(int range){
		int square;
		do { 
			Scanner input = new Scanner(System.in);
			System.out.println("Please select a valid square: ");
			System.out.print("Selected Square : ");
			square = input.nextInt();
			if(square < 0 || square > 8) {
				System.out.println("The number entered was invalid");	 
				System.out.println("Please select a valid square: ");
				System.out.print("Selected Square : ");
				square = input.nextInt();
			}
		}while(square < 0 || square > 8);
		return square;
	}	
}	