package org.example.utils;
import java.util.Random;

public class Numbergen {
    Random rng = new Random();
    String in = "+49 ";
    String[] randomStarts = {
            "151",  // Deutsche Telekom
            "152",  // Vodafone
            "155",  // e-Plus (jetzt Teil von Telefónica)
            "157",  // e-Plus (jetzt Teil von Telefónica)
            "159",  // e-Plus (jetzt Teil von Telefónica)
            "160",  // Deutsche Telekom
            "162",  // Vodafone
            "163",  // Deutsche Telekom
            "170",  // Deutsche Telekom
            "171",  // Deutsche Telekom
            "172",  // Vodafone
            "173",  // Vodafone
            "174",  // Vodafone
            "175",  // Deutsche Telekom
            "176",  // Telefónica Germany (O2)
            "177",  // Telefónica Germany (O2)
            "178",  // Telefónica Germany (O2)
            "179"   // Telefónica Germany (O2)
    };

    public String getNumber() {
        String out = "+49 ";
        out += randomStarts[rng.nextInt(randomStarts.length)];
        out += Integer.toString(rng.nextInt(9)) + " ";
        for (int i = 0; i<7; i++){
            out += Integer.toString(rng.nextInt(9));
        }
        return out;
    }
}
