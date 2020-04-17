package com.bee.manage.durid;

import com.alibaba.druid.pool.DruidPooledConnection;
import com.bee.manage.config.ConfigJDBC;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest

public class DruidTestApplicationTests {
    @Autowired
    private ConfigJDBC configJDBC;
    @Test
    public void testConn(){
        try {
            Connection connection = configJDBC.getDateSource().getConnection();
            System.out.println(connection);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
