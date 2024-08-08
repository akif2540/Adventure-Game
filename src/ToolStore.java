public class ToolStore extends NormalLoc{
    public ToolStore(Player player) {
        super(player,"Mağaza");
    }

    @Override
    public boolean onLocation() {
        System.out.println("-------------- Mağazaya Hoşgeldiniz  ---------");
        System.out.println("1 - Silahlar");
        System.out.println("2 - Zırhlar ");
        System.out.println("3 - Çıkış");

        System.out.print("Seçiniz: ");
        int selectCase = input.nextInt();

        while (selectCase <1 || selectCase > 3){
            System.out.println("Geçersiz bir değer girdiniz :");
            selectCase = input.nextInt();
        }

        switch (selectCase){
            case 1:
                printWeapon();
                buyWeapon();
                break;
            case 2:
                printArmor();
                break;
            case 3:
                System.out.println("Bol şanslar");
                return true;
        }
        return true;
    }

    public void printWeapon(){
        System.out.println("--------- Silahlar ------------ ");
        System.out.println();
        for (Weapon w : Weapon.weapons()){
            System.out.println(w.getId() + " - " + w.getName() + " <Para> : " + w.getPrice() + " <Hasar> : " + w.getDamge());
        }
    }

    public void buyWeapon(){

        System.out.print("Bir silah seçiniz: ");
        int selectWeaponID = input.nextInt();
        while (selectWeaponID <1 || selectWeaponID > Weapon.weapons().length){
            System.out.println("Geçersiz bir değer girdiniz :");
            selectWeaponID = input.nextInt();
        }

        Weapon selectedWeapon = Weapon.getWeaponByID(selectWeaponID);
        if (selectedWeapon.getPrice() > this.getPlayer().getMoney()){
            System.out.println("Yeterli paranız bulunmamaktadır.!!");
        }else {
            // Satın almanın gerçekleştiği alan
            System.out.println(selectedWeapon.getName() + " silahını satın aldınız");
            int balance = this.getPlayer().getMoney() - selectedWeapon.getPrice();
            this.getPlayer().setMoney(balance);
            System.out.println("Kalan Paranız : " + this.getPlayer().getMoney());
           // System.out.println("Önceki Silahınız: " + this.getPlayer().getInventory().getWeapon().getName());
            this.getPlayer().getInventory().setWeapon(selectedWeapon);
           // System.out.println("Yeni Silahınız: " + this.getPlayer().getInventory().getWeapon().getName());
        }
    }


    public void printArmor(){
        System.out.println("Zırhlar");
    }
}
