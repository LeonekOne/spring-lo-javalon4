package pl.sda.javalondek4springdemo.service.github;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.sda.javalondek4springdemo.dto.UserRepoDto;

import java.util.List;


@Service
public class GithubRestService {

    private static final Logger logger = LoggerFactory.getLogger(GithubRestService.class);

    private static final String allRepositoriesUrl = "https://api.github.com/users/{user}/repos";

    private final RestTemplate restTemplate;

    private final String gitHubUser;

    public GithubRestService(RestTemplate restTemplate,
                             @Value("${github.user}") String gitHubUser,
                             @Value("${magic.value}") int magicValue) {
        this.restTemplate = restTemplate;
        this.gitHubUser = gitHubUser;

        logger.info("github user: [{}], magic value: [{}]", gitHubUser, magicValue);

    }

    public String findMyRepoAsString() {
        return restTemplate.getForObject(allRepositoriesUrl, String.class, gitHubUser);
//        Map<String, String> parametersNamesOverValues = Map.of("user", gitHubUser);
//        return restTemplate.getForObject(allRepositoriesUrl, String.class, parametersNamesOverValues);
    }

    public List<UserRepoDto> findInfoOfMyRepos() {
        return restTemplate.getForObject(allRepositoriesUrl,
                List.class,
                gitHubUser);
    }

    public UserRepoDto[] findInfoOfMyReposAsArray() {
        return restTemplate.getForObject(allRepositoriesUrl, UserRepoDto[].class, gitHubUser);
    }



}
