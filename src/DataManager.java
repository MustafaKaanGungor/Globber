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
                    case "ISM":
                    usrName = reader.next();
                    case "KAT":
                    signDate = reader.next();
                    case "DOT":
                    birthDate = reader.next();
                    case "CIN":
                    usrGender = reader.next();
                    case "PAW":
                    usrPassword = reader.next();
                    case "BIO":
                    usrBio = reader.nextLine();
                    case "BOSLUK-":
                    break;
                    default:
                }

                System.out.println(accountType);
                System.out.println(usrName);
                System.out.println(signDate);
                System.out.println(birthDate);
                System.out.println(usrGender);
                System.out.println(usrPassword);
                System.out.println(usrBio);
            }
            
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
