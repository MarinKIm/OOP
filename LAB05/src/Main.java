public class Main {
    public static void main(String[] args){
        City seoul = new City("Seoul", 23, 45);
        City paris = new City("Paris",123,41);
        City racoonCity = new City("Racoon City");
        City megaCity1 = new City("Mega City1");

        City.getDistance(seoul, paris);
        City.getDistance(seoul, racoonCity);
        City.getDistance(paris, megaCity1);
    }
}

