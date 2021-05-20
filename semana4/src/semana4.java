import java.util.Random;
class semana4 {


	static int numberofnegatives(int[] v){
		int count=0;
		int i=0;
		while (i!=v.length){
			if (v[i]<0)
				count++;
			i++;
		}
		return count;
	}

	static boolean allpar(int[] v){
		int i=0;
		while(i!=v.length){
			if(v[i]%2!=0)
				return false;
			i++;
		}
		return true;
	}

	static boolean operations(boolean[] v){
		int i=0;
		while(i!=v.length){
			if(!v[i])
				return false;
			i++;
		}	
		return true;
	}
	static int[] number_even_array(int[] v){
		int i=0;
		int[] u=new int[v.length];
		int i2=0;
		while(i!=v.length){
			if(v[i]%2==0){
				u[i2]=v[i];
				i2++;
			}
			i++;
		}
		return u;
	}
	static int[] naturais(int n){
		int[] resultado=new int[n];
		int i=0;
		while(i!=n){
			resultado[i]=i+1;
			i++;
		}
		return resultado;
	}

	static int[] random(int v){
		int[] resultado=new int[v];
		int i=0;
		while(i!=0){
			resultado[i]=(int)(Math.random()*9);
			i++;
		}
		return resultado;
	}

	static int sum(int[] n){
		int resultado=0;
		int i=0;
		while(i!=n.length){
			resultado=resultado+n[i];
			i++;
		}
		return resultado;
	}

	static double media(int[] v){
		double resultado=0;
		double soma= sum(v);
		resultado=soma/v.length;
		return resultado;
	}

	static int[] copy(int[] v, int size){
		int[] u=new int[size];
		int i=0;
		while(i<v.length && i<u.length){
			u[i]=v[i];
			i++;
		}
		return u;
	}

	static int[] same(int[]v){
		return v;
	}

	static boolean exist(int[] v, int n){
		int i=0;
		while(i!=v.length){
			if(n==v[i])
				return true;
			i++;
		}
		return false;
	}

	static int count(int[] v, int n){
		int resultado=0;
		int i=0;
		while(i!=v.length){
			if (v[i]==n){
				resultado++;
			}
			i++;
		}
		return resultado;
	}

	static int max(int[] v){
		int r=v[0];
		int i=0;
		while (i!=v.length){
			if(v[i]>r)
				r=v[i];
			i++;
		}
		return r;
	}

	static int[] subvector(int[] v, int n, int m){
		int[] r=new int[m-n+1];
		int i=0;
		int count=n;
		while(count<=m && count>=n){
			r[i]=v[count];
			count++;
			i++;
		}
		return r;
	}

	static int[] firsthalf(int[] v,boolean n){
		int m=v.length/2;
		if (n && v.length%2==1){
			m++;
		}
		int[] u=new int[m];
		int i=0;
		while(i<m){
			u[i]=v[i];
			i++;
		}
		return u;	
	}

	static int[] secondthalf(int[] v,boolean n){
		int m=v.length/2;
		if (n && v.length%2==1){
			m++;
		}
		int[] u=new int[m];
		int i=0;
		while(i<u.length){
			u[i]=v[v.length -m+i];
			i++;
		}
		return u;	
	}

	static int[] merge(int[] v, int[] u){
		int i=0;
		int[] resultado= new int[v.length + u.length];
		while (i!=v.length){
			resultado[i]=v[i];
			i++;
		}
		i=0;
		while (i!=u.length){
			resultado[i+v.length]=u[i];
			i++;
		}
		return resultado;
	}

	static int[] inverse(int[] v){
		int i=0;
		int[] novo=new int[v.length];
		while(i!=v.length){
			novo[i]=v[v.length - i-1];
			i++;
		}
		return novo;
	}

	static int randvector(int[] v){
		Random random=new Random();
		int n=random.nextInt(v.length);
		return v[n];
	}

	static int[] duplicate(int[] v){
		int i=0;
		int[] novo=new int[2*(v.length)];
		while(i!=v.length){
			novo[2*i]=v[i];
			novo[2*i+1]=v[i];
			i++;;
		}
		return novo;
	}

	static int[] dupliinvert(int[] v){
		int i=0;
		int[] novo=new int[2*(v.length)];
		int[] inv=inverse(v);
		while(i!=v.length){
			novo[i]=v[i];
			i++;
		}
		i=0;
		while(i!=v.length){
			novo[v.length+i]=inv[i];
			i++;
		}
		return novo;
	}

	//------------------------------------//
	//------------------------------------//

	static int[] fhalf(int[] v){
		int m=v.length/2;
		int[] u=new int[m];
		int i=0;
		while(i<m){
			u[i]=v[i];
			i++;
		}
		return u;	
	}

	static int[] shalf(int[] v){
		int m=v.length/2;
		int[] u=new int[m];
		int i=0;
		while(i<u.length){
			u[i]=v[v.length -m+i];
			i++;
		}
		return u;	
	}

	//--------------------------------//
	//--------------------------------//

	static int[] copymiddle(int[] v){
		int i=0;
		int m=v.length/2;
		int t=v.length;
		if(v.length%2==1){
			t=t-1;
		}
		int[] novo=new int[t];
		int[] first;
		int[] second;
		if(v.length%2==0){
			return v;
		}
		else{
			first=fhalf(v);
			second=shalf(v);
			while(i!=first.length){
				novo[i]=first[i];
				i++;
			}
			i=0;
			while(i!=second.length){
				novo[m+i]=second[i];
				i++;
			}
		}
		return novo;
	}

	static int[] fibovector(int n){
		int i=2;
		int[] resultado= new int[n];
		if(n==0){
			return resultado;
		}
		if(n==1){
			resultado[0]=0;
		return resultado;
		}
		if(n==2){
			resultado[0]=0;
			resultado[1]=1;
			return resultado;
		}
		if(n>2){
			while(i<n){
				resultado[0]=0;
				resultado[1]=1;
				resultado[i]=resultado[i-1]+resultado[i-2];
				i++;
			}
		}
		return resultado;	
	}
}