package code.learnjava;

import java.util.List;

public class User implements Comparable<User> {
  private Long id;
  private String firstName;
  private String lastName;
  private String email;
  private Integer age;
  private List<String> interests;

  public User(Long id, String firstName, String lastName, String email, Integer age, List<String> interests) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.age = age;
    this.interests = interests;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public List<String> getInterests() {
    return interests;
  }

  public void setInterests(List<String> interests) {
    this.interests = interests;
  }

  @Override
  public String toString() {
    return "User{" + "firstName='" + firstName + '\'' + ", email='" + email + '\'' + ", age=" + age + '}';
  }

  @Override
  public int compareTo(User another) {
    return this.age.compareTo(another.age);
  }

}