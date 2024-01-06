import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DataManager {
    
    static int accountType = 0;
    static String usrName;
    static String signDate;
    static String birthDate;
    static String usrGender;
    static String usrPassword;
    static String usrBio;
    
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

                    }
                    else if(accountType == 2) {

                    }
                    case "BOSLUK-":
                    default:
                }

                System.out.println(accountType);
                System.out.println(usrName);
                System.out.println(signDate);
                System.out.println(birthDate);
                System.out.println(usrGender);
                System.out.println(usrPassword);
                System.out.println(usrBio);

                //TODO her kişi okumasından sonra değerleri sıfırla
            }
            
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
