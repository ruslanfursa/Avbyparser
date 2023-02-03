package io.smth;

import io.smth.repo.Repository;
import io.smth.repo.impl.RepositoryImpl;
import io.smth.ui.UiClient;

public class Main {
    public static void main(String[] args) {
        Repository rep = new RepositoryImpl();
        UiClient uic = new UiClient(rep);
        uic.start();
    }
}