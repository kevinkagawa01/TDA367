package com.cbm.tda367.model;

import java.util.ArrayList;
import java.util.List;

public class UserAsset<T extends Prototype<T>> implements Prototype<UserAsset<T>>{

    private final List<T> list;

    UserAsset() {
        this.list = new ArrayList<>();
    }

    private UserAsset(UserAsset<T> userAsset){
        this.list = new ArrayList<>(userAsset.list);
    }

    /**
     * Adds element to the internal list.
     * @param element element to be added to the list.
     */
    void addListItem(T element) {
        list.add(element.cloneObject());
    }

    /**
     * Removes element from the internal list.
     *
     * @param element element to be removed from the list.
     */
    void removeListItem(T element) {
        list.remove(element);
    }

    void setListItem(int index,T element){
        list.set(index,element);
    }

    public List<T> getList() {
        return new ArrayList<>(list);
    }

    /**
     * Returns a safe copy of object.
     *
     * @return safe copy of object.
     */
    @Override
    public UserAsset<T> cloneObject() {
        return new UserAsset<T>(this);
    }
}
