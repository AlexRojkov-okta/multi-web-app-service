package rojkov.bar;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import rojkov.platform.PlatformBean;

@Controller
public class BarController {

  @Autowired
  private PlatformBean platformBean;

  @PostConstruct
  public void postConstruct() throws InterruptedException {
    Thread.sleep(5000);
  }

  @RequestMapping(value = "/hello", method = RequestMethod.GET, produces = "text/plain")
  @ResponseBody
  public String hello() {
    return platformBean.hello(platformBean.hello("Bar"));
  }
}
