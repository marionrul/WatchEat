
import java.util.*;

/**
 * 
 */
public class UserFacade {

    /**
     * Default constructor
     */
    public UserFacade(String mail,String password) {
        connectedUser=new User(mail,password);
    }

    /**
     * 
     */
    public User connectedUser;

    /**
     * @param mail 
     * @param pwd
     */
    public void login(String mail, String pwd) {
        // TODO implement here
    }

    /**
     * @param mail
     */
    public void getFirstNameByMail(String mail) {
        // TODO implement here
    }

    /**
     * @param mail
     */
    public void getLastNameByMail(String mail) {
        // TODO implement here
    }

}