import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Start {
    static private Hesap session = null;
    
    static Scanner input = new Scanner(System.in);
    static Pattern userNamePattern = Pattern.compile("[A-Z]");
    
    public static void main(String[] args) {
        splashScreen();
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
        //TODO: Load data
    }
    
    static void startupScreen() {
        while(session == null) {
            System.out.println("1 - Log in          2 - Sign up          3 - More About Globber");
            
            int logOption = input.nextInt();
            //TODO: hem string hem int halinde seçilebilir yapılabilir
            
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
        }

        BlogSystem.startBlogger(session);
    }

    static void logIn() {
        System.out.println("Kullanici adi giriniz.");
        System.out.print("=>");
        String usrName = input.next();
        if(checkIfUserExists(usrName) == null) {
            System.out.println("Ku");
        }
    }

    static void signUp() {
        System.out.println("    New Account");
        System.out.println("Enter Username");
        System.out.print("=>");
        String usrName = input.next();

        if(checkUserNameAvailablity(usrName) == 0) {
            System.out.println("Enter Birth Date:");
            System.out.print("=>");
            String usrPassword = input.next();
            if(checkPasswordSuffiency(usrPassword) == 0) {

            }
        }
        else if(checkUserNameAvailablity(usrName) == 1) {
            System.out.println("Hata:Kullanici isimlerinde buyuk harf olamaz.");
        }
        else {
            System.out.println("");
        }

    }

    static void signUp(String usrName) {

    }

    static void logOut() {

    }

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
        return 1;
    }

    static void info() {
        System.out.println("Globber is a Blog sharing and reading platform for everyone!");
        System.out.println("");
        System.out.println("Made by BringSalavat, Asrin and FalleErdem");

        //TODO: Github readmesini oluşturunca buraya ekle
    }
}
