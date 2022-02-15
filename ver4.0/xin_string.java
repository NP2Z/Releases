import java.io.*;
import java.util.*;
import java.util.regex.*;
public class xin_string
{
    /*** 
    * @author xin
    * @feature This is too niubi
    */
    public void main() throws IOException
    {
        File inputFile = new File("temp.txt"),outputFile = new File("url.txt");
        FileOutputStream os = new FileOutputStream(outputFile);

        Scanner scan = new Scanner(inputFile);

        String str0 = "http",str1 = ".png|.jpg";
        Pattern pattern1 = Pattern.compile(str0),pattern2 = Pattern.compile(str1);
        int sta = 0,end = 0;
        while(scan.hasNext())
        {
            String str = scan.nextLine();
            Matcher matcher1 = pattern1.matcher(str),matcher2 = pattern2.matcher(str);
            // System.out.println(str1);
            if(matcher1.find() && matcher2.find()) 
            {
                sta = matcher1.start(); end = matcher2.end();
                // System.out.print(matcher2.group());
                // System.out.print(String.format("sta = %d end = %d\n",sta,end));
                for(int i=sta;i<end;++i)
                {
                    // System.out.print(str.charAt(i));
                    os.write(str.charAt(i));
                }
            }
        }
        scan.close(); os.close();
        System.out.println("xin_string is closed");
    }
}