package com.epam.mentorship.utils;

import io.qameta.allure.Allure;
import io.qameta.allure.AllureLifecycle;
import io.qameta.allure.Step;
import io.qameta.allure.model.Status;
import io.qameta.allure.model.StepResult;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static io.qameta.allure.util.AspectUtils.getParameters;
import static io.qameta.allure.util.AspectUtils.getParametersMap;
import static io.qameta.allure.util.NamingUtils.processNameTemplate;
import static io.qameta.allure.util.ResultsUtils.getStatus;
import static io.qameta.allure.util.ResultsUtils.getStatusDetails;

public class AllureAspect {

    private static AllureLifecycle lifecycle;

    @Pointcut("(execution(public * com.epam.mentorship.core.po.*.click*(..)))||(execution(public * com.epam.mentorship.core.po.*.switch*(..))) || (execution(public * com.epam.mentorship.core.po.*.move*(..))) ||(execution(public * com.epam.mentorship.core.po.*.select*(..)))||(execution(public * com.epam.mentorship.core.po.*.check*(..)))||(execution(public * com.epam.mentorship.core.po.*.set*(..)))||(execution(public * com.epam.mentorship.core.po.*.fill*(..)))||(execution(public * ccom.epam.mentorship.po.*.select*(..)))")
    public void pageObjects() {
    }


//    @Around("pages() || sections() || @annotation(io.qameta.allure.Step) && execution(* *(..))")
    @Around("pageObjects()")
    public Object step(ProceedingJoinPoint joinPoint) throws Throwable {
        final MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        final Step step = methodSignature.getMethod().getAnnotation(Step.class);
        final String uuid = UUID.randomUUID().toString();

        final String methodName = Optional.of(arrayToString(joinPoint.getArgs()))
                .filter(StringUtils::isNoneEmpty)
                .map(value -> processNameTemplate(methodSignature.getName(), getParametersMap(methodSignature, joinPoint.getArgs())))
                .orElse(methodSignature.getName());

        final String stepName = step != null ? Optional.of(step.value())
                .filter(StringUtils::isNoneEmpty)
                .map(value -> processNameTemplate(value, getParametersMap(methodSignature, joinPoint.getArgs())))
                .orElse(methodSignature.getName()) : methodName;

        String name = stepName.equalsIgnoreCase("logStep") ? arrayToString(joinPoint.getArgs()) : stepName;

        final StepResult result = (!stepName.equalsIgnoreCase("logStep")) ? new StepResult().withName(name).withParameters(getParameters(methodSignature, joinPoint.getArgs())) : new StepResult().withName(name);

        getLifecycle().startStep(uuid, result);
        try {
            final Object proceed = joinPoint.proceed();
            getLifecycle().updateStep(uuid, s -> s.withStatus(Status.PASSED));
            return proceed;
        } catch (Throwable e) {
            getLifecycle().updateStep(uuid, s -> s
                    .withStatus(getStatus(e).orElse(Status.BROKEN))
                    .withStatusDetails(getStatusDetails(e).orElse(null)));
            throw e;
        } finally {
            getLifecycle().stopStep(uuid);
        }
    }

    public static AllureLifecycle getLifecycle() {
        if (lifecycle == null)
            lifecycle = Allure.getLifecycle();
        return lifecycle;
    }

    private static String arrayToString(final Object... array) {
        return Stream.of(array).map(object -> {
            if (!Objects.toString(object).equals("null") && object.getClass().isArray())
                return arrayToString((Object[]) object);
            return Objects.toString(object);
        })
                .collect(Collectors.joining(", "));
    }

}
