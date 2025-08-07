// 代码生成时间: 2025-08-07 19:31:54
package com.example.apiformatter;

import javax.faces.context.FacesContext;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * API响应格式化工具
 *
 * 提供一个简单的JSF ManagedBean，用于格式化API响应
 */
@ManagedBean
@SessionScoped
public class ApiResponseFormatter implements Serializable {

    // 构造函数
    public ApiResponseFormatter() {
    }

    /**
     * 格式化API响应
     *
     * 根据输入的API响应内容和状态，生成格式化的响应对象
     *
     * @param content   API响应内容
     * @param status    API响应状态
     * @return          格式化后的API响应对象
     */
    public Map<String, Object> formatResponse(String content, String status) {
        Map<String, Object> response = new HashMap<>();
        response.put("status", status);
        response.put("message", content);
        return response;
    }

    /**
     * 处理API响应
     *
     * 根据输入的API响应内容和状态，添加到FacesContext中
     *
     * @param content   API响应内容
     * @param status    API响应状态
     */
    public void handleResponse(String content, String status) {
        try {
            Map<String, Object> formattedResponse = formatResponse(content, status);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("apiResponse", formattedResponse);
        } catch (Exception e) {
            // 错误处理
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error formatting API response", e.getMessage()));
        }
    }
}
