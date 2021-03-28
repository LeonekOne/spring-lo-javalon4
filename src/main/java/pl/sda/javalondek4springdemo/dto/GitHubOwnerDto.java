package pl.sda.javalondek4springdemo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GitHubOwnerDto {

    private String login;

    @JsonProperty("avatar_url")
    private String avatarUrl;

    public GitHubOwnerDto() {
    }

    public GitHubOwnerDto(String login, String avatarUrl) {
        this.login = login;
        this.avatarUrl = avatarUrl;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    @Override
    public String toString() {
        return "GitHubOwnerDto{" +
                "login='" + login + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                '}';
    }
}
