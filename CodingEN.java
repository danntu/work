/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package codingen;

/**
 *
 * @author DMyrzaka
 */
import java.util.SortedMap;
import java.util.TreeMap;
public class CodingEN {

    /**
     * @param args the command line arguments
     */
    
    public String translitRustoEng(String str) {
    SortedMap map = this.translitGetMap();
    //str = str.toLowerCase();
    String[] rus = str.split("");
    String key = "";
    String result = "";
    for(int i = 0; i<rus.length; i++) {
      key = rus[i];
      if(map.containsKey(key)) {
        result += map.get(key);
      } else {
        result += key;
      }
    } 
    return result;
  }  
  
  public SortedMap translitGetMap() {
    SortedMap<String, String> map = new TreeMap<String,String>();
    String[] rus = this.alphabet_rus;
    String[] eng = this.alphabet_eng;
    for(int i = 0; i<rus.length; i++) {
      map.put(rus[i], eng[i]);
    } 
    return map;
  }
  
  public final String[] alphabet_rus = new String[]{
    "а","б","в","г","д","е","ё","ж","з","и","й","к","л","м","н","о","п",
    "р","с","т","у","ф","х","ц","ч","ш","щ","ъ","ы","ь","э","ю","я",
    "А","Б","В","Г","Д","Е","Ё","Ж","З","И","Й","К","Л","М","Н","О","П",
    "Р","С","Т","У","Ф","Х","Ц","Ч","Ш","Щ","Ъ","Ы","Ь","Э","Ю","Я",
    "Ә","І","Ң","Ғ","Ү","Ұ","Қ","Ө","Һ",
    "ә","і","ң","ғ","ү","ұ","қ","ө","һ"
  };
  
  public final String[] alphabet_eng = new String[]{
    "a","b","v","g","d","e","e","zh","z","i","y","k","l","m","n","o","p",
    "r","s","t","u","f","h","c","ch","sh","sch","","y","","e","yu","ya",
    "A","B","V","G","D","E","E","Zh","Z","I","Y","K","L","M","N","O","P",
    "R","S","T","U","F","H","C","Ch","Sh","Sch","","Y","","E","Yu","Ya",
    "A","I","N","G","U","U","K","O","H",
    "a","i","n","g","u","u","k","o","h"
  };
    
  public static void main(String args[])
 {
  CodingEN cod = new CodingEN();
 System.out.println(cod.translitRustoEng("Бұл қазақша мәтіндер және уақытша режимде. әіңғүұқ"));
              
  }

}
