/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package secure_qr_code_generator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

/**
 *
 * @author abans
 */
public class SignData {

    public static String signData(String data, String keyTag) throws NoSuchAlgorithmException, IOException, InvalidKeySpecException, InvalidKeyException, SignatureException {

        /* Read all bytes from the private key file */
        Path path = Paths.get(keyTag + ".key");
        byte[] bytes = Files.readAllBytes(path);

        /* Generate private key. */
        PKCS8EncodedKeySpec ks = new PKCS8EncodedKeySpec(bytes);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        PrivateKey pvt1 = kf.generatePrivate(ks);

        Signature sign = Signature.getInstance("SHA256withRSA");
        sign.initSign(pvt1);
        sign.update(data.getBytes());
        byte[] sign1 = sign.sign();

        Base64.Encoder encoder = Base64.getEncoder();
        String encodeToString = encoder.encodeToString(sign1);
        return keyTag + "," + data + "," + encodeToString;

    }

}
