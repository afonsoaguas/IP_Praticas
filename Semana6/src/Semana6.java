class Semana6 {
	static int[][] matrix(){
		int[][] matrix={{1,0,0},{0,1,0},{0,0,1}};
		int[][] matrixlinha={{1,2,3},{4,5,6},{7,8,9}};
		//int v=2;
		return multiplyMatrix(matrix,matrixlinha);
	}

	static int[] [] LinesWithNaturals(int lines){
		int[][] res=new int[lines] [lines];
		for(int i=0; i!=res.length ; i++)
			for(int j=0; j!=res[i].length; j++)
				res[i][j]=i+1;
		return res;
	}

	static boolean LinesAreOrdered(int[][]matrix){
		for(int i = 0; i != matrix.length; i++) {
			for(int j = 0; j != matrix[i].length-1; j++) {
				if(matrix[i][j]<=matrix[i][j+1])
					return true;
			}
		}
		return false;
	}

	static boolean CellsAreOrdered(int[][]matrix){
		for(int i = 0; i != matrix.length-1; i++)
			for(int j = 0; j != matrix[i].length-1; j++)
				if(matrix[i][j]<=matrix[i][j+1] && matrix[i][matrix[i].length]<=matrix[i+1][0])
					return true;
		return false;
	}

	//Trabalho Prévio
	static int[][] randomMatrix(int lines, int columns) {
		int[][] res=new int[lines][columns];
		for(int i=0; i!=res.length ; i++)
			for(int j=0; j!=res[i].length; j++){
				for(int k=0; k!=10; k++)
					res[i][j]=(int)(Math.random()*k);
			}
		return res;
	}

	static int[][] randomIntMatrix(int lines) {
		int[][] res=new int[lines][lines];
		for(int i=0; i!=res.length ; i++)
			for(int j=0; j!=res[i].length; j++){
				for(int k=0; k!=10; k++)
					res[i][j]=(int)(Math.random()*k);
			}
		return res;
	}

	static int sumMatrixcels(int[][] matrix){
		int sum=0;
		for(int i=0; i!=matrix.length ; i++)
			for(int j=0; j!=matrix[i].length; j++)
				sum += matrix[i][j];
		return sum;
	}

	static int NumberOfCells(int[][] matrix){
		int sum=0;
		for(int i=0; i!=matrix.length ; i++)
			for(int j=0; j!=matrix[i].length; j++)
				sum++;
		return sum;
	}

	//Exercícios
	static int[] unroll(int[][] matrix){
		int n=NumberOfCells(matrix);
		int[] res= new int[n];
		int k=0;
		for(int i=0; i!=matrix.length; i++)
			for(int j=0; j!=matrix[i].length; j++){
				res[k]=matrix[i][j];
				k++;
			}
		return res;
	}

	static int[][] matrixFrom(int[] v, int lines, int columns){
		int[][] res= new int[lines][columns];
		int k=0;
		for(int i=0; i!=res.length ; i++)
			for(int j=0; j!=res[i].length; j++){
				res[i][j]=v[k];
				k++;
			}
		return res;
	}

	static boolean isValid(int[][] matrix){
		for(int i=0; i!=matrix.length-1; i++)
			for(int j=0; j!=matrix[i].length-1; j++)
				if(matrix[i].length==matrix[i+1].length)
					return true;
		return false;
	}

	static boolean isSquare(int[][] matrix){
		for(int i=0; i!=matrix.length-1; i++)
			for(int j=0; j!=matrix[i].length-1; j++)
				if(isValid(matrix) && matrix.length==matrix[i].length)
					return true;
		return false;
	}

	static boolean isEqual(int[][] matrix1, int[][] matrix2){
		int[] m1=new int[NumberOfCells(matrix1)];
		int[] m2=new int[NumberOfCells(matrix2)];
		m1=unroll(matrix1);
		m2=unroll(matrix2);
		for(int i=0; i!=m1.length; i++)
			if(m1[i]!=m2[i])
				return false;
		return true;
	}

	static int[][] identity(int n){
		int[][] res=new int[n][n];
		for(int i=0; i!=res.length; i++)
			for(int j=0; j!=res[i].length; j++)
				if(i==j)
					res[i][j]=1;
		return res;
	}

	static void multiplyByScalar(int[][] m, int s){
		for(int i=0; i!=m.length; i++)
			for(int j=0; j!=m[i].length; j++)
				m[i][j]=m[i][j]*s;
	}

	static void accumulate(int[][] m1, int[][] m2){
		for(int i=0; i!=m1.length; i++)
			for(int j=0; j!=m1[i].length; j++)
				m1[i][j]=m1[i][j]+m2[i][j];
	}

	static boolean isIdentity(int[][] matrix){
		for(int i=0; i!=matrix.length; i++)
			for(int j=0; j!=matrix[i].length; j++)
				if(matrix[i][j]!=identity(matrix.length)[i][j])
					return false;
		return true;
	}

	static int[] ColumnOfMatrix(int[][] matrix, int n){
		int[] res= new int[matrix.length];
		for(int i=0; i!=matrix.length; i++)
			res[i]=matrix[i][n];
		return res;
	}

	static int[][] transposedMatrix(int[][] matrix){
		int[][] res=new int[matrix[0].length][matrix.length];
		for(int i=0; i!=matrix.length; i++)
			for(int j=0; j!=matrix[i].length; j++){
				res[j][i]=matrix[i][j];
			}
		return res;
	}
	
	static boolean isSimetric(int[][]matrix){
		int[][] t=transposedMatrix(matrix);
		if(isEqual(matrix,t))
				return true;
		return false;
	}
	
	//Exercício Extra
	static int[][] multiplyMatrix(int[][]m1, int[][]m2){
		int[][] res= new int[m1.length][m2[0].length];
		for(int i=0; i!=res.length; i++)
			for(int j=0; j!=res[i].length; j++){
				int t=0;
				for(int k=0; k!=m2.length; k++){
					t=(m1[i][k]*m2[k][j])+t;
				}
				res[i][j]=t;
			}
		return res;
	}
	

} 