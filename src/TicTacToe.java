/**
 * Created by Adam on 6/29/2016. Worksheet 4
 */
public class TicTacToe {
    public static void main(String[] args){
        String[] board = new String[9];
        clearBoard(board);
        board[1] = "X";
        board[3] = "X";
        board[8] = "X";
        board[2] = "O";
        board[4] = "O";
        board[7] = "O";
        printBoard(board);
    }
    public static void printRow(String[] board, int startSquare)
    {
        System.out.print(board[startSquare]);
        System.out.print("|");
        System.out.print(board[startSquare + 1]);
        System.out.print("|");
        System.out.print(board[startSquare + 2]);
        System.out.println("");
    }
    public static void printBoard(String[] board)
    {
        for (int k=0 ; k<=6 ; k+=3) {
            printRow(board, k);
            System.out.println("-----");
        }
        System.out.println("___________________________");
    }
    public static void clearBoard(String[] board){
        for (int k=0 ; k<=8 ; k++){
            board[k]="*";
        }
    }
    public static int getBoardState(String[] board){
        int state=5;
        for (int k=0 ; k<=6 ; k+=3){ //check for horizontal row wins
            if (board[k].equals(board[k+1])&&board[k].equals(board[k+2])){
                if (board[k].equals("X")){
                    state=1;//x wins
                } else if (board[k].equals("O")){
                    state=2; //o wins
                }
            }
        }
        for (int k=0 ; k<=3 ; k++){ //check for vertical wins
            if (board[k].equals(board[k+3])&&board[k].equals(board[k+6])){
                if (board[k].equals("X")){
                    state=1;//x wins
                } else if (board[k].equals("O")){
                    state=2; //o wins
                }
            }
        }

        return state;
    }
}
