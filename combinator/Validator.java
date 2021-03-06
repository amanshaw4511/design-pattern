import java.util.function.Function;
import java.util.function.Predicate;

interface Validator extends Predicate<String> {
    static Validator isEmail() {
        return  email -> email.contains("@");
    }

    static Validator isPhoneNo() {
        return phoneNo -> phoneNo.length() == 10;
    }


    default Validator and (Validator otherValidotor) {
        return toTest -> this.test(toTest) ? otherValidotor.test(toTest) : false;
    }
}
