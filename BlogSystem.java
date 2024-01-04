import java.util.ArrayList;

public class BlogSystem {

    static private Kullanici kullaniciSession;
    static private Yazar yazarSession;
    static private Admin adminSession;

    
    static ArrayList<Hesap> hesapList = new ArrayList<Hesap>(); //tüm adminler yazarlar ve kullanıcılar burada -Mustafa
    static ArrayList<BlogYazisi> blogList = new ArrayList<BlogYazisi>(); //tüm blog postları
    
    static void startBlogger(Hesap usrSession, int preset) {
        switch (preset) {
            case 1:
            kullaniciSession = (Kullanici) usrSession;
            System.out.println("Kullanici girisi");
            break;
            case 2:
            yazarSession = (Yazar) usrSession;
            System.out.println("Yazar girisi");
            break;
            case 3:
            adminSession = (Admin) usrSession;
            System.out.println("Admin girisi");
            break;
        }
    }

    
    
}

