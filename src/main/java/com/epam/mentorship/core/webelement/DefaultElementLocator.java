
package com.epam.mentorship.core.webelement;

import com.epam.mentorship.core.driver.DriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.AbstractAnnotations;
import org.openqa.selenium.support.pagefactory.Annotations;
import org.openqa.selenium.support.pagefactory.ElementLocator;

import java.lang.reflect.Field;
import java.util.List;


public class DefaultElementLocator implements ElementLocator {
  private final DriverProvider provider;
  private final boolean shouldCache;
  private final By by;
  private WebElement cachedElement;
  private List<WebElement> cachedElementList;


  public DefaultElementLocator(DriverProvider provider, Field field) {
    this(provider, new Annotations(field));
  }


  public DefaultElementLocator(DriverProvider provider, AbstractAnnotations annotations) {
    this.provider = provider;
    this.shouldCache = annotations.isLookupCached();
    this.by = annotations.buildBy();
  }

  /**
   * Find the element.
   */
  public WebElement findElement() {
    if (cachedElement != null && shouldCache()) {
      return cachedElement;
    }

    WebElement element = provider.getDriver().findElement(by);
    if (shouldCache()) {
      cachedElement = element;
    }

    return element;
  }

  /**
   * Find the element list.
   */
  public List<WebElement> findElements() {
    if (cachedElementList != null && shouldCache()) {
      return cachedElementList;
    }

    List<WebElement> elements = provider.getDriver().findElements(by);
    if (shouldCache()) {
      cachedElementList = elements;
    }

    return elements;
  }

  /**
   * Returns whether the element should be cached.
   *
   * @return {@code true} if the element should be cached
   */
  protected boolean shouldCache() {
    return shouldCache;
  }

  @Override
  public String toString() {
    return this.getClass().getSimpleName() + " '" + by + "'";
  }
}
