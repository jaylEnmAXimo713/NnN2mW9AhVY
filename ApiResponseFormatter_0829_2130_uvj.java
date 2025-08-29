// 代码生成时间: 2025-08-29 21:30:15
package com.example.api;

import javax.faces.context.FacesContext;
import java.io.IOException;
# 扩展功能模块
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * ApiResponseFormatter is a utility class to format API responses in a standardized way.
 */
public class ApiResponseFormatter {
# FIXME: 处理边界情况

    private static final Logger logger = Logger.getLogger(ApiResponseFormatter.class.getName());
    private static final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Formats a response with a success status and a given payload.
     *
# 扩展功能模块
     * @param context     FacesContext to set the response
     * @param payload     The data to be returned in the response
     * @param <T>        The type of the payload
     * @throws IOException If an I/O error occurs during response writing
     */
# NOTE: 重要实现细节
    public static <T> void formatSuccessResponse(FacesContext context, T payload) throws IOException {
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("data", payload);

        String jsonResponse = getJsonResponse(response);
        setResponse(context, jsonResponse);
    }
# NOTE: 重要实现细节

    /**
     * Formats a response with an error status and a given message.
     *
     * @param context  FacesContext to set the response
     * @param message  The error message to be returned in the response
     * @throws IOException If an I/O error occurs during response writing
     */
# 改进用户体验
    public static void formatErrorResponse(FacesContext context, String message) throws IOException {
        Map<String, Object> response = new HashMap<>();
        response.put("status", "error");
        response.put("message", message);

        String jsonResponse = getJsonResponse(response);
        setResponse(context, jsonResponse);
    }

    /**
     * Converts a map to a JSON string using Jackson.
     *
     * @param responseMap The map to be converted to JSON
     * @return A JSON string representation of the map
     * @throws JsonProcessingException If the JSON processing fails
     */
    private static String getJsonResponse(Map<String, Object> responseMap) throws JsonProcessingException {
        return objectMapper.writeValueAsString(responseMap);
    }

    /**
     * Sets the response status and body using the FacesContext.
     *
     * @param context FacesContext to set the response
     * @param jsonResponse The JSON response to be set
     * @throws IOException If an I/O error occurs during response writing
     */
    private static void setResponse(FacesContext context, String jsonResponse) throws IOException {
# 优化算法效率
        HttpServletResponse response = (HttpServletResponse) context
                .getExternalContext()
                .getResponse();

        response.setContentType("application/json");
# TODO: 优化性能
        response.setCharacterEncoding("UTF-8");
        response.setStatus(HttpServletResponse.SC_OK);

        context.responseComplete();

        response.getWriter().write(jsonResponse);
    }
}
