package it.unicam.cs.pa.jbudget100763.model;

import java.util.Map;

import com.google.common.base.Function;

public class RegistryImpl<T> {

    private Map<Integer, T> registry;

    private Function<Integer, T> factory;

    public RegistryImpl(Function<Integer, T> factory) {
        this.factory = factory;
    }

    public T getInstance(int id) {
        if (!registry.containsKey(id)) {
            return registry.get(id);
        } else {
            T o = factory.apply(id);
            registry.put(id, o);
            return o;
        }

    }
}