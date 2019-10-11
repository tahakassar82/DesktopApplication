/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trips;

/**
 *
 * @author Taha Kassar
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.JOptionPane;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RequestServer {
     public static JSONObject MyGETRequest(String url) throws IOException, JSONException {
        URL urlForGetRequest = new URL(url);
        String readLine;
        HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
        conection.setRequestMethod("GET");
        int responseCode = conection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            StringBuffer response;
            try (BufferedReader in = new BufferedReader(
                    new InputStreamReader(conection.getInputStream()))) {
                response = new StringBuffer();
                while ((readLine = in.readLine()) != null) {
                    response.append(readLine);
                }
            }
            try {
                JSONArray nameObject = new JSONArray(response.toString());
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("code", responseCode);
                jSONObject.put("data", nameObject);
                return jSONObject;
            } catch (JSONException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
                return null;
            }
        } else {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", 400);
            jSONObject.put("name", "");
            return jSONObject;
        }
    }
    
    
    public static JSONObject GETRequest(String url) throws IOException, JSONException {
        URL urlForGetRequest = new URL(url);
        String readLine;
        HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
        conection.setRequestMethod("GET");
        int responseCode = conection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            StringBuffer response;
            try (BufferedReader in = new BufferedReader(
                    new InputStreamReader(conection.getInputStream()))) {
                response = new StringBuffer();
                while ((readLine = in.readLine()) != null) {
                    response.append(readLine);
                }
            }
            try {
                JSONArray nameObject = new JSONArray(response.toString());
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("code", responseCode);
                jSONObject.put("reports", nameObject);
                return jSONObject;
            } catch (JSONException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
                return null;
            }
        } else {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", 400);
            jSONObject.put("name", "");
            return jSONObject;
        }
    }

    
    public static JSONObject POSTRequest(String body, String url) throws IOException, JSONException {
        URL obj = new URL(url);
        HttpURLConnection postConnection = (HttpURLConnection) obj.openConnection();
        postConnection.setRequestMethod("POST");
        postConnection.setRequestProperty("Content-Type", "application/json");
        postConnection.setDoOutput(true);
        try (OutputStream os = postConnection.getOutputStream()) {
            os.write(body.getBytes());
            os.flush();
        }
        int responseCode = postConnection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            StringBuffer response;
            try (
                    BufferedReader in = new BufferedReader(new InputStreamReader(
                                    postConnection.getInputStream()))) {
                                String inputLine;
                                response = new StringBuffer();
                                while ((inputLine = in.readLine()) != null) {
                                    response.append(inputLine);
                                }
                            }
                            try {
                                JSONObject nameObject = new JSONObject(response.toString());
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("code", responseCode);
                                jSONObject.put("token", nameObject.getString("token"));
                                return jSONObject;
                            } catch (JSONException e) {
                                JSONObject nameObject = new JSONObject(response.toString());
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("code", responseCode);
                                jSONObject.put("_id", nameObject.getString("_id"));
                                jSONObject.put("name", nameObject.getString("name"));
                                return jSONObject;
                            }

        } else {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", 400);
            jSONObject.put("name", "");
            return jSONObject;
        }

    }

    
     public static JSONObject POSTRequestAdd(String body, String url) throws IOException, JSONException {
        URL obj = new URL(url);
        HttpURLConnection postConnection = (HttpURLConnection) obj.openConnection();
        postConnection.setRequestMethod("POST");
        postConnection.setRequestProperty("Content-Type", "application/json");
        postConnection.setDoOutput(true);
        try (OutputStream os = postConnection.getOutputStream()) {
            os.write(body.getBytes());
            os.flush();
        }
        int responseCode = postConnection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            StringBuffer response;
            try (
                    BufferedReader in = new BufferedReader(new InputStreamReader(
                                    postConnection.getInputStream()))) {
                                String inputLine;
                                response = new StringBuffer();
                                while ((inputLine = in.readLine()) != null) {
                                    response.append(inputLine);
                                }
                            }
                            try {
                                JSONObject nameObject = new JSONObject(response.toString());
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("code", responseCode);
                                jSONObject.put("token", nameObject.getString("token"));
                                return jSONObject;
                            }
                            catch(JSONException e){
                                JOptionPane.showMessageDialog(null, e.getMessage());
                            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Try Again");
            return null;}
        return null;
     }
     
     
     
     
     
    public static JSONObject deleteRequest(String body, String url) throws MalformedURLException, IOException, JSONException {

        URL obj = new URL(url);
        HttpURLConnection deleteConn = (HttpURLConnection) obj.openConnection();
        deleteConn.setDoOutput(true);
        deleteConn.setRequestProperty("Content-Type", "application/json");
        deleteConn.setRequestMethod("DELETE");
        try (OutputStream os = deleteConn.getOutputStream()) {
            os.write(body.getBytes());
            os.flush();
        } catch (IOException ex) {
            
        }
        int responseCode = deleteConn.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            StringBuffer response;
            JSONObject jSONObject = new JSONObject();
            try (
                    BufferedReader in = new BufferedReader(new InputStreamReader(
                                    deleteConn.getInputStream()))) {
                                String inputLine;
                                response = new StringBuffer();
                                while ((inputLine = in.readLine()) != null) {
                                    response.append(inputLine);
                                }
                            }

                            jSONObject.put("code", responseCode);

                            return jSONObject;
        } else {
            JSONObject js = new JSONObject();
            js.put("code", 400);
            return js;
        }
}
}
