package com.sl.utils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * Аннотация используемая в переменных класса PageObject, которая ограничивает размер значений записываемых в базу данных.
 *  Используется в сочетании с классом RandomValue
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Length {
	public int value();
}
