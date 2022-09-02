class Position{
	//treated as a tuple rather than a list
	public final int i; // row index
	public final int j; // column index

	// This class was created first. 
	// It was used to represent the position
	// of an object in a world object which
	// was a matrix of obstacles, an agent, and a goal

	public Position(int i, int j){
		this.i = i;
		this.j = j;
	}

	@Override
	public String toString(){
		return "(" + i + "," + j + ")";
	}

	@Override
	public boolean equals(Object obj){
		Position p = (Position) obj;
		return this.i == p.i && this.j == p.j;
	}

	@Override
	public int hashCode(){
		return (i + "_" + j).hashCode();
	}

	// distance from this poition to a position p
	public int distance(Position p){
		return Math.abs(this.i - p.i) + Math.abs(this.j - p.j);
	}
}