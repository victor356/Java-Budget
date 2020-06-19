
/*
This file is part of JBudget.

    JBudget is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    Foobar is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with Foobar.  If not, see <https://www.gnu.org/licenses/>.
*/package it.unicam.cs.pa.jbudget100763.model;

import java.util.Map;

import com.google.common.base.Function;
/**
 * DISCLAIMER: Classe embrionale in via di sviluppo per la persistenza dei dati dell'applicazione
 * @param <T> tipo elemento da memorizzare
 */
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