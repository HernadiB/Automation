package automationBase;


import casinoPages.hungarian_casino.grandCasinoPages.GrandCasinoLandingPage;
import casinoPages.sweden_casino.pafPages.PafLandingPage;
import casinoPages.hungarian_casino.vegasCasinoPages.VegasCasinoLandingPage;
import casinoPages.hungarian_casino.vegasCasinoVipPages.VegasCasinoVipLandingPage;
import casinoPages.sweden_casino.veraJohnPages.VeraJohnLandingPage;

/** Helpers to create page object when the test start, and don't need to create in every tests **/
public class AutomationUI {
    public GrandCasinoLandingPage grandCasinoLandingPage;
    public VeraJohnLandingPage veraJohnLandingPage;
    public PafLandingPage pafLandingPage;
    public VegasCasinoLandingPage vegasCasinoPage;
    public VegasCasinoVipLandingPage vegasCasinoVipLandingPage;

    public AutomationUI(){
        this.grandCasinoLandingPage = new GrandCasinoLandingPage();
        this.veraJohnLandingPage = new VeraJohnLandingPage();
        this.pafLandingPage = new PafLandingPage();
        this.vegasCasinoPage = new VegasCasinoLandingPage();
        this.vegasCasinoVipLandingPage = new VegasCasinoVipLandingPage();
    }
}
