package random;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
//import org.json.JSONArray;
//import org.json.JSONObject;

public class _ExternalAPIResponse {
    public static void main(String[] args) {
        int barCode = 74001755;
        int discountedPrice = getCalculatedPrice(barCode);
        System.out.println("Discounted price for barcode " + barCode + " is " + discountedPrice);
    }

    public static int getCalculatedPrice(int barCode) {
        try {
            URL url = new URL("https://jsonmock.hackerrank.com/api/inventory?barCode=" + barCode);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuffer response = new StringBuffer();

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

//            JSONObject jsonResponse = new JSONObject(response.toString());
//            JSONArray data = jsonResponse.getJSONArray("data");
//
//            if(data.length() == 0) {
//                return -1;
//            } else {
//                JSONObject item = data.getJSONObject(0);
//                double price = item.getDouble("price");
//                double discount = item.getDouble("discount");
//                double discountedPrice = price - (price * discount / 100);
//
//                return (int) Math.round(discountedPrice);
//            }

            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
