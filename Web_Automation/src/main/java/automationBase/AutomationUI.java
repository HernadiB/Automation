package automationBase;


import automationPages.grandCasinoPages.GrandCasinoLandingPage;
import automationPages.pafPages.PafLandingPage;
import automationPages.vegasCasinoPages.VegasCasinoLandingPage;
import automationPages.veraJohnPages.VeraJohnLandingPage;

/** Helpers to create page object when the test start, and don't need to create in every tests **/
public class AutomationUI {
    public GrandCasinoLandingPage grandCasinoLandingPage;
    public VeraJohnLandingPage veraJohnLandingPage;
    public PafLandingPage pafLandingPage;
    public VegasCasinoLandingPage vegasCasinoPage;

    public AutomationUI(){
        this.grandCasinoLandingPage = new GrandCasinoLandingPage();
        this.veraJohnLandingPage = new VeraJohnLandingPage();
        this.pafLandingPage = new PafLandingPage();
        this.vegasCasinoPage = new VegasCasinoLandingPage();
    }
}
