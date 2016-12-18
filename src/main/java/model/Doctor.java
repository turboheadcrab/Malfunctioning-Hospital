package model;

import dao.Identifiable;

/**
 * Created by Apraxin Vladimir on 15.12.16.
 */
public class Doctor implements Identifiable<Long> {

    private final Long id;
    private final String lastName;
    private final String firstName;
    private final String patronymic;
    private final Specialty specialty;

    public class Builder {

        private Long id;
        private String lastName;
        private String firstName;
        private String patronymic;
        private Specialty specialty;

        public Builder id(Long id) {
            this.id = id;
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
        public Builder specialty(Specialty specialty) {
            this.specialty = specialty;
            return this;
        }

        public Doctor build() {
            return new Doctor(this);
        }
    }

    private Doctor(Builder builder) {
        this.id = builder.id;
        this.lastName = builder.lastName;
        this.firstName = builder.firstName;
        this.patronymic = builder.patronymic;
        this.specialty = builder.specialty;
    }

    @Override
    public Long getPrimaryKey() {
        return id;
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
    public Specialty getSpecialty() {
        return specialty;
    }
}
