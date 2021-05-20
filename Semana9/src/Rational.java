class Rational {
	
	final double a;
	final double b;
	
	Rational(double a, double b) {
		this.a=a;
		this.b=b;
	}
	
	Rational(double x) {
		this.a=x;
		this.b=1;
	}
	
	double real() {
		return a/b;
	}
	
	Rational sum(Rational n) {
		if(b==n.b)
			return new Rational(a+n.a,b);
		else
			return new Rational(a*n.b+n.a*b, b*n.b);
	}
	
	Rational multiEsc(int n) {
		return new Rational(a*n,b);
	}
	
	Rational multiRat(Rational n) {
		return new Rational(a*n.a, b*n.b);
	}
	
	boolean isEqual(Rational n) {
		return (a==n.a && b==n.b) || (a/b==n.a/n.b);
	}
	
	boolean isHigher(Rational n) {
		return (a/b)>(n.a/n.b);
	}

}