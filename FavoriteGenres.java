//time complexity :  O(u * (s+g))
//space complexity : O(S + g)
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FavoriteGenres {

    public static Map<String, List<String>> favoritegenre(Map<String, List<String>> userMap, Map<String, List<String>> genreMap) {

        HashMap<String, String> songToGenre = new HashMap<>();

        for(String genre : genreMap.keySet()){

            List<String> songs = genreMap.get(genre);
            if(songs == null) continue;
            for(String song : songs){
                songToGenre.put(song, genre);
            }
        }

      //  System.out.println(songToGenre);

        HashMap<String, List<String>> result = new HashMap<>();

        for(Map.Entry<String, List<String>> entry : userMap.entrySet()) {
            String user = entry.getKey();
            List<String> userSongs = entry.getValue();
            if(userSongs == null || userSongs.size() == 0) continue;
            Map<String, Integer> songGenreFreqMap = getGenreFreqMap(songToGenre,userSongs);
            List<String> mostHeardGenres = getMostHeardGenres(songGenreFreqMap);
            result.put(user, mostHeardGenres);
        }

        return result;
    }

    private static List<String> getMostHeardGenres(Map<String, Integer> songGenreFreqMap) {

        List<String> mostHeardGenre = new LinkedList<>();
        if(songGenreFreqMap == null) return mostHeardGenre;

        int max = Integer.MIN_VALUE;

        for(Map.Entry<String,Integer> entry :  songGenreFreqMap.entrySet()){

            String genre = entry.getKey();
            int count = entry.getValue();

            if(count > max){
                mostHeardGenre = new LinkedList<>();
                mostHeardGenre.add(genre);
                max = count;
            } else if (count == max){
                mostHeardGenre.add(genre);
            }

        }

        return mostHeardGenre;
    }

    private static Map<String, Integer> getGenreFreqMap(HashMap<String, String> songToGenre, List<String> userSongs) {

            HashMap<String,Integer> freqMap =new HashMap<>();

            if(userSongs == null || userSongs.size() == 0) return freqMap;

            for(String song : userSongs){
                String currentGenre = songToGenre.get(song);
                freqMap.put(currentGenre,freqMap.getOrDefault(currentGenre, 0)+1 );
            }
           

        return freqMap;
    }

    public static void main(String[] args) {

        HashMap<String, List<String>> userSongs = new HashMap<>();
        userSongs.put("David", Arrays.asList(new String[]{"song1", "song2", "song3", "song4", "song8"}));
        userSongs.put("Emma", Arrays.asList(new String[]{"song5", "song6", "song7"}));

        HashMap<String, List<String>> songGenres = new HashMap<>();
        songGenres.put("Rock", Arrays.asList(new String[]{"song1", "song3"}));
        songGenres.put("Dubstep", Arrays.asList(new String[]{"song7"}));
        songGenres.put("Techno", Arrays.asList(new String[]{"song2", "song4"}));
        songGenres.put("Pop", Arrays.asList(new String[]{"song5", "song6"}));
        songGenres.put("Jazz", Arrays.asList(new String[]{"song8", "song9"}));

        Map<String, List<String>> res = favoritegenre(userSongs, songGenres);
        System.out.println(res);
    }
}