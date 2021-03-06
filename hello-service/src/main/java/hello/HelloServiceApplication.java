package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * This is the simple Hello springboot REST service that client applications can consume.
 */
@RestController
@SpringBootApplication
//@EnableDiscoveryClient
@EnableEurekaClient
public class HelloServiceApplication {

  private static Logger log = LoggerFactory.getLogger(HelloServiceApplication.class);

  /**
   * Rest endpoint
   * @return
   */
  @RequestMapping(value = "/greeting")
  public String greet() {
    log.info("Access /greeting");

    List<String> greetings = Arrays.asList("Hi there", "Greetings", "Hello");
    Random rand = new Random();

    int randomNum = rand.nextInt(greetings.size());
    return greetings.get(randomNum);
  }

  /**
   * Ribbon client will ping this endpoint every few seconds
   * @return
   */
  @RequestMapping(value = "/")
  public String home() {
    log.info("Access /");
    return "Ping!";
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    SpringApplication.run(HelloServiceApplication.class, args);
  }
}
