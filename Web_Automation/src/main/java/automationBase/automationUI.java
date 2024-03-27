package automationBase;


import automationPages.grandCasinoPages.GrandCasinoLoginPage;

/** Helpers to create page object when the test start, and don't need to create in every tests **/
public class AutomationUI {
    public GrandCasinoLoginPage grandCasinoLoginPage;

    public AutomationUI(){
        this.grandCasinoLoginPage = new GrandCasinoLoginPage();
    }
}
