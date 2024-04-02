package webTDK.connection.driver;

/**
 * Object to help creating the driver
 */
public class DriverDto {
    /**
     * In constructor set default parameters, so if this setup good to you, don't need to change params
     */
    public DriverDto(){
        this.browserVersion = null;
        this.browserType = "chrome";
        this.implicitWait = 30;
        this.isRemote = false;
        this.RemoteUrl = "https://hub.lambdatest.com/wd/hub";
        this.browserWidth = 0;
        this.browserHeight = 0;
        this.browserLang = "hu";
        this.driverPath = null;
        this.remoteUsername = "";
        this.remoteAccessKey = "";
        this.remoteVisual = true;
        this.remoteVideo = false;
        this.remoteBuild = "";
        this.remoteProject = "";
        this.remoteTunnel = true;
        this.remoteSeleniumVersion = "4.12.0";
        this.remoteW3C = true;
        this.remoteConsole = false;
        this.remoteTerminal = false;
        this.testName = "";
    }

    /**
     * Browser version default LATEST
     */
    private String browserVersion;

    /**
     * Browser type defualt Chrome
     */
    private String browserType;

    /**
     * Implicit wait default 30 sec
     */
    private int implicitWait;

    /** The run is local or remote **/
    private boolean isRemote;

    /** Remote URL **/
    private String RemoteUrl;

    /** Started browser width in pixel **/
    private int browserWidth;

    /** Started browser height in pixel **/
    private int browserHeight;

    /** Browser Language **/
    private String browserLang;

    /** Workaround sys prop for create driver **/
    private String driverPath;

    /** Lambda Remote Username **/
    private String remoteUsername;

    /** Lambda Remote Access Key **/
    private String remoteAccessKey;

    /** Lambda Remote Visual setting **/
    private Boolean remoteVisual;

    /** Lambda Remote Video setting **/
    private Boolean remoteVideo;

    /** Lambda Remote Build setting **/
    private String remoteBuild;

    /** Lambda Remote Project setting **/
    private String remoteProject;

    /** Lambda Remote Tunnel setting **/
    private Boolean remoteTunnel;

    /** Lambda Remote Selenium Version setting **/
    private String remoteSeleniumVersion;

    /** Lambda Remote W3C setting **/
    private Boolean remoteW3C;

    /** Lambda Remote Console setting **/
    private Boolean remoteConsole;

    /** Lambda Remote Terminal setting **/
    private Boolean remoteTerminal;

    /** Lambda Test Name **/
    private String testName;

    /**
     * Return the browser version
     * @return Browser version String
     */
    public String getBrowserVersion() {
        return this.browserVersion;
    }

    /**
     * Set the browser version
     * @param browserVersion String
     * @return DriverDto object
     */
    public DriverDto setBrowserVersion(String browserVersion) {
        this.browserVersion = browserVersion;
        return this;
    }

    /**
     * Get the browser type
     * @return Browser type String
     */
    public String getBrowserType() {
        return this.browserType;
    }

    /**
     * Set the browser type
     * @param browserType String
     * @return DriverDto Object
     */
    public DriverDto setBrowserType(String browserType) {
        this.browserType = browserType;
        return this;
    }

    /**
     * Get the implicit wait
     * @return Implicit wait int
     */
    public int getImplicitWait(){
        return this.implicitWait;
    }

    /**
     * Set the implicit wait
     * @param waitSeconds int
     * @return DriverDto object
     */
    public DriverDto setImplicitWait(int waitSeconds){
        this.implicitWait = waitSeconds;
        return this;
    }

    /**
     * Get the isRemote value
     * @return isRemote boolean
     */
    public boolean getIsRemote(){
        return this.isRemote;
    }

    /**
     * Set the isRemote boolean
     * @param isRemote Boolean
     * @return DriverDto Object
     */
    public DriverDto setIsRemote(boolean isRemote){
        this.isRemote = isRemote;
        return this;
    }

    /**
     * Get the RemoteUrl value
     * @return Remote url string
     */
    public String getRemoteUrl() {
        return RemoteUrl;
    }

    /**
     * Set the RemoteUrl value
     * @param remoteUrl string
     * @return DriverDto Object
     */
    public DriverDto setRemoteUrl(String remoteUrl) {
        RemoteUrl = remoteUrl;
        return this;
    }

    /**
     * Get the browser width value
     * @return Width int
     */
    public int getBrowserWidth(){
        return this.browserWidth;
    }

    /**
     * Set the browserWidth value
     * @param browserWidth int
     * @return DriverDto Object
     */
    public DriverDto setBrowserWidth(int browserWidth){
        this.browserWidth = browserWidth;
        return this;
    }

    /**
     * Get the browerHeight value
     * @return Height int
     */
    public int getBrowserHeight(){
        return this.browserHeight;
    }

    /**
     * Set the browserHeight value
     * @param browserHeight int
     * @return DriverDto Object
     */
    public DriverDto setBrowserHeight(int browserHeight){
        this.browserHeight = browserHeight;
        return this;
    }

    /**
     * Get the browserLang value
     * @return Height String
     */
    public String getBrowserLang(){
        return this.browserLang;
    }

