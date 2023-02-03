package io.smth.ui;

import io.smth.models.Auto;
import io.smth.repo.Repository;
import io.smth.ui.validator.Validator;

import java.util.List;
import java.util.Scanner;

public class UiClient implements UI {
    private final Validator val;
    private final Repository repository;

    public UiClient(Repository rep) {
        this.repository = rep;
        this.val = new Validator();
    }
    @Override
    public void start() {
        List<String> brands = repository.getAutoBrandList();
        printBrandList(brands);
        String input;
        do {
            System.out.println("Choose the car from list above");
            Scanner sc = new Scanner(System.in);
            input = sc.nextLine();
        } while (!val.validateInput(input, brands));
        printAutoList(repository.getAutoList(input));
    }

    private void printBrandList(List<String> l) {
        for (String auto : l) {
            System.out.println(auto);
        }
    }

    private void printAutoList(List<Auto> l) {
        for (Auto auto : l) {
            System.out.println(auto);
        }
    }
}


