package com.exam.main.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;




@Entity
@Table(name="exam")
public class TheClass {
	
	@Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotBlank(message="Name must be provided! ")
    private String className;
	
	@NotBlank(message="Instructor must be provided!")
    private String instructor;
	
	@NotBlank(message="Weekday must be provided!")
    private String weekday;
    
	
	@NotNull
    @Min(value = (long) 0.0)
    @Max(value = (long) 1000.00)
    private Float price;
	
	@NotBlank(message="Description required")
    private String description;
	
    
	

    
    public TheClass() {
        
    }
	
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	

	
	
    public String getClassName() {
		return className;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getInstructor() {
		return instructor;
	}

	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}

	public String getWeekday() {
		return weekday;
	}

	public void setWeekday(String weekday) {
		this.weekday = weekday;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}


    
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }

	

	
    
}