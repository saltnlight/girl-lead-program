import java.io.*;

public class WritingOutputs {
    /*
     * Writing byte streams
     * */
//    OutputStream (abstract class)
//    FileOutputStream: Writes bytes to a file
//    ByteArrayOutputStream: Writes bytes to a byte array
//    BufferedOutputStream: Adds buffering to another output stream
//    DataOutputStream: Writes primitive Java data types
//    ObjectOutputStream: Serializes objects for storage or transmission

    String name = "Vivian";
    int age = 18;
    double height = 1.6;
    boolean isStudent = true;
    public void writeBinaryDataToFile() {
        try(DataOutputStream dis = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("user.bin")))) {
            dis.writeUTF(name);
            dis.writeInt(age);
            dis.writeDouble(height);
            dis.writeBoolean(isStudent);
            dis.flush();
            System.out.println("Finished writing to file");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // read the data from our created binary file
        try(DataInputStream dis = new DataInputStream(new FileInputStream("user.bin"))) {
            System.out.println();
            System.out.println("Attempt reading from file");
            System.out.println(dis.readUTF());
            System.out.println(dis.readInt());
            System.out.println(dis.readDouble());
            System.out.println(dis.readBoolean());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void writeCharactersToFile() {
        String info = "Report on Java IO and NIO GirlLEAD class\nThe instructor thought the class was a bit boring because no one has asked questions";
        try(FileOutputStream fos = new FileOutputStream("Report.txt");
            BufferedOutputStream bos = new BufferedOutputStream(fos)
        ) {
            bos.write(info.getBytes());
//            bos.write(info.getBytes(StandardCharsets.UTF_8));
            bos.flush(); // ensure everything in bos pipe is written to file
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /*
     * Writing character streams
     * */
//    Writer (abstract class)
//    OutputStreamWriter: Bridge from character streams to byte streams
//    FileWriter: Writes characters to a file
//    BufferedWriter: Adds buffering and provides newLine() method
//    StringWriter: Writes to a String buffer
//    PrintWriter: Prints formatted representations of objects

    public void writeToFileUSingWriter() {
        try(FileWriter fileWriter = new FileWriter("Infomation.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)
        ) {
            bufferedWriter.write("Someone asked a question in class");
            bufferedWriter.newLine();
            bufferedWriter.write("And it made me really happy.");
            bufferedWriter.newLine();
            bufferedWriter.write(String.format("Her name is %s. Age:%s. Is a student:%s", name,age,isStudent));
            System.out.println("Attempt writing to file finished");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
