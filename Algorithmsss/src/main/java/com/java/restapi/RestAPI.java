package com.java.restapi;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class RestAPI {
    public static void main(String[] args){
        getRelevantFoodOutlets("Seattle", 500);
    }
    public static String resolveGetCall(int page, String city){
        String readLine = null;
        String responseValue = null;
        String newUrl = "https://jsonmock.hackerrank.com/api/food_outlets?city="+city+"&page="+(page+1);
        try {
            URL getUrl = new URL(newUrl);
            HttpURLConnection connection = (HttpURLConnection) getUrl.openConnection();
            connection.setRequestMethod("GET");
            if(connection.getResponseCode()==(int) HttpURLConnection.HTTP_OK){
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuffer response = new StringBuffer();
                while((readLine = in.readLine())!= null){
                    response.append(readLine);
                }
                responseValue = response.toString();
            }

        }catch(Exception e){
            return "ERROR";
        }
        return responseValue;

    }
    public static List<String> getRelevantFoodOutlets(String city, int maxCost)
    {
        List<String> listOfFoodOutlets = new ArrayList<String>();
        String url = "https://jsonmock.hackerrank.com/api/food_outlets?city="+city;

        try {
            String responseValue = resolveGetCall(1, city);
            JSONObject obj = (JSONObject) JSONValue.parse(responseValue);

            String total_page = obj.get("total_pages").toString();
            int page_count = Integer.parseInt(total_page);
            /**
             * 1. get the total_pages value
             * 2. Use executor service and put them in an array
             */
            ExecutorService executorService = Executors.newCachedThreadPool();
            Callable<String> callable = () -> {
                //System.out.println("THREAD:::::", Thread.currentThread().getName());
                return resolveGetCall(1, city);
            };
            /**
             * Pass a collection of Callables to the Future object
             */
            List<Callable<String>> taskList  =  new ArrayList<>();
            for(int i=0;i<page_count;i++){
                int taskIndex = i;
                Callable<String> task = () -> resolveGetCall(taskIndex, city);
                taskList.add(task);
            }
            Instant starts = Instant.now();
            System.out.println("STARTS AT :" + starts);
            List<Future<String>> futures = executorService.invokeAll(taskList);
            Instant ends = Instant.now();
            System.out.println("ENDS AT :" + ends);
            System.out.println("DURATION :" + Duration.between(starts, ends));
            for(Future<String> future: futures) {
                // The result is printed only after all the futures are complete. (i.e. after 5 seconds)

                JSONObject responseJSON = (JSONObject) JSONValue.parse(future.get());
                //System.out.println("FUTURE ----" + responseJSON.get("page"));
                ArrayList<JSONObject> data = (ArrayList<JSONObject>) responseJSON.get("data");
                for(int i=0;i<data.size();i++){
                    String st = data.get(i).get("estimated_cost").toString();
                    int estimated_cost = Integer.parseInt(st);

                    if(estimated_cost<=maxCost){
                        listOfFoodOutlets.add(data.get(i).get("name").toString());
                       // System.out.println("NAMES" + data.get(i).get("name").toString() + "Estimated cost "+estimated_cost);
                    }
                }
            }
            executorService.shutdown();
        }catch(Exception e){

        }
        return listOfFoodOutlets;
    }
}
