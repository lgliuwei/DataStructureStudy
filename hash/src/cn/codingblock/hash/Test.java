package cn.codingblock.hash;

import cn.codingblock.hash.open_address.BaseHashTable;
import cn.codingblock.hash.open_address.DataItem;
import cn.codingblock.hash.open_address.ReHashProbingHash;
import cn.codingblock.utils.log.Logger;

/**
 * Created by liuwei on 17/8/24.
 */
public class Test {
    public static void main(String[] strs) {
//        BaseHashTable hashTable = new LinearProbingHash(10);
        BaseHashTable hashTable = new ReHashProbingHash(11); //
        hashTable.insert(new DataItem(18));
        hashTable.insert(new DataItem(12));
        hashTable.insert(new DataItem(7));
        hashTable.insert(new DataItem(147));
        hashTable.insert(new DataItem(25));
        hashTable.insert(new DataItem(77));
        hashTable.insert(new DataItem(67));
        hashTable.insert(new DataItem(27));
        hashTable.insert(new DataItem(37));
        hashTable.insert(new DataItem(55));
        hashTable.insert(new DataItem(95));
        hashTable.insert(new DataItem(95));
        hashTable.delete(25);
        hashTable.insert(new DataItem(5));
        hashTable.display();
        Logger.println("\nfind:" + hashTable.find(18));
        Logger.println("find:" + hashTable.find(10));
    }
}
