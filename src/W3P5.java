import java.util.Scanner;

/**
 * Created by Adam on 6/29/2016. Problem 4
 */
public class W3P5 {
    public static void main(String[] args){
    int die,rolls;
    int count[] = new int[6];
    Scanner scan = new Scanner(System.in);
    System.out.println("How many rolls? ");
    rolls=scan.nextInt();
        for (int k=rolls ; k>0 ; k--){
            die = (int) ((Math.random()*6)+1);
            count[die-1]+=1;
        }
        for (int m=0 ; m<6 ; m++) {
            System.out.println("There are " + count[m] + " " + (m+1) + "'s rolled (" + (double) (count[m]/10.0) + "%)");
        }
    }
}