    /**
     * Set the browserLang value
     * @param browserLang String
     * @return DriverDto Object
     */
    public DriverDto setBrowserLang(String browserLang){
        this.browserLang = browserLang;
        return this;
    }

    /**
     * Get Remote Username
     * @return Remote Username String
     */
    public String getRemoteUsername() {
        return this.remoteUsername;
    }

    /**
     * Set Remote Username
     * @param remoteUsername String
     * @return DriverDto Object
     */
    public DriverDto setRemoteUsername(String remoteUsername) {
        this.remoteUsername = remoteUsername;
        return this;
    }

    /**
     * Get Remote Access Key
     * @return Remote Acces Key String
     */
    public Object getRemoteAccessKey() {
        return this.remoteAccessKey;
    }

    /**
     * Set Remote Access Key
     * @param remoteAccessKey String
     * @return DriverDto Object
     */
    public DriverDto setRemoteAccessKey(String remoteAccessKey) {
        this.remoteAccessKey = remoteAccessKey;
        return this;
    }

    /**
     * Get Remote Visual
     * @return Remote Visual Boolean
     */
    public Object getRemoteVisual() {
        return this.remoteVisual;
    }

    /**
     * Set Remote Visual
     * @param remoteVisual Boolean
     * @return DriverDto Object
     */
    public DriverDto setRemoteVisual(Boolean remoteVisual) {
        this.remoteVisual = remoteVisual;
        return this;
    }

    /**
     * Get Remote Video
     * @return Remote Video Boolean
     */
    public Object getRemoteVideo() {
        return this.remoteVideo;
    }

    /**
     * Set Remote Video
     * @param remoteVideo Boolean
     * @return DriverDto Object
     */
    public DriverDto setRemoteVideo(Boolean remoteVideo) {
        this.remoteVideo = remoteVideo;
        return this;
    }

    /**
     * Get Remote build
     * @return RemoteBuild String
     */
    public Object getRemoteBuild() {
        return this.remoteBuild;
    }

    /**
     * Set remote build
     * @param remoteBuild String
     * @return DriverDto Object
     */
    public DriverDto setRemoteBuild(String remoteBuild) {
        this.remoteBuild = remoteBuild;
        return this;
    }

    /**
     * Get Remote Project
     * @return RemoteProject String
     */
    public Object getRemoteProject() {
        return this.remoteProject;
    }

    /**
     * Set Remote Project
     * @param remoteProject String
     * @return DriverDto Object
     */
    public DriverDto setRemoteProject(String remoteProject) {
        this.remoteProject = remoteProject;
        return this;
    }

    /**
     * Get Remote Tunnel
     * @return Remote Tunnel Boolean
     */
    public Object getRemoteTunnel() {
        return this.remoteTunnel;
    }

    /**
     * Set remote Tunnel
     * @param remoteTunnel Boolean
     * @return DriverDto Object
     */
    public DriverDto setRemoteTunnel(Boolean remoteTunnel) {
        this.remoteTunnel = remoteTunnel;
        return this;
    }

    /**
     * Get Remote Selenium Version
     * @return Remote Selenium Version String
     */
    public Object getRemoteSeleniumVersion() {
        return this.remoteSeleniumVersion;
    }

    /**
     * Set Remote Selenium Version
     * @param remoteSeleniumVersion String
     * @return DriverDto Object
     */
    public DriverDto setRemoteSeleniumVersion(String remoteSeleniumVersion) {
        this.remoteSeleniumVersion = remoteSeleniumVersion;
        return this;
    }

    /**
     * Get Remote W3C
     * @return Remote W3C boolean
     */
    public Object getRemoteW3C() {
        return this.remoteW3C;
    }

    /**
     * Set Remote W3C
     * @param remoteW3C boolean
     * @return DriverDto Object
     */
    public DriverDto setRemoteW3C(Boolean remoteW3C) {
        this.remoteW3C = remoteW3C;
        return this;
    }

    /**
     * Get Remote Console
     * @return Remote Console boolean
     */
    public Object getRemoteConsole() {
        return this.remoteConsole;
    }

    /**
     * Set Remote Console
     * @param remoteConsole Boolean
     * @return DriverDto Object
     */
    public DriverDto setRemoteConsole(Boolean remoteConsole) {
        this.remoteConsole = remoteConsole;
        return this;
    }

    /**
     * Get Remote Terminal
     * @return Remote Terminal Boolean
     */
    public Object getRemoteTerminal() {
        return this.remoteTerminal;
    }

    /**
     * Set Remote Terminal
     * @param remoteTerminal Boolean
     * @return DriverDto Object
     */
    public DriverDto setRemoteTerminal(Boolean remoteTerminal) {
        this.remoteTerminal = remoteTerminal;
        return this;
    }

    /**
     * Get Test Name value
     * @return TestName String
     */
    public String getTestName(){
        return this.testName;
    }

    /**
     * Set Test Name value
     * @param testName String
     * @return DriverDto Object
     */
    public DriverDto setTestName(String testName){
        this.testName = testName;
        return this;
    }
}