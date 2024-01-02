package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;



public class Main {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        EdgeOptions options = new EdgeOptions ();
        options.addArguments ( "--remote-allow-origins=*" );
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver (options);
    }

    @Test
    public void tutorial3() throws InterruptedException {
        String givenUrl = "https://magento.softwaretestingboard.com/.";
        driver.get ( givenUrl );
        String currentUrl = driver.getCurrentUrl ();
        if ( givenUrl.equals ( currentUrl ) ) ;
        System.out.println ( "Now verified the given URL" );

        WebElement sign = driver.findElement ( By.linkText ( "Sign In" ) );
        sign.click ();
        System.out.println ( "Now click the sign in button" );

        WebElement Email = driver.findElement(By.id ( "email" ) );
        Email.sendKeys ( "thyshayat@gmail.com" );
        System.out.println ( "Now entered the team email address" );

        WebElement password = driver.findElement ( By.id ( "pass" ) );
        password.sendKeys ( "Tha1Sha2Yat3" );
        System.out.println ( "Now entered the team password" );

        WebElement bsign = driver.findElement ( By.id ( "send2" ) );
        bsign.click ();
        System.out.println ( "sign in to account" );

        WebElement gear = driver.findElement ( By.linkText ( "Gear" ) );
        gear.click ();
        System.out.println ( "Click the gear tab button" );

        WebElement bag = driver.findElement ( By.xpath (  "//*[@id=\"maincontent\"]/div[4]/div[2]/div[2]/div/ul/li[1]/a") );
        bag.click();
        System.out.println ( "Click the bags tab button" );

        WebElement bagType = driver.findElement ( By.xpath ( "//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[10]/div/div/strong/a" ) );
        bagType.click ();
        System.out.println ( "Click the (Rival Field Messenger) name" );

        /*get the bag name xpath*/
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String product1 ="Rival Field Messenger";
        WebElement product_1 = driver.findElement(By.xpath("/html/body/div[1]/main/div[2]/div/div[1]/div[1]/h1/span"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertEquals(product1,product_1.getText());
        System.out.println( "The product name is similar to the selected product" );

        /*get the price xpath*/
        String price1 = "$45.00";
        WebElement price_1 = driver.findElement(By.xpath("/html/body/div[1]/main/div[2]/div/div[1]/div[3]/div[1]/span/span/span"));
        System.out.println( "Compare the price" );
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Assert.assertEquals(price1,price_1.getText());
        System.out.println( "The product price is similar to the selected product price" );

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement addCart= driver.findElement ( By.id ("product-addtocart-button"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        addCart.click ();
        System.out.println( "Product 1 add to the cart" );
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        /*get the cart full xpath*/
        WebElement checkCart = driver.findElement ( By.xpath ( "/html/body/div[1]/header/div[2]/div[1]/a" ) );
        checkCart.click();
        System.out.println( "Check the cart first time" );
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement Gear1= driver.findElement ( By.linkText ( "Gear" ) );
        Gear1.click ();
        System.out.println( "Again click the gear tab button" );
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement watches = driver.findElement ( By.xpath ( "/html/body/div[1]/main/div[4]/div[2]/div[2]/div/ul/li[3]/a" ) );
        watches.click ();
        System.out.println ( "Click the watches tab button" );
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement summitwatch = driver.findElement ( By.xpath ( "/html/body/div[1]/main/div[3]/div[1]/div[3]/ol/li[7]/div/div/strong/a" ) );
        summitwatch.click ();
        System.out.println ( "Click the (Summit Watch) name" );
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement addCart2= driver.findElement ( By.xpath ("/html/body/div[1]/main/div[2]/div/div[1]/div[4]/form/div/div/div[2]/button" ) );
        addCart2.click ();
        System.out.println( "Product 2 add to the cart" );

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement checkCart1 = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div/a"));
        checkCart1.click();
        System.out.println( "Check the cart second time" );
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        /*go to cart - next go to view and edit cart - next get subtotal full xpath*/
        String expectedTotalPrice = "$99.00";
        WebElement totalPrice = driver.findElement(By.xpath("/html/body/div[1]/main/div[3]/div/div[2]/div[1]/div[2]/div/table/tbody/tr[1]/td/span"));
        System.out.println("Go to cart,next go to view & edit cart and get subtotal");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertEquals(totalPrice.getText(),expectedTotalPrice);
        System.out.println("Task02 part-6 Done");

        /*remove the summit watch and get the new subtotal full xpath*/
        WebElement remove = driver.findElement(By.xpath("//*[@id=\"shopping-cart-table\"]/tbody[2]/tr[2]/td/div/a[3]"));
        remove.click ();
        String removeTotalPrice = "$45.00";
        WebElement total1Price = driver.findElement(By.xpath("/html/body/div[1]/main/div[3]/div/div[2]/div[1]/div[2]/div/table/tbody/tr[1]/td/span"));
        System.out.println("Get the new subtotal");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertEquals(total1Price.getText(),removeTotalPrice);
        System.out.println("Task02 part-7 Done");

        /*go to check out and get the button xpath*/
        WebElement checkout = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[1]/ul/li[1]/button"));
        checkout.click ();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("");

        /* This code use to add address details*/

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebElement  address1 = driver.findElement ( By.xpath ( "/html/body/div[1]/main/div[2]/div/div[2]/div[4]/ol/li[1]/div[2]/form/div/fieldset/div/div[1]/div/input" ) );
        address1.sendKeys ( "Thyaga , " );

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebElement  address2 = driver.findElement ( By.xpath ( "/html/body/div[1]/main/div[2]/div/div[2]/div[4]/ol/li[1]/div[2]/form/div/fieldset/div/div[2]/div/input" ) );
        address2.sendKeys ( "Shamila , " );

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebElement  address3 = driver.findElement ( By.xpath ( "/html/body/div[1]/main/div[2]/div/div[2]/div[4]/ol/li[1]/div[2]/form/div/fieldset/div/div[3]/div/input" ) );
        address3.sendKeys ( " Yatheesh" );

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebElement  city = driver.findElement ( By.xpath ( "/html/body/div[1]/main/div[2]/div/div[2]/div[4]/ol/li[1]/div[2]/form/div/div[4]/div/input" ) );
        city.sendKeys ( "TEAM 21" );

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebElement  region = driver.findElement ( By.xpath ( "/html/body/div[1]/main/div[2]/div/div[2]/div[4]/ol/li[1]/div[2]/form/div/div[5]/div/select" ) );
        region.click( );
        System.out.println( "Click the drop down" );

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement  region1 = driver.findElement ( By.xpath ( "/html/body/div[1]/main/div[2]/div/div[2]/div[4]/ol/li[1]/div[2]/form/div/div[5]/div/select/option[63]" ) );
        region1.click( );
        System.out.println( "Select Washington" );

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebElement  region2 = driver.findElement ( By.xpath ( "/html/body/div[1]/main/div[2]/div/div[2]/div[4]/ol/li[1]/div[2]/form/div/div[5]/div/select" ) );
        region2.click( );
        System.out.println( "Again click the drop down" );

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebElement  zip = driver.findElement ( By.xpath ( "/html/body/div[1]/main/div[2]/div/div[2]/div[4]/ol/li[1]/div[2]/form/div/div[7]/div/input" ) );
        zip.sendKeys ( "12345");

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebElement  country = driver.findElement ( By.xpath ( "/html/body/div[1]/main/div[2]/div/div[2]/div[4]/ol/li[1]/div[2]/form/div/div[8]/div/select" ) );
        country.click( );
        System.out.println( "Click the drop down" );

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement  country1 = driver.findElement ( By.xpath ( "/html/body/div[1]/main/div[2]/div/div[2]/div[4]/ol/li[1]/div[2]/form/div/div[8]/div/select/option[210]" ) );
        country1.click( );
        System.out.println( "Select Sri Lanka" );

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebElement  country2 = driver.findElement ( By.xpath ( "/html/body/div[1]/main/div[2]/div/div[2]/div[4]/ol/li[1]/div[2]/form/div/div[8]/div/select" ) );
        country2.click( );
        System.out.println( "Again click the drop down" );

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebElement  phoneNum = driver.findElement ( By.xpath ( "/html/body/div[1]/main/div[2]/div/div[2]/div[4]/ol/li[1]/div[2]/form/div/div[9]/div/input" ) );
        phoneNum.sendKeys ( "0123456789");
        System.out.println("Enter the phone number");


        WebElement  next1 = driver.findElement ( By.xpath ( "/html/body/div[1]/main/div[2]/div/div[2]/div[4]/ol/li[2]/div/div[3]/form/div[3]/div/button/span" ) );
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        next1.click( );

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement placeOrderButton = driver.findElement(By.xpath("//button[@title='Place Order']"));
        Thread.sleep(5000);
        placeOrderButton.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        String thanks = "Thank you for your purchase!";
        WebElement thanks1 = driver.findElement(By.xpath("/html/body/div[1]/main/div[1]/h1/span"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertEquals(thanks1.getText(),thanks);
        System.out.println("Task02 part-12 Done");





    }
}