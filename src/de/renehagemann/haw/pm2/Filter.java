package de.renehagemann.haw.pm2;

import java.util.function.Predicate;

public class Filter<T> {
    /**
     * Takes an array of predicates and returns a predicate with the single predicates with an and
     * @param predicates Array of predicates to united
     * @return Predicate with ands between the single predicates
     */
    Predicate<T> andAll(Predicate<? super T>[] predicates){
        Predicate<T> result = (T o) -> true;
        for(Predicate<? super T> predicate: predicates){
            result = result.and(predicate);
        }
        return result;
    }

    /**
     * Takes an array of predicates and returns a predicate with the single predicates with an or
     * @param predicates Array of predicates to united
     * @return Predicate with ors between the single predicates
     */
    Predicate<T> orAny(Predicate<? super T>[] predicates){
        Predicate<T> result = (T o) -> false;
        for(Predicate<? super T> predicate: predicates){
            result = result.or(predicate);
        }
        return result;
    }
}
