package io.smth.ui.validator;


import java.util.List;

public class Validator {
    public boolean validateInput(String input, List<String> cars) {
        for (String s : cars) {
            if (input.equalsIgnoreCase(s)) {
                return true;
            }
        }
        return false;
    }
}

