
import java.util.Scanner;

import meteo.Meteo;

public class Execution {


    private Meteo meteo = new Meteo();
    private Scanner input = new Scanner(System.in);


    public void startSession() {
        // Support Variables
        String str = null;
        int choice = -1;


        do {

            // User View menu
            System.out.println("\n1. Add Year\n"+
                                "2. Select Year\n"+
                                "3. Exit\n");
            str = input.nextLine();

            // chceking if the choice is a number
            try {
                choice = Integer.parseInt(str);
            } catch (NumberFormatException nFormatException) {
                System.out.println("Type a number that's equivlent to one of the choices please");
            }

            // real menu
            switch (choice) {
                case 1:
                    System.out.println("Enter year:");
                    str = input.nextLine();
                    meteo.addYear(str);
                    break;
            
                case 2:
                    System.out.println("Enter year:");
                    str = input.nextLine();
                    yearMenu(str);
                    break;
                    
                case 3:
                    System.out.println("Thanks for testing");
                    break;    
    

                default:
                        choice = 0;
                        System.out.println("Wrong choice!\n");
                    break;
            }
        } while (choice!=3);
    }


    private void yearMenu(String year) {
        // Support Variables
        String str = null;
        int choice = -1;


        do {

            // User View menu
            System.out.println("\n1. Get year fog days\n"+
                                "2. Get year rain days\n"+
                                "3. Get year snow days\n"+
                                "4. Get year Medium Temperature\n"+
                                "5. Get year Minumum Temperature\n"+
                                "6. Get year Maximum Temperature\n"+
                                "7. Get year Medium Humidity\n"+
                                "8. Get month\n"+
                                "9. back\n");
            str = input.nextLine();

            // chceking if the choice is a number
            try {
                choice = Integer.parseInt(str);
            } catch (NumberFormatException nFormatException) {
                System.out.println("Type a number that's equivlent to one of the choices please");
            }

            // real menu
            switch (choice) {
                case 1:
                    System.out.println("Enter intrested month.\n"+
                                        "Range of Months (Example : 1-4) from the 1th month till the 4th\n"+
                                        "More Months (Example : 1;8;12;5) the 1st, 8th, 12th and 5th month \n"+
                                        "One single month (Example : 1) only the 1st month" );
                    str = input.nextLine();                                     
                    System.out.println("The total fog days of the year "+year+" are "+meteo.get(year).getFogDays(str));
                    break;
            
                case 2:
                    System.out.println("Enter intrested month.\n"+
                                        "Range of Months (Example : 1-4) from the 1th month till the 4th\n"+
                                        "More Months (Example : 1;8;12;5) the 1st, 8th, 12th and 5th month \n"+
                                        "One single month (Example : 1) only the 1st month" );
                    str = input.nextLine();                                     
                    System.out.println("The total fog days of the year "+year+" are "+meteo.get(year).getRainDays(str));
                    break;
                    
                case 3:
                    System.out.println("Enter intrested month.\n"+
                                        "Range of Months (Example : 1-4) from the 1th month till the 4th\n"+
                                        "More Months (Example : 1;8;12;5) the 1st, 8th, 12th and 5th month \n"+
                                        "One single month (Example : 1) only the 1st month" );
                    str = input.nextLine();                                     
                    System.out.println("The total fog days of the year "+year+" are "+meteo.get(year).getSnowDays(str));
                    break; 
                    
                case 4:
                    System.out.println("Enter intrested month.\n"+
                                        "Range of Months (Example : 1-4) from the 1th month till the 4th\n"+
                                        "More Months (Example : 1;8;12;5) the 1st, 8th, 12th and 5th month \n"+
                                        "One single month (Example : 1) only the 1st month" );
                    str = input.nextLine();                                     
                    System.out.println("The total fog days of the year "+year+" are "+meteo.get(year).getMediumTemp(str));
                    break; 

                case 5:
                    System.out.println("Enter intrested month.\n"+
                                        "Range of Months (Example : 1-4) from the 1th month till the 4th\n"+
                                        "More Months (Example : 1;8;12;5) the 1st, 8th, 12th and 5th month \n"+
                                        "One single month (Example : 1) only the 1st month" );
                    str = input.nextLine();                                     
                    System.out.println("The total fog days of the year "+year+" are "+meteo.get(year).getMinTemp(str));
                    break; 

                case 6:
                    System.out.println("Enter intrested month.\n"+
                                        "Range of Months (Example : 1-4) from the 1th month till the 4th\n"+
                                        "More Months (Example : 1;8;12;5) the 1st, 8th, 12th and 5th month \n"+
                                        "One single month (Example : 1) only the 1st month" );
                    str = input.nextLine();                                     
                    System.out.println("The total fog days of the year "+year+" are "+meteo.get(year).getMaxTemp(str));
                    break; 

                case 7:
                    System.out.println("Enter intrested month.\n"+
                                        "Range of Months (Example : 1-4) from the 1th month till the 4th\n"+
                                        "More Months (Example : 1;8;12;5) the 1st, 8th, 12th and 5th month \n"+
                                        "One single month (Example : 1) only the 1st month" );
                    str = input.nextLine();                                     
                    System.out.println("The total fog days of the year "+year+" are "+meteo.get(year).getMediumHumidity(str));
                    break; 

                case 8:
                    System.out.println("Enter month to select. Example : 1 which means the 1st month of the year. ");
                    str = input.nextLine();
                    monthMenu(year,str);
                    break; 

                default:
                        choice = 0;
                        System.out.println("Wrong choice!\n");
                    break;
            }
        } while (choice!=9);
    }


