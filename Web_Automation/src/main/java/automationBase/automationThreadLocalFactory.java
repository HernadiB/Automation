package automationBase;

import webTDK.common.ThreadLocalBaseFactory;

/** Helper to store data in thread **/
public class automationThreadLocalFactory extends ThreadLocalBaseFactory {
    private static final ThreadLocal<automationUI> ui = new ThreadLocal<>();
    public static automationUI getUi(){
        return ui.get();
    }
    public static void setUi(automationUI ui){
        automationThreadLocalFactory.ui.set(ui);
    }
    public static void removeThreadLocalVariables(){
        ui.remove();
    }
}
