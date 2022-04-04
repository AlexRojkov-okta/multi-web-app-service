package rojkov.platform;

import org.springframework.stereotype.Component;

@Component
public class PlatformBean {

  public String hello(String v) {
    return "Hello " + v + " from " + this;
  }
}
