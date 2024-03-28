package webTDK.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Value {
    private final Object value;
    private final ValueConditionFunction function;

    public Value(Object value, ValueConditionFunction function){
        this.value = value;
        this.function = function;
    }

    public Object getValue(){
        return value;
    }

    public boolean isConditionFulfilled(WebDriver driver, WebElement element, Object value){
        return function.execute(driver, element, value);
    }

    public boolean equals(Value other){
        return this.value.equals(other.value) && this.function.equals(other.function);
    }
}
