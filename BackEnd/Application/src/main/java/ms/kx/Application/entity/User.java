package ms.kx.Application.entity;


import jakarta.persistence.*;
import lombok.*;
import ms.kx.Application.exceptions.PhoneNumberException;
import ms.kx.Application.exceptions.UserNameException;
import org.jetbrains.annotations.NotNull;

@Entity
@RequiredArgsConstructor
@Table(name = "users_database", schema = "users_database")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    @Getter @Setter
    private Long user_id;

    @Column(name = "user_firstname")
    @Getter
    private String user_firstname;

    @Column(name = "user_lastname")
    @Getter
    private String user_lastname;

    @Column(name = "user_email")
    @Getter @Setter
    private String user_email;

    @Column(name = "user_phone")
    @Getter
    private String user_phone;


    @Override
    public String toString() {
        return "User{" + '\'' +
                "user_id=" + user_id + '\'' +
                ", user_firstname='" + user_firstname + '\'' +
                ", user_lastname='" + user_lastname + '\'' +
                ", user_email='" + user_email + '\'' +
                ", user_phone='" + user_phone + '\'' +
                '}';
    }

    public void setUser_firstname(String user_firstname) {
        if (!user_firstname.isBlank()) {
            this.user_firstname = user_firstname;
        }else {
            throw new UserNameException("First Name Can Not Be Empty");
        }
    }

    public void setUser_lastname(String user_lastname) {
        if(!user_lastname.isBlank()) {
            this.user_lastname = user_lastname;
        }else {
            throw new UserNameException("Last Name Can Not Be Empty");
        }
    }

    public void setUser_phone(String user_phone) {
        if(user_phone.startsWith("0") && user_phone.length() == 9){
            user_phone.chars().limit(9);
            this.user_phone = user_phone;
        }else{
            throw new PhoneNumberException("Phone Number Must To Start With 0 And Have No More Than 9 Digits");
        }
    }
}
