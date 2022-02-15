import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
public class xin 
{
    /*** 
    * @author xin
    * @feature This is too niubi
    */
    public static void main(String[] args) throws IOException,Exception
    {
        URL url = new URL("https://s4.ax1x.com/2022/01/30/HC4MPf.png");

        HttpURLConnection con = (HttpURLConnection)url.openConnection();

        final int sec = 1000;
        con.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.122 Safari/537.36");
        con.setReadTimeout(sec * 10);
        con.connect();

        InputStream is = con.getInputStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        int maxn = 1024 * 10,len = 0;
        byte[] buf = new byte[maxn];

        while((len = is.read(buf)) != -1)
        {
            System.out.print(String.format("Get the mem of [ %3d MB ] [ %5d KB ]\n",len / 1024,len));
            baos.write(buf, 0, len);
        }


        File filename = new File("pic.jpg");

        FileOutputStream os = new FileOutputStream(filename);
        os.write(baos.toByteArray());

        os.close();
    }
}