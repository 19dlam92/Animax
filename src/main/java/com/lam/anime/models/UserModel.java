package com.lam.anime.models;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "users")
public class UserModel {
	// @Email = REGEX is built in
	// @Transient = for PASSWORD CONFIRMATION
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotEmpty(message="is required!")
    @Size(min=3, max=30, message="MUST be between 3 and 30 characters")
    private String userName;
    
    @NotEmpty(message="is required!")
    @Email(message="Invalid email!")
    private String email;
    
    @NotEmpty(message="is required!")
    @Size(min=8, max=128, message="MUST be between 8 and 128 characters")
    private String password;
    
    @Transient
    @NotEmpty(message="MUST match Password!")
    @Size(min=8, max=128, message="MUST be between 8 and 128 characters")
    private String confirm;

    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    // ====================================================
	// EMPTY CONSTRUCTOR
    // ====================================================
    public UserModel() {
    
    }
    
    // ====================================================
	// LOADED CONSTRUCTOR
    // ====================================================
    public UserModel(String userName, String email, String password, String confirm) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.confirm = confirm;
    }

	// ====================================================
	// GETTERS
    // ====================================================
    public Long getId() {
        return id;
    }
	public String getUserName() {
		return userName;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public String getConfirm() {
		return confirm;
	}
    
    // ====================================================
	// SETTERS
    // ====================================================
	public void setId(Long id) {
		this.id = id;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}
    
    // ====================================================
	// CREATED_AT AND UPDATED_AT
    // ====================================================
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
	
	
}
