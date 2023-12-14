package org.group15;

//public class Main {
//    public static void main(String[] args) {
//        System.out.println("Hello world!");
//    }
//}
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class Main {
    public static void main(String[] args) throws Exception{
        Configuration conf = new Configuration();

        Job job = Job.getInstance(conf, "Word Count Top N");
        job.setJarByClass(Main.class);

        // Mapper和Reducer类设置
        job.setMapperClass(TopNMapper.class);
        job.setReducerClass(TopNReducer.class);

        // 作业的输出键值类型
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        // 输入和输出路径
        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));

        // 等待作业完成并打印统计结果
        System.exit(job.waitForCompletion(true)?0:1);

    }
}
