package org.example.demo5.zpo;

import org.example.demo5.User;

/**
 * An interface representing a user with methods for adding user information.
 */
public interface Uzytkownik {

    /**
     * Adds user information to the system.
     *
     * @param user The User object containing user information.
     */
    void addUser(User user);

    // The following method was commented out as it's not used in the interface.
    // If it's meant to be included, uncomment and provide documentation.

    // /**
    //  * Adds user information to the system.
    //  *
    //  * @param uzytkow The uzytkow object containing user information.
    //  */
    // void addUser(uzytkow uzytkow);
}
