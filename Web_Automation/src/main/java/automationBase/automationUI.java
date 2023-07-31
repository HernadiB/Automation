package automationBase;


import automationPages.grandCasinoPages.GrandCasinoLoginPage;

/** Helpers to create page object when the test start, and don't need to create in every tests **/
public class automationUI {
    public GrandCasinoLoginPage grandCasinoLoginPage;

    public automationUI(){
        this.grandCasinoLoginPage = new GrandCasinoLoginPage();
    }
}
