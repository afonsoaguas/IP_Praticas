class Rectangle {
	
	  final int width;
	    final int height;

	    Rectangle(int width, int height) {
	          this.width = width;
	          this.height = height;
	    }
	    
	    Rectangle(int side) {
	    	this.width = side;
	    	this.height = side;
	    }
	    
	    int area() {
	    	return width*height;
	    }
	    
	    int perimeter() {
	    	return width*2+height*2;
	    }
	    
	    double diagonal() {
	    	return Math.sqrt(width*width + height*height);
	    }
	    
	    boolean isSquare() {
	    	return width==height;
	    }
	    
	    Rectangle scale(int factor) {
	    	Rectangle newRect= new Rectangle(this.width*factor, this.height*factor);
	    	return newRect;
	    }
	    
	    Rectangle sum(int width, int height) {
	    	Rectangle ans= new Rectangle(this.width + width, this.height + height);
	    	return ans;
	    }
	    
	    boolean isBigger(Rectangle r) {
	    	return area()>r.area();
	    }
	    
	    static Rectangle max(Rectangle a, Rectangle b) {
	    	if(a.area()>=b.area())
	    		return a;
	    	else
	    		return b;
	    }

}