package surgir.pe.myapplication.data.remote.dto.character;

import androidx.annotation.NonNull;

public class Info {
    private String next;
    private Integer pages;
    private String prev;
    private Integer count;

    public Info(String next, Integer pages, String prev, Integer count) {
        this.next = next;
        this.pages = pages;
        this.prev = prev;
        this.count = count;
    }

    public String getNext() {
        return this.next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public Integer getPages() {
        return this.pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public String getPrev() {
        return this.prev;
    }

    public void setPrev(String prev) {
        this.prev = prev;
    }

    public Integer getCount() {
        return this.count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @NonNull
    @Override
    public String toString() {
        return "Info{" +
                "next='" + next + '\'' +
                ", pages=" + pages +
                ", prev='" + prev + '\'' +
                ", count=" + count +
                '}';
    }
}
