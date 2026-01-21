public class Contact {

  private String firstName;
  private String lastName;
  private String email;

  public Contact(String firstName, String lastName, String email) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
  }

  public String toString() {
    return firstName + " " + lastName + " (" + email + ")";
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getEmail() {
    return email;
  }

  public String getUsername() {
    int at = email.indexOf("@");
    if (at <= 0) return "";
    return email.substring(0, at);
  }

  public String getDomain() {
    int at = email.indexOf("@");
    int lastDot = email.lastIndexOf('.');
    if (at < 0 || lastDot <= at) return "";
    return email.substring(at + 1, lastDot);
  }

  public String getDomainExtension() {
    int lastDot = email.lastIndexOf('.');
    if (lastDot < 0 || lastDot == email.length() - 1) return "";
    return email.substring(lastDot + 1);
  }
}
