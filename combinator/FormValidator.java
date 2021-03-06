import java.util.function.Function;

/**
 * Example 
 * Form form = new Form("aman", "aman@gmail.com", "3554345", 25);
 * FormValidationResult result = FormValidator.isEmailValid()
 *      .and(isPhoneNoValid())
 *      .and(isAdult())
 *      .apply(form);
 * 
 * if it passes all validation then result is SUCCESS
 * else this result is the first validation failed status
 *
 * lazzy evaluation :
 *   it checks for next validation only if current validation passes
 *
 *      */

interface FormValidator extends Function<Form, FormValidationResult> {
    enum FormValidationResult {
        SUCCESS,
        INVALID_EMAIL,
        INVALID_PHONE_NO,
        NOT_ADULT;
    }

    static FormValidator isEmailValid() {
        return form -> form.getName().contains("@");
    }

    static FormValidator isPhoneNoValid() {
        return form -> form.getPhone().length() == 10;
    }

    static FormValidator isAdult() {
        return form -> form.getAge() >= 18;
    }

    default FormValidator and(FormValidator other) {
        return form -> {
            FormValidationResult result = this.apply(form);
            return result == FormValidationResult.SUCCESS ? other.apply(form) : result;
        };
    }

}


class Form {
    private String name;
    private String email;
    private String phone;
    private int Age;

    public Form(String name, String email, String phone, int age) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        Age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

}



