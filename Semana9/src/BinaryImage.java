class BinaryImage {

	private boolean[][] data; // @binaryimage

	/**
	 * Creates a binary image from the given image file (GIF, JPG, PNG).
	 * The pixels of the original image will be converted to
	 * black/white according to their luminance value.
	 */
	BinaryImage(String path) {
		this.data = ImageUtil.readBinaryImage(path);
	}

	/**
	 * Creates a black binary image with the given dimension in pixels.
	 */
	BinaryImage(int width, int height) {
		data = new boolean[height][width];
	}

	/**
	 * Image width in pixels,
	 */
	int getWidth() {
		return data[0].length;
	}

	/**
	 * Image height in pixels,
	 */
	int getHeight() {
		return data.length;
	}

	/**
	 * Is pixel at (x, y) black?
	 */
	boolean isBlack(int x, int y) {
		validatePosition(x, y);
		return !data[y][x];
	}

	/**
	 * Sets the pixel at (x, y) to white.
	 */
	void setWhite(int x, int y) {
		validatePosition(x, y);
		data[y][x] = true;
	}

	/**
	 * Sets the pixel at (x, y) to black.
	 */
	void setBlack(int x, int y) {
		validatePosition(x, y);
		data[y][x] = false;
	}

	/**
	 * Is (x, y) a valid pixel position in this image?
	 */
	boolean validPosition(int x, int y) {
		return 
				x >= 0 && x < getWidth() &&
				y >= 0 && y < getHeight();
	}

	void validatePosition(int x, int y) {
		if(!validPosition(x, y))
			throw new IllegalArgumentException(
					"invalid point " + x + ", " + y + 
					": matrix dimension is " + getWidth() + " x " + getHeight());
	}

	BinaryImage (Rectangle r) {
		data = new boolean[r.width][r.height];
	}

	Rectangle convert(BinaryImage img) {
		return new Rectangle(img.getWidth(),img.getHeight());
	}

	boolean isWhite(Point p) {
		validatePosition(p.x, p.y);
		return data[p.x][p.y];
	}

	void paint(Point p, boolean white) {
		validatePosition(p.x, p.y);
		data[p.x][p.y] = white;
	}

	int getCount(boolean white) {
		int count=0;
		for(int x=0; x!=getWidth(); x++)
			for(int y=0; y!=getHeight(); y++)
				if(data[x][y]==white)
					count++;
		return count;		
	}

	Point[] getPoints(boolean white) {
		int n=getCount(white);
		Point[] ans=new Point[n];
		int i=0;
		for(int x=0; x!=getWidth(); x++)
			for(int y=0; y!=getHeight(); y++)
				if(data[x][y]==white){
					ans[i]=new Point(x, y);
					i++;
				}
		return ans;
	}

	void invert() {
		for(int x=0; x!=getWidth(); x++)
			for(int y=0; y!=getHeight(); y++)
				if(data[x][y]==true)
					data[x][y]=false;
				else
					data[x][y]=true;
	}

	void fillRectangle(Point p, Rectangle r) {
		for(int x=p.x; x!=r.width+p.x; x++)
			for(int y=p.y; y!=r.height+p.y; y++)
				data[x][y]=true;
	}

	void borderRectangle(Point p, Rectangle r) {
		for(int x=p.x; x!=r.width+p.x; x++)
			data[x][p.y]=true;
		for(int y=p.y; y!=r.height+p.y; y++)
			data[p.x][y]=true;
		for(int x=p.x; x!=r.width+p.x; x++)
			data[x][getHeight()-p.y]=true;
		for(int y=p.y; y!=r.height+p.y; y++)
			data[getWidth()-p.x][y]=true;
	}

	void changeSize(Rectangle r) {
		boolean[][] ans=new boolean[r.width][r.height];
		for(int x=0; x!=r.width; x++)
			for(int y=0; y!=r.height; y++){
				if(validPosition(x,y))
					if(data[x][y]==true)
						ans[x][y]=true;
					else
						ans[x][y]=false;
				else
					ans[x][y]=false;
			}
		data=ans;
	}

}