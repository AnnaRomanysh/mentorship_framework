package com.epam.mentorship.core.allure;

import io.qameta.allure.Allure;
import io.qameta.allure.AllureLifecycle;
import io.qameta.allure.Step;
import io.qameta.allure.model.Status;
import io.qameta.allure.model.StepResult;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static io.qameta.allure.util.AspectUtils.getParameters;
import static io.qameta.allure.util.AspectUtils.getParametersMap;
import static io.qameta.allure.util.NamingUtils.processNameTemplate;
import static io.qameta.allure.util.ResultsUtils.getStatus;
import static io.qameta.allure.util.ResultsUtils.getStatusDetails;


@Aspect
public class AllureAspect {

    private static AllureLifecycle lifecycle;

    @Pointcut("(execution(public * com.epam.mentorship.core.po.*.click*(..)))||(execution(public * com.epam.mentorship.core.po.*.switch*(..))) || (execution(public * com.epam.mentorship.core.po.*.move*(..))) ||(execution(public * com.epam.mentorship.core.po.*.select*(..)))||(execution(public * com.epam.mentorship.core.po.*.check*(..)))||(execution(public * com.epam.mentorship.core.po.*.set*(..)))||(execution(public * com.epam.mentorship.core.po.*.fill*(..)))||(execution(public * ccom.epam.mentorship.po.*.select*(..)))")
    public void pageObjects() {
    }

    @Pointcut("execution(public * com.epam.mentorship.businessobject.*.*(..))")
    public void bussinessObjects() {
    }

    @Pointcut("execution(public * com.epam.mentorship.*.*.step(..))")
    public void step(){

    }

    @Around("(pageObjects()|| bussinessObjects() || step())&&!@annotation(io.qameta.allure.Step)")
    public Object step(ProceedingJoinPoint joinPoint) throws Throwable {
        final MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        final Step step = methodSignature.getMethod().getAnnotation(Step.class);
        final String uuid = UUID.randomUUID().toString();

        final String methodName = Optional.of(arrayToString(joinPoint.getArgs()))
                .filter(StringUtils::isNoneEmpty)
                .map(value -> processNameTemplate(convertToReadableFormat(methodSignature.getName()), getParametersMap(methodSignature, joinPoint.getArgs())))
                .orElse(convertToReadableFormat(methodSignature.getName()));

        final String stepName = step != null ? Optional.of(step.value())
                .filter(StringUtils::isNoneEmpty)
                .map(value -> processNameTemplate(value, getParametersMap(methodSignature, joinPoint.getArgs())))
                .orElse(convertToReadableFormat(methodSignature.getName())) : methodName;

        String name = stepName.equalsIgnoreCase("step") ? arrayToString(joinPoint.getArgs()) : stepName;

        final StepResult result = (!stepName.equalsIgnoreCase("step")) ? new StepResult().withName(name).withParameters(getParameters(methodSignature, joinPoint.getArgs())) : new StepResult().withName(name);

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

    private String convertToReadableFormat(String methodName) {
        String[] ops = methodName.split("");
        StringBuilder stringBuilder = new StringBuilder();
        Pattern pattern = Pattern.compile("[A-Z]");
        for (int i = 0; i < ops.length; i++) {
            int index = i >= ops.length - 1 ? i : i + 1;
            boolean startsFromUpper = pattern.matcher(ops[index]).find();
            stringBuilder.append(ops[i].toLowerCase());
            if (i == 0) {
                stringBuilder.replace(0, 1, ops[i].toUpperCase());
            }
            if (startsFromUpper) {
                stringBuilder.append(" ");
            }

        }
        return stringBuilder.toString();
    }
}
