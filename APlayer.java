public abstract class APlayer {
	
	//private members
	private String name;		 
	private String mark;		
	 
	//constructors 
	public APlayer(String name, String mark) {
		setName(name);
		setMark(mark); 
	}
	
	//setters and getters for setting up the players
	public void setName(String name) {
		this.name = name;
	} 
	
	public String getName() {
		return name;
	}
	
	public void setMark(String mark) {
		this.mark = mark;
	}
	
	public String getMark() {
		return mark;
	}
	
	//abstract methods
	public abstract int selectBoardNum(int range);
	public abstract int selectSquareNum(int range);
	
}