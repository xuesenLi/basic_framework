package cn.com.wewin;

import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.Context;
import org.apache.tomcat.util.scan.StandardJarScanner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Slf4j
@EnableSwagger2
@SpringBootApplication
public class MakeIDApplication {

  public static void main(String[] args) throws UnknownHostException {

    ConfigurableApplicationContext application = SpringApplication.run(MakeIDApplication.class, args);
    Environment env = application.getEnvironment();
    String ip = InetAddress.getLocalHost().getHostAddress();
    String port = env.getProperty("server.port");
    String path = env.getProperty("server.servlet.context-path");
    log.info("\n\t----------------------------------------------------------\n\t" +
        "用用程序 MakeID-Boot 正在运行! 访问地址:\n\t" +
        "本地访问: \t\thttp://localhost:" + port + path + "/\n\t" +
        "外部访问: \t\thttp://" + ip + ":" + port + path + "/\n\t" +
        "接口文档: \t\thttp://" + ip + ":" + port + path + "/doc.html\n\t" +
        "\n\t----------------------------------------------------------");

  }

  /**
  * tomcat-embed-jasper引用后提示jar找不到的问题
  */
  @Bean
  public TomcatServletWebServerFactory tomcatFactory() {
   return new TomcatServletWebServerFactory() {
    @Override
    protected void postProcessContext(Context context) {
     ((StandardJarScanner) context.getJarScanner()).setScanManifest(false);
    }
   };
  }
}