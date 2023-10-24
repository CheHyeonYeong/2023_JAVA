package Week07_chy.ByteStreamsLab;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class ByteStreamsLab {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        System.out.println("원본 파일 명을 입력하세요 : ");
        String inputFileName = scan.next();
        System.out.println("복사 파일 명을 입력하세요 : ");
        String outputFileName = scan.next();

        try (FileReader inputStream = new FileReader(inputFileName);
             FileWriter outputStream = new FileWriter(outputFileName)){
            int c;
            while ((c=inputStream.read())!=-1){
                outputStream.write(c);
            }
        }
        System.out.println(inputFileName +"을 "+outputFileName+"로 복사하였습니다.");


    }
}
