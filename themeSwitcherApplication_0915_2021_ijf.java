// 代码生成时间: 2025-09-15 20:21:30
package com.example.themeswitcher;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

// @ManagedBean注解表明这是一个JSF的Managed Bean
// @SessionScoped注解表明该Bean的生命周期是会话级别的
@ManagedBean
@SessionScoped
public class ThemeSwitcher {

    // 当前主题
    private String currentTheme;

    // 构造函数，初始化当前主题
    public ThemeSwitcher() {
        this.currentTheme = "default"; // 默认主题
    }

    // 获取当前主题
    public String getCurrentTheme() {
        return currentTheme;
    }

    // 设置当前主题
    public void setCurrentTheme(String currentTheme) {
        this.currentTheme = currentTheme;
    }

    // 切换主题的方法
    public String switchTheme(String newTheme) {
        try {
            if (newTheme != null && !newTheme.trim().isEmpty()) {
                // 将新主题设置为当前主题
                setCurrentTheme(newTheme);
                // 将主题保存到会话中
                HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
                if (session != null) {
                    session.setAttribute("theme", newTheme);
                }
                return "success"; // 返回成功页面
            } else {
                return "error"; // 返回错误页面
            }
        } catch (Exception e) {
            // 错误处理
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getMessage()));
            return "error"; // 返回错误页面
        }
    }
}
