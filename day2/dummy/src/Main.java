import java.net.HttpURLConnection;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws Exception{
        System.out.println("Hello world!");
        URL url1 = new URL("https://www.google.com/");
        HttpURLConnection httpURLConnection = (HttpURLConnection)url1.openConnection();
        String status = String.valueOf(httpURLConnection.getContent());
        System.out.println(status);
    }
}