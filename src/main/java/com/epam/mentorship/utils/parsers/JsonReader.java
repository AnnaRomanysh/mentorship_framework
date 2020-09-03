package com.epam.mentorship.utils.parsers;

import com.epam.mentorship.utils.Logger;
import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JsonReader {

    private static final String DATA_LOCATION = "src//main//resources//testdata//";

    public static <T> List<T> read(String fileName, Class<T> type) {
        List<T> users = new ArrayList();
        String filePath = DATA_LOCATION + fileName;
        Gson gson = new Gson();
        try {
            users = gson.fromJson(new FileReader(filePath), getType(List.class, type));
        } catch (
                FileNotFoundException e) {
            Logger.error("Could ot read a file: " + filePath);
            e.printStackTrace();
        }
        return users;

    }

    private static Type getType(Class<?> rawClass, Class<?> parameter) {

        return new ParameterizedType() {
            @Override
            public Type[] getActualTypeArguments() {
                return new Type[]{parameter};
            }

            @Override
            public Type getRawType() {
                return rawClass;
            }

            @Override
            public Type getOwnerType() {
                return null;
            }
        };
    }

}
