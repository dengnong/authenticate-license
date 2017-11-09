package demo;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Properties;

/**
 * Created by 54472 on 2017/10/24.
 */
public class License {
    private String macInfo;
    private String ipInfo;
    private String osInfo;

    public String getHardwareInfo() throws UnknownHostException, SocketException {
        Properties properties = System.getProperties();
        ipInfo = InetAddress.getLocalHost().getHostAddress();
        osInfo = properties.getProperty("os.name");
        byte[] mac = NetworkInterface.getByInetAddress(InetAddress.getLocalHost()).getHardwareAddress();
        StringBuffer sb = new StringBuffer("");
        for(int i = 0; i < mac.length; i++) {
            if(i != 0){
                sb.append("-");
            }
            int temp = mac[i]&0xff;
            String str = Integer.toHexString(temp);
            if(str.length()==1) {
                sb.append("0"+str);
            }else {
                sb.append(str);
            }
        }
        macInfo = sb.toString().toUpperCase();
        System.out.println(ipInfo+"|"+osInfo+"|"+macInfo);
        return ipInfo+"|"+osInfo+"|"+macInfo;
    }
}
