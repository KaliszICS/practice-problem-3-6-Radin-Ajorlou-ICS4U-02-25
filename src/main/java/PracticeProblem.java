public class PracticeProblem {

	public static void main(String args[]) {
		String[][] arr = {
			{"r", "r", "*", "r", "F"},
			{"r", "r", "r", "r", "r"},
			{"s" }
		};
		System.out.println(noOfPaths(arr));

	}



	public static int searchMazeMoves(String[][] arr){
		int row = arr.length - 1;
		int column = 0;
		int moves = 0;
		int leastMoves = 1000;
		leastMoves = searchHelper(arr, row, column, moves, leastMoves);
		if (leastMoves == 1000){
			return -1; 
		}
		return leastMoves;
	}


	public static int searchHelper(String[][] arr, int row, int column, int moves, int leastMoves){
		if (arr[row][column] == "F"){
			if (moves <= leastMoves){
				leastMoves = moves;
			}
			return leastMoves;
		}

		else if(arr[row][column] == "*"){
			moves--;
			return leastMoves;
		}

		try{
			moves++;
			leastMoves = searchHelper(arr, row, column + 1, moves, leastMoves); //tries move right
			moves--;
		}
		catch(ArrayIndexOutOfBoundsException e){
			moves--; //if move right out of bounds removes the step
		}
		try{
			moves++;
			leastMoves = searchHelper(arr, row - 1, column, moves, leastMoves); //tries move up
		}
		catch(ArrayIndexOutOfBoundsException l){
			moves--; //if move up out of bounds removes the step;
		}
		return leastMoves;

	}








	public static int noOfPaths(String[][] arr){
		int row = arr.length - 1;
		int column = 0;
		int paths = 0;
		return pathsHelper(arr, row, column, paths);

	}



	public static int pathsHelper(String[][] arr, int row, int column, int paths){
		if (arr[row][column] == "F"){
			return ++paths;
		}
		else if(arr[row][column] == "*"){
			return paths;
		}

		try{
			paths = pathsHelper(arr, row, column + 1, paths);//move right
		}
		catch(ArrayIndexOutOfBoundsException e){}
		try{
			paths = pathsHelper(arr, row - 1, column, paths);//move up 
		}
		catch(ArrayIndexOutOfBoundsException l){}
		return paths;
	}















	
}
