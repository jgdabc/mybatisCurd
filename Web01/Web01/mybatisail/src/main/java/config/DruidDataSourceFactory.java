package config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.datasource.pooled.PooledDataSourceFactory;

/**
 * @author 兰舟千帆
 * @version 1.0
 * @date 2023/8/23 21:09
 * @Description 功能描述:
 */
public class DruidDataSourceFactory extends PooledDataSourceFactory {
//    它继承了PooledDataSourceFactory，而且通过构造方法将其中的dataSource改为了Druid自带的DruidDataSource。
    public DruidDataSourceFactory()
    {
        this.dataSource  =  new DruidDataSource();
    }
}
