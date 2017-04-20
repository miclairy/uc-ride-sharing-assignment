package model;

import com.google.gson.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by clbmi on 20/04/2017.
 */
public class DeserializeObservable implements JsonDeserializer<ObservableList<?>> {
    @Override
    public ObservableList<?> deserialize(JsonElement jsonElement, Type typeOfT, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        ObservableList list = FXCollections.observableArrayList();
        final Type type = ((ParameterizedType)typeOfT).getActualTypeArguments()[0];
        for (final JsonElement element : jsonElement.getAsJsonArray()) {
            list.add(Data.gson.fromJson(element, type));
        }
        return list;
    }
}
