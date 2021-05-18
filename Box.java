public class Box {

		//private members
		private String placeholder = "-";
		private int row; 
		private int col; 
		
		//constructors
 		public Box () { 
		}
		  
 		public Box (int row, int col, String placeholder) {
 			this.row = row;
 			this.col = col;  
			setPlaceholder(placeholder);
		}

 		//setters and getters for setting up the Box class 
 		public String getPlaceholder() {
			return placeholder;
		}

 		public boolean setPlaceholder(String player) {
 			if (isAvailable()) {
				this.placeholder = player; 
				return true;
			}
 			return false;
		}
		
 		//checks if a square in the small board is available
 		public boolean isAvailable() {
			if(!getPlaceholder().equals("X"))
				if(!getPlaceholder().equals("O"))
					return true;
			return false;
		}
 		
 		//prints out the move 
 		public void print() {
			System.out.print(" || _"+getPlaceholder() + "_");
		}
}  