import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MBTA{
    public HashMap<String, List<String>> lineAndStation;


    public MBTA(){

        lineAndStation = new HashMap<>();
        List<String> red = new ArrayList<>(Arrays.asList("South Station","Park Street","Kendall","Central","Harvard","Porter","Davis","Alewife"));
        List<String> green = new ArrayList<>(Arrays.asList("Government Center","Park Street","Boylston","Arlington","Copley","Hynes","Kenmore"));
        List<String> orange = new ArrayList<>(Arrays.asList("North Station","Haymarket","Park Street","State","Downtown Crossing","Chinatown","Back Bay","Forest Hills"));
        lineAndStation.put("Red", red);
        lineAndStation.put("Green", green);
        lineAndStation.put("Orange",orange);
    }


    public int stopsBetweenStations(String line1,String stop1, String line2,String stop2){
        List<String> station1 = lineAndStation.get(line1);
        List<String> station2 = lineAndStation.get(line2);

        if(line1.equals(line2)){
            int result = Math.abs(station1.indexOf(stop2) - station1.indexOf(stop1));
            System.out.println(result);
            return result;
        }else{
            int line1Result = Math.abs((station1.indexOf(stop1) - station1.indexOf("Park Street")));
            int line2Result = Math.abs((station2.indexOf(stop2) - station2.indexOf("Park Street")));
            int result = line1Result + line2Result;
            System.out.println(result);
            return result;
        }
    }

    public static void main(String[] args) {
        MBTA mbta = new MBTA();
        mbta.stopsBetweenStations("Red", "Alewife", "Red", "Alewife"); // 0 stops
        mbta.stopsBetweenStations("Red", "Alewife", "Red", "South Station"); // 7 stops
        mbta.stopsBetweenStations("Red", "South Station", "Green", "Kenmore"); // 6 stops
    }
}