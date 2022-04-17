
# Spark vs Python
This is a simple PoC to compare the performance of spark and python as a servers that process data using some user-uploaded code.
I created .txt files of different sizes (50, 100, 150, 200, and 250 MBs) to compare the performance on.
You should create a jar file from SampleRunner and add it as app resource in Launcher.
## Files Description
 - Launcher	
	 - It holds the configuration of spark and initializes the master node
	 - Use `setAppResource` to add the SampleRunner jar 
	 - Use `setSparkHome` to point to your local spark installment 
	 - Use `addFile` to add the shell script that runs the python code
	 - Use `addPyFile` to add the python script
	 - Errors are written in `submit.err.log` while stdout is written in `submit.out.log` 
 - SparkSimpleApp
	 - It initializes the sparkContext object, reads input text file, partitions the data, and invokes the shell script on the partitioned data. 
	 - The output is written in a folder called temp(%d), where %d is a randomly generated integer
 - run_python_code.sh
	 - It is responsible for running the python script `spark_test.py`
	 - It reads input data from spark and pass it to the python script as stdin
 - spark_test.py
	 - simple python code that simulates user-uploaded code
	 - it reads data from stdin and it simply uppercase all the letters 
	 - it writes the output back to stdout
 -  test. py
	 - It acts as a wrapper for the user-uploaded code
	 - It creates a sub-process to run user's code
## Results

![alt text](Isolated.png "Title")