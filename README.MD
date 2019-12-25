# springboot 学习

## 技术总览
1. springboot 基础
2. 数据库连接池
3. Swagger2集成






## tips
- Spring Boot错误处理机制，参考 ErrorMvcAutoConfiguration
    1. 如果是浏览器，则返回一个默认的错误页面：
    2. 如果是其他测试工具，如Postman，则返回一个json数据：
- Druid等作为连接池     
    Spring Boot默认采用tomcat-jdbc连接池，如果需要C3P0，DBCP，Druid等作为连接池，需要加入相关依赖以及配置
- 获得NamedParameterJdbcTemplate实例
```
@Override
public List<Item> selectItemByIds(String itemIds) {
    NamedParameterJdbcTemplate nameJdbc = new NamedParameterJdbcTemplate(jdbcTemplate);
    Map<String,Object> paramMap = new HashMap<String, Object>();
    try {
        String sql = "SELECT  *  FROM zcy_goods_item WHERE id IN(:itemIds) ORDER BY id DESC";
        paramMap.put("itemIds", Arrays.asList(itemIds.split(",")));
        return nameJdbc.query(sql,paramMap, new BeanPropertyRowMapper<Item>(Item.class));
    } catch (DataAccessException e) {
        return null;
    }
}
它的作用主要有：
i）、runSchemaScripts();运行建表语句
ii）、runDataScripts();运行插入数据的sql语句
默认只需要将文件命名为：  默认规则：schema.sql或者schema-all.sql
            schema-*.sql 用于建表操作
            data-*.sql 用于数据操作
自定义规则：spring.datasource.schema=[classpath:department.sql]
被@PostConstruct修饰的方法会在服务器加载Servlet的时候运行，并且只会被服务器执行一次。
```















## 问题
- 国际化需要完善
- Swagger需要完善
```$xslt
1.@Api：可设置对控制器的描述
2. @ApiOperation：: 可设置对接口的描述
3 .@ApiIgnore: Swagger 文档不会显示拥有该注解的接口。
4 @ApiImplicitParams: 用于描述接口的非对象参数集。
5 @ApiImplicitParam: 用于描述接口的非对象参数，一般与 @ApiImplicitParams 组合使用。
6 @ApiModel:可设置接口相关实体的描述
7 @ApiModelProperty: 可设置实体属性的相关描述。
```