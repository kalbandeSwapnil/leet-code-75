package com.code;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MultiThreadedPaginationExample {

    private static final int TOTAL_PAGES = 10;
    private static final String API_URL_TEMPLATE = "https://api.example.com/data?page=%d";

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(5);


        List<Future<String>> futures = new ArrayList<>();

        try {
            // Submit tasks for each page
            for (int page = 1; page <= TOTAL_PAGES; page++) {
                final int currentPage = page;
                Callable<String> task = () -> fetchPageData(currentPage);
                futures.add(executorService.submit(task));
            }

            // Retrieve the results from each Future
            for (Future<String> future : futures) {
                try {
                    // This will block until the thread finishes execution
                    String response = future.get();
                    // Process the response (e.g., parse JSON, store in DB, etc.)
                    System.out.println("Page Response:\n" + response);
                } catch (InterruptedException e) {
                    System.err.println("Task interrupted: " + e.getMessage());
                } catch (ExecutionException e) {
                    System.err.println("Error during task execution: " + e.getCause());
                }
            }

        } finally {
            // Always shut down the ExecutorService
            executorService.shutdown();
        }
    }

    /**
     * Fetches data for a given page from the API.
     *
     * @param page The page number to fetch.
     * @return The response body as a String.
     * @throws Exception if there is an issue with the network request or I/O
     */
    private static String fetchPageData(int page) throws Exception {
        String urlString = String.format(API_URL_TEMPLATE, page);
        HttpURLConnection connection = null;
        BufferedReader reader = null;

        try {
            // Create a connection to the specified URL
            URL url = new URL(urlString);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);   // 5-second timeout for connection
            connection.setReadTimeout(5000);      // 5-second timeout for reading data

            // If the API requires a header (token or something), you can add:
            // connection.setRequestProperty("Authorization", "Bearer <your_token_here>");

            // Check the response code
            int responseCode = connection.getResponseCode();
            if (responseCode != HttpURLConnection.HTTP_OK) {
                throw new RuntimeException("Failed : HTTP Error code : " + responseCode);
            }

            // Read the response
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder responseBuilder = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                responseBuilder.append(line);
            }

            return responseBuilder.toString();

        } finally {
            // Close resources
            if (reader != null) {
                reader.close();
            }
            if (connection != null) {
                connection.disconnect();
            }
        }
    }
}
