package com.ia;

import org.springframework.test.context.ContextConfiguration;

import java.lang.annotation.ElementType;
        import java.lang.annotation.Retention;
        import java.lang.annotation.RetentionPolicy;
        import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@ContextConfiguration(value = {"file:WebContent/WEB-INF/ia-project-servlet.xml",
        "classpath:/resources/testApplicationContext.xml",
        "classpath:/resources/mock-beans.xml"})

public @interface ControllerTest {

}

