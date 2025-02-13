package automationBase;


import casinoPages.hungarian_casino.grandCasinoPages.GrandCasinoLandingPage;
import casinoPages.slovak_casino.nikePages.NikeLandingPage;
import casinoPages.sweden_casino.atgPages.AtgLandingPage;
import casinoPages.sweden_casino.expektPages.ExpektLandingPage;
import casinoPages.sweden_casino.hajperPages.HajperLandingPage;
import casinoPages.sweden_casino.pafPages.PafLandingPage;
import casinoPages.hungarian_casino.vegasCasinoPages.VegasCasinoLandingPage;
import casinoPages.hungarian_casino.vegasCasinoVipPages.VegasCasinoVipLandingPage;
import casinoPages.slovak_casino.tipSportPages.TipSportLandingPage;
import casinoPages.sweden_casino.swedenLimitedPages.SwedenLimitedLandingPage;
import casinoPages.sweden_casino.veraJohnPages.VeraJohnLandingPage;

/** Helpers to create page object when the test start, and don't need to create in every tests **/
public class AutomationUI {
    public GrandCasinoLandingPage grandCasinoLandingPage;
    public VeraJohnLandingPage veraJohnLandingPage;
    public PafLandingPage pafLandingPage;
    public VegasCasinoLandingPage vegasCasinoPage;
    public VegasCasinoVipLandingPage vegasCasinoVipLandingPage;
    public ExpektLandingPage expektLandingPage;
    public HajperLandingPage hajperLandingPage;
    public NikeLandingPage nikeLandingPage;
    public TipSportLandingPage tipSportLandingPage;
    public AtgLandingPage atgLandingPage;
    public SwedenLimitedLandingPage swedenLimitedLandingPage;

    public AutomationUI(){
        this.grandCasinoLandingPage = new GrandCasinoLandingPage();
        this.veraJohnLandingPage = new VeraJohnLandingPage();
        this.pafLandingPage = new PafLandingPage();
        this.vegasCasinoPage = new VegasCasinoLandingPage();
        this.vegasCasinoVipLandingPage = new VegasCasinoVipLandingPage();
        this.expektLandingPage = new ExpektLandingPage();
        this.hajperLandingPage = new HajperLandingPage();
        this.nikeLandingPage = new NikeLandingPage();
        this.tipSportLandingPage = new TipSportLandingPage();
        this.atgLandingPage = new AtgLandingPage();
        this.swedenLimitedLandingPage = new SwedenLimitedLandingPage();
    }
}
