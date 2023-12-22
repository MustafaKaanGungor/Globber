import java.util.Scanner;

public class Hesap {
    private String kullaniciAd;
    private String kayitTarihi;
    private String dogumTarihi;
    private String cinsiyet;
    private String bio;

    public String getKullaniciAd() {
        return kullaniciAd;
    }

    public void setKullaniciAd(String kullaniciAd) {
        this.kullaniciAd = kullaniciAd;
    }

    public String getKayitTarihi() {
        return kayitTarihi;
    }

    public void setKayitTarihi(String kayitTarihi) {
        this.kayitTarihi = kayitTarihi;
    }

    public String getDogumTarihi() {
        return dogumTarihi;
    }

    public void setDogumTarihi(String dogumTarihi) {
        this.dogumTarihi = dogumTarihi;
    }

    public String getCinsiyet() {
        return cinsiyet;
    }

    public void setCinsiyet(String cinsiyet) {
        this.cinsiyet = cinsiyet;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
/* 
class KullaniciIslemleri {

    // Kullanıcı kaydı oluşturma metodu
    public Hesap kullaniciKaydiOlustur() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Kullanıcı adınızı girin: ");
        String kullaniciAd = scanner.nextLine();

        System.out.println("Kayıt tarihinizi girin: ");
        String kayitTarihi = scanner.nextLine();

        System.out.println("Doğum tarihinizi girin: ");
        String dogumTarihi = scanner.nextLine();

        System.out.println("Cinsiyetiniz: ");
        String cinsiyet = scanner.nextLine();

        System.out.println("Biyografinizi oluşturun: ");
        String bio = scanner.nextLine();

        Hesap kullanici = new Hesap();
        kullanici.setKullaniciAd(kullaniciAd);
        kullanici.setKayitTarihi(kayitTarihi);
        kullanici.setDogumTarihi(dogumTarihi);
        kullanici.setCinsiyet(cinsiyet);
        kullanici.setBio(bio);

        System.out.println("Kullanıcı Kaydınız Oluşturuldu!");
        return kullanici;
    }

    // Kullanıcı bilgilerini görüntüleme metodu
    public void kullaniciBilgileriniGoruntule(Hesap kullanici) {
        System.out.println("\nKullanıcı Bilgileri:");
        System.out.println("Kullanıcı Adı: " + kullanici.getKullaniciAd());
        System.out.println("Kayıt Tarihi: " + kullanici.getKayitTarihi());
        System.out.println("Doğum Tarihi: " + kullanici.getDogumTarihi());
        System.out.println("Cinsiyet: " + kullanici.getCinsiyet());
        System.out.println("Biyografi: " + kullanici.getBio());
    }
    KullaniciIslemleri kullaniciIslemleri = new KullaniciIslemleri();

    Hesap kullanici = kullaniciIslemleri.kullaniciKaydiOlustur(); // Kullanıcı kaydı oluşturmak için

    kullaniciIslemleri.kullaniciBilgileriniGoruntule(kullanici);// Oluşturulan kullanıcının bilgilerini görüntülemek için
} */

