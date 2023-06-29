import java.util.*;

public class Vigenere {
  String plain_text;
  String pt_nospace;
  String key;

  Vigenere(String pt, String key) {
    this.plain_text = pt;
    this.key = key;
    this.pt_nospace = pt.replaceAll("\\s+", "");
  }

  private void generateKey() {
    int x = this.plain_text.length();

    for (int i = 0;; i++) {
      if (x < this.key.length())
        break;
      /*
       * if (x == i)
       * i = 0;
       */
      if (this.key.length() == x)
        break;
      this.key += (this.key.charAt(i));
    }
  }
  
  // This function returns the encrypted text
  // generated with the help of the key

  public String encryptedText() {
    generateKey();
    String cipher_text = "";
    String encrypted_text = "";

    for (int i = 0; i < this.pt_nospace.length(); i++) {
      int x;
      // converting in range 0-25
      x = (this.pt_nospace.charAt(i) + this.key.charAt(i)) % 26;

      // convert into alphabets(ASCII)
      x += 'A';

      cipher_text += (char) (x);
    }
    // System.out.println(cipher_text);
    // RFC r = new RFC(cipher_text,3);
    // cipher_text = r.encryptRailFence();
    // System.out.println(key);
    for (int i = 0; i < this.plain_text.length(); i++) {
      if (this.plain_text.charAt(i) == 32) {
        encrypted_text += " ";
        i--;
      } else {
        encrypted_text += cipher_text.charAt(i);
      }
    }

    return cipher_text;
  }

  // This function decrypts the encrypted text
  // and returns the original text
  public String decryptedText() {
    generateKey();
    // RFC r = new RFC(cipher_text, 3);
    // String c = r.decryptRailFence();
    String orig_text = "";

    for (int i = 0; i < this.pt_nospace.length() &&
        i < this.key.length(); i++) {
      // converting in range 0-25
      if (this.pt_nospace.charAt(i) != ' ') {
        int x = (this.pt_nospace.charAt(i) - this.key.charAt(i) + 26) % 26;

        // convert into alphabets(ASCII)
        x += 'A';
        orig_text += (char) (x);
      } else
        orig_text += this.pt_nospace.charAt(i);
    }
    return orig_text;
  }

  // This function will convert the lower case character to Upper case

}