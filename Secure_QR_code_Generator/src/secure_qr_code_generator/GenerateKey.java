/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package secure_qr_code_generator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 *
 * @author abans
 */
public class GenerateKey {

    public static void GenerateKey(String tagName) throws NoSuchAlgorithmException, FileNotFoundException, IOException {
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
        kpg.initialize(2048);
        KeyPair kp = kpg.generateKeyPair();
        Key pub = kp.getPublic();
        Key pvt = kp.getPrivate();

        Base64.Encoder encoder = Base64.getEncoder();

        FileOutputStream out = new FileOutputStream(tagName + ".key");
        out.write(pvt.getEncoded());
        out.close();

        FileWriter public_key = new FileWriter(tagName + ".pub");
        public_key.write("-----BEGIN RSA PUBLIC KEY-----\n");
        public_key.write(encoder.encodeToString(pub.getEncoded()));
        public_key.write("\n-----END RSA PUBLIC KEY-----\n");
        public_key.close();

    }
}
