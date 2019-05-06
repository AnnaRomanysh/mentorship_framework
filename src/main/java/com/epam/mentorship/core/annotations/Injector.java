package com.epam.mentorship.core.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

    @Retention(RetentionPolicy.RUNTIME)
    public @interface Injector {
        boolean required() default true;
    }

