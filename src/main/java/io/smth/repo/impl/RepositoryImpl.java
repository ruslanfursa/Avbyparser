package io.smth.repo.impl;

import io.smth.models.Auto;
import io.smth.repo.Repository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static org.jsoup.Jsoup.connect;

public class RepositoryImpl implements Repository {

    private static final String HTTP_PREFIX = "https://";
    private static final String BASE_URL = "av.by";
    private static final String SLASH = "/";
    private static final String CARS_PREFIX = "cars.";

    @Override
    public List<String> getAutoBrandList() {
        ArrayList<String> mainPageCars = new ArrayList<>();
        try {
            Document page = connect(HTTP_PREFIX + BASE_URL + SLASH).header("Content-Type", "text/html; charset=utf-8").get();
            Elements allCars = page.getElementsByAttributeValue("class", "catalog__title");
            for (Element e : allCars) {
                String title = e.text();
                mainPageCars.add(title);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return mainPageCars;
    }

    @Override
    public List<Auto> getAutoList(String brand) {
        StringBuilder url = new StringBuilder(HTTP_PREFIX + CARS_PREFIX + BASE_URL + SLASH + brand);
        ArrayList<Auto> cars = new ArrayList<>();
        try {
            Document page = Jsoup.connect(String.valueOf(url)).get();
            Elements allCars = page.getElementsByAttributeValue("class", "listing-item__wrap");
            for (Element e : allCars) {
                String title = e.getElementsByAttributeValue("class", "listing-item__title").text();
                String description = e.getElementsByAttributeValue("class", "listing-item__params").text();
                String price = e.getElementsByAttributeValue("class", "listing-item__priceusd").text();
                String link = e.getAllElements().attr("href");
                cars.add(new Auto(title, description, price, HTTP_PREFIX.concat(CARS_PREFIX.concat(BASE_URL.concat(link)))));
            }
        } catch (IOException e) {
            System.out.println("Invalid address");
        }
        return cars;
    }
}
