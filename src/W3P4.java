import java.util.Arrays;

/**
 * Created by Adam on 6/29/2016. Problem 4
 */
public class W3P4 {
    public static void main(String[] args){
    int die;
    int count[] = new int[6];
        for (int k=0 ; k<1000 ; k++){
            die = (int) ((Math.random()*6)+1);
            count[die-1]+=1;
        }
        for (int m=0 ; m<6 ; m++) {
            System.out.println("There are " + count[m] + " " + (m+1) + "'s rolled (" + (double) (count[m]/10.0) + "%)");
        }
    }
}
