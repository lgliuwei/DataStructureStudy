package cn.codingblock.hash.open_address;

/**
 * Created by liuwei on 17/8/24.
 */
public class DataItem {
    private int data;

    public DataItem(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "DataItem{" +
                "data=" + data +
                '}';
    }
}
