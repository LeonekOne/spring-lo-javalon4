package pl.sda.javalondek4springdemo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.javalondek4springdemo.repository.MyRepository;

import static java.util.Objects.nonNull;

@Service
public class MyService {

    private static final Logger logger = LoggerFactory.getLogger(MyService.class);

    // @Autowired - do not use on field!!! It makes sense only in tests!!!
    private MyRepository myRepository;


    public MyService() {
        logger.info("MyService()");
    }

    @Autowired
    public void setMyRepository(MyRepository myRepository) {
        logger.info("setting my repository dependency into my service");
        this.myRepository = myRepository;
    }

    public MyService(MyRepository myRepository) {
        logger.info("MyService(MyRepository myRepository)");
        this.myRepository = myRepository;
    }
    
    public String convertToUpperCase(String string) {
        // if (string != null) --> nonNull
        String result = nonNull(string) ? string.toUpperCase() : "parameter was null!!!";

        logger.info("object before conversion: [{}], and after: [{}]", string, result);

        return result;
    }
}
