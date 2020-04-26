package tests;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;

import java.util.*;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class TC1 extends TestBase {

    @Test
    public void defaultRankOrderTest() throws InterruptedException {
        int rowCount = wikiPage.listOfAllRowsWithoutHeader.size();
        Set<Integer> orderedRanksList = new TreeSet<>();
        List<Integer> unorderedRanksList = new ArrayList<>();
        for (int i = 1; i < rowCount; i++) {
            WebElement rankCell = driver.findElement(By.xpath("//*[@id='mw-content-text']/div/table[8]/tbody/tr["+i+"]/td[1]"));
            orderedRanksList.add(Integer.parseInt(rankCell.getText().replace("–86", "")));
            unorderedRanksList.add(Integer.parseInt(rankCell.getText().replace("–86", "")));
        }
        assertEquals(unorderedRanksList, orderedRanksList);
    }

    @Test
    public void defaultCountryNamesOrderTest(){
        wikiPage.NOC.click();


        int rowCount = wikiPage.listOfAllRowsWithoutHeader.size();
        Set<String> orderedCountriesList = new TreeSet<>();
        List<String> unorderedCountriesList = new ArrayList<>();
        for (int i = 1; i < rowCount; i++) {
            if(driver.findElement(By.xpath("//*[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr["+i+"]/td[1]")).getText().equals("11–86")){
                break;
            }else{
                WebElement countryCell = driver.findElement(By.xpath("//*[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr["+i+"]/th/a"));
                orderedCountriesList.add(countryCell.getText());
                unorderedCountriesList.add(countryCell.getText());
            }
        }
        assertEquals(unorderedCountriesList, orderedCountriesList);
    }

    @Test
    public void unorderedRankTest(){
        wikiPage.NOC.click();
        int rowCount = wikiPage.listOfAllRowsWithoutHeader.size();
        Set<Integer> orderedRanksList = new TreeSet<>();
        List<Integer> unorderedRanksList = new ArrayList<>();
        for (int i = 1; i < rowCount; i++) {
            WebElement rankCell = driver.findElement(By.xpath("//*[@id='mw-content-text']/div/table[8]/tbody/tr["+i+"]/td[1]"));
            orderedRanksList.add(Integer.parseInt(rankCell.getText().replace("–86", "")));
            unorderedRanksList.add(Integer.parseInt(rankCell.getText().replace("–86", "")));
        }
        assertNotEquals(unorderedRanksList, orderedRanksList);
    }

    @Test
    public void leastMedalSortTest(){
        System.out.println(getLeastGoldMedalsCoutnry("silver"));
    }

    @Test
    public void listOfCountriesBySilverMedalsTest(){
        System.out.println(getListOfCountriesBySilverMedals().toString());
    }

    @Test
    public void rowAndColNumberByCountryNameTest(){
        Arrays.toString(getRowAndColNumberOfCountryByName("China"));
    }


    public String getLeastGoldMedalsCoutnry(String medalTypeSort){
        if(medalTypeSort.equals("gold")){
            wikiPage.gold.click();
            wikiPage.gold.click();
        }else if(medalTypeSort.equals("silver")){
            wikiPage.silver.click();
            wikiPage.silver.click();
        }else if(medalTypeSort.equals("bronze")){
            wikiPage.bronze.click();
            wikiPage.bronze.click();
        }
        WebElement leastMedalCountryElement = driver.findElement(By.xpath("//*[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr[11]/th/a"));
        return leastMedalCountryElement.getText();

    }

    public List<String> getListOfCountriesBySilverMedals(){
        wikiPage.silver.click();
        wikiPage.silver.click();
        List<String> listOfCountriesBySilverMedals = new ArrayList<>();
        for (WebElement eachCoutnry : wikiPage.listOfCountriesElements) {
            listOfCountriesBySilverMedals.add(eachCoutnry.getText());
        }
        return listOfCountriesBySilverMedals;
    }

    public int[] getRowAndColNumberOfCountryByName(String countryName){
        int[] rowAndColNumberArray = new int[2];
        int numberOfRows = wikiPage.listOfAllRowsWithoutHeader.size()-1;
        for (int row = 1; row < numberOfRows; row++) {
                if(driver.findElement(By.xpath("//*[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr["+row+"]/th/a")).getText().equals(countryName)){
                    rowAndColNumberArray[0] = row;
                    rowAndColNumberArray[1] = 2;
                }
            }
        return rowAndColNumberArray;
    }

}
