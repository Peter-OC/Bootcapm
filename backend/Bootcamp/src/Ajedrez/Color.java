package Ajedrez;

public enum Color {   
	BLANCAS("blancas"), NEGRAS("negras");
	
	private final String COLOR;
		
		//Constructor
		private Color(String pColor) {
			this.COLOR=pColor;
		}
		
		public String getColor() {
			return COLOR;
		}

}



