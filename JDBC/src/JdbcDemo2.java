import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcDemo2 {

    public static void main(String[] args) throws SQLException {

        // 1. 创建 数据源 对象
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setUrl("jdbc:mysql://127.0.0.1:3306/temp?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("123456");

        // 2. 和数据库服务器进行通信 需要建立网络连接
        Connection connection = dataSource.getConnection();

        // 3. 构造 SQL 语句
        String sql = "select * from student";
        PreparedStatement preparedStatement =connection.prepareStatement(sql);

        // 4. 执行 SQL (把 SQL 通过网络发送到服务器)
        // 返回结果是一个对象 称为 ResultSet
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            // 针对一行进行处理了
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            System.out.println(id + " " + name);
        }

        // 5. 关闭连接等资源
        resultSet.close();
        preparedStatement.close();
        connection.close();

    }

}
