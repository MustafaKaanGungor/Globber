import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.time.LocalDate;

public class Start {
    static private Hesap session = null;
    
    static Scanner input = new Scanner(System.in);
    static Pattern userNamePattern = Pattern.compile("[A-Z]");
    static Pattern userPasswordPattern = Pattern.compile("");
    
    public static void main(String[] args) {
        splashScreen();
        loadData();
        startupScreen();
    }
    
    static void splashScreen() {
        System.out.println("      ___  __    _____  ____  ____  ____  ____ ");
        System.out.println("     / __)(  )  (  _  )(  _ \\(  _ \\( ___)(  _ \\");
        System.out.println("    ( (_-. )(__  )(_)(  ) _ < ) _ < )__)  )   /");
        System.out.println("     \\___/(____)(_____)(____/(____/(____)(_)\\_)");
        
        System.out.println("Welcome to Globber");
    }
    
    static void loadData() {
        System.out.println("Data is loading");
        DataManager.loadData();
        System.out.println("Done");
    }
    
    static void startupScreen() {
        System.out.println("1- Log in    2- Sign up    3- More About Globber");
        int logOption = input.nextInt();
        
        switch (logOption) {
            case 1:
            logIn();
            break;
            case 2:
            signUp();
            break;
            case 3:
            info();
            break;
            default:
            System.out.println("Please select one of the given options");
            break;
        }
        
        BlogSystem.startBlogger(session);
    }
    
    static void logIn() {
        System.out.println("  Log in");
        getUsrName(1);
    }
    
    static void signUp() {
        System.out.println("  New Account");
        getUsrName(2);
        /* 
        if(checkUserNameAvailablity(usrName) == 0) {
            while(true) {
                System.out.println("Enter Password:");
                System.out.print("=>");
                String usrPassword = input.next();
                if(checkPasswordSuffiency(usrPassword) == 0) {
                    LocalDate myObj = LocalDate.now();
                    BlogSystem.hesapList.add(new Hesap(usrName, myObj, usrbirthDate, usrGender));
                    System.out.println("Account created succesfully.");
                    startupScreen();
                    break;
                }
                else {
                    System.out.println("Choose a stronger password");
                }
            }
            break;
        }
        else if(checkUserNameAvailablity(usrName) == 1) {
            System.out.println("Hata:Kullanici isimlerinde buyuk harf olamaz.");
        }
        else {
            System.out.println("This username is already taken.");
        }
        */
        
    }
    
    static void logOut() {
        
    }
    
    static void getUsrName(int option) {
        System.out.println("Enter Username");
        System.out.print("=>");
        String usrName = input.next();
        
        if(usrName.charAt(0) == '0') {
            System.out.println("Returning back to menu.");
            startupScreen();
        }
        else if(checkUserNameAvailablity(usrName) == 0) {
            getUsrBirthDate();
        }
        else if(checkUserNameAvailablity(usrName) == 1) {
            
        }
        else {
            
        }
    }
    
    static void getUsrBirthDate() {
        System.out.println("Enter Birth Date:");
        System.out.print("=>");
        String usrbirthDate = input.next();
    }

    static void getUsrGender() {
        System.out.println("Enter Gender:");
        System.out.print("=>");
        String usrGender = input.next();
    }

    static void getUsrPassword(int option) {}
    
    static Hesap checkIfUserExists(String usrName) {
        for(int i = 0; i < BlogSystem.hesapList.size(); i++) {
            if(BlogSystem.hesapList.get(i).getKullaniciAd().equals(usrName)) {
                return BlogSystem.hesapList.get(i);
            }
        }
        
        return null;
    }
    
    static int checkUserNameAvailablity(String usrName) {
        Matcher matcher = userNamePattern.matcher(usrName);
        if(matcher.find()) {
            return 1;
        }
        else {
            for(int i = 0; i < BlogSystem.hesapList.size(); i++) {
                if(BlogSystem.hesapList.get(i).getKullaniciAd().equals(usrName)) {
                    return 2;
                }
            }
            
            return 0;
        }
    }
    
    
    static int checkPasswordSuffiency(String Password) {
        return 0;
    }
    
    static void info() {
        System.out.println("Globber is a Blog sharing and reading platform for everyone!");
        System.out.println("");
        System.out.println("Made by BringSalavat, Asrin and FalleErdem");
        System.out.println("");
        //TODO: Github readmesini oluşturunca buraya ekle
        startupScreen();
    }
}
