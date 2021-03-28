package pl.sda.javalondek4springdemo.service.github;

import org.apache.catalina.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.sda.javalondek4springdemo.dto.UserRepoDto;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
public class GithubRestService {

    private static final Logger logger = LoggerFactory.getLogger(GithubRestService.class);

    private static final String allRepositoriesUrl = "https://api.github.com/users/{user}/repos";

    private final RestTemplate restTemplate;

    private final String gitHubUser;

    public GithubRestService(RestTemplate restTemplate,
                             @Value("${github.user}") String gitHubUser,
                            @Value("${magic.value:42}") int magicValue) {
        this.restTemplate = restTemplate;
        this.gitHubUser = gitHubUser;

        logger.info("github user: [{}], magic value: [{}]", gitHubUser, magicValue);
    }

    public String findMyReposAsString() {
        return restTemplate.getForObject(allRepositoriesUrl, String.class, gitHubUser);
//        Map<String, String> parametersNamesOverValues = Map.of("user", gitHubUser);
//        return restTemplate.getForObject(allRepositoriesUrl, String.class, parametersNamesOverValues);
    }

    public List<UserRepoDto> findInfoOfMyRepos() {

        return restTemplate.exchange(allRepositoriesUrl, HttpMethod.GET, null,
            new ParameterizedTypeReference<List<UserRepoDto>>() {},
            gitHubUser).getBody();
    }

    public UserRepoDto[] findInfoOfMyReposAsArray() {
        return restTemplate.getForObject(allRepositoriesUrl, UserRepoDto[].class, gitHubUser);
    }

//    private List<String> doNothing(List<String> strings) {
//        return strings;
//    }
//
//    private List<UserRepoDto> doNothing(List<UserRepoDto> strings) {
//        return strings;
//    }
    // this is how JVM see those methods
        private List doNothing(List strings) {
        return strings;
    }
}
