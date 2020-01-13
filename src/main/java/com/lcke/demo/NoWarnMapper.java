package com.lcke.demo;

/**
 * ClassName: 去除启动时找不到 Mapper 的警告 <br/>
 * package org.mybatis.spring.mapper; 中 doScan 会默认在
 * @SpringBootApplication 路径下找 Mapper
 * Description: <br/>
 * date: 2020/1/13 16:57<br/>
 *
 * @author smk<br />
 * @since JDK 1.8
 */
@org.apache.ibatis.annotations.Mapper
public interface NoWarnMapper{}