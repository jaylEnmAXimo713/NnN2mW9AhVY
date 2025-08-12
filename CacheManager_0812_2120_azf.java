// 代码生成时间: 2025-08-12 21:20:53
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * CacheManager is a ManagedBean that handles caching of data.
 * It uses a HashMap to store cached data and provides methods to get, set, and clear cache.
 */
@ManagedBean
@SessionScoped
public class CacheManager {

    private Map<String, Object> cache;

    /**
     * Initializes the cache after bean construction.
     */
    @PostConstruct
    public void init() {
        this.cache = new HashMap<>();
    }

    /**
     * Retrieves an item from the cache with the given key.
     *
     * @param key The key associated with the cached item.
     * @return The cached item if found, otherwise null.
     */
    public Object getFromCache(String key) {
        if (key == null || key.isEmpty()) {
            throw new IllegalArgumentException("Cache key cannot be null or empty.");
        }
        return cache.get(key);
    }

    /**
     * Adds or updates an item in the cache with the given key and value.
     *
     * @param key The key associated with the cached item.
     * @param value The value to cache.
     */
    public void addToCache(String key, Object value) {
        if (key == null || key.isEmpty()) {
            throw new IllegalArgumentException("Cache key cannot be null or empty.");
        }
        cache.put(key, value);
    }

    /**
     * Clears the entire cache.
     */
    public void clearCache() {
        cache.clear();
    }

    /**
     * Removes an item from the cache with the given key.
     *
     * @param key The key associated with the cached item.
     */
    public void removeFromCache(String key) {
        if (key == null || key.isEmpty()) {
            throw new IllegalArgumentException("Cache key cannot be null or empty.");
        }
        cache.remove(key);
    }
}
