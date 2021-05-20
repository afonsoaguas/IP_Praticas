class Calculator {
	
	int value;
	
	public int getValue() {
		return value;
	}

    void plus(int n) {
        value += n;
    }
    
    void clean() {
    	value = 0;
    }
    
    void subtract(int n) {
    	value -= n;
    }
    
    void mult(int n) {
    	value *= n;
    }
    
    void sqr(int n) {
    	for(int i=1; i!=n; i++)
    		value *= value;
    }
    
    void divid(int n) {
    	value /= n;
    }
    
    void resto(int n) {
    	value %= n;
    }

}