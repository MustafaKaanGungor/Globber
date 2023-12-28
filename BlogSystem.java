import java.util.ArrayList;

public class BlogSystem {
    
    ArrayList<Hesap> hesapList = new ArrayList<Hesap>(); //tüm adminler yazarlar ve kullanıcılar burada -Mustafa
    ArrayList<BlogYazisi> blogList = new ArrayList<BlogYazisi>(); //tüm blog postları

    private Hesap session = null; //şuanda oturumu açık olan kullanıcı
    //session program açıldığında null olarak başlayacak yani oturum açık olmayacak
    //buraya yazacağımız if komutu ile session null olduğunda oturum açılmasını isteyeceğiz
    //kullanıcı ve kullanıcıŞifre ile oturum açılabilcek
    //ardından sistem kısmındaki methodları session objesi üzerinden kullanacağız

    public static void main(String[] args) {
        if(args[0].equals("command")) {
            System.out.println("calisiyor");
        }
        else {
            System.out.println("calismiyor");
        }
    }
    

    //oturum açma ve kapama methodları,

    //TODO: kullanıcılar için buraya CRUD işlemleri eklenicek -Mustafa


}
