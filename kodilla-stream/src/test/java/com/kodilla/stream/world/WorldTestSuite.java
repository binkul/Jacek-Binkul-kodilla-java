package com.kodilla.stream.world;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class WorldTestSuite {
    @Test
    public void testGetPeopleQuantity() {
        //Given
        Country country1 = new Country("Poland", "Warszawa", 40000000);
        Country country2 = new Country("Francja", "Paryż", 67364357);
        Country country3 = new Country("Rosja", "Moskwa", 142122776);
        Country country4 = new Country("Japonia", "Tokio", 126168156);
        Country country5 = new Country("Chiny", "Pekin", 1384688986);
        Country country6 = new Country("Indie", "Delhi", 1296834042);
        Country country7 = new Country("USA", "Waszyngton", 329256465);
        Country country8 = new Country("Meksyk", "Meksyk", 125959205);
        Country country9 = new Country("Australia", "Sydney", 23470145);
        Country country10 = new Country("Kamerun", "Jaunde", 25640965);
        Country country11 = new Country("Kenia", "Nairobi", 48397527);
        Country country12 = new Country("Uganda", "Kampala", 40853749);
        Continent continent1 = new Continent("Europa");
        Continent continent2 = new Continent("Azja");
        Continent continent3 = new Continent("Afryka");
        Continent continent4 = new Continent("Ameryka północna");

        //When
        World world = new World("Ziemia");
        continent1.addCountry(country1);
        continent1.addCountry(country2);
        continent1.addCountry(country3);
        continent2.addCountry(country4);
        continent2.addCountry(country5);
        continent2.addCountry(country6);
        continent3.addCountry(country10);
        continent3.addCountry(country11);
        continent3.addCountry(country12);
        continent4.addCountry(country7);
        continent4.addCountry(country8);
        world.addContinent(continent1);
        world.addContinent(continent2);
        world.addContinent(continent3);
        world.addContinent(continent4);

        BigDecimal peopleQuantity = world.getPeopleQuantity();
        int countryCount = world.getCountryCount();

        //Then
        BigDecimal peopleQuantityExpected = new BigDecimal("3627286228");
        Assert.assertEquals(peopleQuantityExpected, peopleQuantity);
        Assert.assertEquals(11, countryCount);
    }

    @Test
    public void testGetAlienQuantity() {
        //Given
        Country country1 = new Country("Poland", "Warszawa", 40000000);
        Country country2 = new Country("Francja", "Paryż", 67364357);
        Country country3 = new Country("Rosja", "Moskwa", 142122776);
        Country country4 = new Country("Japonia", "Tokio", 126168156);
        Country country5 = new Country("Chiny", "Pekin", 1384688986);
        Country country6 = new Country("Indie", "Delhi", 1296834042);
        Continent continent1 = new Continent("Europa");
        Continent continent2 = new Continent("Azja");
        Country country7 = new Country("Macka", "Macka", 400000000);
        Country country8 = new Country("Stepownia", "Stopa", 689000000);
        Country country9 = new Country("Trojnogia", "Jedna noga", 1234567891);
        Country country10 = new Country("Mutancja", "Dwugłowia", 345612896);
        Country country11 = new Country("Psiarnia", "Kot", 1118976579);
        Country country12 = new Country("Głaskonia", "Ogon", 800000000);
        Continent continent3 = new Continent("Mars północ");
        Continent continent4 = new Continent("Mars południe");
        World world1 = new World("Ziemia");
        World world2 = new World("Mars");

        //When
        Planet planet = new Planet();
        continent1.addCountry(country1);
        continent1.addCountry(country2);
        continent1.addCountry(country3);
        continent2.addCountry(country4);
        continent2.addCountry(country5);
        continent2.addCountry(country6);
        continent3.addCountry(country7);
        continent3.addCountry(country8);
        continent3.addCountry(country9);
        continent4.addCountry(country10);
        continent4.addCountry(country11);
        continent4.addCountry(country12);
        world1.addContinent(continent1);
        world1.addContinent(continent2);
        world2.addContinent(continent3);
        world2.addContinent(continent4);
        planet.addWorld(world1);
        planet.addWorld(world2);

        BigDecimal alienQuantity = planet.getAliensQuantity();

        //Then
        BigDecimal alienQuantityExpected = new BigDecimal("7645335683");
        Assert.assertEquals(alienQuantityExpected, alienQuantity);
    }

}