    private void monthMenu(String year, String month) {
        // Support Variables
        String str = null;
        int choice = -1;
        int monthIndex = Integer.parseInt(month);


        do {

            // User View menu
            System.out.println("\n1. Get Month fog days\n"+
                                "2. Get Month rain days\n"+
                                "3. Get Month snow days\n"+
                                "4. Get Month Medium Temperature\n"+
                                "5. Get Month Maximum Temperature\n"+
                                "6. Get Month Minimum Temperature\n"+
                                "7. Get Month Medium Humidity\n"+
                                "8. Back\n");
            str = input.nextLine();

            // chceking if the choice is a number
            try {
                choice = Integer.parseInt(str);
            } catch (NumberFormatException nFormatException) {
                System.out.println("Type a number that's equivlent to one of the choices please");
            }

            // real menu
            switch (choice) {
                case 1:
                    System.out.println("This month had "+meteo.get(year).getMonth(monthIndex).getFogPhenCount()+" foggy days.");
                    break;
            
                case 2:
                    System.out.println("This month had "+meteo.get(year).getMonth(monthIndex).getRainPhenCount()+" rainy days.");
                    break;
                    
                case 3:
                    System.out.println("This month had "+meteo.get(year).getMonth(monthIndex).getSnowPhenCount()+" snowy days.");
                    break;    
    
                case 4:
                    System.out.println("This month Medium temperature was: "+meteo.get(year).getMonth(monthIndex).getMediumTemp());
                    break; 

                case 5:
                    System.out.println("This month Maximum temperature was: "+meteo.get(year).getMonth(monthIndex).getMaxTemp());
                    break; 

                case 6:
                    System.out.println("This month Minimum temperature was: "+meteo.get(year).getMonth(monthIndex).getMinTemp());
                    break; 

                case 7:
                    System.out.println("This month Medium humidity was: "+meteo.get(year).getMonth(monthIndex).getMediumHumidity());
                    break;  

                default:
                        choice = 0;
                        System.out.println("Wrong choice!\n");
                    break;
            }
        } while (choice!=8);
    }


}


/**
 * @author Yash Kumar
 * @since 2002
 */