package pl.sda.javalondek4springdemo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserRepoDto {

    private Long id;

    private String name;

    @JsonProperty("full_name")
    private String fullName;

    private GitHubOwnerDto owner;

    public UserRepoDto() {
    }

    public UserRepoDto(Long id, String name, String fullName, GitHubOwnerDto owner) {
        this.id = id;
        this.name = name;
        this.fullName = fullName;
        this.owner = owner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public GitHubOwnerDto getOwner() {
        return owner;
    }

    public void setOwner(GitHubOwnerDto owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "UserRepoDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", fullName='" + fullName + '\'' +
                ", owner=" + owner +
                '}';
    }
}
