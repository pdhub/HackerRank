package booking.com;

import java.util.*;

public class HotelSorting {
    public static void main(String[] args) {
        new HotelSorting().printHotels();
    }

    static void printHotels(){
        Scanner in = new Scanner(System.in);
        int input = in.nextInt();
        Map<Integer, Hotel> map = new HashMap<Integer, Hotel>();
        Map<Integer, Integer> hotelCount = new HashMap<Integer, Integer>();

        while(input-- >0){
            int hotelId = in.nextInt();
            int score = in.nextInt();
            Hotel hotel = map.get(hotelId);
            if(Objects.isNull(hotel)){
                hotel = new Hotel(hotelId, score);
                hotel.setAvgScore(Long.valueOf(score));
                map.put(hotelId, hotel);
                hotelCount.put(hotelId, 1);
            }else {
                int count = hotelCount.get(hotelId);
                int totalScore = hotel.getScore() + score;
                hotel.setScore(totalScore);
                hotel.setAvgScore(Long.valueOf(totalScore)/(count+1));
                hotelCount.put(hotelId, hotelCount.get(hotelId)+1);
            }
        }

        List<Hotel> hotelList = new ArrayList<Hotel>();
        for (Integer hotelId: map
                .keySet()
             ) {
            hotelList.add(map.get(hotelId));
        }
        Collections.sort(hotelList);

        for (Hotel hotel: hotelList
             ) {
            System.out.println(hotel.getHotelId());
        }
    }

    static class Hotel implements Comparable<Hotel>{
        private int hotelId;
        private int score;
        private Long avgScore;

        public Hotel(int hotelId, int score) {
            this.hotelId = hotelId;
            this.score = score;
        }

        public int compareTo(Hotel o) {
            if(o.avgScore == this.avgScore){
                //return this.hotelId - o.hotelId;
                return o.hotelId - this.hotelId;
            }
            //return ((Long)(o.avgScore - this.avgScore)).intValue();
            return ((Long)(this.avgScore - o.avgScore)).intValue();
        }

        public int getHotelId() {
            return hotelId;
        }

        public void setHotelId(int hotelId) {
            this.hotelId = hotelId;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

        public Long getAvgScore() {
            return avgScore;
        }

        public void setAvgScore(Long avgScore) {
            this.avgScore = avgScore;
        }
    }
}
