package com.project.eac.common;

public enum Level {
    Province,
    Prefecture,
    County;

    public static Level from_code(int code) {
        if (code % 100 != 0) {
            return County;
        } else if (code % 10000 != 0) {
            return Prefecture;
        } else {
            return Province;
        }
    }
}
