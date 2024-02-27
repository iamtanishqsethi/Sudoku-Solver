public class Sudoku {
    public static void main(String[] args) {
        int[][] board = new int[][]{
                {0, 0, 2, 1, 0, 6, 5, 8, 0},
                {9, 0, 0, 0, 0, 5, 0, 0, 1},
                {0, 6, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 6, 0, 5, 7, 4, 3, 0},
                {0, 4, 0, 0, 0, 0, 0, 7, 0},
                {0, 9, 5, 4, 3, 0, 8, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 4, 0},
                {3, 0, 0, 5, 0, 0, 0, 0, 8},
                {0, 2, 4, 3, 0, 1, 6, 0, 0}
        };
        if(solve(board)){
            display(board);
        }
        else {
            System.out.println("cannot solve");
        }
    }
    static boolean solve(int[][] board){
        int n = board.length;
        int row = -1;
        int col = -1;
        boolean emptyLeft = true;

        //This is how we are replacing the r,c from arguments
        for(int i = 0;i<n;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==0){//found empty item , nothing placed yet
                    row= i ;
                    col= j;
                    emptyLeft=false;//marking the cell
                    break;
                }
            }
            //if we found some empty element in row, then break
            if(emptyLeft==false){
                break;
            }
        }
        //if no empty element left
        if(emptyLeft==true){
            return true;
            //sudoku solved
        }
        //put the answer and back track
        for(int number = 1;number<=board.length;number++){
            if(isSafe(board,row,col,number)){
                board[row][col]=number;
                //checking if we can solve this
                if(solve(board)){
                    return true;
                    //found answer
                }
                else{
                    //back track
                    board[row][col]=0;
                }
            }
        }
        //if nothing works out , sudoku cannot be solved
        return false;
    }
    static void display(int[][] board){
        for(int[] row:board){
            for(int num:row){
                System.out.print(num+" ");
            }
            System.out.println();
        }
    }

    static boolean isSafe(int[][] board ,int row,int col,int num){
        //checking the row
        for(int i=0;i<board.length;i++){
            //if the number is already in the row,we cannot place it
            if(board[row][i]==num){
                return false;
            }
        }
        //checking in the col
        for(int[] nums:board){
            //if the num is already in column , we cannot place it
            if(nums[col]==num){
                return false;
            }
        }
        //checking in the 3x3 square(for 9x9 sudoku),
        // if the num is already placed or not

        int sqrt = (int)(Math.sqrt(board.length));
        int rowStart = row-row%sqrt;
        int colStart = col-col%sqrt;

        for(int r = rowStart;r<rowStart+sqrt;r++){
            for(int c = colStart;c<colStart+sqrt;c++){
                if(board[r][c]==num){
                    return false;
                }
            }
        }
        // if everything ok , we can place that number at the particular cell
        return true;
    }
}
