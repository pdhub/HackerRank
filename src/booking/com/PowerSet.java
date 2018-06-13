package booking.com;

import java.util.*;

public class PowerSet{

    public static void main(String[] args) {
        find_all_possible_teams();
    }
        static void find_all_possible_teams() {
            Scanner in = new Scanner(System.in);
            String s = in.next();
            Set<String> res = findTeams(s);
            List<String> list = new ArrayList<>(res);
            Collections.sort(list, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    if (o1.length() == o2.length())
                        return o1.compareTo(o2);
                    return o1.length() - o2.length();
                }
            });//Collections.sort(Arrays.asList());
            for (String s1: list
                 ) {
                System.out.println(s1);
            }

        }

        private static Set<String> findTeams(String s) {
            Set<String> set = new TreeSet<>();
            if(!s.isEmpty())
                set.add(s);
            for(int i=0; i<s.length();i++){
                String substring = s.substring(0, i) + s.substring(i+1);
                set.addAll(findTeams(substring));
            }
            return set;
        }


}
