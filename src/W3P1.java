import java.util.Arrays;

/**
 * Created by Adam on 6/29/2016. Problem 1
 */
public class W3P1 {
    public static void main(String[] args){
        double rand[] = new double[100];
        double sum=0;
        for (int k=0 ; k<100 ; k++){
            rand[k]=Math.random();
            sum += rand[k];
        }
        int over=0;
        double average=(sum/100.0);
        System.out.println("average = " + average);
        for (int k=0 ; k<100 ; k++){
            if (rand[k]>average){
                over++;
                System.out.println(rand[k]);
            }
        }
    }
}
