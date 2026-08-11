import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDemo1 {

    public static void main(String[] args) throws SQLException {

        // 1. 创建 数据源 对象
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setUrl("jdbc:mysql://127.0.0.1:3306/temp?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("123456");

        // 2. 和数据库服务器进行通信 需要建立网络连接
        Connection connection = dataSource.getConnection();

        // 3. 构造 SQL 语句
        String sql = "insert into student values(2, '扁鹊')";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        // 4. 执行 SQL (把 SQL 通过网络发送到服务器)
        int n = preparedStatement.executeUpdate();
        System.out.println("n = " + n);

    }

}
