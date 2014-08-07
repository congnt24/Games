import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class GetData {
	public static void main(String[] args) {
		URL url;
		try {
			url = new URL("http://view.websudoku.com/?level=1");
			URLConnection conn=url.openConnection();
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
			StringBuilder html=new StringBuilder();
			String line;
			while ((line=br.readLine())!=null) {
				html.append(line);
			}
			Pattern pattern = Pattern.compile("<INPUT NAME=cheat ID=\"cheat\" TYPE=hidden VALUE=\"([^\"]*)\">");	//([^\"]*)
			Matcher matcher=pattern.matcher(html.toString());
			Matcher mat=Pattern.compile("<INPUT ID=\"editmask\" TYPE=hidden VALUE=\"([^\"]*)\">").matcher(html.toString());
			if (matcher.find() && mat.find()) {
				System.out.println(matcher.group(1));
				System.out.println(mat.group(1));
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}
