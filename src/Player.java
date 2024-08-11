import java.util.Scanner;

public class Player {
   private int damage;
   private int health;
   private int money;
   private String charName;
   private String name;
   Scanner input = new Scanner(System.in);
   private Inventory inventory;

   public Player(String name){
       this.name = name;
       this.inventory = new Inventory();
   }

   public void selectChar(){

       Samurai samurai = new Samurai();
       Archer archer = new Archer();
       Knight knight = new Knight();

       GameChar[] charList = {new Samurai(), new Archer(),new Knight()}; // polimorfizm

       System.out.println("Karekterler");
       System.out.println("----------------------------------------");
       for (GameChar gameChar : charList){
           System.out.println(
                   "ID: " +gameChar.getId()+
                   "\t Karekter:" + gameChar.getName() +
                   "\t Hasar: " + gameChar.getDamage() +
                   "\t Sağlık: " + gameChar.getHealth() +
                           "\t Para: " + gameChar.getMoney()
           );
       }
       System.out.println("----------------------------------------");
       System.out.print("Karekterinizi Seçiniz : ");
       int selectChar = input.nextInt();
       switch (selectChar){
           case 1:
               initPlayer(new Samurai());
               break;
           case 2:
               initPlayer(new Archer());
               break;
           case 3:
               initPlayer(new Knight());
               break;
           default:
               initPlayer(new Samurai());
       }
       System.out.println("Karekter : " + this.getCharName());
   }

   public void selectLoc(){

   }

   public void initPlayer(GameChar gameChar){
       this.setDamage(gameChar.getDamage());
       this.setHealth(gameChar.getHealth());
       this.setMoney(gameChar.getMoney());
       this.setCharName(gameChar.getName());
   }

   public void printInfo(){
       System.out.println(
               "Silahınız : " + this.getInventory().getWeapon().getName() +
                       " , Zırh :" + this.getInventory().getArmor().getName() +
                       " , Bloklama : " + this.getInventory().getArmor().getBlock() +
               " , Hasarınız : " + this.getTotalDamage() +
               " , Sağlığını : " + this.getHealth() +
               " , Paranız :" + this.getMoney());
   }

   public int getTotalDamage(){
       return damage + this.getInventory().getWeapon().getDamge();
   }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Weapon getWeapon(){
       return this.getInventory().getWeapon();
    }
}
