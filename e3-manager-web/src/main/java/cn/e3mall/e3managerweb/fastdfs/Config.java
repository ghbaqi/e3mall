package cn.e3mall.e3managerweb.fastdfs;

import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    /**
     * tomcatEmbedded这段代码是为了解决，上传文件大于10M出现连接重置的问题。
     * 此异常内容GlobalException也捕获不到
     */
    //Tomcat large file upload connection reset
//    @Bean
//    public TomcatEmbeddedServletContainerFactory tomcatEmbedded() {
//        TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory();
//        tomcat.addConnectorCustomizers((TomcatConnectorCustomizer) connector -> {
//            if ((connector.getProtocolHandler() instanceof AbstractHttp11Protocol<?>)) {
//                //-1 means unlimited
//                ((AbstractHttp11Protocol<?>) connector.getProtocolHandler()).setMaxSwallowSize(-1);
//            }
//        });
//        return tomcat;
//    }
}
