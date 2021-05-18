class ComputerPlayer extends APlayer {
	
	//constructor
	public ComputerPlayer(String name, String mark) {
		super(name, mark);
	}  

	//computer picks random number from range given
	public int selectRowNum(int range) { 
		return (int)(Math.random() * range);
	} 

	//computer picks random number from range given 
	public int selectColNum(int range) { 
		return (int)(Math.random() * range); 
	}

	@Override
	//computer selects random board from range given
	public int selectBoardNum(int range) {
		return (int)(Math.random() * range);
	}  

	@Override
	//computer selects random square from range given
	public int selectSquareNum(int num) {
		return selectRowNum(3) * 3 + selectColNum(3);
	}	
}

