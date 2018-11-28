import java.util.*;

/**
 * @author xiaobzhu
 * this class is used to do the calculation for the quicksort, in this file, it get the random array from the main file
 * then do the calculation in this file
 */
public class Calculation {
    private ArrayList<Integer> finalAnswer = new ArrayList<>();

    /**
     * this is the constructor of the calculation file, in this constructor it pass the arraylist value from the main file
     * @param arrayList get the value pass in
     */
    public Calculation(ArrayList<Integer>arrayList){
        quickSort(arrayList);
        System.out.println("FInal result     "+finalAnswer);

    }

    /**
     * this method is used to used to seperate the numbers into three arraylist whis based on the pivots, and to do the quick
     * sort in this method
     * it used the check method, use the check method, to check the number is ordered or not in each part, if it's not
     * in order, it will got to recursive to run the quick sort method
     * this is the recursive way to solve the quick sort
     * @param arrayList the arraylist value pass in
     */
    public void quickSort(ArrayList <Integer>arrayList){
        ArrayList<Integer> partA = new ArrayList();
        ArrayList<Integer>  partB = new ArrayList();
        ArrayList<Integer>  partC = new ArrayList();
        int[] pivot = pivot(arrayList);
        for(int i=0; i< arrayList.size(); i++){    // this for loop is used to put the numbers into the suitable arraylist
            if(arrayList.get(i) <= pivot[0]){
                partA.add(arrayList.get(i));
            }
            if(arrayList.get(i) >= pivot[1]){
                partC.add(arrayList.get(i));
            }
            if(arrayList.get(i) < pivot[1] && arrayList.get(i) > pivot[0]){
                partB.add(arrayList.get(i));
            }
            System.out.println("sub arrays = " +partA +" "+partB+" "+partC);
        }


        arrayList.clear(); // after one order process, it will clear up the arraylist
        arrayList.addAll(partA);
        arrayList.addAll(partB);
        arrayList.addAll(partC);
        if(!check(partA)){ // do the check for each arraylist, if the arraylist is not in order, it will rework on the quickSort method
            quickSort(partA);
        }else{
            finalAnswer.addAll(partA);
        }
        if(!check(partB)){
            quickSort(partB);
        }else{
            finalAnswer.addAll(partB);
        }
        if(!check(partC)){
            quickSort(partC);
        }else{
            finalAnswer.addAll(partC);
        }





    }

    /**
     * this method is used to calculation to find the pivot of the array list, in this method it will choose the pivot in
     * random way, also in this method it will put the smaller pivot in the previous position
     * @param arrayList the value pass in
     * @return the int array value, the array has two elements
     */
    public int[] pivot(ArrayList<Integer>arrayList){
        int[] pivot = new int[2];  // this part is random choos the pivot from the numbers, I create the lenght two int array to save these two pivots
        Random ran = new Random();  //call the random class
        pivot[0] = arrayList.get(ran.nextInt(arrayList.size()));
        pivot[1] = arrayList.get(ran.nextInt(arrayList.size()));
        while(pivot[0] == pivot[1]){
            pivot[0] = arrayList.get(ran.nextInt(arrayList.size()));
            pivot[1] = arrayList.get(ran.nextInt(arrayList.size()));
        }
        if(pivot[0] > pivot[1]){
            int i  = pivot[0];
            pivot[0] = pivot[1];
            pivot[1] = i;
        }
        System.out.println("randomly select pivots --> "+pivot[0] +" "+ pivot[1]);
        return pivot;
    }

    /**
     * this method is used to do the check, it used to check the number is ordered or not, it works like to compare the
     * number in the next position and the current posistion, if the number in the next position is larger than the current
     * position, it will return false, then it will let the quicksort method to recursive to run it self until the value
     * pass in can make this method to return true
     * @param arrayList the value pass in
     * @return the boolean value, to show the arraylist is order not not, if its true, it mean order, if its false, it means
     * not order.
     */
    public boolean check(ArrayList<Integer> arrayList){
        if (arrayList.size() > 1){
            for(int i = 0; i < arrayList.size()-1; i++){// this for loop is used to check the arraylist is in order or not
                if(arrayList.get(i) > arrayList.get(i+1)){
                    return false;
                }
            }
        }
        return true;
    }



}
