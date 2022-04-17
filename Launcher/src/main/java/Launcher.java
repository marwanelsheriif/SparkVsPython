import java.io.File;
import java.io.IOException;

import org.apache.spark.launcher.SparkAppHandle;
import org.apache.spark.launcher.SparkLauncher;

public class Launcher {
    private static final boolean waitForCompletion = true;
	public static void main(String[] args) throws IOException, InterruptedException
    {
		System.out.println("INIT");
		
		
       SparkLauncher launcher = new SparkLauncher()
           .setVerbose(true)
           .setMaster("local[*]")
           .setSparkHome("/Users/marwamostsafa/Downloads/spark-3.2.1-bin-hadoop3.2" )
           .setAppResource("/SparkSimpleApp/target/SparkSimpleApp-0.0.1-SNAPSHOT.jar")
           .setMainClass("SampleRunner")
           .addAppArgs("3", "2500000")
           .addFile("/run_python_code.sh")
           .addPyFile("/spark_test.py")
           .redirectError(new File("submit.err.log"))
           .redirectOutput(new File("submit.out.log"));
       System.out.println("Iinitialized");
       SparkAppHandle handle = launcher.startApplication();
       

       // Poll until application gets submitted
       
       while (handle.getAppId() == null) {
           Thread.sleep(1500L);
       }
       System.out.println("got ID");
       
       if (waitForCompletion) {
           while (!handle.getState().isFinal()) {
              
               Thread.sleep(1500L);
           }
           System.out.println("finished");

       } else {
           handle.disconnect();
       }
       
    }
}
