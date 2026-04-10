package com.task.task.model;

public class User {
        private String username;
        private String gmail;
        private String password;
        private String feedback;

        public User() {
        }

        public User(String username, String gmail, String password) {
            this.username = username;
            this.gmail = gmail;
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getGmail() {
            return gmail;
        }

        public void setGmail(String gmail) {
            this.gmail = gmail;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getFeedback() {
            return feedback;
        }

        public void setFeedback(String feedback) {
            this.feedback = feedback;
        }

}
