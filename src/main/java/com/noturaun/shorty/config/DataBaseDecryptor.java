package com.noturaun.shorty.config;


import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@EnableEncryptableProperties
public class DataBaseDecryptor {


    @Value("${jasypt.encryptor.password}")
    private String privateKey;

    @Bean(name = "jasyptStringEncryptor")
    public StringEncryptor encryptor() {
        final PooledPBEStringEncryptor pbeStringEncryptor = new PooledPBEStringEncryptor();
        pbeStringEncryptor.setConfig(configEncryptDecrypt());
        return pbeStringEncryptor;
    }

    public SimpleStringPBEConfig configEncryptDecrypt() {
        final SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setPassword(privateKey);
        config.setPoolSize("5");
        config.setAlgorithm("PBEWithHMACSHA512AndAES_256");
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
        config.setIvGeneratorClassName("org.jasypt.iv.RandomIvGenerator");
        config.setKeyObtentionIterations("1000");
        config.setProviderName("SunJCE");
        return config;
    }
}
