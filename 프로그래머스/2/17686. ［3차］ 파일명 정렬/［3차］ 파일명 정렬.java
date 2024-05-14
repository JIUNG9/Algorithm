import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

class Solution {
 
  public String[] solution(String[] files) {

    List<File> filesList = FileConvertor.convertToFileList(files);
    return filesList.stream().sorted().map(FileConvertor::convertToString).toArray(String[]::new);
  }

  static class FileConvertor {

    private static List<File> convertToFileList(String[] files) {
      List<File> filesList = new ArrayList<>();
      for (String file : files) {
        filesList.add(convertToFile(file));
      }
      return filesList;
    }

    private static File convertToFile(String file) {
      String head = "";
      String num = "";
      String tail = "";
      for(int i = 0; i < file.length(); i++){
        char c = file.charAt(i);
        if(head.equals("") && Character.isDigit(c)){
          head = file.substring(0,i);
          while(Character.isDigit(c)){
            num = num.concat(String.valueOf(c));
            i++;
            if(i < file.length()) c = file.charAt(i);
            else break;
          }
          tail = file.substring(i);
          break;
        }
         }

      if(num.length() > 5){
        tail = num.substring(5) + tail;
        num = num.substring(0,5);
      }


      return new File(head, num, tail);
    }

    private static String convertToString(File file) {
      return file.toString();
    }

  }

}


class File implements Comparable<File> {

  private final String header;
  private final String number;
  private final String tail;

  public File(String header, String number, String tail) {
    this.header = header;
    this.number = number;
    this.tail = tail;
  }

  @Override
  public String toString() {
    return header + number + tail;
  }

@Override
  public int compareTo(File o) {
    int headerComparisonResult = this.header.toLowerCase(Locale.ROOT)
        .compareTo(o.header.toLowerCase(Locale.ROOT));
    int numberComparisonResult = Integer.compare(Integer.parseInt(this.number),
        Integer.parseInt(o.number));
    if (headerComparisonResult != 0) {
      return headerComparisonResult;
    }
        return numberComparisonResult;


  }
}