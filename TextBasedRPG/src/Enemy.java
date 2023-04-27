public class Enemy extends Entity{
    private int atk;
    private int hp;
    
    public Enemy(String nama,int atk, int hp) {
        super(nama);
        this.atk = atk;
        this.hp = hp;
    }
    public int getAtk(){
        return this.atk;
    }
    public void setAtk(int atk){
        this.atk = atk;
    }
    public int getHp(){
        return this.hp;
    }
    public void setHp(int hp){
        this.hp = hp;
    }
}