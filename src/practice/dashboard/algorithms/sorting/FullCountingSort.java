package practice.dashboard.algorithms.sorting;

import java.util.*;

/**
 * Created by PDeb on 10/30/2017.
 */
public class FullCountingSort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Data> list = new ArrayList<Data>();
        int totalInputs = in.nextInt();
        for (int i = 0; i < totalInputs; i++) {
            int accompnyingInteger = in.nextInt();
            String word = in.next();
            Data data = new Data(accompnyingInteger, word, i);
            list.add(data);
        }
        Collections.sort(list, new DataComparator());
        for(Data data : list)
        {
            if(data.initialPosition<totalInputs/2)
                System.out.print("-");
            else
                System.out.print(data.word);
            System.out.print(" ");
        }
    }
}
class Data {
    public int accompanyingInteger;
    public String word;
    public int initialPosition;

    public Data(int accompanyingInteger, String word, int initialPosition) {
        this.accompanyingInteger = accompanyingInteger;
        this.word = word;
        this.initialPosition = initialPosition;
    }

}

class DataComparator implements Comparator<Data>{

    public int compare(Data o1, Data o2) {
        return o1.accompanyingInteger-o2.accompanyingInteger;
    }
}