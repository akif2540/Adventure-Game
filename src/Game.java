import java.util.Scanner;

public class Game {
    private Scanner input = new Scanner(System.in);

    public void start() {
        System.out.println("Macera Oyununa Hoş Geldiniz !!");
        System.out.print("Lütfen Bir İsim Giriniz: ");
        //String playerName = input.nextLine();

        Player player = new Player("akif");
        System.out.println("Sayın " + player.getName() + " Bu karanlık Ada da dikkatli ol bol Şanslar :)");
        System.out.println("-----------------------------------------------------------------------------------");
        player.selectChar();

        Location location = null;
        while (true) {
            player.printInfo();
            System.out.println();
            System.out.println("###########################  Bölgeler  ######################### ");
            System.out.println();
            System.out.println("1 - Güvenli Ev , Güvenli Evde Düşman Olmaz ve sağlığınız yenilenir.");
            System.out.println("2 - Dükkan  , Mağaza düşman olmaz ve silah veya zırh satın alabilirsiniz.");
            System.out.println("3 - Mağara  , Ödül <YEMEK> ,Dikkatli Ol Zombilerden Kendini Koru");
            System.out.println("4 - Orman  , Ödül <ODUN>, Dikkatli Ol Vampirlerden Kendini Koru");
            System.out.println("5 - Nehir  , Ödül <SU>, Dikkatli Ol Ayılardan Kendini Koru");
            System.out.println("0 - Çıkış Yap  , Oyunu Sonlandır..");
            System.out.println();
            System.out.print("Gitmek istediğiniz Bölgeyi Seçiniz: ");

            int selectLoc = input.nextInt();

            switch (selectLoc) {
                case 0:
                    location = null;
                    break;
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                case 3:
                    location = new Cave(player);
                    break;
                case 4:
                    location = new Forest(player);
                    break;
                case 5:
                    location = new River(player);
                    break;
                default:
                    System.out.println("Lütfen Geçerli Bir Bölge Giriniz !");
            }
            if (location == null) {
                System.out.println("Oyun Bitti Görüşmek Üzere");
                break;
            }
            if (!location.onLocation()) {
                System.out.println("GAME OVER");
                break;
            }
        }
    }
}
