## SSH 整合

### Struts2的框架（src下的struts.xml）  

	核心过滤器
	<filter>
	  	<filter-name>struts2</filter-name>
	  	<filter-class>org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter</filter-class>
	  </filter>
	  
	  <filter-mapping>
	  	<filter-name>struts2</filter-name>
	  	<url-pattern>/*</url-pattern>
	  </filter-mapping>
	  
### Spring的框架  
	jdbc.properties
	log4j.properties
	applicationContext.xml
	web.xml

### Hibernate的框架  
	hibernate.cfg.xml     --交给Spring管理