/**
 * Represents RGB colors.
 * RGB values are stored in a 3-position array, with values in the interval [0, 255].
 * rgb[0] - Red
 * rgb[1] - Green
 * rgb[2] - Blue
 */
class Color {

	private final int[] rgb; // @color

	/**
	 * Creates an RGB color. Provided values have to 
	 * be in the interval [0, 255]
	 */
	Color(int r, int g, int b) {
		if(!valid(r) || !valid(g) || !valid(b))
			throw new IllegalArgumentException("invalid RGB values: " + r + ", " + g + ", " + b);

		this.rgb = new int[] {r, g, b};
	}

	/**
	 * Red value [0, 255]
	 */
	int getR() {
		return rgb[0];
	}

	/**
	 * Green value [0, 255]
	 */
	int getG() {
		return rgb[1];
	}

	/**
	 * Blue value [0, 255]
	 */
	int getB() {
		return rgb[2];
	}

	/**
	 * Obtains the luminance in the interval [0, 255].
	 */
	int getLuminance() {
		return (int) Math.round(rgb[0]*.21 + rgb[1]*.71 + rgb[2]*.08);
	}

	static boolean valid(int value) {
		return value >= 0 && value <= 255;
	}

	static Color randomColor() {
		int rndr=0;
		int rndg=0;
		int rndb=0;
		Color res;
		rndr=(int)(Math.random()*(256));
		rndg=(int)(Math.random()*(256));
		rndb=(int)(Math.random()*(256));
		res=new Color(rndr,rndg,rndb);
		return res;
	}

	static Color[] randomColorArray(int length) {
		Color[] res= new Color[length];
		Color t;
		for(int i=0; i!=res.length; i++){
			int rndr=(int)(Math.random()*(256));
			int rndg=(int)(Math.random()*(256));
			int rndb=(int)(Math.random()*(256));
			t=new Color(rndr,rndg,rndb);
			res[i]=t;
		}
		return res;
	}

	static Color inverted(Color color) {
		int r=color.getR();
		int g=color.getG();
		int b=color.getB();
		color=new Color(255-r,255-g,255-b);
		return color;
	}

	static Color changeBrightness (Color color, int factor) {
		int r=limit(color.getR()+factor);
		int g=limit(color.getG()+factor);
		int b=limit(color.getB()+factor);
		Color newcolor=new Color(r,g,b);
		return newcolor;
	}

	static int limit(int value){
		if(value>255)
			return 255;
		if(value<0)
			return 0;
		return value;
	}

	static Color changeBrithTest(){
		Color color=randomColor(); 
		int factor=100;
		return changeBrightness(color,factor);
	}

}

