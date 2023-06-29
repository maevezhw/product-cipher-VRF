import java.util.*;

public class RFC{
  String pt;
  int key;

  RFC(String pt, int key){
    this.pt=pt;
    this.key=key;
  }
  
  public String encryptText(){
    char[][] rail = new char[this.key][this.pt.length()];
    for (int i = 0; i < this.key; i++){
      Arrays.fill(rail[i], '\n');
    }
 
    boolean dirDown = false; //direction down
    int row = 0, col = 0; 
 
    for (int i = 0; i < this.pt.length(); i++) {
      if (row == 0 || row == this.key - 1)
        dirDown = !dirDown;
        rail[row][col++] = this.pt.charAt(i);
        if (dirDown)
          row++;
        else
          row--;
    }
    
    StringBuilder result = new StringBuilder();
    for (int i = 0; i < this.key; i++)
      for (int j = 0; j < this.pt.length(); j++)
        if (rail[i][j] != '\n')
          result.append(rail[i][j]);
 
    return result.toString();
  }
 
  public String decryptText(){
    char[][] rail = new char[key][this.pt.length()];
      
    for (int i = 0; i < key; i++){
      Arrays.fill(rail[i], '\n');
    }
      
    boolean dirDown = true;
    int row = 0, col = 0;
 
    // mark the places with '*'
    for (int i = 0; i < this.pt.length(); i++) {
      // check the direction of flow
      if (row == 0)
        dirDown = true;
      if (row == key - 1)
        dirDown = false;
 
      // place the marker
      rail[row][col++] = '*';
 
      // find the next row using direction flag
      if (dirDown)
        row++;
      else
        row--;
      }
 
      // now we can construct the fill the rail matrix
      int index = 0;
      for (int i = 0; i < key; i++)
          for (int j = 0; j < this.pt.length(); j++)
              if (rail[i][j] == '*' && index < this.pt.length())
                rail[i][j] = this.pt.charAt(index++);
 
      StringBuilder result = new StringBuilder();
      row = 0;
      col = 0;
      for (int i = 0; i < this.pt.length(); i++) {
        // check the direction of flow
        if (row == 0)
          dirDown = true;
        if (row == key - 1)
          dirDown = false;
 
        // place the marker
        if (rail[row][col] != '*')
          result.append(rail[row][col++]);
 
        // find the next row using direction flag
        if (dirDown)
          row++;
        else
          row--;
      }
      System.out.println("Rail fence decrypted text: "+result.toString());
      return result.toString();
    }
}