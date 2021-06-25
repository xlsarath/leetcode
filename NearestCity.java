
import java.util.*;

public class NearestCity {
        class City {
            int x;
            int y;
            String name;
        }
    
        private int dist(City c1, City c2) {
            return (c2.x - c1.x) * (c2.x - c1.x) + (c2.y - c1.y) * (c2.y - c1.y);
        }
    
        public List<String> getNearestCities(int numOfCities, List<String> cities, List<Integer> xCoordinates, List<Integer> yCoordinates, int numOfQueries, List<String> queries) {
            Map<String, City> cityMap = new HashMap<>();
            Map<Integer, Set<String>> xMap = new HashMap<>();
            Map<Integer, Set<String>> yMap = new HashMap<>();
    
            for (int i = 0; i < numOfCities; i++) {
                City city = new City();
                city.name = cities.get(i);
                city.x = xCoordinates.get(i);
                city.y = yCoordinates.get(i);
    
                cityMap.put(city.name, city);
    
                Set<String> xMapCities = xMap.getOrDefault(city.x, new HashSet<>());
                xMapCities.add(city.name);
                xMap.put(city.x, xMapCities);
    
                Set<String> yMapCities = yMap.getOrDefault(city.y, new HashSet<>());
                yMapCities.add(city.name);
                yMap.put(city.y, yMapCities);
            }
    
            List<String> result = new LinkedList<>();
            for (String query : queries) {
                City city = cityMap.get(query);
    
                Set<String> set = new HashSet<>();
                set.addAll(xMap.get(city.x));
                set.addAll(yMap.get(city.y));
    
                int minDist = Integer.MAX_VALUE;
                String str = "";
                for (String cityName : set) {
                    City c = cityMap.get(cityName);
                    int dist = dist(city, c);
                    if (!cityName.equals(query) && dist <= minDist) {
                        if (dist < minDist) {
                            str = c.name;
                        } else if (str.compareTo(c.name) < 0) {
                            str = c.name;
                        }
                        minDist = dist;
                    }
                }
    
                if (str.length() > 0) {
                    result.add(str);
                } else {
                    result.add("None");
                }
            }
    
            return result;
        }
    
        public static void main(String[] args) {
            int numOfCities = 3;
            String[] cities = {"c1", "c2", "c3"};
            Integer[] xCoordinates = {3, 2, 1};
            Integer[] yCoordinates = {3, 2, 3};
            int numOfQueries = 3;
            String[] queries = {"c1", "c2", "c3"};
            NearestCity nearestCity = new NearestCity();
            List<String> result = nearestCity.getNearestCities(numOfCities, Arrays.asList(cities), Arrays.asList(xCoordinates), Arrays.asList(yCoordinates), numOfQueries, Arrays.asList(queries));
            for (String str : result) {
                System.out.println(str);
            }
        }
    }