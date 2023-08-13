package org.example.spring01.domain;

import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Map;

@RequiredArgsConstructor
@Setter
public class Student {
    private final String firstName;
    private final String lastName;
    private Map<Integer, String> answers;

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Student castObj)) {
            return false;
        }
        return this.firstName.equals(castObj.firstName) && this.lastName.equals(castObj.lastName);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + firstName.hashCode();
        hash = 31 * hash + lastName.hashCode();
        return hash;
    }
}
