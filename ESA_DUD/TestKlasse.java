package ESA_DUD;

import java.io.File;
import java.io.IOException;
import ESA_DUD.VerzErst.*;

public class TestKlasse {

    public  static void main(String args[]) throws IOException{

        File parentPfad = new File ("/Users/Chris/Dateimanagement/");
        VerzErst.erstellen(parentPfad.toString());
        VerzErst.erstellen(parentPfad + "/Dokumente/");
        VerzErst.erstellen(parentPfad + "/Graphik/");
        VerzErst.erstellen(parentPfad + "/Java/");


    }
}
