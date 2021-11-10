/**
 * Meteo
 */

package meteo;

import java.util.LinkedList;

public class Meteo {

    LinkedList<Year> list = null;
    SiteReader reader = null;

    public Meteo(String year){
        list = new LinkedList<Year>();
    }
    
}
