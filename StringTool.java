import java.util.Scanner;

class Main {
  public void lower(){
    Scanner sc = new Scanner(System.in);
    String message;
    System.out.println("\n\nEnter your string: ");
    message = sc.nextLine();
    char[] charArray = message.toCharArray();
    boolean foundSpace = true;
    for(int i = 0; i < charArray.length; i++) {
      if(Character.isLetter(charArray[i])) {
        if(foundSpace) {
          charArray[i] = Character.toLowerCase(charArray[i]);
          foundSpace = false;
        }
      }
      else {
        foundSpace = true;
      }
    }
    message = String.valueOf(charArray);
    System.out.println(message);

    System.out.println(message.toLowerCase());

  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String message;
    System.out.println("\n\nEnter your string: ");
    message = sc.nextLine();
    char[] charArray = message.toCharArray();
    boolean foundSpace = true;
    for(int i = 0; i < charArray.length; i++) {
      if(Character.isLetter(charArray[i])) {
        if(foundSpace) {
          charArray[i] = Character.toUpperCase(charArray[i]);
          foundSpace = false;
        }
      }
      else {
        foundSpace = true;
      }
    }
    message = String.valueOf(charArray);
    System.out.println(message);

    System.out.println(message.toUpperCase());
  }
}
//



