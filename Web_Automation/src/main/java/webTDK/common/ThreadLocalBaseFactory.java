package webTDK.common;

import webTDK.connection.ConnectionInfo;
import java.util.Properties;

/**
 * Default collection of thread locals
 *  use it and extends it if needed
 */
public class ThreadLocalBaseFactory {
    /** Runtime properties **/
    private static final ThreadLocal<Properties> runtimeProps = new ThreadLocal<>();

    /** Connection info **/
    private static final ThreadLocal<ConnectionInfo> connectionInfo = new ThreadLocal<>();

    /** Get actual thread connection info **/
    public static ConnectionInfo getConnectionInfo(){
        return connectionInfo.get();
    }

    /** Set actual thread runtime props **/
    public static void setConnectionInfo(ConnectionInfo connectionInfo){
        ThreadLocalBaseFactory.connectionInfo.set(connectionInfo);
    }

    /** Get actual thread runtime props **/
    public static Properties getRuntimeProps(){
        return runtimeProps.get();
    }

    /** Set actual thread runtime props **/
    public static void setRuntimeProps(Properties runtimeProps){
        ThreadLocalBaseFactory.runtimeProps.set(runtimeProps);
    }

    /** Remove actual thread values **/
    public static void removeThreadLocalVariables(){
        runtimeProps.remove();
        connectionInfo.remove();
    }
}
