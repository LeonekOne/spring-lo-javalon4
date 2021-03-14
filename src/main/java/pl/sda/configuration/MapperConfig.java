package pl.sda.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.sda.javalondek4springdemo.converter.BookMapper;

@Configuration
public class MapperConfig {

    @Bean
    public BookMapper bookMapper() {
        return new BookMapper();
    }
}
