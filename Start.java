import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Iterator;
import java.time.LocalDate;

public class Start {
    static private Hesap session = null;
    
    static Scanner input = new Scanner(System.in);
    static Pattern userNamePattern = Pattern.compile("[A-Z]");
    static Pattern userPasswordPattern = Pattern.compile("[A-Z]");//TODO regexi düzelt
    
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
    }
    
    static void logOut() {
        
    }
    
    static void getUsrName(int option) {
        System.out.println("Enter Username");
        System.out.print("=>");
        String usrName = input.next();
        
        if(usrName.charAt(0) == '0') { //Go back
            System.out.println("Returning back to menu.");
            startupScreen();
        }
        else if(option == 1) { //Log in
            if(checkIfUserExists(usrName) != null) {
                getUsrPassword(checkIfUserExists(usrName));
            }
            else {
                System.out.println("No user found with this name");
                getUsrName(option);
            }
        }
        else if(option == 2) { //Sign up
            if(checkUserNameAvailablity(usrName) == 0) {
                getUsrBirthDate(usrName);
            }
            else if(checkUserNameAvailablity(usrName) == 1) {
                System.out.println("Username can not include uppercase letters.");
                getUsrName(option);
            }
            else {
                System.out.println("An user with this name already exists. Please select something else");
                getUsrName(option); 
            }
        }
        
    }
    
    static void getUsrBirthDate(String usrName) {
        System.out.println("Enter Birth Date (DD/MM/YYYY):");
        System.out.print("=>");
        String usrbirthDate = input.next();//TODO gerçek bir tarih verilmiş mi diye kontrol et
        usrbirthDate = usrbirthDate.trim();
        
        if(usrbirthDate.charAt(0) == '0') { //Go back
            System.out.println("Returning back to menu.");
            startupScreen();
        }
        
        getUsrGender(usrName, usrbirthDate);
    }
    
    static void getUsrGender(String usrName, String usrBirthDate) {
        System.out.println("Enter Gender:");//TODO cinsiyete sayı girilmesini engelle
        System.out.print("=>");
        String usrGender = input.next();
        usrGender = usrGender.trim();
        
        if(usrGender.charAt(0) == '0') { //Go back
            System.out.println("Returning back to menu.");
            startupScreen();
        }
        
        getUsrPassword(usrName, usrBirthDate, usrGender);
    }
    
    static void getUsrPassword(Hesap usrAccount) { //Log in
        System.out.println("Enter Password");
        System.out.print("=>");
        String usrPassword = input.next();
        
        if(usrPassword.charAt(0) == '0') { //Go back
            System.out.println("Returning back to menu.");
            startupScreen();
        }
    }
    
    static void getUsrPassword(String usrName, String usrBirthDate, String usrGender) { //Sign up
        System.out.println("Enter Password");
        System.out.print("=>");
        String usrPassword= input.next();
        
        if(usrPassword.charAt(0) == '0') { //Go back
            System.out.println("Returning back to menu.");
            startupScreen();
        }
        else if(checkPasswordSuffiency(usrPassword) == 1) {
            createAccount(usrName, usrBirthDate, usrGender, usrPassword);
        }
        else {
            System.out.println("Password should include;");
            System.out.println(" - At least 1 capital letter");
            System.out.println(" - At least 1 lowercase letter");
            System.out.println(" - At least 1 number");
            getUsrPassword(usrName, usrBirthDate, usrGender);
        }
        
    }
    
    static void createAccount(String usrName, String usrBirthDate, String usrGender, String usrPassword) {
        System.out.println("Account got created succesfully.");
        LocalDate myObj = LocalDate.now();
        BlogSystem.hesapList.add(new Hesap(usrName, myObj, usrBirthDate, usrGender, usrPassword));

        printList();

        startupScreen();
    }
    
    static Hesap checkIfUserExists(String usrName) {
        Iterator<Hesap> iterator = BlogSystem.hesapList.iterator();
        
        while(iterator.hasNext()) {
            
            /*if(iterator.next().getKullaniciAd().equals(usrName)) {
                return iterator.next();
            }*/
        }
        return null;
    }
    
    static int checkUserNameAvailablity(String usrName) {
        Matcher matcher = userNamePattern.matcher(usrName);
        if(matcher.find()) {
            return 1;
        }
        else {
            Iterator<Hesap> iterator = BlogSystem.hesapList.iterator();
            
            while(iterator.hasNext()) {
                String ad = iterator.next().getKullaniciAd();
                if(ad.equals(usrName)) {
                    return 2;
                }
            }
            return 0;
        }
    }
    
    static int checkPasswordSuffiency(String Password) {
        Matcher matcher = userPasswordPattern.matcher(Password);
        if(matcher.find()) {//TODO regex olmazsa birden fazla regex kullanılabilir?
            return 1;
        }
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

    static void printList() {
        Iterator<Hesap> iterator = BlogSystem.hesapList.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next().getKullaniciAd());
        }
    }
}
