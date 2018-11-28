import java.util.ArrayList;

/**
 * @author xiaobzhu
 * this class is the main class for the quick sort. in this class it used to random generate the random 100 value. use the Math
 * object,to random generate 100 different numbers
 */
public class QuickSort {
    /**
     * this is the mean method for this project, in this method it random generate 100 different value
     * @param args parameter in the main method.
     */
    public static void main(String args[]){
        ArrayList<Integer> randomArr = new ArrayList<Integer>();
        int num = 100;
        for(int i = 0; i < num; i++){ // random generate 100 different numbers
            randomArr.add((int)(Math.random()*100));
        }
        System.out.println("initial = "+randomArr);
        Calculation calculation = new Calculation(randomArr);

    }
}
