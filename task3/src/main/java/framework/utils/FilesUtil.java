package framework.utils;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FilesUtil {

    public static Path getAbsolutPath(String pathDirectory, String nameFile ){
        return Paths.get(pathDirectory, nameFile);
    }
    public static File getFile(String pathDirectory, String nameFile ){
        return getAbsolutPath(pathDirectory, nameFile).toFile();
    }
    public static String getAbsolutPathDirectory(String pathDirectory){
        return Paths.get(pathDirectory).toAbsolutePath().toString();
    }
}
