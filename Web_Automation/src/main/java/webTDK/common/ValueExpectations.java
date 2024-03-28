package webTDK.common;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import webTDK.common.helpers.PresenceHelpers;
import webTDK.common.helpers.wait.WaitHelpers;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicBoolean;

public enum ValueExpectations {
    //TODO: CHECKBOX_SELECTED -> projekt specifikus lesz
    TEXT_EQUALS((driver, webElement, value) -> webElement.getText().equals(value.toString())),
    INPUT_EQUALS((driver, webElement, value) -> webElement.getAttribute("value").equals(value.toString())),
    CLASS_CONTAINS((driver, webElement, value) -> webElement.getAttribute("class").contains(value.toString())),
    SRC_CONTAINS((driver, webElement, value) -> webElement.getAttribute("src").contains(value.toString())),
    TITLE_EQUALS((driver, webElement, value) -> webElement.getAttribute("title").equals(value.toString())),
    ELEMENT_EXISTS((driver, parentElement, childElementLocator) -> {
        AtomicBoolean isPresent = new AtomicBoolean(false);
        WaitHelpers.withCustomImplicitWait(driver, Duration.ofSeconds(0), () -> {
            try {
                isPresent.set(PresenceHelpers.isPresent(driver, parentElement.findElement((By) childElementLocator)));
            } catch (NoSuchElementException e) {
                isPresent.set(false);
            }
        });
        return isPresent.get();
    }),
    ELEMENT_NOT_EXISTS((driver, parentElement, childElementLocator) -> !ELEMENT_EXISTS.getMethod().execute(driver, parentElement, childElementLocator)),
    HAS_TEXT((driver, webElement, expectation) -> StringUtils.isNotEmpty(webElement.getText()) == Boolean.parseBoolean(expectation.toString()));

    private final ValueConditionFunction function;
    public ValueConditionFunction getMethod(){
        return function;
    }
    ValueExpectations(ValueConditionFunction f){
        this.function = f;
    }
}
