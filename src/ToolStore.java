public class ToolStore extends NormalLoc {
    public ToolStore(Player player) {
        super(player, "Mağaza");
    }

    @Override
    public boolean onLocation() {
        System.out.println("-------------- Mağazaya Hoşgeldiniz  ---------");
        boolean showMenu = true;
        while (showMenu) {
            System.out.println("1 - Silahlar");
            System.out.println("2 - Zırhlar ");
            System.out.println("3 - Çıkış");

            System.out.print("Seçiniz: ");
            int selectCase = input.nextInt();

            while (selectCase < 1 || selectCase > 3) {
                System.out.print("Geçersiz bir değer girdiniz Lütfen Tekrar Deneyin : ");
                selectCase = input.nextInt();
            }

            switch (selectCase) {
                case 1:
                    printWeapon();
                    buyWeapon();
                    break;
                case 2:
                    printArmor();
                    buyArmor();
                    break;
                case 3:
                    System.out.println("Bol şanslar");
                    showMenu = false;
                    break;
            }
        }
        return true;

    }

    public void printWeapon() {
        System.out.println("--------- Silahlar ------------ ");
        System.out.println();
        for (Weapon w : Weapon.weapons()) {
            System.out.println(w.getId() + " - " + w.getName() + " <Para> : " + w.getPrice() + " <Hasar> : " + w.getDamge());
        }
        System.out.println("0 - Çıkış Yap");
    }

    public void buyWeapon() {

        System.out.print("Bir silah seçiniz: ");
        int selectWeaponID = input.nextInt();
        while (selectWeaponID < 0 || selectWeaponID > Weapon.weapons().length) {
            System.out.print("Geçersiz bir değer girdiniz Lütfen Tekrar Deneyin : ");
            selectWeaponID = input.nextInt();
        }
        if (selectWeaponID != 0) {
            Weapon selectedWeapon = Weapon.getWeaponByID(selectWeaponID);
            if (selectedWeapon != null) {
                if (selectedWeapon.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("Yeterli paranız bulunmamaktadır.!!");
                } else {
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
        }
    }


    public void printArmor() {
        System.out.println("--------- Zırhlar ------------ ");
        System.out.println();
        for (Armor a : Armor.armors()) {
            System.out.println(a.getId() + " - " + a.getName() + " <Zırh Değeri> : " + a.getBlock() + " <Para> : " + a.getPrice());

        }
        System.out.println("0 - Çıkış Yap");
    }

    public void buyArmor() {
        System.out.print("Bir zırh seçiniz: ");
        int selectArmorID = input.nextInt();
        while (selectArmorID < 0 || selectArmorID > Armor.armors().length) {
            System.out.print("Geçersiz bir değer girdiniz Lütfen Tekrar Deneyin : ");
            selectArmorID = input.nextInt();
        }

        if (selectArmorID != 0) {
            Armor selectedArmor = Armor.getArmorByID(selectArmorID);
            if (selectedArmor != null) {
                if (selectedArmor.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("Yeterli Paranız Bulunmamaktadır...!");
                } else {
                    System.out.println(selectedArmor.getName() + "Zırhınızı satın aldınız...");
                    int balance = this.getPlayer().getMoney() - selectedArmor.getPrice();
                    this.getPlayer().setMoney(balance);
                    this.getPlayer().getInventory().setArmor(selectedArmor);
                    System.out.println("Kalan Paranız : " + this.getPlayer().getMoney());
                }
            }
        }
    }
}
