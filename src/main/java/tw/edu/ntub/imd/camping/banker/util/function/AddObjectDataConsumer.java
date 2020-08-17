package tw.edu.ntub.imd.camping.banker.util.function;

import tw.edu.ntub.imd.camping.banker.util.json.object.ObjectData;

@FunctionalInterface
public interface AddObjectDataConsumer<T> extends TripleConsumer<ObjectData, Integer, T> {
    @Override
    default void accept(ObjectData objectData, Integer integer, T t) {
        addObject(objectData, integer, t);
    }

    void addObject(ObjectData objectData, int index, T t);
}
