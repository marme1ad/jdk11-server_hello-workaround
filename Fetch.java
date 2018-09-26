import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class Fetch {

    private static final String URL_TO_FETCH = "https://repository.jboss.org/nexus/content/groups/public/javax/media/jai-core/1.1.3/jai-core-1.1.3.pom";

    public static void main(final String[] args) throws Exception {
        final URL targetURL = new URL(URL_TO_FETCH);
        try (final InputStream is = targetURL.openConnection().getInputStream()) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }

}
