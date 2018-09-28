package melissadata.globalname.model;

import org.apache.sling.commons.json.JSONObject;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;

public class GlobalNameTransaction {
    private final String endpoint;
    private GlobalNameOptions options;
    private String identNumber;
    private String company, fullname, format;

    public GlobalNameTransaction() {
        endpoint    = "https://globalname.melissadata.net/V3/WEB/GlobalName/doGlobalName?";
        options     = new GlobalNameOptions();
        identNumber = "";
        company     = "";
        fullname    = "";
        format      = "";
    }
    public String processTransaction(String request) {
        String response = "";
        URI uri;
        URL url;
        try {
            uri = new URI(request);
            url = new URL(uri.toURL().toString());

            HttpURLConnection urlConn = (HttpURLConnection)(url.openConnection());

            BufferedReader in = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));

            StringReader reader;
            StringWriter writer = new StringWriter();
            StringBuilder jsonResponse = new StringBuilder();
            String inputLine = "";

            if (format.equals("JSON"))
            {
                while ((inputLine = in.readLine()) != null) {
                    jsonResponse.append(inputLine);
                }
                @SuppressWarnings("deprecation")
                JSONObject test = new JSONObject(jsonResponse.toString());
                response = test.toString(10);
            } else {
                String xmlLine = "";
                String xmlString = "";

                while((xmlLine = in.readLine()) != null) {
                    xmlString += xmlLine + "\n";
                }

                TransformerFactory tf = TransformerFactory.newInstance();
                Transformer t = tf.newTransformer();
                t.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "10");
                t.setOutputProperty(OutputKeys.INDENT, "yes");

                reader = new StringReader(xmlString);
                try {
                    t.transform(new javax.xml.transform.stream.StreamSource(reader), new javax.xml.transform.stream.StreamResult(writer));
                } catch (TransformerException e) {
                    e.printStackTrace();
                }
                response = writer.toString();
            }
        } catch (Exception e){
            System.out.println("Error sending request: \n" + e);
        }
        return response;
    }

    public String generateRequestString() {
        String request = "";
        request = endpoint;
        request += "&id=" + getIdentNumber();
        request += "&opt=" + options.generateOptionString();
        try {
            if(!getCompany().equals(""))
                request += "&comp=" + URLEncoder.encode(getCompany(), "UTF-8");

            if(!getFullname().equals(""))
                request += "&full=" + URLEncoder.encode(getFullname(), "UTF-8");

        } catch (UnsupportedEncodingException e) {
            System.out.println("Unsupported Encoding Exception: " +e);
        }
        request += "&format=" + getFormat();

        return request;
    }

    public GlobalNameOptions getOptions() {
        return options;
    }

    public void setOptions(GlobalNameOptions options) {
        this.options = options;
    }

    public String getIdentNumber() {
        return identNumber;
    }

    public void setIdentNumber(String identNumber) {
        this.identNumber = identNumber;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }
}
