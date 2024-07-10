package demo.sale.config;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.time.Duration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializationContext.SerializationPair;

@Configuration
public class RedisConfig {

    @Value("${spring.data.redis.host}")
    private String redisHost;

    @Value("${spring.data.redis.port}")
    private int redisPort;

//    @Value("${spring.data.redis.password}")
//    private String redisPassword;


    @Bean
    public LettuceConnectionFactory redisConnectionFactory() {
        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration(redisHost,
            redisPort);
//        configuration.setPassword(redisPassword);
        return new LettuceConnectionFactory(configuration);
    }

//    @Bean
//    public RedisCacheManager cacheManager(RedisConnectionFactory connectionFactory) {
//        return RedisCacheManager.create(connectionFactory);
//    }


//    @Bean
//    public CacheManager redisCacheManager() {
//        // Create JSON Redis Serializer to use
//        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.enable(JsonGenerator.Feature.IGNORE_UNKNOWN);
//        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
//        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL,
//            JsonTypeInfo.As.PROPERTY);
//        GenericJackson2JsonRedisSerializer jsonRedisSerializer = new GenericJackson2JsonRedisSerializer(
//            objectMapper);
//
//        // Configure RedisCacheManager
//        RedisSerializationContext.SerializationPair jsonSerializer =
//            RedisSerializationContext.SerializationPair.fromSerializer(jsonRedisSerializer);
//        return RedisCacheManager.RedisCacheManagerBuilder
//            .fromConnectionFactory(redisConnectionFactory)
//            .cacheDefaults(
//                RedisCacheConfiguration.defaultCacheConfig()
//                    .entryTtl(Duration.ofDays(1))
//                    .serializeValuesWith(jsonSerializer)
//                    .disableCachingNullValues()
//            )
//            .build();
//    }


    @Bean
    public CacheManager redisCacheManager() {
        // Create JSON Redis Serializer to use
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(JsonGenerator.Feature.IGNORE_UNKNOWN);
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL, JsonTypeInfo.As.PROPERTY);
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        GenericJackson2JsonRedisSerializer jsonRedisSerializer = new GenericJackson2JsonRedisSerializer(objectMapper);

        // Configure RedisCacheManager
        SerializationPair<Object> jsonSerializer =
                                  RedisSerializationContext.SerializationPair.fromSerializer(jsonRedisSerializer);
        return RedisCacheManager.RedisCacheManagerBuilder
            .fromConnectionFactory(this.redisConnectionFactory())
            .cacheDefaults(
                RedisCacheConfiguration.defaultCacheConfig()
                                       .entryTtl(Duration.ofDays(1))
                                       .serializeValuesWith(jsonSerializer)
                                       .disableCachingNullValues()
            )
            .build();
    }
//
//    public void saveConfigToFile(RedisConfig config, String filePath) throws IOException {
//        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
//        objectMapper.writeValue(new File(filePath), config);
//    }
//
//    public static RedisConfig loadConfigFromFile(String filePath) throws IOException {
//        ObjectMapper objectMapper = new ObjectMapper();
//        return objectMapper.readValue(new File(filePath), RedisConfig.class);
//    }

}
