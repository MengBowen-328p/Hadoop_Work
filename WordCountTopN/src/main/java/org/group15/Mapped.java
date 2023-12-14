package org.group15;

import java.io.*;
import java.nio.charset.StandardCharsets;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

public class Mapped {
}




public class TopNMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

    private final static IntWritable ONE = new IntWritable(1);
    private final Text word = new Text();
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        //分词工具的使用
        byte[] bt = value.getBytes();
        InputStream ip = new ByteArrayInputStream(bt);
        Reader read = new InputStreamReader(ip, StandardCharsets.UTF_8);
        IKSegmenter iks = new IKSegmenter(read,true);
        Lexeme t;
        while ((t = iks.next()) != null) {
            word.set(t.getLexemeText());
            context.write(word, ONE);
        }
    }
}


