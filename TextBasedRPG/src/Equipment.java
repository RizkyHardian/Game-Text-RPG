

public abstract class Equipment {
    protected String nama;
    protected String Id;
    protected int harga;

    public abstract int updateStat(int baseAtk);

    public Equipment(String nama, String Id, int harga) {
        this.nama = nama;
        this.Id = Id;
        this.harga = harga;
    }

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



        public void showChar(boolean ver){
        if (ver) {
            System.out.println("Id          -> " + this.Id);
            System.out.println("Name        -> " + this.nama);
            System.out.println("Price       -> " + this.harga);
        }
        else {
            System.out.println("Name        -> " + this.nama);
            System.out.println("Price       -> " + this.harga);
        }
    }
}
