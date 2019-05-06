package com.epam.mentorship;

import com.epam.mentorship.core.annotations.Injector;
import com.epam.mentorship.core.driver.Driver;
import com.epam.mentorship.utils.Logger;
import com.epam.mentorship.utils.TestListener;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

@Listeners(TestListener.class)
public class BaseTest {


    @BeforeClass
    public void before() {
        createInstance();
    }


    @AfterMethod
    public void quit(){
        Driver.quit();
    }


    private void createInstance() {
        Class<?> clazz = this.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) { Annotation[] annotations = field.getAnnotations();
            for (Annotation annotation : annotations) {
                if (annotation instanceof Injector) {
                    try {
                        Logger.debug("Trying to create instance " + field.getType());
                        Object object = field.getType().newInstance();
                        field.setAccessible(true);
                        field.set(this, object);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
