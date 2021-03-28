package pl.sda.javalondek4springdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.javalondek4springdemo.service.github.GithubRestService;

@RestController
@RequestMapping("/github")
public class GithubController {

    private final GithubRestService githubRestService;

    public GithubController(GithubRestService githubRestService) {
        this.githubRestService = githubRestService;

    }

    @GetMapping("/my-repos-as-string")
    String myRepos() {
        return githubRestService.findMyRepoAsString();
    }
}
