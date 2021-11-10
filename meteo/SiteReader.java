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

        if( monthIndex == -1){
            System.err.println("Set a month");
        }else{
            try {

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
        }
        setLines(fileContent);
        url = null;
        return fileContent;

    }

    public String[] getFile(int monthIndex){

        // Support Variables
        String line = null;
        String content[] = new String[2];

        if( monthIndex == -1){
            System.err.println("Set a month");
        }else{
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
        }
        setLines(content[1]);
        url = null;
        return content;

    }

    /**
     * Method tha extracts each line of the 
     * file content in a string array
     * 
     * @param content to be separated
     */
    private void setLines(String content){
        contentLines = content.split("\n");
    }


}

/**
 * @author Yash Kumar
 * @since 2002
 */

