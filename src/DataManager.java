import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DataManager {
    
    static int accountType = 0;
    static String usrName = " ";
    static String signDate = " ";
    static String birthDate = " ";
    static String usrGender = " ";
    static String usrPassword = " ";
    static String usrBio = " ";
    static String usrComments = " ";
    static String usrFollowWriter = " ";
    static String usrFollowTag = " ";
    static String usrHistory = " ";
    static String writtenBlogs = " ";
    static String followers = " ";
    
    
    static File dosya = new File("data/Hello.txt");
    public static void loadData() {
        Scanner reader;
        
        try {
            reader = new Scanner(dosya);
            
            while(reader.hasNextLine()) {
                switch(reader.next()) {
                    case "Hesap":
                    accountType = reader.nextInt();
                    if(!reader.next().equals("ISM")) {
                        break;
                    }
                    case "ISM":
                    usrName = reader.next();
                    if(!reader.next().equals("KAT")) {
                        break;
                    }
                    case "KAT":
                    signDate = reader.next();
                    if(!reader.next().equals("DOT")) {
                        break;
                    }
                    case "DOT":
                    birthDate = reader.next();
                    if(!reader.next().equals("CIN")) {
                        break;
                    }
                    case "CIN":
                    usrGender = reader.next();
                    if(!reader.next().equals("PAW")) {
                        break;
                    }
                    case "PAW":
                    usrPassword = reader.next();
                    if(!reader.next().equals("BIO")) {
                        break;
                    }
                    case "BIO":
                    usrBio = reader.nextLine();
                    
                    if(accountType == 1) {
                        switch(reader.next()) {
                            case "YRM":
                            usrComments = reader.nextLine();
                            if(!reader.next().equals("YZR")) {
                                break;
                            }
                            case "YZR":
                            usrFollowWriter = reader.nextLine();
                            if(!reader.next().equals("TAG")) {
                                break;
                            }
                            case "TAG":
                            usrFollowTag = reader.nextLine();
                            if(!reader.next().equals("HST")) {
                                break;
                            }
                            case "HST":
                            usrHistory = reader.nextLine();
                        }
                    }
                    else if(accountType == 2) {
                        switch(reader.next()) {
                            case "WRB":
                            writtenBlogs = reader.nextLine();
                            if(!reader.next().equals("TKP")) {
                                break;
                            }
                            case "TKP":
                            followers = reader.nextLine();
                        }
                    }
                    case "BOSLUK-":
                    default:
                }

                usrComments.trim();
                usrComments.split("[0-9]");
                /*for(int i = 0; i < usrComments.length(); i++) {
                    for(int ii = 0; ii < 5; ii++) {
                        String sumOfChars = "";
                        sumOfChars += usrComments.charAt(ii);


                    }

                }*/

                if(accountType == 1) {
                    BlogSystem.hesapList.add(new Kullanici(usrBio, signDate, followers, birthDate, usrPassword));
                }
                else if(accountType == 2) {
                    BlogSystem.hesapList.add(new Yazar(usrBio, signDate, followers, birthDate, usrPassword));
                }
                else if(accountType == 3) {
                    BlogSystem.hesapList.add(new Admin(usrName, signDate, birthDate, usrGender, usrPassword));
                }
                
                accountType = 0;
                usrName = " ";
                signDate = " ";
                birthDate = " ";
                usrGender = " ";
                usrPassword = " ";
                usrBio = " ";
                usrComments = " ";
                usrFollowWriter = " ";
                usrFollowTag = " ";
                usrHistory = " ";
                writtenBlogs = " ";
                followers = " ";
            }
            
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
