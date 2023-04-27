import java.util.ArrayList;

public class Armor extends Equipment{
    private int AdditionalHp;
    private ArrayList<Armor> dataArmor;

    public Armor(String nama, String id, int harga, int addHp) {
        super(nama, id, harga);
        this.AdditionalHp = addHp;
        dataArmor = new ArrayList<Armor>();
    }
    
    public int updateStat(int baseHp){
        return this.getAdditionalHp() + baseHp;
    }

    public int getAdditionalHp() {
        return this.AdditionalHp;
    }

    public void setAdditionalHp(int AdditionalHp) {
        this.AdditionalHp = AdditionalHp;
    }

    public ArrayList<Armor> getArmor() {
        return this.dataArmor;
    }

    public void setArmor(ArrayList<Armor> Armor) {
        this.dataArmor = Armor;
    }

    	//Overloading
        public void showChar(){
            super.showChar(false);
            System.out.println("Additonal HP -> " + this.AdditionalHp);
        }
        //Overloading
        public void showChar(boolean ver){
            if (ver) {
                super.showChar(true);
                System.out.println("Additional Hp -> " + this.AdditionalHp);
            }
            else {
                showChar();
            }
        }
}
