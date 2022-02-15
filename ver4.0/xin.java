import java.io.*;
import java.net.*;
import java.util.*;
import java.util.regex.*;
// import web;
public class xin
{
    /*** 
    * @author xin
    * @feature This is too niubi
    */
    public boolean find(String str,String pat)
    {
        Pattern Pat = Pattern.compile(pat);
        Matcher mat = Pat.matcher(str);
        return mat.find();
    }
    public static void main(String[] args) throws IOException,Exception
    {
        xin func = new xin();

        int from = 1,to = 1;
        if(args.length >= 2) 
        {
            from = Integer.valueOf(args[0]);
            to = Integer.valueOf(args[1]);
        }
        for(int jsq = from;jsq <= to;++ jsq)
        {
            // static String temp = "123";
            xin_web thread1 = new xin_web(); xin_string thread2 = new xin_string();
            thread1.main(); thread2.main();
            
            File inputFile = new File("url.txt");
            Scanner scan = new Scanner(inputFile);

            String baseurl = scan.nextLine();
            URL url = new URL(baseurl);
            
            scan.close();
            
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            
            int sec_cont = 1000;
            
            con.setReadTimeout(10 * sec_cont);
            con.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.122 Safari/537.36");
            con.connect();
            
            InputStream is = con.getInputStream();
            ByteArrayOutputStream Baos = new ByteArrayOutputStream();
            

            int maxn = 1024 * 50,len = 0;
            byte[] buf = new byte[maxn];
            
            while((len = is.read(buf)) != -1)
            {
                System.out.print(String.format("Get the mem of [ %5d KB ]\n",len));
                Baos.write(buf, 0, len);
            }

            System.out.println("Check");
            System.out.println(String.format("The %dth pic is already",jsq));

            String dirname = "Pics/";
            File dir = new File(dirname);
            if(!dir.exists()) dir.mkdirs();

            String filename = new String(dirname + "pic" + String.valueOf(jsq));
            

            if(func.find(baseurl,".jpg")) filename = filename + ".jpg";
            if(func.find(baseurl,".png")) filename = filename + ".png";
            
            File file = new File(filename);
            

            FileOutputStream os = new FileOutputStream(file);
            os.write(Baos.toByteArray());
            
            
            File operate1 = new File("temp.txt"),operate2 = new File("url.txt");
            operate1.delete(); operate2.delete();
            // System.out.print(Baos.toByteArray());
            os.close();
        }
    }
}