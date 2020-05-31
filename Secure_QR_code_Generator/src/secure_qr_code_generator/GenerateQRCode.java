/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package secure_qr_code_generator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @author abans
 */
public class GenerateQRCode {
    public static boolean generateQRCode(String text ,String tag) throws IOException {
        
        String s = null;
        Process p = Runtime.getRuntime().exec("python qr_script.py "+text+" "+tag);

        BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));

        // read any errors from the attempted command
        while ((s = stdError.readLine()) != null) {
            return false;
        }
        return true;
    }
}
