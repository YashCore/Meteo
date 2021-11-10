/**
 * Day
 */

package meteo;

public class Day {
    
    //----------------------------] ATTRIBUTES [----------------------------
    private int day = -1;
    private int wind = -1;
    private int midTemp = -1;
    private int minTemp = -1;
    private int maxTemp = -1;
    private int humidity = -1;
    private String rain = null;
    private String phenomena = null;

    //----------------------------] CONSTRUCTOR [----------------------------
    public Day(int day, int wind, int midTemp, int minTemp, int maxTemp, int humidity, String rain, String phenomena) {
        this.day = day;
        this.wind = wind;
        this.midTemp = midTemp;
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
        this.humidity = humidity;
        this.rain = rain;
        this.phenomena = phenomena;
    }


    //----------------------------] GETTERS [----------------------------
    public int getDay() {
        return day;
    }

    public int getWind() {
        return wind;
    }

    public int getMidTemp() {
        return midTemp;
    }

    public int getMinTemp() {
        return minTemp;
    }

    public int getMaxTemp() {
        return maxTemp;
    }

    public int getHumidity() {
        return humidity;
    }

    public String getRain() {
        return rain;
    }

    public String getPhenomena() {
        return phenomena;
    }


    //----------------------------] TOSTRING [----------------------------
    @Override
    public String toString() {
        return "Day [day=" + day + ", humidity=" + humidity + ", maxTemp=" + maxTemp + ", midTemp=" + midTemp
                + ", minTemp=" + minTemp + ", phenomena=" + phenomena + ", rain=" + rain + ", wind=" + wind + "]";
    }
 }


 /**
 * @author Yash Kumar
 * @since 2002
 */