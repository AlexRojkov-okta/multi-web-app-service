package rojkov.platform;

import org.apache.catalina.LifecycleEvent;
import org.apache.catalina.LifecycleListener;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Platform implements LifecycleListener {

  private static final Log log = LogFactory.getLog(Platform.class);

  private static AnnotationConfigApplicationContext platformContext;

  @Override
  public void lifecycleEvent(LifecycleEvent event) {
    if (platformContext == null) {
      platformContext = new AnnotationConfigApplicationContext(PlatformBean.class);
    }
  }

  public static AnnotationConfigApplicationContext platformContext() {
    return platformContext;
  }
}
