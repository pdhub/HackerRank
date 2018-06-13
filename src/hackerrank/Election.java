package hackerrank;

import java.util.*;

public class Election {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = in.nextInt();
        String[] votes = new String[testCases];
        for (int i = 0; i < testCases; i++) {
            votes[i] = in.next();
        }
        System.out.println(electionWinner(votes));
    }

    static String electionWinner(String[] votes) {
        Map<String, Contender> map= new HashMap<>();
        for (String contenderName: votes
             ) {
            if (map.containsKey(contenderName))
                map.get(contenderName).votes++;
            else
                map.put(contenderName, new Contender(contenderName, 1));
        }
        Set<Contender> allContenders = new TreeSet<>(new ContenderComparator().reversed());
        for (Contender contender: map.values()
             ) {
            allContenders.add(contender);
        }
        return ((TreeSet<Contender>) allContenders).pollFirst().name;
    }

    static class ContenderComparator implements Comparator<Contender>{
        @Override
        public int compare(Contender o1, Contender o2) {
            if (o1.votes == o2.votes)
                return o1.name.compareTo(o2.name);
            return o1.votes.compareTo(o2.votes);
        }
    }

    static class Contender {
        public String name;
        public Integer votes;

        public Contender(String name, Integer votes) {
            this.name = name;
            this.votes = votes;
        }
    }
}
