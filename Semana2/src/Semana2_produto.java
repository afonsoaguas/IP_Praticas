class Semana2_produto {
	static int divisao(int a, int b) {
		int resultado=0;
		while (a>=b) {
			resultado=resultado+1;
			a=a-b;
		}
	return resultado;
	}
	static int produto(int a, int b){
		int resultado=0;
		int somasAfazer=b;
		while(somasAfazer!=0){
			resultado=resultado+a;
			somasAfazer=somasAfazer-1;
		}
		return resultado;
	}
	static int max(int a,int b){
		if(a<b)
			return b;
		else
			return a;
	}
	static boolean isMultiple(int a,int b){
		while(a>b)
			a=a-b;
		return a==b;
	}
	static int absoluto(int a){
		if(a>0)
			return a;
		else
			return -a;
	}
	static int dividir(int a,int b) {
		int resultado=a/b;
		return resultado;
	}
	static int powerof2(int a) {
		int r=1;
		int multi=a;
		while (multi!=0) {
			r=r*2;
			multi=multi-1;
		}
		return r;
	}
	static int somaate(int a) {
		int r=0;
		int s=0;
		while (s<=a) {
			r=r+s;
			s=s+1;
		}
		return r;
	}
	static int somapares(int a,int b) {
		int r=0;
		while (a<=b) {
			if (a%2==0)
				r=r+a;
			a=a+1;
		}
		return r;
	}
	static int firstdigit(int a) {
		while (a>=10) {
			a=a/10;
		}
		return a;
	}
	static int fator(int n) {
		int i=n-1;
		int f=n;
			while (i>1) {
			f=f*i;
			i=i-1;
		}
		return f;
	
	}
}