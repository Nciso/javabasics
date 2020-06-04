
import java.util.ArrayList;

class PermutationDups {

  static ArrayList<StringBuffer> getPermutations(StringBuffer str){
    ArrayList<StringBuffer> permutations = new ArrayList<StringBuffer>();
    if(str.length()<1){
      return permutations;
    }

    if(str.length() == 1){
      permutations.add(str);
      return permutations;
    }

    StringBuffer lastChar = new StringBuffer(str.substring(str.length()-1));
    //System.out.println("last char: " + lastChar);
    StringBuffer newString = new StringBuffer(str.substring(0, str.length()-1));
    //System.out.println("newString: " + newString);
    ArrayList<StringBuffer> newPermutations = getPermutations(newString);

    for(StringBuffer s: newPermutations){
      permutations.add(s);

      permutations.add(new StringBuffer().append(s).append(lastChar));
      permutations.add(new StringBuffer().append(lastChar).append(s));
      //permutations.add(lastChar.append(s));
    }
    permutations.add(lastChar);
    return permutations;
  } 

  public static void main(String[] args){
    StringBuffer str = new StringBuffer("abc");
    ArrayList<StringBuffer> permutations = getPermutations(str);

    for(StringBuffer s: permutations){
      System.out.println(s);
    }
  }
}