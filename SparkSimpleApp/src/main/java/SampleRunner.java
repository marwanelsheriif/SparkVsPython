import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.spark.SparkConf;
import org.apache.spark.SparkFiles;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;



public class SampleRunner {

	static int random = (int )(Math.random() * 50 + 1);
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		Long startTimeNano = System.nanoTime();
		Long startTimeMilli = System.currentTimeMillis();

		SparkConf conf = new SparkConf().setMaster("local[*]").setAppName("Spark Test");
			
        JavaSparkContext sc = new JavaSparkContext(conf);

        JavaRDD<String> input = sc.textFile("/SparkSimpleApp/String250.txt");
        
        String rootDirPath = SparkFiles.getRootDirectory();
       
	    JavaRDD<String> output = input.pipe(SparkFiles.get("run_python_code.sh"));
	    for(Object obj : sc.getConf().getAll()) {
            System.out.println(obj);
        }
        output.saveAsTextFile(String.format("/SparkSimpleApp/temp%d",random));
       
        Long durationNano = System.nanoTime() - startTimeNano;
        Long durationMilli = System.currentTimeMillis() - startTimeMilli;
        
        System.out.println("Execution time in nano: "+ String.valueOf(durationNano) + "ns"); 
        System.out.println("Execution time in ms by converting ns to ms: "+ String.valueOf(durationNano / 1000000) + "ms");
        System.out.println("Execution time in ms : "+ String.valueOf(durationMilli) + "ms");
		       
	}
	
	}

