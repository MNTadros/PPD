package com.projectplanner.dashboard.util;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import io.github.cdimascio.dotenv.Dotenv;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.security.Security;
import java.util.Base64;
import java.util.List;
import java.util.ArrayList;

public class EncryptedFileStorage {
    private static final Dotenv dotenv = Dotenv.load();
    private static final String SECRET = dotenv.get("SECRET_KEY", "defaultfallback16byt");
    private static final String ALGO = "AES";

    static {
        Security.addProvider(new BouncyCastleProvider());
    }

    public static void save(List<String> lines, String path) throws Exception {
        String content = String.join("\n", lines);
        byte[] encrypted = encrypt(content.getBytes());
        try (FileOutputStream fos = new FileOutputStream(path)) {
            fos.write(encrypted);
        }
    }

    public static List<String> load(String path) throws Exception {
        File file = new File(path);
        if (!file.exists()) return new ArrayList<>();
        byte[] encrypted = new byte[(int) file.length()];
        try (FileInputStream fis = new FileInputStream(path)) {
            fis.read(encrypted);
        }
        String decrypted = new String(decrypt(encrypted));
        List<String> result = new ArrayList<>();
        for (String line : decrypted.split("\n")) {
            if (!line.trim().isEmpty()) result.add(line);
        }
        return result;
    }

    private static byte[] encrypt(byte[] data) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGO, "BC");
        SecretKeySpec key = new SecretKeySpec(SECRET.getBytes(), ALGO);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return cipher.doFinal(data);
    }

    private static byte[] decrypt(byte[] data) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGO, "BC");
        SecretKeySpec key = new SecretKeySpec(SECRET.getBytes(), ALGO);
        cipher.init(Cipher.DECRYPT_MODE, key);
        return cipher.doFinal(data);
    }
}
