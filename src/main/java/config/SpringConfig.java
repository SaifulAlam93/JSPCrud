/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;
//
//import config.birt.BirtEngineFactory;
//import config.birt.BirtView;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 *
 * @author User
 */
@Import({WebSecurityConfig.class,HibernateConfiguration.class})
@EnableWebMvc
@Configuration
@ComponentScan({"controller", "dao.impl", "service","config"})
public class SpringConfig implements WebMvcConfigurer {
    
    
    // BIRT //
//    @Bean
//    public BirtView birtView() {
//        BirtView bv = new BirtView();
//        bv.setBirtEngine(this.engine().getObject());
//        return bv;
//    }
//
//    @Bean
//    public BeanNameViewResolver beanNameResolver() {
//        BeanNameViewResolver br = new BeanNameViewResolver();
//        return br;
//    }
//
//
//
//    @Bean
//    protected BirtEngineFactory engine() {
//        BirtEngineFactory factory = new BirtEngineFactory();
//        return factory;
//    }
//    
        @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
    

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/*.html").addResourceLocations("/WEB-INF/html/");
      
        
        registry.addResourceHandler("/css/**").addResourceLocations("/WEB-INF/html/css/");
        registry.addResourceHandler("/fonts/**").addResourceLocations("/WEB-INF/html/fonts/");
        registry.addResourceHandler("/img/**").addResourceLocations("/WEB-INF/html/img/");
        registry.addResourceHandler("/js/**").addResourceLocations("/WEB-INF/html/js/");
        registry.addResourceHandler("/pdf/**").addResourceLocations("/WEB-INF/html/pdf/");
        registry.addResourceHandler("/style.css").addResourceLocations("/WEB-INF/html/style.css");

    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/reports").setViewName("birtView");
//        registry.addViewController("/").setViewName("forward:/index.html");
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/login").setViewName("login");

    }

    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/employee_management");
        dataSource.setUsername("root");
        dataSource.setPassword("");

        return dataSource;
    }


}
