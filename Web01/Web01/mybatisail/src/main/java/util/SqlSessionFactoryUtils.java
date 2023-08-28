package util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

public class SqlSessionFactoryUtils {
    private static SqlSessionFactory sqlSessionFactory;
    public static SqlSessionFactory getInstance() throws IOException {
        synchronized (SqlSessionFactoryUtils.class){
            if (sqlSessionFactory == null){
                synchronized (SqlSessionFactoryUtils.class){
                    sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
                }
            }
        }
        return sqlSessionFactory;
    }
}
