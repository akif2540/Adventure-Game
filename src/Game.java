import java.util.Scanner;

public class Game {
    private Scanner input = new Scanner(System.in);

    public void start(){
        System.out.println("Macera Oyununa Hoş Geldiniz !!");
        System.out.print("Lütfen Bir İsim Giriniz: ");
        //String playerName = input.nextLine();

        Player player = new Player("akif");
        System.out.println("Sayın " + player.getName() + " Bu karanlık Ada da dikkatli ol bol Şanslar :)");
        System.out.println("Karekterinizi Seçiniz..");
        player.selectChar();
    }
}
