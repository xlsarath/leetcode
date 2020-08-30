import java.util.*;

public class ClosestStraightCity {

     /**
   * This method calculates and returns distance between two cities
   * represented by (x1, y1) and (x2,y2).
   *
   * @param x1
   * - x co-ordinate of city 1
   * @param y1
   * - y co-ordinate of city 1
   * @param x2
   * - x co-ordinate of city 2
   * @param y2
   * - y co-ordinate of city 2
   */
   static int distance(int x1, int y1, int x2, int y2) {
    return Math.abs((x1 - x2) + (y1 - y2));
}

/**
* This method finds the closest city to q[i] which is located in a straight
* line. It returns a string array where element at index i denotes the city
* closest to the city q[i].
*
* @param c
* - string array of cities
* @param x
* - integer array representing the x co-ordinate of each city in
* array c
* @param y
* - integer array representing the y co-ordinate of each city in
* array c
* @param q
* - string array representing the cities for which the nearest
* city is to be found
*/
static String[] closestStraightCity(String[] c, int[] x, int[] y, String[] q) {
    // Create a string array to store the nearest city
    String[] nearestCityArr = new String[q.length];

    // Find nearest city for each city in q
    for (int i = 0; i < q.length; i++) {

        // Get queried city
        String queriedCity = q[i];

        // Get co-ordinate of queriedCity
        int[] coord = getCoord(queriedCity, c, x, y);

        // Integer than represents minimum distance from queriedCity
        int minDist = Integer.MAX_VALUE;

        // String that represents nearest city to queriedCity
        String nearestCity = null;

        // ------------------------FIND NEAREST CITY------------------------
        // Check queriedCity with each city in c
        for (int j = 0; j < c.length; j++) {

            // Check if queriedCity and c[j] are not same
            if (!queriedCity.equals(c[j])) {

                // Check if either x or y of both queriedCity and city c[i]
                // are same
                if ((coord[0] == x[j]) || (coord[1] == y[j])) {

                    // Find distance between queriedCity and c[i]
                    int dist = distance(coord[0], coord[1], x[j], y[j]);

                    // Check if dist is less than minDist
                    if (dist <= minDist) {

                        // Update minDist
                        minDist = dist;

                        // Check if nearestCity is null or if nearestCity is
                        // not null and if nearestCity is alphabetically
                        // greater than city c[j]
                        if ((nearestCity == null) || ((nearestCity != null) && (nearestCity.compareTo(c[j]) > 0)))
                            nearestCity = c[j];
                    } // End if (minDIst)
                } // End if ( Co-ordinate compare)
            } // End if (queriedCity compared with c[j])
        } // End for

        // Check if nearestCity if is found
        if (nearestCity != null)
            nearestCityArr[i] = nearestCity;
        else
            nearestCityArr[i] = "NONE";

    } // End for

    // Return nearestCityArr
    return nearestCityArr;
}

/**
* This method returns an integer array containing x and y co-ordinate of
* city. 0th element represents x co-ordinate and 1 represents y co-ordinate
*
* @param city
* - City whose coordinate is to be found
* @param c
* - string array of cities
* @param x
* - integer array representing the x co-ordinate of each city in
* array c
* @param y
* - integer array representing the y co-ordinate of each city in
* array c
*/
static int[] getCoord(String city, String[] c, int[] x, int[] y) {
    // Create int array to hold the x and y co-ordinates of city
    int[] coord = new int[2];

    // Find city in array c
    for (int index = 0; index < c.length; index++) {
        // Check if city is same as c[index]
        if (city.equals(c[index])) {

            // Get x co-ordinate of c[i]
            coord[0] = x[index];

            // Get y co-ordinate of c[i]
            coord[1] = y[index];

            // Exit loop
            break;
        }
    }

    // Return
    return coord;
}

/**
* This method reads n cities, each on a separate line, from stdin.
*
* @param in
* - Scanner to read from stdin
* @param n
* - number of lines to read
* @return - String array
*/
static String[] readNStrings(Scanner in, int n) {
    // Create a string array
    String[] strArr = new String[n];

    // Read n strings from stdin
    for (int i = 0; i < n; i++)
        strArr[i] = in.nextLine().trim();

    // Return strArr
    return strArr;
}

/**
* This method reads n integers, each on a separate line, from stdin.
*
* @param in
* - Scanner to read from stdin
* @param n
* - number of lines to read
* @return - int array
*/
static int[] readNInts(Scanner in, int n) {
    // Create an int array
    int[] intArr = new int[n];

    // Read n integers from stdin
    for (int i = 0; i < n; i++)
        intArr[i] = in.nextInt();

    // Return intArr
    return intArr;
}

public static void main(String[] args) {
    // Scanner to read user input
    Scanner in = new Scanner(System.in);

    // ------------------------CITY------------------------
    // Read n, number of cities
    int n = in.nextInt();

    // Consume the newline character
    in.nextLine();

    // Get n cities from stdin
    String[] city = readNStrings(in, n);

    // ------------------------X-COORD------------------------
    // Read nx, number of x-coordinates
    int nx = in.nextInt();

    // Get nx number of x-coordinates from stdin
    int[] x = readNInts(in, nx);

    // ------------------------Y-COORD------------------------
    // Read ny, number of y-coordinates
    int ny = in.nextInt();

    // Get nx number of x-coordinates from stdin
    int[] y = readNInts(in, ny);

    // ------------------------QUERIED CITIES------------------------
    // Read m, number of cities to be queried
    int m = in.nextInt();

    // Consume the newline character
    in.nextLine();

    // Read m number of cities to be queried
    String[] q = readNStrings(in, m);

    // ------------------------FIND NEAREST CITIES------------------------
    String[] nearestCity = closestStraightCity(city, x, y, q);

    // Display nearest city
    for (int i = 0; i < nearestCity.length; i++)
        System.out.println(nearestCity[i]);
}

}