public class Hesap {
    private String kullaniciAd;
    private String kayitTarihi;
    private String dogumTarihi;
    private String cinsiyet;
    private String password;
    private String bio;

    Hesap(String kullaniciAd, String kayitTarihi, String dogumTarihi, String cinsiyet, String password) {
        this.kullaniciAd = kullaniciAd;
        this.kayitTarihi = kayitTarihi;
        this.dogumTarihi = dogumTarihi;
        this.cinsiyet = cinsiyet;
        this.password = password;
    }

    Hesap(String kullaniciAd, String kayitTarihi, String dogumTarihi, String cinsiyet, String password, String bio) {
        this.kullaniciAd = kullaniciAd;
        this.kayitTarihi = kayitTarihi;
        this.dogumTarihi = dogumTarihi;
        this.cinsiyet = cinsiyet;
        this.password = password;
        this.bio = bio;
    }

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

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}