package com.example.NT.logic;

import java.io.Serializable;
import java.util.*;


public class CompassModel implements Serializable {
    private static final CompassModel instance = new CompassModel();

    private final Map<String, Range> model;

    public CompassModel() {
        model = new HashMap<>();

        model.put("North", new Range(0, 359));
        model.put("North-East", new Range(23, 67));
        model.put("East", new Range(68, 112));
        model.put("South-East", new Range(113, 157));
        model.put("South", new Range(157, 202));
        model.put("South-West", new Range(203, 247));
        model.put("West", new Range(247, 298));
        model.put("North-West", new Range(299, 337));
    }


    public static CompassModel getInstance() {
        return instance;
    }

    public Map<String, String> side(int degree) {
        Collection<String> side = model.keySet();
        Map<String, String> map = new HashMap<>();
        for (String key : side) {
            Range temp = model.get(key);
            if (key != null) {
                if (temp.inRange(degree)) {
                    map.put("Side", key);
                    return map;
                }
            }
        }
        map.put("Side", "Не существует");
        return map;
    }
}
