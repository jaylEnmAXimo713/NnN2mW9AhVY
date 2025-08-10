// 代码生成时间: 2025-08-10 13:59:37
package com.example.api;

import javax.faces.context.FacesContext;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

public class ApiResponseFormatter {

    // Common API response status codes
    public enum Status {
        SUCCESS("success"),
        ERROR("error");

        private String status;

        Status(String status) {
            this.status = status;
        }

        public String getStatus() {
            return status;

        }
    }

    /**
     * Formats the API response and sends it to the client.
     *
     * @param context The FacesContext instance.
     * @param status The response status.
     * @param data The data to be included in the response.
     * @param message The message to be included in the response.
     * @throws IOException If an I/O error occurs while writing to the response.
     */
    public static void formatAndSendResponse(FacesContext context, Status status, Object data, String message) throws IOException {
        HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
        response.setContentType("application/json");
        Map<String, Object> apiResponse = new HashMap<>();
        apiResponse.put("status", status.getStatus());
        apiResponse.put("data", data);
        apiResponse.put("message", message);

        // Send the response to the client
        context.getExternalContext().setResponseStatus(HttpServletResponse.SC_OK);
        context.getExternalContext().responseReset();
        context.getExternalContext().setResponseContentType("application/json");
        context.getExternalContext().getResponseOutputWriter().write(toJson(apiResponse));
        context.getExternalContext().flushBuffer();
    }

    /**
     * Converts a Map to a JSON string.
     *
     * @param map The map to convert to JSON.
     * @return A JSON string representation of the map.
     */
    private static String toJson(Map<String, Object> map) {
        // In a real-world application, you would use a JSON library like Jackson or Gson to convert the map to JSON.
        // For simplicity, this method is a placeholder and will need to be implemented or replaced with a real JSON conversion.
        return new StringBuilder()
            .append("{"status":"").append(map.get("status")).append("","data":").append(map.get("data")).append(","message":"").append(map.get("message")).append(""}")
            .toString();
    }

    // Additional methods for error handling, data validation, etc., can be added here.

}