import java.io.*;

public class DatafilterStream {
  public static void main(String[] args) throws IOException {
    OutputStream out = new FileOutputStream("data.bin");
    DataOutputStream filterOut = new DataOutputStream(out);
    filterOut.writeInt(275);
    filterOut.writeDouble(45.79);
    filterOut.close();

    InputStream in = new FileInputStream("data.bin");
    DataInputStream filterIn = new DataInputStream(in);
    int num1 = filterIn.readInt();
    double num2 = filterIn.readDouble();
    filterIn.close();

    System.out.println(num1);
    System.out.println(num2);
  }
}
