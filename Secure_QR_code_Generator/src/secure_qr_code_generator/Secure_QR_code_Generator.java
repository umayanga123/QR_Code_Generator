/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package secure_qr_code_generator;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author abans
 */
public class Secure_QR_code_Generator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            // TODO code application logic here

            /*    KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
            kpg.initialize(2048);
            KeyPair kp = kpg.generateKeyPair();
            Key pub = kp.getPublic();
            Key pvt = kp.getPrivate();
            String outFile = "s1";
            FileOutputStream out = new FileOutputStream(outFile + ".key");
            out.write(pvt.getEncoded());
            out.close();

            FileOutputStream out1 = new FileOutputStream(outFile + ".pub");
            out1.write(pub.getEncoded());
            out1.close();

            System.err.println("Private key format: " + pvt.getFormat());
            // prints "Private key format: PKCS#8" on my machine

            System.err.println("Public key format: " + pub.getFormat());
            // prints "Public key format: X.509" on my machine
            
            
            /* Read all bytes from the private key file */
 /* Path path = Paths.get("s1.key");
            byte[] bytes = Files.readAllBytes(path);

            /* Generate private key. */
 /*PKCS8EncodedKeySpec ks = new PKCS8EncodedKeySpec(bytes);
            KeyFactory kf = KeyFactory.getInstance("RSA");
            PrivateKey pvt1 = kf.generatePrivate(ks);
            System.out.println(pvt1);
            
           
            
            /* Read all the public key bytes */
 /*  Path ppath = Paths.get("s1.pub");
            byte[] pbytes = Files.readAllBytes(ppath);

            /* Generate public key. */
 /*  X509EncodedKeySpec ks1 = new X509EncodedKeySpec(pbytes);
            KeyFactory kf1 = KeyFactory.getInstance("RSA");
            PublicKey pub1 = kf1.generatePublic(ks1);
            System.out.println(pub1);
            
            Base64.Encoder encoder5 = Base64.getEncoder();

            String outFile2 = "s1";
            Writer out3 = new FileWriter(outFile2 + ".key");
            out3.write("-----BEGIN RSA PRIVATE KEY-----\n");
            out3.write(encoder5.encodeToString(pvt.getEncoded()));
            out3.write("\n-----END RSA PRIVATE KEY-----\n");
            out3.close();

            
            FileWriter out4 = new FileWriter(outFile2 + ".pub");
            out4.write("-----BEGIN RSA PUBLIC KEY-----\n");
            out4.write(encoder5.encodeToString(pub.getEncoded()));
            out4.write("\n-----END RSA PUBLIC KEY-----\n");
            out4.close();
            
            
            Signature sign = Signature.getInstance("SHA256withRSA");
            String text ="www.google.com";
            
            sign.initSign(pvt1);
            sign.update(text.getBytes());
            byte[] sign1 = sign.sign();
            
            Base64.Encoder encoder = Base64.getEncoder();
            String encodeToString = encoder.encodeToString(sign1);
            System.out.println(encodeToString);
            out = new FileOutputStream("signFile.txt");
            out.write(sign1);
            out.close();
           
           Signature sign2 = Signature.getInstance("SHA256withRSA");
           sign2.initVerify(pub1);
           String text2 ="www.google.com";
           sign2.update(text2.getBytes());
   

            /* Read the signature bytes from file */
 /*   path = Paths.get("signFile.txt");
            bytes = Files.readAllBytes(path);
            System.out.println(": Signature " +(sign2.verify(bytes) ? "OK" : "Not OK"));*/
            GenerateKey.GenerateKey("s2");
            String signData = SignData.signData("www.facebook.com", "s2");
            boolean generateQRCode = GenerateQRCode.generateQRCode(signData);
            if (generateQRCode) {
                JOptionPane.showMessageDialog(null, "Genetate QR code");
            } else {
                JOptionPane.showMessageDialog(null, "ERROR");
            }

        } catch (IOException | NoSuchAlgorithmException | InvalidKeySpecException | InvalidKeyException | SignatureException ex) {
            Logger.getLogger(Secure_QR_code_Generator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
