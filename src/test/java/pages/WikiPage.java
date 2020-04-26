package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.nio.file.WatchEvent;
import java.util.ArrayList;
import java.util.List;

public class WikiPage {
    public WikiPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(className = "wikitable sortable plainrowheaders jquery-tablesorter")
    public WebElement table;

    @FindBy(xpath = "//*[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr")
    public List<WebElement> listOfAllRowsWithoutHeader;

    @FindBy(xpath = "//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/thead/tr/th")
    public List<WebElement> listOfHeaderColumns;

    @FindBy(xpath = "//*[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr[i]/td")
    public List<WebElement> allCellsInRankCol;

    @FindBy(xpath = "//*[@class='wikitable sortable plainrowheaders jquery-tablesorter']/thead/tr/th[2]" )
    public WebElement NOC;

    @FindBy(xpath = "//*[@id='mw-content-text']/div/table[8]/thead/tr/th[3]")
    public WebElement gold;

    @FindBy(xpath = "//*[@id='mw-content-text']/div/table[8]/thead/tr/th[4]")
    public WebElement silver;

    @FindBy(xpath = "//*[@id='mw-content-text']/div/table[8]/thead/tr/th[5]")
    public WebElement bronze;

    @FindBy(xpath = "//*[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr//th/a")
    public List<WebElement> listOfCountriesElements;

}

