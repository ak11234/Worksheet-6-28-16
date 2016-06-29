import javax.sql.rowset.spi.SyncResolver;
import java.util.Scanner;

/**
 * Created by Adam on 6/29/2016. Worksheet 4
 */
public class TicTacToe {
    public static final String[] playerSymbol = { "X", "O" };
    public static String[] playerType = {"Human" , "Computer"};
    public static void main(String[] args){
        System.out.println("How many players?: ");
        Scanner scan = new Scanner(System.in);
        int numplayers;
        numplayers = scan.nextInt();
        if (numplayers==0){
            playerType[0]="Computer";
        }
        if (numplayers==2){
            playerType[1]="Human";
        }
        String[] board = new String[9];
        int player = 0;
        int currentMove;
        clearBoard(board);
        while (getBoardState(board)==4){
            //GAME TIME
            printBoard(board);
            currentMove=getMove(board,player);
            while (! isLegalMove(board, currentMove)){
                System.out.println(playerType[player] + " has made an invalid move and must try again.");
                currentMove=getMove(board,player);
            }
            board[currentMove]=playerSymbol[player];
            player = switchPlayer(player);
        }
        printBoard(board);
        int status =getBoardState(board);
        if (status==1){
            System.out.println("X Wins!");
        }
        else if (status==2){
            System.out.println("O Wins!");
        }
        else if (status==3){
            System.out.println("Looks like it was a tie -_-");
        } else {
            System.out.println("Error: State Code: " + status);
        }
        System.out.println("State code: " + getBoardState(board));
    }
    public static int getMove(String[] board, int player){
        if (playerType[player].equals("Human")){
            return getHumanMove();
        }
        else if (playerType[player].equals("Computer")){
            return getComputerMove(board,player);
        }
        return -1;
    }
    public static boolean isLegalMove(String[] board, int move){
        if (board[move].equals("*")){
            return true;
        }
        return false;
    }
    public static int switchPlayer(int player){
        if (player==0){
            return 1;
        }else {
            return 0;
        }
    }
    public static int getHumanMove(){
        System.out.println("Present your move: ");
        Scanner scan = new Scanner(System.in);
        int num;
        num = scan.nextInt();
        return num;
    }
    public static int getComputerMove(String[] board, int computernum){
        int move = ((int) (Math.random()*8));
        return move;
    //    board[move]=playerSymbol[computernum];
    //    System.out.println("i moved -" + playerSymbol[computernum] + "- into position " + move);
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
                    return 1;//x wins
                } else if (board[k].equals("O")){
                    return 2; //o wins
                }
            }
        }
        for (int k=0 ; k<3 ; k++){ //check for vertical wins
            if (board[k].equals(board[k+3])&&board[k].equals(board[k+6])){
                if (board[k].equals("X")){
                    return 1;//x wins
                } else if (board[k].equals("O")){
                    return 2; //o wins
                }
            }
        }
        if (board[0].equals(board[4])&&board[0].equals(board[8])){ //check topleft to br diag win
            if (board[0].equals("X")){
                return 1;//x wins
            } else if (board[0].equals("O")){
                return 2; //o wins
            }
        }
        if (board[2].equals(board[4])&&board[2].equals(board[6])){ //check topleft to br diag win
            if (board[2].equals("X")){
                return 1;//x wins
            } else if (board[2].equals("O")){
                return 2; //o wins
            }
        }
        for (int k=0 ; k<=8 ; k++){ //check if any open spaces
            if (board[k].equals("*")){
                return 4; //open space, game still on
            }
        }
        return 3;
    }
}
