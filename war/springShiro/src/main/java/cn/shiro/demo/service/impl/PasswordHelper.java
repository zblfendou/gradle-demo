package cn.shiro.demo.service.impl;

import cn.shiro.demo.models.User;
import org.apache.shiro.crypto.*;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Service;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 14-1-28
 * <p>Version: 1.0
 */
@Service("passwordHelper")
public class PasswordHelper {

    private RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator ();
    private String algorithmName = "md5";
    private int hashIterations = 2;

    public void setRandomNumberGenerator(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void setAlgorithmName(String algorithmName) {
        this.algorithmName = algorithmName;
    }

    public void setHashIterations(int hashIterations) {
        this.hashIterations = hashIterations;
    }

    public void encryptPassword(User user) {

        user.setSecuritySalt(randomNumberGenerator.nextBytes().toHex());

        String newPassword = new SimpleHash (
                algorithmName,
                user.getPassword(),
                ByteSource.Util.bytes(user.getSecuritySalt ()),
                hashIterations).toHex();

        user.setPassword(newPassword);
    }
}
