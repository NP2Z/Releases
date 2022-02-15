import java.io.*;
import java.net.*;
public class xin_web
{
    /*** 
    * @author xin
    * @feature This is too niubi
    */
    public void main() throws IOException,Exception
    {
        String baseurl = "https://bing.ioliu.cn/v1/rand?type=json";
        URL url = new URL(baseurl);
        
        HttpURLConnection con = (HttpURLConnection)url.openConnection();
        
        int sec_cont = 1000;
        
        con.setReadTimeout(10 * sec_cont);
        con.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1)");
        con.connect();
        
        InputStream is = con.getInputStream();
        ByteArrayOutputStream Baos = new ByteArrayOutputStream();
        

        int maxn = 1024 * 10,len = 0,tot = 0;
        byte[] buf = new byte[maxn];
        
        while((len = is.read(buf)) != -1)
        {
            System.out.print(String.format("Get the mem of [ %3d MB ] [ %5d KB ]\n",len / 1024,len));
            Baos.write(buf, 0, len);
            tot += len;
        }

        System.out.println(String.format("Total of %d MB",tot / maxn));
        String filename = new String("temp.txt");
        File file = new File(filename);

        FileOutputStream os = new FileOutputStream(file);
        os.write(Baos.toByteArray());
        

        // System.out.print(Baos.toByteArray());
        os.close();
        System.out.println("xin_web is closed");
    }
}
