package com.epam.mentorship;

import com.epam.mentorship.core.injector.Injector;
import com.epam.mentorship.utils.TestListener;
import org.testng.annotations.Guice;
import org.testng.annotations.Listeners;

@Guice(modules = {Injector.class})
@Listeners(TestListener.class)
public class BaseTest {


}
