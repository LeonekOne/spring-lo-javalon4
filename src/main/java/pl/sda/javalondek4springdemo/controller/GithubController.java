package pl.sda.javalondek4springdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.javalondek4springdemo.dto.UserRepoDto;
import pl.sda.javalondek4springdemo.service.github.GithubRestService;

import java.util.List;

@RestController
@RequestMapping("/github")
public class GithubController {

    private final GithubRestService githubRestService;

    public GithubController(GithubRestService githubRestService) {
        this.githubRestService = githubRestService;
    }

    @GetMapping("/my-repos-as-string")
    String myRespos() {
        return githubRestService.findMyReposAsString();
    }

    @GetMapping("/my-repos")
    List<UserRepoDto> myReposAsCollection() {
        return githubRestService.findInfoOfMyRepos();
    }

    @GetMapping("/my-repos-array")
    UserRepoDto[] myReposAsArray() {
        return githubRestService.findInfoOfMyReposAsArray();
    }
}
