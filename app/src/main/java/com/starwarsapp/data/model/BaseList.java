package com.starwarsapp.data.model;

import java.io.Serializable;
import java.util.List;

public class BaseList<T> implements Serializable {

    public int count;
    public String next;
    public String previous;
    public List<T> results;

    public BaseList() {
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public List<T> getResults() {
        return results;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }

    public boolean hasNext(){
        if(next != null & !next.isEmpty()){
            return true;
        } else {
            return false;
        }
    }
}
