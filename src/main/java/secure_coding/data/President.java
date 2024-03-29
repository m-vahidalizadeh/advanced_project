package secure_coding.data;

import secure_coding.util.ObfuscationUtil;

public class President {
    private long id;
    private String firstName;
    private String middleInitial;
    private String lastName;
    private String emailAddress;

    public President() {
        super();
    }

    public President(long id, String firstName, String middleInitial, String lastName, String emailAddress) {
        this.id = id;
        this.firstName = firstName;
        this.middleInitial = middleInitial;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleInitial() {
        return middleInitial;
    }

    public void setMiddleInitial(String middleInitial) {
        this.middleInitial = middleInitial;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("President{");
        sb.append("id=").append(id);
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", middleInitial='").append(middleInitial).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", emailAddress='").append(ObfuscationUtil.obfuscateData(emailAddress)).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
