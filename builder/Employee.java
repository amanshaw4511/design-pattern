
class Employee {
    private final String empId;
    private final String firstName;
    private final String lastName;
    private final Date dob;
    private final String role;
    private final String company;

    private Employee(Builder builder) {
        this.empId = builder.empId;
    }

    class Builder {

        private final String empId;
        private String firstName;
        private String lastName;
        private Date dob;
        private String role;
        private String company;

        public Builder(Stirng empId) {
            this.empId = empId;
        }

        Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        Builder dob(Date dob) {
            this.dob = this.dob;
            return this;
        }

        Builder role(String role) {
            this.role = role;
            return this;
        }

        Builder company(String company) {
            this.company = company;
            return this;
        }

        Employee build() {
            return new Employee(this);
        }

    }

    public String getEmpId() {
        return empId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getDob() {
        return dob;
    }

    public String getRole() {
        return role;
    }

    public String getCompany() {
        return company;
    }

}
