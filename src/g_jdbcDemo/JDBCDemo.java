package g_jdbcDemo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Jdbc连接数据库
 * 1.注册相关数据库驱动
 * 2.获取数据库连接
 * ## <1>./当前目录   <2>../上级目录 <3>/根目录
 * @author huanghao
 * @Date 2019-10-08 14:50
 */
public class JDBCDemo {
    /** 配置数据库相关 **/
    private static final String propertiesPath = "src/g_jdbcDemo/jdbc.properties";

    /**
     * @author huanghao
     * @Date 2019-10-8
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        Properties properties = new Properties();
        System.out.println(System.getProperty("user.dir"));
        // 使用InPutStream流读取properties文件
        BufferedReader bufferedReader = new BufferedReader(new FileReader(propertiesPath));
        properties.load(bufferedReader);
        String url = properties.getProperty("jdbc.url");
        String user = properties.getProperty("jdbc.username");
        String password = properties.getProperty("jdbc.password");
        String driverClassName = properties.getProperty("jdbc.mysql.driverClassName");
        // 注册驱动
        Class.forName(driverClassName);
        // 创建连接
        Connection conn = DriverManager.getConnection(url, user, password);
        String sql = "select assetcode from absmpur where bank = ? limit 20";
        PreparedStatement pre = conn.prepareStatement(sql);
        pre.setString(1, "1429");
        ResultSet rs = pre.executeQuery();
        BufferedWriter bw = new BufferedWriter(new FileWriter("src/g_jdbcDemo/result.properties"));
        while (rs.next()) {
            String assetcode = rs.getString(1);
            bw.write(assetcode);
            bw.write("\r\n");
        }
        Properties p2 = new Properties();
        p2.store(bw, "result");
    }
}
