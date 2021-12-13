import java.io.*;

public class Problem2 {
  public static void main(String[] args) throws IOException {
    FileWriter fw = new FileWriter("printf.txt");
    BufferedWriter bw = new BufferedWriter(fw);
    PrintWriter pw = new PrintWriter(bw);

    pw.printf("제 나이는 %d살 입니다.", 24);
    pw.println("");

    pw.println("저는 자바가 좋습니다.");
    pw.print("특히 I/O 부분에서 많은 매력을 느낍니다.");
    pw.close();

    FileReader fr = new FileReader("printf.txt");
    BufferedReader br = new BufferedReader(fr);
    String str = null;

    while (true) {
      str = br.readLine();
      if (str == null) {
        break;
      }
      System.out.println(str);
    }
    br.close();
  }
}
