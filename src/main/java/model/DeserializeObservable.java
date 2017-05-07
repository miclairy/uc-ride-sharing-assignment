package model;

import com.google.gson.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import com.google.gson.InstanceCreator;

/**
 * Created by clbmi on 20/04/2017.
 */
public class DeserializeObservable implements InstanceCreator<ObservableList<?>> {

    public ObservableList<?> createInstance(Type type) {

        return FXCollections.observableArrayList();
    }
}
