// 代码生成时间: 2025-09-22 12:43:51
package com.example.themeswitcher;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.HashMap;
import java.util.Map;

/**
 * Managed bean for theme switching functionality.
 */
@ManagedBean(name = "themeSwitcher")
@SessionScoped
public class ThemeSwitcher {

    // Map to store available themes
    private Map<String, String> themes;

    // Current theme
    private String currentTheme;

    /**
     * Initialize themes map.
     */
    public ThemeSwitcher() {
        themes = new HashMap<>();
        themes.put("light", "/css/light-theme.css");
        themes.put("dark", "/css/dark-theme.css");
        themes.put("colorful", "/css/colorful-theme.css");

        // Set the default theme to light
        currentTheme = themes.get("light");
    }

    /**
     * Get the current theme.
     * 
     * @return the current theme
     */
    public String getCurrentTheme() {
        return currentTheme;
    }

    /**
     * Set the current theme.
     * 
     * @param currentTheme the current theme to set
     */
    public void setCurrentTheme(String currentTheme) {
        this.currentTheme = currentTheme;
    }

    /**
     * Get the available themes.
     * 
     * @return the map of available themes
     */
    public Map<String, String> getThemes() {
        return themes;
    }

    /**
     * Switch the theme.
     * 
     * @param newTheme the new theme to switch to
     * @return the navigation outcome
     */
    public String switchTheme(String newTheme) {
        if (themes.containsKey(newTheme)) {
            setCurrentTheme(themes.get(newTheme));
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("theme", currentTheme);
            return "success";
        } else {
            // Handle error if the theme is not found
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Theme not found."));
            return "error";
        }
    }
}
