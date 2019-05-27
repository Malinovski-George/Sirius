package by.malinovski.book;

import by.malinovski.book.aop.CustomRequestInterceptor;
import nz.net.ultraq.thymeleaf.LayoutDialect;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.filter.CommonsRequestLoggingFilter;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import javax.sql.DataSource;
import java.util.Properties;

// import de.codecentric.boot.admin.server.config.EnableAdminServer;

// @EnableAdminServer
@SpringBootApplication
@EnableTransactionManagement
@Import({WebSecurityConfig.class, AuthenticationSecurityConfig.class, PasswordEncoderConfig.class})
// @Import({WebSecurityConfig.class})
@EnableAutoConfiguration(
    exclude = {
      DataSourceAutoConfiguration.class,
      DataSourceTransactionManagerAutoConfiguration.class,
      HibernateJpaAutoConfiguration.class
    })
@ComponentScan("by.malinovski")
@EnableCaching
public class Demo2Application implements WebMvcConfigurer {

  @Autowired private Environment env;

  @Autowired private CustomRequestInterceptor customRequestInterceptor;

  public static void main(String[] args) {
    SpringApplication.run(Demo2Application.class, args);
  }

  @Bean(name = "dataSource")
  public DataSource getDataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();

    // See: application.properties
    //        dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
    dataSource.setDriverClassName(env.getProperty("spring.datasource.driverClassName"));
    dataSource.setUrl(env.getProperty("spring.datasource.url"));
    dataSource.setUsername(env.getProperty("spring.datasource.username"));
    dataSource.setPassword(env.getProperty("spring.datasource.password"));

    System.out.println("## getDataSource: " + dataSource);

    return dataSource;
  }

  @Autowired
  @Bean(name = "sessionFactory")
  public SessionFactory getSessionFactory(DataSource dataSource) throws Exception {
    Properties properties = new Properties();

    // See: application.properties
    properties.put("hibernate.dialect", env.getProperty("spring.jpa.properties.hibernate.dialect"));
    properties.put("hibernate.show_sql", env.getProperty("spring.jpa.show-sql"));
    properties.put(
        "current_session_context_class", //
        env.getProperty("spring.jpa.properties.hibernate.current_session_context_class"));

    LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();

    // Package contain entity classes
    factoryBean.setPackagesToScan(new String[] {""});
    factoryBean.setDataSource(dataSource);
    factoryBean.setHibernateProperties(properties);
    factoryBean.afterPropertiesSet();
    //
    SessionFactory sf = factoryBean.getObject();
    System.out.println("## getSessionFactory: " + sf);
    return sf;
  }

  @Autowired
  @Bean(name = "transactionManager")
  public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
    HibernateTransactionManager transactionManager =
        new HibernateTransactionManager(sessionFactory);

    return transactionManager;
  }

  @Bean
  public SpringTemplateEngine templateEngine() {
    SpringTemplateEngine templateEngine = new SpringTemplateEngine();
    templateEngine.setTemplateResolver(thymeleafTemplateResolver());
    templateEngine.addDialect(new LayoutDialect());
    templateEngine.addDialect(new SpringSecurityDialect()); // dialect for
    templateEngine.setEnableSpringELCompiler(true);
    //        templateEngine.setEnableSpringELCompiler(true);
    return templateEngine;
  }

  @Bean
  public SpringResourceTemplateResolver thymeleafTemplateResolver() {
    SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
    //        templateResolver.setPrefix("templates/");
    templateResolver.setPrefix("classpath:/templates/");
    templateResolver.setSuffix(".html");
    templateResolver.setTemplateMode("HTML5");
    templateResolver.setCacheable(false);

    return templateResolver;
  }

  @Bean
  public ThymeleafViewResolver thymeleafViewResolver() {
    ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
    viewResolver.setTemplateEngine(templateEngine());
    viewResolver.setCharacterEncoding("UTF-8");

    return viewResolver;
  }

  @Override
  public void addViewControllers(ViewControllerRegistry registry) {
    registry.addViewController("/login").setViewName("login");
    registry.addViewController("/home").setViewName("home");
    registry.addViewController("/registrationForm").setViewName("registrationForm");
    registry.addViewController("/").setViewName("home");
  }

  //    log request
  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry
        .addInterceptor(customRequestInterceptor)
        .addPathPatterns("/**/log-incoming-request/**/");

    registry.addInterceptor(localeChangeInterceptor());
  }

  @Bean
//  @Profile("debug")
  public CommonsRequestLoggingFilter requestLoggingFilter() {
    CommonsRequestLoggingFilter loggingFilter = new CommonsRequestLoggingFilter();
    loggingFilter.setIncludeClientInfo(true);
    loggingFilter.setIncludeQueryString(true);
    loggingFilter.setIncludePayload(true);
    loggingFilter.setIncludeHeaders(false);
    return loggingFilter;
  }

  /*i18n*/
  @Bean
  public LocaleResolver localeResolver() {
    SessionLocaleResolver slr = new SessionLocaleResolver();
    //        slr.setDefaultLocale(new Locale("ru"));

    //        CookieLocaleResolver resolver = new CookieLocaleResolver();
    //        resolver.setDefaultLocale(new Locale("ru"));
    //        resolver.setDefaultLocale(new Locale("ru"));
    //        resolver.setCookieName("locale");
    //        resolver.setCookieMaxAge(60 * 60 * 24 * 365 * 10);
    return slr;
  }

  @Bean
  public LocaleChangeInterceptor localeChangeInterceptor() {
    LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
    lci.setParamName("lang");
    return lci;
  }
}
