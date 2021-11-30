import com.groupdocs.conversion.Converter;
import com.groupdocs.conversion.filetypes.FileType;
import com.groupdocs.conversion.options.convert.ConvertOptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class HindiWordsExtracter {

    public static void main(String[] args) throws FileNotFoundException {
        HashSet<String> lines = new HashSet<String>();
        File file = new File("Unicode/hindi.txt");
        Scanner input = new Scanner(file);
        int count = 0;
        while (input.hasNext()) {
            String next  = input.next();
            char[] temp = next.toCharArray();
            for(char c: temp){
                if(c=='|'){

                }
            }
            System.out.println(next);
            lines.add(next);
            count++;
        }
        input.close();
        System.out.println(lines);
        System.out.println("Word count: " + count);
        System.out.println("Unique word count: " + lines.size());
    }
}
