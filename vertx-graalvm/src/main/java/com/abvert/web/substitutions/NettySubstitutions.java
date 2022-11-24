package com.abvert.web.substitutions;

import java.util.function.Predicate;


/**
 * A predicate to tell whether this platform includes the argument class.
 */
final class PlatformHasClass implements Predicate<String> {
    @Override
    public boolean test(String className) {
        try {
            @SuppressWarnings({"unused"}) final Class<?> classForName = Class.forName(className);
            return true;
        } catch (ClassNotFoundException cnfe) {
            return false;
        }
    }
}

public class NettySubstitutions {
}

