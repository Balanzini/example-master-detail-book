package com.jose.books.app.di.scope;

import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import javax.inject.Scope;


/**
 * Created by jose on 5/07/16.
 */
@Scope
@Retention(value = RUNTIME)
public @interface ActivityScope {
}
