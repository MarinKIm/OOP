public class City {
    String name;
    float lat;
    float lot;

    public City(String name, float lat, float lot){
        this.name = name;
        this.lat = lat;
        this.lot = lot;
    }
    public City(String name){
        this.name = name;
        lat = (float)Math.random();
        lot = (float)Math.random();
    }
    public int equals(City city1, City city2){
        if(city1.name.equals(city2.name) && (city1.lat == city2.lat) &&(city1.lot == city2.lot) ){
            return 1;
        }
        else{
            return 0;
        }
    }

    public static void toString(City city){
        System.out.printf("City: %s\n",city.name);
        System.out.printf("    Longitude: %f\n",city.lot);
        System.out.printf("    Latitude: %f\n",city.lat);
    }

    public static void getDistance(City city1, City city2){
        toString(city1);
        System.out.printf(" to\n");
        toString(city2);

        float latSquare = (city1.lat-city2.lat)*(city1.lat-city2.lat);
        float lotSquare = (city1.lot-city2.lot)*(city1.lot-city2.lot);

        System.out.printf(" is\n");
        System.out.println(Math.sqrt(latSquare+lotSquare));
    }
    }