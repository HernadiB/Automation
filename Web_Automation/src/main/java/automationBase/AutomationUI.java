package automationBase;


import automationPages.grandCasinoPages.GrandCasinoLandingPage;
import automationPages.veraJohnPages.VeraJohnLandingPage;

/** Helpers to create page object when the test start, and don't need to create in every tests **/
public class AutomationUI {
    public GrandCasinoLandingPage grandCasinoLandingPage;
    public VeraJohnLandingPage veraJohnLandingPage;

    public AutomationUI(){
        this.grandCasinoLandingPage = new GrandCasinoLandingPage();
        this.veraJohnLandingPage = new VeraJohnLandingPage();
    }
}
