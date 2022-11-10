package Entities;

import java.util.Random;

public class Generate {
    private static Generate instance;

    public static Generate getInstance() {
        if (instance == null) {
            instance = new Generate();
        }
        return instance;
    }

    public static String generateString(){
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        String generatedString = buffer.toString();
        return generatedString;
    }

    public static String getRandomNumber(){
        int min = 0;
        int max = 999999;

        int number = (int)Math.floor(Math.random()*(max-min+1)+min);

        String generatednumber=number+"";

        return generatednumber;
    }

    public static String getLocation(String cha){
        if(cha=="b"){
            return "Beyond the Wall";
        }
        else if (cha=="k") {
            return "Kings Landing";
        }
        else if (cha=="w"){
            return "Winterfell";
        }
        return null;
    }

    public static String getLocationEmployees(String cha){
        if(cha=="a"){
            return "A Knows nothing dude.";
        }
        else if (cha=="c") {
            return "Co-Executive Producer";
        }
        else if (cha=="e"){
            return "Executive Producer";
        }
        else if (cha=="r"){
            return "RESTool creator \uD83D\uDE0E";
        }
        return null;
    }

}
