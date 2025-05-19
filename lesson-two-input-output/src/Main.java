//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        NIO nio = new NIO();
        nio.fileNIOManipulation();

        WritingOutputs writingOutputs = new WritingOutputs();
//        writingOutputs.writeCharactersToFile();
//        writingOutputs.writeBinaryDataToFile();
//        writingOutputs.writeToFileUSingWriter();

        ReadingInputs readingInputs = new ReadingInputs();
        try {
//            readingInputs.readText();
//            readingInputs.readFile();
//            readingInputs.readFromURL();

//            readingInputs.fileReader();
//            readingInputs.byteToCharacterStream();
        }
        catch (Exception e) {
            // do anything you want with the error
            System.out.println(e.getMessage());
//            System.out.println(e.getStackTrace());
//            throw e;
        }


    }
}