package com.project.airport.config;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

/**
 * <p>Description：跨域请求配置类</p>
 * @author：gusong
 * @date：2019/4/1 19:59
 */
@Configuration
public class CorsConfig {
    /**
     * <p>Description：配置允许跨域访问</p>
     * @return：org.springframework.web.cors.CorsConfiguration
     * @author：gusong
     * @date：2019/4/1 20:01
     */
    private CorsConfiguration buildConfig() {
        HttpServletResponse response;
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.setAllowedOriginPatterns(Arrays.asList("*"));
        corsConfiguration.addAllowedHeader("*");
        // 允许访问的方法名,GET POST等
        corsConfiguration.addAllowedMethod("*");
        return corsConfiguration;
    }

    /**
     * <p>Description：跨域过滤器</p>
     * @return：CorsFilter
     * @author：gusong
     * @date：2019/4/1 20:02
     */
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", buildConfig());
        return new CorsFilter(source);

    }

}
