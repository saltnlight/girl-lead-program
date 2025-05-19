import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class NIO {
//    File: Represents file and directory pathnames not the content of the file, and it doesn’t let you read or write to it
//    Path:
//    Files: Represents file and directory pathnames and is also used for writing, reading, copying, and deleting files

    public void fileNIOManipulation() {
//        File file = new File("Report.txt");
        Path path = Path.of("new-file.txt");
        Path path2 = Path.of("Report.txt");
        try{
            System.out.println("Does our file exists: "+Files.exists(path));
            if(!Files.exists(path)) {
                Files.createFile(path);
                System.out.println("Does our file exists: "+Files.exists(path));
            }

            // write stuff to the path
            Files.write(path, Arrays.asList("Hello World!","I am a file!","End of file!"));
//            Files.write(path, Files.readAllBytes(path2));

            // reading from a file
            List<String> content = Files.readAllLines(path);
            content.forEach(System.out::println);
//            for(String line : content) {
//                System.out.println(line);
//            }

            // delete the file
            boolean deleted = Files.deleteIfExists(path);
            System.out.println("Is the file deleted: "+deleted);
            if(!Files.exists(path))
                System.out.println("File doesn't exist");

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
