package mainpackage.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.SystemEnvironmentPropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by lukasz on 10.02.16.
 */
@Configuration
@ComponentScan(basePackages = "mainpackage")

@EnableWebMvc
@EnableAsync
public class AppConfig extends WebMvcConfigurerAdapter {


    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");

    }



    public static final String DRIVER = "org.postgresql.Driver";




    @Bean(destroyMethod = "close")
    public Connection connection() throws ClassNotFoundException, SQLException {
        Class.forName(DRIVER);
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/partysearcher",
                "","");
    }



    @Bean
    public DataSource dataSource()
    {
       // System.out.print("SSSS:"+System.getenv("PARTY_SEARCHER_USER"));
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName(DRIVER);
        ds.setUrl("jdbc:postgresql://localhost:5432/partysearcher");
        //TODO: CREATE ENVIRONMENT VARIABLES (DOES NOT WORK FOR NOW)
        /*ds.setUsername(System.getenv("PARTY_SEARCHER_USER").toString());
        ds.setPassword(System.getenv("PARTY_SEARCHER_PASSWORD").toString());*/
        ds.setUsername("");
        ds.setPassword("");

        return ds;

    }
    @Bean
    public JdbcTemplate jdbcTemplate(javax.sql.DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }


}
