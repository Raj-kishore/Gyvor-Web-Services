package com.dynacult.restapi.entity;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "appusersbackup")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)

public class Appuser implements Serializable {
//    private static final long serialVersionUID = 4048798961366546485L;
	private static final long serialVersionUID = 5926468583005150707L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "userid")
    private Long userId;
    
    @Column(name = "usermobileno")
	private String userMobileNo;
    
    @Column(name = "useremail")
	private String userEmail;
    
    @Column(name = "dealername")
	private String dealerName;
    
    @Column(name = "password")
	private String password;
    
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserMobileNo() {
		return userMobileNo;
	}

	public void setUserMobileNo(String userMobileNo) {
		this.userMobileNo = userMobileNo;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	
	public String getDealerName() {
		return dealerName;
	}

	public void setDealerName(String dealerName) {
		this.dealerName = dealerName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

		//need default constructor for JSON Parsing
		public Appuser()
		{
			
		}

		public Appuser(String phoneNo, String password) {
			this.setUserMobileNo(phoneNo);
			this.setPassword(password);
		}
	
	
	
	


	
}
