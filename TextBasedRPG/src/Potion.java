import java.util.ArrayList;

public class Potion {
    private String nama;
    private String Id;
    private int harga;
    private int ATK;
    private int HP;
    private int MP;
    private String type;
    private ArrayList<Potion> dataPotion;

    public String getNama() {
        return this.nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getId() {
        return this.Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public int getHarga() {
        return this.harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public int getATK() {
        return this.ATK;
    }

    public void setATK(int ATK) {
        this.ATK = ATK;
    }

    public int getHP() {
        return this.HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getMP() {
        return this.MP;
    }

    public void setMP(int MP) {
        this.MP = MP;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ArrayList<Potion> getPotion() {
        return this.dataPotion;
    }

    public void setPotion(ArrayList<Potion> Potion) {
        this.dataPotion = Potion;
    }

    public Potion(String id, String nama, int harga, int ATK, int HP, int MP, String type){ 
        this.ATK = ATK;
        this.HP = HP;
        this.MP = MP;
        this.Id = id;
        this.nama = nama;
        this.harga = harga;
        this.type = type;
		dataPotion = new ArrayList<Potion>();
    }

    public void showPotion(boolean ver){
        if (ver) {
            System.out.println("ID        -> " + this.Id);
            System.out.println("Name      -> " + this.nama);
            System.out.println("Type      -> " + this.type);
            System.out.println("ATK++     -> " + this.ATK);
            System.out.println("HP++      -> " + this.HP);
            System.out.println("MP++      -> " + this.MP);
            System.out.println("Price     -> " + this.harga);
        }
        else {
            System.out.println("Name      -> " + this.nama);
            System.out.println("Type      -> " + this.type);
            System.out.println("ATK++     -> " + this.ATK);
            System.out.println("HP++      -> " + this.HP);
            System.out.println("MP++      -> " + this.MP);
            System.out.println("Price     -> " + this.harga);
        }
    }
}