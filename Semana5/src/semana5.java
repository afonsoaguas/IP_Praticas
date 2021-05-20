class semana5 {
	// Algumas da semana passada mas com menos passos
	static boolean exists(int n, int[] v){
		for(int i=0; i!=v.length; i++){
			if(n==v[i]){
				return true;
			}
		}
		return false;
	}

	static int[] firsthalf(int[] v,boolean n){
		int[] u=new int[(v.length/2)+((v.length%2==1 && n)? 1:0)];
		for(int i=0;i<u.length;i++)
			u[i]=v[i];
		return u;
	}

	//Trabalho Prévio
	static char[] charvector(char v, int n){
		char[] r=new char[n];
		for(int i=0; i!=n; i++)
			r[i]=v;
		return r;
	}

	static void fill(char c, char[] v){
		char[] r=new char[v.length];
		for(int i=0; i!=v.length; i++)
			r[i]=c;
	}

	static void replace(char f, char s, char[] v){
		for(int i=0; i!=v.length; i++)
			if(v[i]==f)
				v[i]=s;
	}

	//Exercicios
	static char[] sequence(char c, int n){
		char[] r=new char[n];
		for(int i=0; i!=n; i++ , c++)
			r[i]=c;
		return(r);
	}

	static void subsfirst(char[] v, char n, char o){
		for(int i=0;i!=v.length; i++){
			if(v[i]==o){
				v[i]=n;
				System.out.print(v);
				return;
			}
		}
	}

	static void lastoccur(char[] v, char n, char o){
		for(int i=v.length-1;i>=0; i--){
			if(v[i]==o){
				v[i]=n;
				System.out.print(v);
				return;
			}
		}

	}

	static void shiftleft(char[] v){
		char s=v[0];
		for(int i=0;i!=v.length;i++){
			if(i==v.length-1)
				v[v.length-1]=s;
			else
				v[i]=v[i+1];
		}
		System.out.print(v);
	}

	static void shiftright(char[] v){
		char s=v[v.length-1];
		for(int i=v.length-1;i!=-1;i--){
			if(i==0)
				v[0]=s;
			else
				v[i]=v[i-1];
		}
		System.out.print(v);
	}

	static void swap(char[] v, int f, int s){
		char safe=v[f];
		v[f]=v[s];
		v[s]=safe;
	}

	static void invert(char[] v){
		char[] r=new char[v.length];
		int s=v.length-1;
		for(int i=0;i!=v.length;i++)
			r[i]=v[s-i];
		System.out.print(r);
	}

	static char[] radomindex(char[] v){
		int j=0;
		char t=0;
		for(int i=v.length-1;i>0;i--){
			j=(int)(Math.random()*(i+1));
			t=v[j];
			v[j]=v[i];
			v[i]=t;
		}
		return v;
	}

	static void ordem(char[] v){
		for(int i=0, i2=0;i!=v.length-1;i++ ,i2=i+1){
			if(v[i]>v[i2])
				swap(v,i,i2);
		}
		System.out.print(v);
	}
	
	//Exercícios Extra
	static char[] concat(char[] v, char n){
		char[] r=new char[v.length+1];
		for(int i=0;i!=v.length;i++){
			r[i]=v[i];
			r[v.length]=n;
		}
		return r;
	}

	static char[] concat2(char[] v, char n){
		char[] r=new char[v.length+1];
		for(int i=1;i!=r.length;i++){
			r[i]=v[i-1];
			r[0]=n;
		}
		return r;
	}

	static void replaceRandom(char[] v, char n){
		int j=0;
		for(int i=0;i!=5;i++){
			j=(int)((Math.random()*(i+1)));
		}
		v[j]=n;
		System.out.print(v);
	}
	
	static void swapHalfs(char[] v){
		char[] first=new char[(int)v.length/2];
		char[] second=new char[(int)((v.length/2)+((v.length%2==1)?1:0))];
		for(int i=0;i!=first.length;i++)
			first[i]=v[i];
		for(int i=0;i!=second.length;i++)
			second[i]=v[first.length+i];
		for(int i=0;i!=second.length;i++)
			v[i]=second[i];
		for(int i=0;i!=first.length;i++)
			v[second.length+i]=first[i];
		System.out.print(v);
	}

}