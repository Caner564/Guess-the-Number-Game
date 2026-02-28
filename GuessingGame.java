import java.util.Scanner;

public class GuessingGame {
    private int secretNumber;
    private int guessCount;

    public void startGame() {
        secretNumber = (int) (Math.random() * 100) + 1;
        guessCount = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hoş geldin! 'Tahmin Etme Oyunu' başlıyor.");
        System.out.println("1 ile 100 arasında bir sayı düşündüm. Tahmin etmeye çalış!");

        while (true) {
            System.out.print("Tahminini gir (ya da çıkmak için 'quit' yaz): ");
            String input = scanner.nextLine();


            if (input.equalsIgnoreCase("quit")) {
                System.out.println("Oyun sonlandırıldı. Düşündüğüm sayı " + secretNumber + " idi.");
                break;
            }


            if (isNumeric(input)) {
                int userGuess = Integer.parseInt(input);
                guessCount++;


                if (userGuess < 1 || userGuess > 100) {
                    System.out.println("Lütfen 1 ile 100 arasında bir sayı gir.");
                } else if (userGuess < secretNumber) {
                    System.out.println("Tahminin çok düşük! Tekrar dene.");
                } else if (userGuess > secretNumber) {
                    System.out.println("Tahminin çok yüksek! Tekrar dene.");
                } else {
                    System.out.println("Tebrikler! Sayıyı " + guessCount + " denemede buldun.");
                    break;
                }
            } else {
                System.out.println("Geçersiz giriş. Lütfen geçerli bir sayı veya 'quit' yaz.");
            }
        }
        scanner.close();
    }


    private boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
