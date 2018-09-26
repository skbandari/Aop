package config;

import files.Auditor;
import files.Authenticator;
import files.BookDAO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class AppContextConfig {

    String fileName = "audit.log";
    @Bean
   public BookDAO bookDAO() {
        return new BookDAO();
    }

    @Bean
    public Authenticator authenticator() {
        return new Authenticator();
    }

    @Bean
    public Auditor auditor() {
        return new Auditor(fileName);
    }

}
