/**
 * Created by Adam on 6/29/2016. Worksheet 4
 */
public class W4P1 {
    public static void main(String[] args){
        String[] board = new String[9];
        board[1] = "X";
        board[3] = "X";
        board[8] = "X";
        board[2] = "O";
        board[4] = "O";
        board[7] = "O";
        printBoard(board);
        board[0] = "X";
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
        printRow(board, 0);
        System.out.println("-----------");
    }
}
