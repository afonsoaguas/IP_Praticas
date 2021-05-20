class IntSet {

	int size;
	private int[] vector;
	private int next;

	IntSet(int size){
		this.size=size;
		vector= new int[size];
		next=0;
	}

	IntSet(int[] vector){
		this.vector=vector;
		next=0;
	}

	int capacity(){
		return vector.length; 
	}

	int numElements(){
		return next;
	}

	boolean isEmpty(){
		return next==0; 
	}

	boolean isFull(){
		return next==vector.length; 
	}

	boolean exist(int n){
		for(int i=0; i<vector.length; i++)
			if(vector[i]==n)
				return true;
		return false;
	}

	public int[] getElements(){
		return vector;
	}

	void add(int n){
		if(exist(n))
			throw new IllegalArgumentException("Esse numero é repetido!");
		if(isFull())
			throw new IllegalStateException("O vetor está cheio!");
		vector[next]=n;
		next++;
	}

	void remove(int n){
		if(!exist(n))
			throw new IllegalArgumentException("Esse numero não existe!");
		for(int i=0; i<vector.length; i++)
			if(vector[i]==n)
				for(int l=i; l<vector.length-1; l++)
					vector[l]=vector[l+1];
	}

	void duplicate(){
		int[] vector=new int[2*this.vector.length];
		for(int i=0; i<next; i++)
			vector[i]=this.vector[i];
	}

	public IntSet union(IntSet set){
		int[] vector=new int[this.vector.length + set.vector.length];
		for(int i=0; i<this.vector.length; i++)
			vector[i]=this.vector[i];
		for(int i=0; i<set.vector.length; i++)
			vector[i]=this.vector[i];
		return new IntSet(vector);
	}

	public IntSet inters(IntSet set){
		union(set);
		for(int i=0; i<vector.length; i++)
			if(exist(vector[i]))
				remove(i);
		return new IntSet(vector);
	}

}