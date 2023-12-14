package org.group15;

import java.io.IOException;
import java.util.*;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class TopNReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
    private TreeMap<Integer, String> topWords;
    private int count;

    @Override
    protected void setup(Context context) {
        topWords = new TreeMap<>();
        count = 0;
    }

    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Context context) {
        int frequency = 0;
        for (IntWritable value : values) {
            frequency += value.get();
        }
        //top50
        topWords.put(frequency, key.toString());
        if (topWords.size() > 50) {
            topWords.remove(topWords.firstKey());
        }
    }

    @Override
    protected void cleanup(Context context) throws IOException, InterruptedException {
        for (Map.Entry<Integer, String> entry : topWords.descendingMap().entrySet()) {
            int frequency = entry.getKey();
            String word = entry.getValue();
            context.write(new Text(word), new IntWritable(frequency));
        }
    }
}

