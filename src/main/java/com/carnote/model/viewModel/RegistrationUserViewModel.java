package com.carnote.model.viewModel;

public class RegistrationUserViewModel {

    private String username;
    private String password;
    private String retyped_password;

    public RegistrationUserViewModel() {
    }

    public RegistrationUserViewModel(String username, String password, String retyped_password) {
        this.username = username;
        this.password = password;
        this.retyped_password = retyped_password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRetyped_password() {
        return retyped_password;
    }

    public void setRetyped_password(String retyped_password) {
        this.retyped_password = retyped_password;
    }
}
