import java.util.ArrayList;
import java.util.Scanner;

public class BlogSystem {
    
    ArrayList<Hesap> hesapList = new ArrayList<Hesap>(); //tüm adminler yazarlar ve kullanıcılar burada -Mustafa
    ArrayList<BlogYazisi> blogList = new ArrayList<BlogYazisi>(); //tüm blog postları
    
    static private Hesap session = null;
    
    static Scanner input = new Scanner(System.in);
    
    public static void main(String[] args) {
        /*if(args[0].equals("command")) {
            System.out.println("calisiyor");
        }
        else {
            System.out.println("calismiyor");
        }*/
        
        startupScreen();
    }
    
    static void startupScreen() {
        System.out.println("      ___  __    _____  ____  ____  ____  ____ ");
        System.out.println("     / __)(  )  (  _  )(  _ \\(  _ \\( ___)(  _ \\");
        System.out.println("    ( (_-. )(__  )(_)(  ) _ < ) _ < )__)  )   /");
        System.out.println("     \\___/(____)(_____)(____/(____/(____)(_)\\_)");
        
        System.out.println("Welcome to Globber");
        
        while(session == null) {
            System.out.println("1 - Log in          2 - Sign up");
            
            int logOption = input.nextInt();
            
            switch (logOption) {
                case 1:
                    logIn();
                    break;
                case 2:
                    signUp();
                break;
                default:
                System.out.println("Verilen seçeneklerden birini seçiniz");
                break;
            }
        }
    }

    static void logIn() {
        System.out.println("Kullanici adi giriniz.");
        System.out.print("=>");
        String usrName = input.next();

        if(checkUserNameAvailablity(usrName) == 0) {
            System.out.println("Sifrenizi giriniz.");
            System.out.print("=>");
            String usrPassword = input.next();
            if(checkPasswordSuffiency(usrPassword) == 0) {

            }
        }
        else if(checkUserNameAvailablity(usrName) == 1) {
            System.out.println("");
        }

        
    }

    static void signUp() {

    }

    static void signUp(String usrName) {

    }

    static void logOut() {

    }

    static int checkUserNameAvailablity(String usrName) {
        return 1;
    }

    static int checkPasswordSuffiency(String Password) {
        return 1;
    }
    
    
    //oturum açma ve kapama methodları,
    
    //TODO: kullanıcılar için buraya CRUD işlemleri eklenicek -Mustafa
    
    
}

