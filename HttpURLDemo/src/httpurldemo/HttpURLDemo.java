/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package httpurldemo;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author JRome
 */
public class HttpURLDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
      
        String fileURL = "http://jdbc.postgresql.org/download/postgresql-9.2-1002.jdbc4.jar";
        String saveDir = "C:\\Users\\JRome\\Desktop\\CIT 360";
        try {
            HttpDownUtility.downloadFile(fileURL, saveDir);
        } catch (IOException ex) {
        }
        
        System.out.println("=====^^^^========^^^^=========^^^^=============^^^^========");
        
        // test sending GET request
        String requestURL = "http://www.google.com";
        try {
            HttpUtility.sendGetRequest(requestURL);
            String[] response = HttpUtility.readMultipleLinesRespone();
            for (String line : response) {
                System.out.println(line);
            }
        } catch (IOException ex) {
        }
        HttpUtility.disconnect();
         
         
        System.out.println("=====^^^^========^^^^=========^^^^=============^^^^=========");
         
        // test sending POST request
        Map<String, String> params = new HashMap<>();
        requestURL = "https://accounts.google.com/ServiceLoginAuth";
        params.put("Email", "jromeo421@gmail.com");
        params.put("Passwd", "Hugh1414!");
         
        try {
            HttpUtility.sendPostRequest(requestURL, params);
            String[] response = HttpUtility.readMultipleLinesRespone();
            for (String line : response) {
                System.out.println(line);
            }
        } catch (IOException ex) {
        }
        HttpUtility.disconnect();
    }
}
