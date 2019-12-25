```java
@Configuration
@PropertySource("classpath:dbcp2.properties")//如果配置信息不在全局配置文件application.properties/yml中，则需要显式加载外部properties
public class Dbcp2Config {
 
    @Value("${dbcp2.driver}")
    private String driver;
 
    @Value("${dbcp2.url}")
    private String url;
 
    @Value("${dbcp2.username}")
    private String username;
 
    @Value("${dbcp2.password}")
    private String password;
 
    @Bean("dbcp2")
    public DataSource dataSource(){
        BasicDataSource dataSource = new BasicDataSource();
 
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
 
        return dataSource;
    }
}
/*****************************************************************/
@Configuration
@PropertySource("classpath:c3p0.properties")//引入外部配置文件
public class C3p0Config {
 
    @Autowired
    private Environment env;
 
    @Bean("c3p0")
    public DataSource dataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        System.out.println("env ==========：" + env.getProperty("c3p0.driver"));
 
        dataSource.setDriverClass(env.getProperty("c3p0.driver"));
        dataSource.setJdbcUrl(env.getProperty("c3p0.url"));
        dataSource.setUser(env.getProperty("c3p0.username"));
        dataSource.setPassword(env.getProperty("c3p0.password"));

        return dataSource;
    }
}
```
