/**
 * Represents binary images.
 * Image data is represented as a matrix:
 * - the number of lines corresponds to the image height (data.length)
 * - the length of the lines corresponds to the image width (data[*].length)
 * - false values are mapped to black
 * - true values are mapped to white
 */
class BinaryImage {

	private boolean[][] data; // @binaryimage

	/**
	 * Creates a black binary image with the given dimension in pixels.
	 */
	BinaryImage(int width, int height) {
		data = new boolean[height][width];
	}

	/**
	 * Image width in pixels.
	 */
	int getWidth() {
		return data[0].length;
	}

	/**
	 * Image height in pixels.
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

	/**
	 * Validates if the given (x, y) is a valid pixel position,
	 * throwing an exception in case if it is not.
	 */
	void validatePosition(int x, int y) {
		if(!validPosition(x, y))
			throw new IllegalArgumentException(
					"invalid point " + x + ", " + y + 
					": matrix dimension is " + getWidth() + " x " + getHeight());
	}

	//-----------------------------------------//
	static BinaryImage test(){
		BinaryImage img= new BinaryImage(200,200);
		int x=50;
		int y=50;
		for(int i=0; i!=200; i++)
			for(int j=0; j!=200; j++)
				img.setWhite(i,j);
		img.setBlack(50,50);
		img.setBlack(100,100);
		for(int a = 0; a != x; a++) {
	        for(int b = 0; b != y; b++) {
	            img.setBlack(50 + a, 50 + b);
	        }
	    }
		//paintSquare(img,100,50,25);
		//BlackBorder(img);
		//BinaryImage ans;
		//ans=createChessBoard(15);
		//BinaryImage ans2;
		//ans2=scalarImage(ans,2);
		//newInverted(ans);
		return img;
	}

	static BinaryImage RandomImage(int x, int y){
		BinaryImage ans=new BinaryImage(x,y);
		int rnd=0;
		for(int i=0; i!=x; i++)
			for(int j=0; j!=y; j++){
				for(int k=0; k!=x-1; k++)
					rnd=(int)(Math.random()*(k+1));
				ans.setWhite(rnd,j);
			}
		return ans;
	}

	static void paintSquare(BinaryImage img, int xi, int yi, int side) {
		for(int x=xi; x!=xi+side; x++)
			for(int y=yi; y!=yi+side; y++)
				if(img.validPosition(x,y))
					img.setWhite(x,y);
	}

	static void BlackBorder(BinaryImage img){
		for(int i=0; i!=img.getWidth(); i++)
			img.setBlack(i,0);
		for(int k=0; k!=img.getWidth(); k++)
			img.setBlack(k,img.getHeight()-1);
		for(int j=0; j!=img.getHeight(); j++)
			img.setBlack(0,j);
		for(int l=0; l!=img.getHeight(); l++)
			img.setBlack(img.getWidth()-1,l);
	}

	static BinaryImage createChessBoard(int n){
		BinaryImage board= new BinaryImage((n*8)+2,(n*8)+2);
		for(int x=1; x<=(6*n)+1; x+=2*n)
			for(int y=1; y<=(6*n)+1; y+=2*n)
				paintSquare(board,x,y,n);
		for(int x1=n+1; x1<=(7*n)+1; x1+=2*n)
			for(int y1=n+1; y1<=(7*n)+1; y1+=2*n)
				paintSquare(board,x1,y1,n);
		return board;
	}

	void sameInverted(){
		for(int x=0; x!=getWidth(); x++)
			for(int y=0; y!=getHeight(); y++)
				if(isBlack(x,y))
					setWhite(x,y);
				else
					setBlack(x,y);
	}

	BinaryImage newInverted(){
		BinaryImage ans= new BinaryImage(getWidth(),getHeight());
		for(int x=0; x!=getWidth(); x++)
			for(int y=0; y!=getHeight(); y++)
				if(isBlack(x,y))
					ans.setWhite(x,y);
				else
					ans.setBlack(x,y);
		return ans;
	}


	static BinaryImage scalarImage(BinaryImage img, int n){
		BinaryImage ans= new BinaryImage(img.getWidth()*n,img.getHeight()*n);
		ans=createChessBoard(n*15);
		return ans;
	}

	static BinaryImage merge(BinaryImage n, BinaryImage m){
		for(int x=0; x!=n.getWidth(); x++){
			for(int y=0; y!=n.getHeight(); y++){
				if(n.isBlack(x,y) || m.isBlack(x,y))
					m.setBlack(x,y);
					else
					m.setWhite(x,y);
			}
		}
		return m;
	}
	
	static BinaryImage randCircle(BinaryImage img, int r, int x, int y){
		for(int i=0; i!=img.getWidth(); i++)
			for(int j=0; j!=img.getHeight(); j++)
				if(((i-x)*(i-x)+(j-y)*(j-y))<=r*r)
					if((Math.random())<0.5)
					img.setWhite(i,j);
		return img;
	}

}