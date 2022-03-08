import java.util.*;

class Test {
    Test() {

    }

}

class Person {
    private String name;
    private int age;
    private List<String> skills;

    private Person() {}

    public static void main(String... args) {
        new Test();
    }

    @Override
    public String toString() {
        return "Person("+ name + " " + age + " " + skills + ")";
    }

    public static PersonBuilder builder() {
        return new PersonBuilder();
    }

    public static class PersonBuilder {
        private Person person;

        public PersonBuilder() {
            this.person = new Person();
            this.person.age = -1;
            this.person.skills = new ArrayList<String>();

        }

        public PersonBuilder name(String name) {
            this.person.name = name;
            return this;
        }

        public PersonBuilder age(int age) {
            this.person.age = age;
            return this;
        }

        public PersonBuilder skills(List<String> skills) {
            this.person.skills = skills;
            return this;
        }

        public PersonBuilder skill(String skill) {
            this.person.skills.add(skill);
            return this;
        }

        public Person build() {
            if (this.person.name == null) {
                throw new RuntimeException("name field is required to build");
            }
            if (this.person.age == -1) {
                throw new RuntimeException("age field is required to build");
            }
            return this.person;
        }
    }
}
