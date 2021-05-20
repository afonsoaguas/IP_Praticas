class semana3 {
	static int sumdiv(int a) {
		int i=1;
		int n=0;
		while (i!=n) {
			if(n%i==0)
				n=n+1;
			i=i+1;
		}
		return n;
	}

	static int ndiv(int a) {
		int i=1;
		int n=0;
		while (i!=n+1) {
			if (a%i==0);
			n=n+1;
			i=i+1;
		}
		return n;
	}

	static boolean prime(int a) {
		int i=2;
		if (a==1)
			return false;
		else
			while (i<a) {
			if(a%i==0)
				return false;
			i=i+1;
		}
		return true;
	}

	static int sumprime(int a) {
		int i=1;
		int n=0;
		while (i<=a) {
			if (prime(i))
				n=n+1;
			i=i+1;
		}
		return n;
	}

	static int sumprimeupto(int a) {
		int i=1;
		int n=0;
		while (i<=a) {
			if (prime(i))
				n=n+1;
			i=i+1;		
		}
		return n;
	}

	static boolean perfect(int a) {
		if (a==sumdiv(a))
			return true;
		return false;
	}

	static int nperfect(int a) {
		int i=1;
		int n=0;
		while (i!=n+1) {
			if (i==sumdiv(i))
				n=n+1;
			i=i+1;
		}
		return n;
	}

	static int existprime(int a,int b) {
		int p=sumprimeupto(b-1)-sumprimeupto(a);
		return p;
	}

	static int fibo(int a) {
		if (a==0)
			return 0;
		if (a==1)
			return 1;	
		return fibo(a-1)+fibo(a-2);
	}

	static int fator(int n) {
		if (n==0)
			return 1;
		return n*fator(n-1);
	}
	static int maxdiv(int a,int b) {
		if (b==0)
			return a;
		return maxdiv(b,a%b);
	}
	static int difprime(int a){
		int primoant=2;
		int maiordif=0;
		int i=0;
		while(i<=a){
			if(prime(i))
				if(i-primoant>maiordif)
					maiordif=i-primoant;
			    primoant=i;
			i=i+1;
		}
	return maiordif;
	}
}
					
