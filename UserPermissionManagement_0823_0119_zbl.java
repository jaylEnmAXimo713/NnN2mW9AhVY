// 代码生成时间: 2025-08-23 01:19:19
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Managed Bean for User Permission Management.
 * This class handles the user permissions operations.
 */
@ManagedBean(name = "userPermissionBean")
@ViewScoped
public class UserPermissionManagement implements Serializable {

    private static final long serialVersionUID = 1L;

    // Simulation of a database user table
    private List<User> users;

    public UserPermissionManagement() {
        users = new ArrayList<>();
        // Initialize with sample data
        users.add(new User(1, "John Doe", List.of("ADMIN", "USER")));
        users.add(new User(2, "Jane Doe", List.of("USER\)));
    }

    /**
     * Adds a new user with specified permissions.
     *
     * @param username The username of the new user.
     * @param permissions A list of permissions for the new user.
     * @return The newly added user.
     */
    public User addUser(String username, List<String> permissions) {
        User newUser = new User(users.size() + 1, username, permissions);
        users.add(newUser);
        return newUser;
    }

    /**
     * Removes a user by their ID.
     *
     * @param userId The ID of the user to remove.
     * @return The removed user, or null if not found.
     */
    public User removeUser(int userId) {
        return users.removeIf(user -> user.getId() == userId) ? users.get(users.size() - 1) : null;
    }

    /**
     * Updates a user's permissions.
     *
     * @param userId The ID of the user to update.
     * @param permissions The new list of permissions.
     * @return The updated user, or null if not found.
     */
    public User updatePermissions(int userId, List<String> permissions) {
        for (User user : users) {
            if (user.getId() == userId) {
                user.setPermissions(permissions);
                return user;
            }
        }
        return null;
    }

    /**
     * Finds a user by their ID.
     *
     * @param userId The ID of the user to find.
     * @return The user if found, otherwise null.
     */
    public User findUserById(int userId) {
        for (User user : users) {
            if (user.getId() == userId) {
                return user;
            }
        }
        return null;
    }

    /**
     * Retrieves all users.
     *
     * @return A list of all users.
     */
    public List<User> getAllUsers() {
        return new ArrayList<>(users);
    }

    // Getters and setters
    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    // Inner User class
    public static class User implements Serializable {
        private int id;
        private String username;
        private List<String> permissions;

        public User(int id, String username, List<String> permissions) {
            this.id = id;
            this.username = username;
            this.permissions = permissions;
        }

        // Standard getters and setters
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public List<String> getPermissions() {
            return permissions;
        }

        public void setPermissions(List<String> permissions) {
            this.permissions = permissions;
        }
    }
}
