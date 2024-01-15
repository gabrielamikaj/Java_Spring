package com.gabriela.springboot.projects.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


    @Entity
    @Table(name = "users")
    public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @NotEmpty(message = "Name is required!")
        @Size(min = 3, max = 30, message = "Name must be between 3 and 30 characters")
        private String userName;

        @NotEmpty(message = "Email is required!")
        @Email(message = "Please enter a valid email!") // @Email annotation has regex built in for email patterns
        private String email;

        @NotEmpty(message = "Password is required!")
        @Size(min = 8, max = 128, message = "Password must be between 8 and 128 characters")
        private String password;

        @Transient
        @NotEmpty(message = "Confirm Password is required!")
        @Size(min = 8, max = 128, message = "Confirm Password must be between 8 and 128 characters")
        private String confirm;

        @Column(updatable = false)
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        private Date createdAt;
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        private Date updatedAt;


        @PrePersist
        protected void onCreate() {
            this.createdAt = new Date();
        }
        @PreUpdate
        protected void onUpdate() {
            this.updatedAt = new Date();
        }

        public User() {
        }

        // loaded constructor
        public User(String userName, String email, String password, String confirm) {
            super();
            this.userName = userName;
            this.email = email;
            this.password = password;
            this.confirm = confirm;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getConfirm() {
            return confirm;
        }

        public void setConfirm(String confirm) {
            this.confirm = confirm;
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
    }

