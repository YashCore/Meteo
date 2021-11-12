package meteo;
/**
 * SiteReader
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class SiteReader {
    

    //----------------------------] ATTRIBUTES [----------------------------

    // Url Object  for connection
    private URL url = null;

    // Attributes to create the query string
    private String year = null;
    private int monthIndex = -1;
    private String month []= {"Gennaio","Febbraio","Marzo","Aprile","Maggio","Giugno","Luglio","Agosto","Settembre","Ottobre","Novembre","Dicembre",} ;
    private String queryString = null;
    private final String QUERY_HEADER = "https://www.ilmeteo.it/portale/archivio-meteo/Milano/";
    private final String QUERY_FOOTER = "?format=csv";

    // File contents 
    private String fileContent = null;
    private String contentLines[] = null;


    //----------------------------] CONSTRUCTOR [----------------------------
    public SiteReader(String year) {
        this.year = year+"/";
        this.monthIndex = 0;
        this.queryString = QUERY_HEADER+this.year+month[monthIndex]+QUERY_FOOTER;
        //https://www.ilmeteo.it/portale/archivio-meteo/Milano/year/month/?format=csv"       
    }

    public SiteReader(String year, int monthIndex) {
        this.year = year+"/";
        this.monthIndex = monthIndex;
        this.queryString = QUERY_HEADER+this.year+this.month[monthIndex]+QUERY_FOOTER;
        //"https://www.ilmeteo.it/portale/archivio-meteo/Milano/year/month/?format=csv"      
    }


    //----------------------------] GET & SET [---------------------------- 
    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year+"/";
        queryString = QUERY_HEADER+year+month+QUERY_FOOTER;
        //"https://www.ilmeteo.it/portale/archivio-meteo/Milano/year/month/?format=csv"  
    }

    public String getMonth() {
        return month[monthIndex];
    }

    public void setMonth(int monthIndex) {
        this.monthIndex = monthIndex;
        queryString = QUERY_HEADER+year+month[monthIndex]+QUERY_FOOTER;
        //"https://www.ilmeteo.it/portale/archivio-meteo/Milano/year/month/?format=csv"  
    }

    public String getFileContent() {
        return fileContent;
    }

    public String[] getContentLines() {
        return contentLines;
    }


    //----------------------------] METHODS [---------------------------- 

  

    /**
     * Method that reads full content 
     * of the given file from web
     * 
     * @return file content
     * @throws MalformedURLException
     */
    public String getFile(){

        // Support Variables
        String line = null;

        // Empty year 
        if( monthIndex == -1){
            System.err.println("Set a month first!");
        }else{
            // Verify index
            if(monthIndex <= month.length){
                try {

                    setMonth(monthIndex);

                    // Connection to the site
                    url = new URL(queryString);
                    BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));

                    // Reading lines 
                    while ((line = br.readLine()) != null) 
                        fileContent += line;
                    
                    br.close();
                } catch (IOException e) {
                    System.out.println(e);
                }
            }else{
                System.err.println("No such month! Please select a valid month.");
            }
        }
        url = null;
        return fileContent;

    }

    /**
     * Method that reads file content 
     * from web, with a given value
     * 
     * @param monthIndex value that refers to a value int the month[] array
     * @return [] the month name & file content
     */
    public String[] getFile(int monthIndex){

        // Support Variables
        String line = null;
        String content[] = new String[2];

        // Empty year 
        if( monthIndex == -1){
            System.err.println("Set a month first!");
        }else{
            // Verify index
            if(monthIndex <= month.length){
                try {
                    
                    setMonth(monthIndex);
                    content[0] = month[monthIndex];
                    // Connection to the site
                    url = new URL(queryString);
                    BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));

                    // Reading lines 
                    while ((line = br.readLine()) != null) 
                    content[1] += line;
                    
                    br.close();
                
                } catch (IOException e) {
                    System.out.println(e);
                }
            }else{
                System.err.println("No such month! Please select a valid month.");
            }
        }
        url = null;
        return content;

    }



}

/**
 * @author Yash Kumar
 * @since 2002
 */

