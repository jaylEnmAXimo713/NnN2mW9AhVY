// 代码生成时间: 2025-08-22 09:52:21
public class SqlInjectionPrevention {

    // 使用PreparedStatement来防止SQL注入
    public void executeSafeQuery(String userInput) {
        // 假设我们有一个数据库连接和一个SQL查询
        String query = "SELECT * FROM users WHERE username = ? AND password = ?";

        try {
            // 加载驱动并建立连接
            // 这里省略了加载驱动和建立连接的代码，假设dbConnection不为空
            Connection dbConnection = null;

            // 使用PreparedStatement来防止SQL注入
            PreparedStatement preparedStatement = dbConnection.prepareStatement(query);

            // 替换参数占位符
            preparedStatement.setString(1, userInput);
            // 假设用户输入了用户名和密码
            String password = "userPassword"; // 这里为了演示直接赋值，实际应用中应从用户输入获取
            preparedStatement.setString(2, password);

            // 执行查询
            ResultSet resultSet = preparedStatement.executeQuery();

            // 处理查询结果
            while (resultSet.next()) {
                // 打印结果或进行其他操作
                System.out.println("User found: " + resultSet.getString("username"));
            }

            // 关闭资源
            resultSet.close();
            preparedStatement.close();
            dbConnection.close();

        } catch (SQLException e) {
            // 错误处理
            e.printStackTrace();
        }
    }

    // 主方法，用于测试
    public static void main(String[] args) {
        // 创建实例并调用方法
        SqlInjectionPrevention prevention = new SqlInjectionPrevention();
        String userInput = "' OR '1'='1"; // 这是一个恶意输入，用于演示SQL注入攻击
        prevention.executeSafeQuery(userInput);
    }
}
