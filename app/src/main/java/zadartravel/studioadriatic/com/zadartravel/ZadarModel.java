package zadartravel.studioadriatic.com.zadartravel;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Andrej on 24.1.2016..
 */
public class ZadarModel implements Parcelable {
    private String id_lokacija;
    private String id_smjestaj;
    private String naziv;
    private String vrsta;
    private String mobitel;
    private String telefon;
    private String adresa;
    private String email;
    private int zvjezdice;
    private String web;
    private double duzina;
    private double sirina;
    private int brojlezajeva;
    private int klima;
    private int internet;
    private int satelitska;
    private int croatia365;
    private int odmora;
    private int odcentra;
    private int kucniljubimci;
    private int dostupno;
    private String images;

    public ZadarModel (){}

    public String getId_lokacija() {
        return id_lokacija;
    }

    public void setId_lokacija(String id_lokacija) {
        this.id_lokacija = id_lokacija;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public int getDostupno() {
        return dostupno;
    }

    public void setDostupno(int dostupno) {
        this.dostupno = dostupno;
    }

    public int getKucniljubimci() {
        return kucniljubimci;
    }

    public void setKucniljubimci(int kucniljubimci) {
        this.kucniljubimci = kucniljubimci;
    }

    public int getOdmora() {
        return odmora;
    }

    public void setOdmora(int odmora) {
        this.odmora = odmora;
    }

    public int getOdcentra() {
        return odcentra;
    }

    public void setOdcentra(int odcentra) {
        this.odcentra = odcentra;
    }

    public int getCroatia365() {
        return croatia365;
    }

    public void setCroatia365(int croatia365) {
        this.croatia365 = croatia365;
    }

    public int getSatelitska() {
        return satelitska;
    }

    public void setSatelitska(int satelitska) {
        this.satelitska = satelitska;
    }

    public int getInternet() {
        return internet;
    }

    public void setInternet(int internet) {
        this.internet = internet;
    }

    public int getKlima() {
        return klima;
    }

    public void setKlima(int klima) {
        this.klima = klima;
    }

    public int getBrojlezajeva() {
        return brojlezajeva;
    }

    public void setBrojlezajeva(int brojlezajeva) {
        this.brojlezajeva = brojlezajeva;
    }

    public double getSirina() {
        return sirina;
    }

    public void setSirina(double sirina) {
        this.sirina = sirina;
    }

    public double getDuzina() {
        return duzina;
    }

    public void setDuzina(double duzina) {
        this.duzina = duzina;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public int getZvjezdice() {
        return zvjezdice;
    }

    public void setZvjezdice(int zvjezdice) {
        this.zvjezdice = zvjezdice;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getMobitel() {
        return mobitel;
    }

    public void setMobitel(String mobitel) {
        this.mobitel = mobitel;
    }

    public String getVrsta() {
        return vrsta;
    }

    public void setVrsta(String vrsta) {
        this.vrsta = vrsta;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getId_smjestaj(String id_smjestaj) {
        return this.id_smjestaj;
    }

    public void setId_smjestaj(String id_smjestaj) {
        this.id_smjestaj = id_smjestaj;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id_lokacija);
        dest.writeString(this.id_smjestaj);
        dest.writeString(this.naziv);
        dest.writeString(this.vrsta);
        dest.writeString(this.mobitel);
        dest.writeString(this.telefon);
        dest.writeString(this.adresa);
        dest.writeString(this.email);
        dest.writeInt(this.zvjezdice);
        dest.writeString(this.web);
        dest.writeDouble(this.duzina);
        dest.writeDouble(this.sirina);
        dest.writeInt(this.brojlezajeva);
        dest.writeInt(this.klima);
        dest.writeInt(this.internet);
        dest.writeInt(this.satelitska);
        dest.writeInt(this.croatia365);
        dest.writeInt(this.odmora);
        dest.writeInt(this.odcentra);
        dest.writeInt(this.kucniljubimci);
        dest.writeInt(this.dostupno);
        dest.writeString(this.images);
    }

    protected ZadarModel(Parcel in) {
        this.id_lokacija = in.readString();
        this.id_smjestaj = in.readString();
        this.naziv = in.readString();
        this.vrsta = in.readString();
        this.mobitel = in.readString();
        this.telefon = in.readString();
        this.adresa = in.readString();
        this.email = in.readString();
        this.zvjezdice = in.readInt();
        this.web = in.readString();
        this.duzina = in.readDouble();
        this.sirina = in.readDouble();
        this.brojlezajeva = in.readInt();
        this.klima = in.readInt();
        this.internet = in.readInt();
        this.satelitska = in.readInt();
        this.croatia365 = in.readInt();
        this.odmora = in.readInt();
        this.odcentra = in.readInt();
        this.kucniljubimci = in.readInt();
        this.dostupno = in.readInt();
        this.images = in.readString();
    }

    public static final Parcelable.Creator<ZadarModel> CREATOR = new Parcelable.Creator<ZadarModel>() {
        public ZadarModel createFromParcel(Parcel source) {
            return new ZadarModel(source);
        }

        public ZadarModel[] newArray(int size) {
            return new ZadarModel[size];
        }
    };
}
