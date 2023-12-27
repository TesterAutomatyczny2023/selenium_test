package page.object.model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

import java.util.List;

public class TheHerokuAddAndRemoveElementsPage {
      //@CacheLookup //- nie używaj na elementach które mogą się zmieniać, zostanie użyta poprzednia wersja elemntu zamiast nowej
      @FindBy(className="added-manually")
      protected List<WebElement> elements;
      @CacheLookup
      @FindBy(  tagName = "button")
      protected WebElement button;
      public TheHerokuAddAndRemoveElementsPage(WebDriver driver) {
          PageFactory.initElements(driver, this);
      }
      public void addElement() {
          button.click();
      }
      public void addElement(int count){
          for (int i = 1; i <= count; i++) {
              button.click();
          }
      }
      public int getElementCount() {
          return elements.size();
      }
}
