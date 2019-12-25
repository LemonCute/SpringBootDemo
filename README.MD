# springboot 学习

## 技术总览
1. springboot 基础
2. 数据库连接池
3. Swagger2集成






## tips
- Spring Boot错误处理机制，参考 ErrorMvcAutoConfiguration
    1. 如果是浏览器，则返回一个默认的错误页面：
    2. 如果是其他测试工具，如Postman，则返回一个json数据：
















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