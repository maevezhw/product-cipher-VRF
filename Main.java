import java.util.*;

class Main {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    String answer = "";
    System.out.println("Welcome to Ciphering Program!");
    do {
      System.out.println("\nPlease choose what you want to do:\n1. Encrypt\n2. Decrypt\n3. Encrypt then Decrypt");
      System.out.print("\nYour choose: ");
      String c = input.next();

      switch (c) {
        case "1":
          encrypt();
          break;
        case "2":
          decrypt();
          break;
        case "3":
          encryptDecrypt();
          break;
        default:
          System.out.println("\nTerjadi error! Silahkan ulang kembali program!");
          System.exit(0);
      }

      System.out.print("\nDo you want to try again? (y/n):");
      String a = input.next();
      answer += a;
    } while (answer == "y" || answer == "Y");

    // if (answer == "n") {
    //   System.out.println("Shutting Down . . .");
    //   System.exit(0);
    // }
  }

  public static void encrypt() {
    Scanner input = new Scanner(System.in);

    System.out.print("\nPlain text: ");
    String p = input.nextLine();

    System.out.print("Key: ");
    String k = input.nextLine();

    p = p.toUpperCase();
    k = k.toUpperCase();

    Vigenere v = new Vigenere(p, k);
    System.out.println("\nEncrypted text: " + v.encryptedText());
  }

  public static void decrypt() {
    Scanner input = new Scanner(System.in);

    System.out.print("\nEncrypted text: ");
    String p = input.nextLine();

    System.out.print("Key: ");
    String k = input.nextLine();

    p = p.toUpperCase();
    k = k.toUpperCase();

    Vigenere v = new Vigenere(p, k);
    System.out.println("\nDecrypted text: " + v.decryptedText());
  }

  public static void encryptDecrypt() {
    Scanner input = new Scanner(System.in);

    System.out.print("\nPlain text: ");
    String p = input.nextLine();

    System.out.print("Key: ");
    String k = input.nextLine();

    p = p.toUpperCase();
    k = k.toUpperCase();

    Vigenere v = new Vigenere(p, k);
    System.out.println("\nEncrypted text: " + v.encryptedText());

    Vigenere d = new Vigenere(v.encryptedText(), k);
    System.out.println("\nLet's decrypt the text to check if it's right!");
    System.out.println("Decrypted text: " + d.decryptedText());
  }
}