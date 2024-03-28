package webTDK.common;

import org.openqa.selenium.By;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ElementValueConditions {
    private final HashMap<By, Value> hashMap;

    public ElementValueConditions(){
        this.hashMap = new HashMap<>();
    }

    public ElementValueConditions put(By by, Value value) {
        this.hashMap.put(by, value);
        return this;
    }

    public Set<Map.Entry<By, Value>> entrySet(){
        return hashMap.entrySet();
    }
}
