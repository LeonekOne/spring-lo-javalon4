package pl.sda.javalondek4springdemo.service.github;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class GithubRestService {

    private static final Logger logger = LoggerFactory.getLogger(GithubRestService.class);

    private final RestTemplate restTemplate;

    private final String gitHubUser;

    public GithubRestService(RestTemplate restTemplate, @Value("github.user") String gitHubUser) {
        this.restTemplate = restTemplate;
        this.gitHubUser = gitHubUser;

        logger.info("github user: [{}]", gitHubUser);
    }
}
