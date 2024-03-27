package automationBase;

import webTDK.common.ThreadLocalBaseFactory;

/** Helper to store data in thread **/
public class AutomationThreadLocalFactory extends ThreadLocalBaseFactory {
    private static final ThreadLocal<AutomationUI> ui = new ThreadLocal<>();
    public static AutomationUI getUi(){
        return ui.get();
    }
    public static void setUi(AutomationUI ui){
        AutomationThreadLocalFactory.ui.set(ui);
    }
    public static void removeThreadLocalVariables(){
        ui.remove();
    }
}
