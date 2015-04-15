package com.company;


import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by navenprasad25 on 08/04/2015.
 */
public class HTTPRequest {
    public void sendGet(){
        try{
            URL url = new URL("http://api.openweathermap.org/data/2.5/weather?q=Kuala%20Lumpur");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

            String result = in.readLine().toString();
            System.out.println("THIS IS THE GET RESULT : "+result);




        }catch(Exception e){
            System.out.println(e);
        }
    }

    public void sendPost(){

        try{

            URL url = new URL("https://selfsolve.apple.com/wcResults.do");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            con.setRequestMethod("POST");
            String parameters = "sn=C02G8416DRJM&cn=&locale=&caller=&num=12345"; // this is what you want to send.
            con.setDoOutput(true);

            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(parameters);
            wr.flush();
            wr.close();

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) { // this is to get multiple lines, see if you can do the same for the one above
                response.append(inputLine);
            }

            System.out.println("THIS IS THE POST RESULT: "+ response.toString());
            in.close();






        }catch(Exception e){
            e.printStackTrace();

        }
    }
}


