import java.util.ArrayList;

public class Weapon extends Equipment{
    private int damage;
	private String type;
	private ArrayList<Weapon> dataWeapon;
    
    public Weapon(String nama, String id, int harga, int damage, String type){ 
        super(nama, id, harga);
        this.damage = damage;
        this.type = type;
		dataWeapon = new ArrayList<Weapon>();
    }

	public int updateStat(int baseAtk){
		return this.getDamage() + baseAtk;
	}

	public int getDamage() {
		return this.damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public ArrayList<Weapon> getWeapon() {
        return this.dataWeapon;
    }

    public void setWeapon(ArrayList<Weapon> weapon) {
        this.dataWeapon = weapon;
    }

	//Overloading
    public void showChar(){
        super.showChar(false);
		System.out.println("Type      -> " + this.type);
        System.out.println("Damage    -> " + this.damage);
    }
    //Overloading
    public void showChar(boolean ver){
        if (ver) {
            super.showChar(true);
            System.out.println("Damage    -> " + this.damage);
            System.out.println("Type      -> " + this.type);
        }
        else {
            showChar(false);
        }
    }
}