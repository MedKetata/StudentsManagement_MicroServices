package tn.micro.service.cloud.balancer;

import feign.Feign;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.context.annotation.Bean;

@LoadBalancerClient(value = "address-service" , configuration = CustomLoadBalancerConfiguration.class)
public class AdrSerLoadBalConfig {
    @LoadBalanced
    @Bean
    public Feign.Builder feignBuilder () {
        return Feign.builder();
    }


}


