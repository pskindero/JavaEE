============================================
How to deploy application to Wildfly server?
============================================

1. Start Wildfly 10 (/home/pskindero/Desktop/application_servers/wildfly-10.1.0.Final) by one following methods:
- use bin/standalone.sh
- use Eclipse GUI -> in Servers tab
2. Go to Administration panel: http://localhost:9990/console/App
  In deployments -> add deployment and choose proper war file.
4. Check REST GET method - http://localhost:8080/javaeetech-war-0.0.1-SNAPSHOT/serv/people

============================================
How to add MySQL as data source to Wildfly?
============================================

1. In standalone.xml add:
<datasources><datasource jndi-name="java:jboss/datasources/ExampleDS" pool-name="ExampleDS" enabled="true" use-java-context="true"><connection-url>jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE</connection-url><driver>h2</driver><security><user-name>sa</user-name><password>sa</password></security></datasource><datasource jta="true" jndi-name="java:jboss/mysql" pool-name="proj" enabled="true" use-java-context="true" use-ccm="true"><connection-url>jdbc:mysql://localhost:3306/db170509</connection-url><driver>mysql</driver><security><user-name>root</user-name><password>amigo6</password></security><statement><prepared-statement-cache-size>32</prepared-statement-cache-size><share-prepared-statements>true</share-prepared-statements></statement></datasource><drivers><driver name="mysql" module="com.mysql"><xa-datasource-class>com.mysql.jdbc.jdbc2.optional.MysqlXADataSource</xa-datasource-class></driver><driver name="h2" module="com.h2database.h2"><xa-datasource-class>org.h2.jdbcx.JdbcDataSource</xa-datasource-class></driver></drivers></datasources>
2. Create $WILDFLY_HOME/modules/system/layers/base/com/mysql/main and place:
 -mysql connector jar
 -module.xml with content:
 <module xmlns="urn:jboss:module:1.1" 
        name="com.mysql">
    <resources>
        <resource-root path="mysql-connector-java-5.1.26.jar"/>
        <!-- Insert resources here -->
    </resources>
    <dependencies>
        <module name="javax.api"/>
        <module name="javax.transaction.api"/>
        <module name="javax.servlet.api" optional="true"/>
    </dependencies>
</module>