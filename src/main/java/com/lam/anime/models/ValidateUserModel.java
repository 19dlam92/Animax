package com.lam.anime.models;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class ValidateUserModel {

	  @NotEmpty(message="is required!")
    @Email(message="Invalid email!")
    private String email;
    
    @NotEmpty(message="is required!")
    @Size(min=8, max=128, message="MUST be between 8 and 128 characters")
    private String password;
    
    // =================================================
    // EMPTY CONSTRUCTOR
    // =================================================
    public ValidateUserModel() {
    
    }
    
    // =================================================
    // GETTERS
    // =================================================
    public String getEmail() {
		return email;
    }
    public String getPassword() {
		return password;
    }
    // =================================================
    // SETTERS
    // =================================================
    public void setEmail(String email) {
		this.email = email;
    }
    public void setPassword(String password) {
		this.password = password;
    }
	
}
