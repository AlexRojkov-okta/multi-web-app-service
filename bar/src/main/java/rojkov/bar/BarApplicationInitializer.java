package rojkov.bar;

import java.util.Set;
import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import rojkov.platform.Platform;

public class BarApplicationInitializer implements ServletContainerInitializer {

  private static final Log log = LogFactory.getLog(BarApplicationInitializer.class);

  private AnnotationConfigWebApplicationContext ctx;

  @Override
  public void onStartup(Set<Class<?>> set, ServletContext servletContext) throws ServletException {
    servletContext.log("Initializing Bar Application");

    ctx = new AnnotationConfigWebApplicationContext();

    ctx.setParent(Platform.platformContext());
    ctx.setServletContext(servletContext);
    ctx.register(BarController.class);

    Dynamic dispatcher = servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));
    dispatcher.setLoadOnStartup(1);
    dispatcher.addMapping("/");
  }
}
