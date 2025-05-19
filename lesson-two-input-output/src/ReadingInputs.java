import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class ReadingInputs {

    /*
     * Reading character streams
     * */
//    Reader (abstract class)
//    InputStreamReader: Bridge from byte streams to character streams
//    FileReader: Reads characters from a file
//    BufferedReader: Adds buffering and provides readLine() method
//    StringReader: Reads from a String source

    public void fileReader() {
        try(FileReader fr = new FileReader("src/resource/sample_file.txt");
            BufferedReader br = new BufferedReader(fr);
        ) {
            for (String line = br.readLine(); line != null; line = br.readLine()) {
                System.out.println(line);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void byteToCharacterStream() {
        try {
            URL url = new URL("https://www.w3.org/TR/png/iso_8859-1.txt");
            try(InputStreamReader isr = new InputStreamReader(url.openStream());
                BufferedReader br = new BufferedReader(isr);
            ){
//                for (int i = 0; i < 10; i++) {
//                    System.out.println(br.readLine());
//                }
                for (String line = br.readLine(); line != null; line = br.readLine()) {
                    System.out.println(line);
                }
            }
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /*
     * Reading byte streams
     * */
//    InputStream (abstract class)
//    FileInputStream: Reads bytes from a file
//    ByteArrayInputStream: Reads bytes from a byte array
//    BufferedInputStream: Adds buffering to another input stream
//    DataInputStream: Reads primitive Java data types
//    ObjectInputStream: Deserializes objects written by ObjectOutputStream

    public void readFromURL() {
        try {
            URL url = new URL("https://www.w3.org/TR/png/iso_8859-1.txt");
            try(InputStream is = url.openStream();
//                BufferedInputStream bis = new BufferedInputStream(is);
                DataInputStream dis = new DataInputStream(is);
            ){
                int index = dis.read();
                while (index != -1) {
                    System.out.print((char) index);
                    index = dis.read();
                }
            }
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
        // print how long it took
    }

    public void readFile() {
        // try with resources
        try(
            FileInputStream fis = new FileInputStream("src/resource/sample_file.txt");
            BufferedInputStream bis = new BufferedInputStream(fis);
            DataInputStream dis = new DataInputStream(bis);
        ){
            int index = dis.read();
            while (index != -1) {
                System.out.print((char) index);
                index = dis.read();
            }
        }
        catch (Exception e) {
            System.out.println("An error occurred while reading the file.");
            System.out.println(e.getMessage());
        }

    }

    public void readText() throws IOException {
        String message = "Hello\nLadies\nWelcome\nto Java Programming!";
//        System.out.println(message);

        byte[] data = message.getBytes();
//        for (byte b : data) {
//            System.out.print(b);
//        }

        System.out.println();
        DataInputStream inputStream = new DataInputStream(new ByteArrayInputStream(data));
        System.out.println(inputStream.readLine()); // deprecated
//        System.out.println(inputStream.readLine());
//        System.out.println(inputStream.readLine());
        int i = inputStream.read();
        while (i != -1) {
            System.out.print(i);
            System.out.print((char) i);
            System.out.println();
            i = inputStream.read();
        }

    }
}
