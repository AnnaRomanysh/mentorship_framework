package com.epam.mentorship.core.webelement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.Arrays;
import java.util.List;
import static com.epam.mentorship.utils.Logger.*;

public class Checkbox extends Element {

    private List<String> valueList;
    private List<Element> checkboxLabels;
    private List<Element> checkboxInputs;
    private String checkBoxInputSelector = ".//input";
    private String checkBoxLabelSelector = ".//label";

    public Checkbox(WebElement webElement) {
        super(webElement);
    }


    public void checkAll() {
        info("Check all checkbox inputs");
        getInputs().forEach(el -> {
            if (el.isSelected()) {
                el.click();
            }
        });
    }

    public void unChecktAll() {
        info("Uncheck all checkbox inputs");
        getInputs().forEach(el -> {
            if (!el.isSelected()) {
                el.click();
            }
        });
    }

    public void checkByValues(String... values) {
        info("Check checkbox values: " + values.toString());
        valueList = Arrays.asList(values);
        checkboxLabels = getLabels();
        if (values.length > 0) {
            checkboxLabels.forEach(label -> valueList.forEach(value -> {
                if (label.getText().equalsIgnoreCase(value) && !label.isSelected()) {
                    label.click();
                }
            }));
        } else {
            throw new IllegalArgumentException("Values to check should be defined");
        }
    }

    public void checkByIndexes(int... indexes) {
        checkboxInputs = getInputs();
        if (indexes.length > 0) {
            for (int i = 0; i < indexes.length; i++) {
                if (!checkboxInputs.get(indexes[i]).isSelected()) {
                    checkboxInputs.get(indexes[i]).click();
                }
            }

        } else {
            throw new IllegalArgumentException("Indexes to check should be defined");
        }

    }

    public void unCheckByValues(String... values) {
        info("Uncheck all checkbox values: "+ values.toString());
        valueList = Arrays.asList(values);
        checkboxLabels = getLabels();
        if (values.length > 0) {
            checkboxLabels.forEach(label -> valueList.forEach(value -> {
                if (label.getText().equalsIgnoreCase(value) && label.isSelected()) {
                    label.click();
                }
            }));
        } else {
            throw new IllegalArgumentException("Values to unCheck should be defined");
        }
    }

    public void unCheckByIndexes(int... indexes) {
        checkboxInputs = getInputs();
        if (indexes.length > 0) {
            for (int i = 0; i < indexes.length; i++) {
                if (checkboxInputs.get(indexes[i]).isSelected()) {
                    checkboxInputs.get(indexes[i]).click();
                }
            }
        } else {
            throw new IllegalArgumentException("Indexes to unCheck should be defined");
        }

    }

    public List<Element> getInputs(){
        return  getElement().getElements(By.xpath(checkBoxInputSelector));
    }

    public List<Element> getLabels(){
        return  getElement().getElements(By.xpath(checkBoxLabelSelector));
    }


}
