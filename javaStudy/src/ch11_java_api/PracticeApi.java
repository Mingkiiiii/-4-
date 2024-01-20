package ch11_java_api;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PracticeApi {
	public static void main(String[] args) {
	    try {
	        getCryptoInfo("KRW-BTC");
	        getCryptoInfo("BTC-ETC");
	        getCryptoInfo("KRW-ETH");
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}


    public static void getCryptoInfo(String code) throws Exception {
        String apiUrl = "https://api.upbit.com/v1/ticker?markets=" + code;
        URL url = new URL(apiUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setDoOutput(true);
        int responseCode = conn.getResponseCode();

        if(responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }

            in.close();
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(response.toString().substring(1, response.toString().length()-1));

            String market = (String) jsonObject.get("market");
            double tradePrice = (double) jsonObject.get("trade_price");
            long timestamp = (long) jsonObject.get("timestamp");
            Date date = new Date(timestamp);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            String tradeDate = sdf.format(date);

            System.out.println("==========현재===========");
            System.out.println("market: " + market);
            System.out.println("trade date: " + tradeDate);
            System.out.println("trade Price: " + tradePrice);
            System.out.println("trade_Price: " + Math.round(tradePrice));
        } else {
            throw new Exception("HTTP Connection Response Code is not OK: " + responseCode);
        }
    }
}
