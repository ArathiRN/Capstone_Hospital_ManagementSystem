package com.arathin.hospitalmanagementapp.nagendrappa_aarathi_hospitalmanagement;

import com.arathin.hospitalmanagementapp.nagendrappa_aarathi_hospitalmanagement.entity.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

class UserParameterizedTest {

    @ParameterizedTest(name = "{index} => firstName={0}, lastName={1}, email={2}")
    @MethodSource("userProvider")
    @DisplayName("Test User Constructor with Parameters")
    void testUserConstructor(String firstName, String lastName, String email, String password, String phoneNumber, String gender, String address, String dob) {
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPassword(password);
        user.setPhoneNumber(phoneNumber);
        user.setGender(gender);
        user.setAddress(address);
        user.setDob(dob);

        assertEquals(firstName, user.getFirstName());
        assertEquals(lastName, user.getLastName());
        assertEquals(email, user.getEmail());
        assertEquals(password, user.getPassword());
        assertEquals(phoneNumber, user.getPhoneNumber());
        assertEquals(gender, user.getGender());
        assertEquals(address, user.getAddress());
        assertEquals(dob, user.getDob());
    }

    static Stream<Arguments> userProvider() {
        return Stream.of(
                Arguments.of("John", "Doe", "john.doe@example.com", "password123", "1234567890", "Male", "123 Main St", "1990-01-01"),
                Arguments.of("Jane", "Doe", "jane.doe@example.com", "password456", "0987654321", "Female", "456 Elm St", "1992-02-02"),
                Arguments.of("Jim", "Beam", "jim.beam@example.com", "password789", "1122334455", "Male", "789 Oak St", "1985-05-05")
        );
    }
}
