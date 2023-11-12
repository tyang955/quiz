package com.example.quiz.config;//package com.example.quiz.config;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//
//import javax.sql.DataSource;
//
//@Configuration
//public class JdbcConfig {
//    @Value("${spring.datasource.url}")
//    private String databaseUrl;
//
//    @Value("${spring.datasource.username}")
//    private String databaseUsername;
//
//    @Value("${spring.datasource.password}")
//    private String databasePassword;
//
//    @Bean
//    public DataSource dataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//        dataSource.setUrl(databaseUrl);
//        dataSource.setUsername(databaseUsername);
//        dataSource.setPassword(databasePassword);
//        return dataSource;
//    }
//
//    @Bean
//    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
//        return new JdbcTemplate(dataSource);
//    }
//}
