package model;

/**
 * Created by Apraxin Vladimir on 15.12.16.
 */
public class User {

    private final String username;
    private final String password;
    private final String lastName;
    private final String firstName;
    private final String patronymic;
    private final String healthInsurance;

    public static class Builder {

        private String username;
        private String password;
        private String lastName;
        private String firstName;
        private String patronymic;
        private String healthInsurance;

        public Builder username(String username) {
            this.username = username;
            return this;
        }
        public Builder password(String password) {
            this.password = password;
            return this;
        }
        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }
        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }
        public Builder patronymic(String patronymic) {
            this.patronymic = patronymic;
            return this;
        }
        public Builder healthInsurance(String healthInsurance) {
            this.healthInsurance = healthInsurance;
            return this;
        }


        public User build() {
            return new User(this);
        }
    }

    private User(Builder builder) {
        this.username = builder.username;
        this.password = builder.password;
        this.lastName = builder.lastName;
        this.firstName = builder.firstName;
        this.patronymic = builder.patronymic;
        this.healthInsurance = builder.healthInsurance;
    }

    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public String getLastName() {
        return lastName;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getPatronymic() {
        return patronymic;
    }
    public String getHealthInsurance() {
        return healthInsurance;
    }
}
