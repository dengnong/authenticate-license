package demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * Created by 54472 on 2017/10/25.
 */
public class Comparison {
    public boolean comparison() {
        boolean flag = false;
        try {
            File file = new File("src\\license");
            License license = new License();
            BufferedReader readLine = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            String readLicense = readLine.readLine();
            //解密
            readLicense = EncryptionAndDecryption.decrypt(readLicense);
            System.out.println(readLicense);
            String hardwareInfo = license.getHardwareInfo();
            System.out.println(hardwareInfo);
            if (readLicense.equals(hardwareInfo)) {
                flag = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
}
