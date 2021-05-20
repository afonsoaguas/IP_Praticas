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
	
	static final Color WHITE=new Color(255,255,255);
	static final Color BLACK=new Color(0,0,0);
	static final Color RED=new Color(255,0,0);
	static final Color GREEN=new Color(0,255,0);
	static final Color BLUE=new Color(0,0,255);
	static final Color PURPLE=new Color(153,51,153);
	
	static Color invert(Color c){
		int r=limit(255-c.getR());
		int g=limit(255-c.getG());
		int b=limit(255-c.getB());
		return new Color(r,g,b);
	}
	
	Color bright(int value) {
		int r=limit(getR()+value);
		int g=limit(getG()+value);
		int b=limit(getB()+value);
		Color c=new Color(r,g,b);
		return c;
	}
	
	static int limit(int value){
		if(value>255)
			return 255;
		if(value<0)
			return 0;
		return value;
	}
	
	boolean sameRGB(Color c){
		if(c==null)
			return false;
		int r=getR();
		int g=getG();
		int b=getB();
		int rc=c.getR();
		int gc=c.getG();
		int bc=c.getB();
		if(r==rc&&g==gc&&b==bc)
			return true;
		else
			return false;
	}
	
	static boolean contains(Color[] colors, Color c) {
		for(int i=0; i!=colors.length; i++)
			if(colors[i].sameRGB(c))
				return true;
		return false;
	}

}