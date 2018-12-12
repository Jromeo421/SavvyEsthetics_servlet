/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package httpurldemo;

import java.io.*;
import java.net.*;
import java.util.*;
/**
 *
 * @author JRome
 */
class HttpUtility {
    
    /*
     * Represents an HTTP connection
     */
     private static HttpURLConnection httpConn;

     
    /**
     * Makes an HTTP request using GET method to the specified URL.
     *
     * @param requestURL
     *            the URL of the remote server
     * @return An HttpURLConnection object
     * @throws IOException
     *             thrown if any I/O error occurred
     */
    public static HttpURLConnection sendGetRequest(String requestURL) throws IOException {

        URL url = new URL(requestURL);

        httpConn = (HttpURLConnection) url.openConnection();

        httpConn.setUseCaches(false);

        httpConn.setDoInput(true); // true if we want to read server's response

        httpConn.setDoOutput(false); // false indicates this is a GET request

        return httpConn;
    }


    /**
     * Makes an HTTP request using POST method to the specified URL.
     *
     * @param requestURL
     *            the URL of the remote server
     * @param params
     *            A map containing POST data in form of key-value pairs
     * @return An HttpURLConnection object
     * @throws IOException
     *             thrown if any I/O error occurred
     */
    public static HttpURLConnection sendPostRequest(String requestURL, Map<String, String> params) throws IOException {

        URL url = new URL(requestURL);

        httpConn = (HttpURLConnection) url.openConnection();

        httpConn.setUseCaches(false);

        httpConn.setDoInput(true); // true indicates the server returns response

        StringBuilder requestParams = new StringBuilder();

        if (params != null && params.size() > 0) {

        httpConn.setDoOutput(true); // true indicates POST request

        // creates the params string, encode them using URLEncoder

            Iterator<String> paramIterator = params.keySet().iterator();

            while (paramIterator.hasNext()) {

                String key = paramIterator.next();

                String value = params.get(key);

                requestParams.append(URLEncoder.encode(key, "UTF-8"));

                requestParams.append("=").append(
                URLEncoder.encode(value, "UTF-8")
            
            );
            requestParams.append("&");

        }

        // sends POST data

        OutputStreamWriter writer = new OutputStreamWriter(httpConn.getOutputStream()
    );
        writer.write (requestParams.toString

    ());
        writer.flush ();
        }

        return httpConn;
    }

        /**
     * Returns only one line from the server's response. This method should be
     * used if the server returns only a single line of String.
     *
     * @return a String of the server's response
     * @throws IOException
     *             thrown if any I/O error occurred
     */
    public static String readSingleLineRespone() throws IOException {InputStream inputStream = null;
    if (httpConn != null) {
    inputStream = httpConn.getInputStream();
    } else {
    throw new IOException("Connection is not established.");
    }
    String response;
         try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                 inputStream))) {
             response = reader.readLine();
         }
    return response;
    }

     /**
     * Returns an array of lines from the server's response. This method should
     * be used if the server returns multiple lines of String.
     *
     * @return an array of Strings of the server's response
     * @throws IOException
     *             thrown if any I/O error occurred
     */
    public static String[] readMultipleLinesRespone() throws IOException {
        InputStream inputStream = null;
        if (httpConn != null) {
        inputStream = httpConn.getInputStream();
        } else {
        throw new IOException("Connection is not established.");
        }
        List<String> response;
         try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
             response = new ArrayList<>();
             String line = "";
             while ((line = reader.readLine()) != null){
                 response.add(line);
             }
         }
            return response.toArray(new String[0]);
        }
    
        /**
         * Closes the connection if opened
         */
        public static void disconnect(){    
            if (httpConn != null) {
            httpConn.disconnect();
            }
        }
    }
