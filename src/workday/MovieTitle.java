package workday;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MovieTitle {
    public static void main(String[] args) throws IOException {
        String[] result = getNumberOfMovies("spiderman");
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }



    static String[] getNumberOfMovies(String substr) throws IOException {
        String url = "https://jsonmock.hackerrank.com/api/movies/search/?Title="+substr;
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        List<String> list = new ArrayList<>();
        MovieResponse movieResponse = fetchMovieDetails(substr, con);
        process(list, movieResponse);
        while (movieResponse != null) {
            movieResponse = fetchMovieDetails(substr, con);
            process(list, movieResponse);
            if (Integer.valueOf(movieResponse.page) == movieResponse.total_pages)
                break;
        }
        Collections.sort(list);
        String[] res = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private static void process(List<String> list, MovieResponse movieResponse) {
        Data[] data = movieResponse.data;
        for (Data movieData: data) {
            list.add(movieData.Title);
        }
    }

    private static MovieResponse fetchMovieDetails(String substr, HttpURLConnection con) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        Gson gson = new Gson();
        return gson.fromJson(response.toString(), MovieResponse.class);
    }

    class MovieResponse {
        public String page;
        public int per_page;
        public int total;
        public int total_pages;
        public Data data[];

        public MovieResponse() {
        }

        public MovieResponse(String page, int per_page, int total, int total_pages, Data[] data) {
            this.page = page;
            this.per_page = per_page;
            this.total = total;
            this.total_pages = total_pages;
            this.data = new Data[per_page];
        }

        @Override
        public String toString() {
            return "MovieResponse{" +
                    "page='" + page + '\'' +
                    ", per_page=" + per_page +
                    ", total=" + total +
                    ", total_pages=" + total_pages +
                    ", data=" + Arrays.toString(data) +
                    '}';
        }
    }

    class Data{
        public String Poster;
        public String Title;
        public String Type;
        public int Year;
        public String imdbID;

        public Data() {
        }

        public Data(String poster, String title, String type, int year, String imdbID) {
            Poster = poster;
            Title = title;
            Type = type;
            Year = year;
            this.imdbID = imdbID;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "Poster='" + Poster + '\'' +
                    ", Title='" + Title + '\'' +
                    ", Type='" + Type + '\'' +
                    ", Year=" + Year +
                    ", imdbID='" + imdbID + '\'' +
                    '}';
        }
    }
}
