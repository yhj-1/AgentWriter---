package com.yupi.template.config;

import com.stripe.Stripe;
import jakarta.annotation.PostConstruct;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Stripe 配置
 *
 * @author <a href="https://codefather.cn">编程导航学习圈</a>
 */
@Configuration
@ConfigurationProperties(prefix = "stripe")
@Data
public class StripeConfig {

    /**
     * Stripe API 密钥
     */
    private String apiKey;

    /**
     * Webhook 签名密钥
     */
    private String webhookSecret;

    /**
     * 支付成功回调 URL
     */
    private String successUrl;

    /**
     * 支付取消回调 URL
     */
    private String cancelUrl;

    @PostConstruct
    public void init() {
        Stripe.apiKey = this.apiKey;
    }
}
