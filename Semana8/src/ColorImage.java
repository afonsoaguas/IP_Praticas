/**
 * Represents color images.
 * Image data is represented as a matrix:
 * - the number of lines corresponds to the image height (data.length)
 * - the length of the lines corresponds to the image width (data[*].length)
 * - pixel color is encoded as integers (ARGB)
 */
class ColorImage {

	private int[][] data; // @colorimage

	ColorImage(String file) {
		this.data = ImageUtil.readColorImage(file);
	}

	ColorImage(int width, int height) {
		data = new int[height][width];
	}

	int getWidth() {
		return data[0].length;
	}

	int getHeight() {
		return data.length;
	}

	void setColor(int x, int y, Color c) {
		data[y][x] = ImageUtil.encodeRgb(c.getR(), c.getG(), c.getB());
	}

	Color getColor(int x, int y) {
		int[] rgb = ImageUtil.decodeRgb(data[y][x]);
		return new Color(rgb[0], rgb[1], rgb[2]);
	}

	void invertImg(){
		for(int x=0; x!=getWidth(); x++)
			for(int y=0; y!=getHeight(); y++)
				setColor(x,y,Color.invert(getColor(x,y)));
	}

	void changeBrith(int n){
		for(int x=0; x!=getWidth(); x++)
			for(int y=0; y!=getHeight(); y++)
				setColor(x,y,getColor(x,y).bright(n));
	}

	void flipH(){
		Color aux;
		for(int x=0; x!=getWidth()/2; x++){
			for(int y=0; y!=getHeight(); y++){
				aux=getColor(x,y);
				setColor(x,y,getColor(getWidth()-x-1,y));
				setColor(getWidth()-x-1,y,aux);
			}
		}
	}

	void pasteNew(ColorImage img, int p1, int p2){
		if(img.getWidth()<getWidth() && img.getHeight()<getHeight()){
			for(int x=0; x!=img.getWidth(); x++)
				for(int y=0; y!=img.getHeight(); y++)
					setColor(x+p1,y+p2,img.getColor(x,y));
		}
		if(img.getWidth()>getWidth() && img.getHeight()>getHeight()){
			for(int x=0; x!=getWidth(); x++)
				for(int y=0; y!=getHeight(); y++)
					setColor(x+p1,y+p2,img.getColor(x,y));
		}
		if(img.getWidth()>getWidth() && img.getHeight()<getHeight()){
			for(int x=0; x!=getWidth(); x++)
				for(int y=0; y!=img.getHeight(); y++)
					setColor(x+p1,y+p2,img.getColor(x,y));
		}
		if(img.getWidth()<getWidth() && img.getHeight()>getHeight()){
			for(int x=0; x!=img.getWidth(); x++)
				for(int y=0; y!=getHeight(); y++)
					setColor(x+p1,y+p2,img.getColor(x,y));
		}
		
	}
	
	ColorImage BW(){
		ColorImage newB=new ColorImage(getWidth(),getHeight());
		for(int x=0; x!=getWidth(); x++){
			for(int y=0; y!=getHeight(); y++){
				int l=getColor(x,y).getLuminance();
				if(l<128)
					newB.setColor(x,y,Color.BLACK);
				else
					newB.setColor(x,y,Color.WHITE);
			}
		}
		return newB;
	}
	
	ColorImage copy(){
		ColorImage copy=new ColorImage(getWidth(),getHeight());
		for(int x=0; x!=getWidth(); x++)
			for(int y=0; y!=getHeight(); y++)
				copy.setColor(x,y,getColor(x,y));
		return copy;
	}

	ColorImage selection(int startx, int starty, int endx, int endy) {
		ColorImage select=new ColorImage(endx-startx,endy-starty);
		int xend=(((endx-startx))+((endx-startx%2==1)? -1:0));
		int yend=(((endy-starty))+((endy-starty%2==1)? -1:0));
		for(int x=0; x<xend; x++)
			for(int y=0; y<yend; y++)
				select.setColor(x,y,getColor(x+startx,y+starty));
		return select;
	}
	
}
