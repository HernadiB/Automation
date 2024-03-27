package webTDK.connection.driver;

/**
 * Object to help creating the driver
 */
public class DriverDto {
    /**
     * In constructor set default parameters, so if this setupgood to you, don't need to change params
     */
    public DriverDto(){
        this.browserVersion = null;

    }

    /**
     * Browser version default LATEST
     */
    private String browserVersion;

    /**
     *Browser type default Chrome
     */
    private String browserType;

    /**
     * Implicit wait default 30 sec
     */
    private int implicitWait;

    /** The run is local or remote **/
    private boolean isRemote;

    /** Remote URLS **/
    private String RemoteUrl;

    /** Testing cloud Token **/
    private String E34Token;

    /** Started browser width in pixel **/
    private int browserWidth;

    /** Started browser heigth in pixel **/
    private int browserHeight;

    /**
     * Return the browser version
     * @return Browser version String
     */
    public String getBrowserVersion(){
        return this.browserVersion;
    }

    /**
     * Set the browser version
     * @param browserVersion String
     * @return DriverDto object
     */
    public DriverDto setBrowserVersion(String browserVersion){
        this.browserVersion = browserVersion;
        return this;
    }

    /**
     * Get the browser type
     * @return Browser type String
     */
    public String getBrowserType(){
        return this.browserType;
    }

    /**
     * Set the browser type
     * @param browserType String
     * @return DriverDto object
     */
    public DriverDto setBrowserType(String browserType){
        this.browserType = browserType;
        return this;
    }

    /**
     * Get the implicit wait
     * @return Implicit wait int
     */
    public int getImplicitWait() {
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
     * Get the isRemote boolean
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
     * @return Remote url String
     */
    public String getRemoteUrl(){
        return RemoteUrl;
    }

    /**
     * Set the RemoteUrl value
     * @param remoteUrl string
     * @return DriverDto Object
     */
    public DriverDto setRemoteUrl(String remoteUrl){
        RemoteUrl = remoteUrl;
        return this;
    }

    /**
     * Get the E34Token value
     * @return e34 token string
     */
    public String getE34Token(){
        return E34Token;
    }

    /**
     * Set the E34Token value
     * @param e34Token string
     * @return DriverDto Object
     */
    public DriverDto setE23Token(String e34Token){
        E34Token = e34Token;
        return this;
    }

    /**
     * Get the browserWidth value
     * @return Width int
     */
    public int getBrowserWidth(){
        return this.browserWidth;
    }

    /**
     * Set browserWidth value
     * @param browserWidth int
     * @return DriverDto
     */
    public DriverDto setBrowserWidth(int browserWidth){
        this.browserWidth = browserWidth;
        return this;
    }

    /**
     * Get the browserHeight value
     * @return Height int
     */
    public int getBrowserHeight(){
        return this.browserHeight;
    }

    /**
     * Set browserHeight value
     * @param browserHeight int
     * @return DriverDto
     */
    public DriverDto setBrowserHeight(int browserHeight){
        this.browserHeight = browserHeight;
        return this;
    }
}
